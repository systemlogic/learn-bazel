#!/usr/bin/python

"""Utility to generate transitive Bazel dependencies for maven artifacts

This program will generate the complete list of Bazel dependencies for the
given Maven dependencies. This program assumes we are running in our
development environment, where the WORKSPACE file will use our maven_dep()
macro for defining a maven dependency and the BUILD files will use the
//external:name-jar form for dependencies.

Usage:
    bazelDependencies.py [-w <WORKSPACE file>] <file containing Maven dependencies>

If a WORKSPACE file was given, it will be used. Otherwise, it will be searched for from
the location of the script.

The input file containing the dependencies will look like:

org.glassfish.jersey.core:jersey-server:2.25.1
org.glassfish.jersey.containers:jersey-container-servlet-core:2.25.1
org.glassfish.jersey.containers:jersey-container-jetty-http:2.25.1
org.eclipse.jetty:jetty-server:9.3.20.v20170531
org.eclipse.jetty:jetty-servlet:9.3.20.v20170531

where each line is a group:name:version 

"""

from __future__ import print_function

import os
import sys
import argparse
import re
import shutil
import tempfile
import subprocess

def findParentFile(filename):
    # Start at the directory holding the script we are executing
    currentDir = os.path.dirname(os.path.abspath(__file__))
    prevDir = None
    while currentDir != prevDir:
        testfile = os.path.join(currentDir, filename)
        if os.path.isfile(testfile):
            return testfile
        prevDir = currentDir
        currentDir = os.path.abspath(os.path.join(currentDir, os.path.pardir))
    return None

def findWorkspaceFile():
    workspaceFile = findParentFile("WORKSPACE")
    if workspaceFile:
        return open(workspaceFile, "r")
    print("WARNING: no WORKSPACE file was found.")
    return None

def extractMavenDependenciesFromWORKSPACE(workspaceFile):
    if not workspaceFile:
        workspaceFile = findWorkspaceFile()

    if not workspaceFile:
        return {}

    workspaceDeps = re.findall('maven_dep\s*\([^)]*artifact\s*=\s*"([^"]*)[^)]*\)', workspaceFile.read())
    result = {}
    for dep in workspaceDeps:
        key, value = dep.rsplit(":", 1)
        result[key] = value;

    return result

def buildGradleFile(directory, deps):
    pathToGradleBuild = os.path.join(directory, "build.gradle")
    with open(pathToGradleBuild, "w") as f:
        f.write("apply plugin: 'java'\n\n")
        f.write("repositories {\n")
        f.write("  jcenter()\n")
        f.write("  mavenCentral()\n")
        f.write("}\n\n")
        f.write("dependencies {\n")
        for dep in deps:
            parts = dep.split(":")
            f.write("  compile( group: '{0}', name: '{1}', version: '{2}' )\n".format(*parts))
        f.write("}\n\n")

def processGradleOutput(output, topLevelDeps, currentDeps):
    result = []
    seen = set()

    # Prepopulate result list with the top level dependencies
    for dep in topLevelDeps:
        result.append(dep)
        seen.add(dep.rsplit(":", 1)[0])

    state = "findTreeStart"
    for line in output.splitlines():
        if state == "findTreeStart":
            if line.startswith(("+---", "\\---")):
                state = "processTree"

        if state == "processTree":
            if len(line) == 0:
                state = "finished"
                continue
            topLevel = line.startswith(("+", "\\"))
            artifact = line[line.index("--- ")+4:]

            # artifact may have trailing information like (*) or -> version
            extraIndex = artifact.find(" ")
            if extraIndex >= 0:
                extra = artifact[extraIndex+1:]
                artifact = artifact[:extraIndex]
            else:
                extra = None
            name, version = artifact.rsplit(":", 1)

            # Remember top level dependency we are processing
            if topLevel:
                topLevelArtifact = artifact

            if extra is not None and extra.startswith("-> "):
                realVersion = extra[3:]
                print("WARNING! Dependency "+topLevelArtifact+" has a transitive dependency with a version mismatch.")
                print("  It wants to use artifact "+name+" at version "+version+" but will")
                print("  use version "+realVersion+" instead. Perhaps the top-level dependencies")
                print("  can be updated to use a comptiable version?")
                version = realVersion
                artifact = name + ":" + realVersion

            if not name in seen:
                seen.add(name)
                result.append(artifact)

    return result

def calculateTransitiveDependencies(topLevelDeps, currentDeps):
    try:
        tempDir = tempfile.mkdtemp()
        buildGradleFile(tempDir, topLevelDeps)
        gradlew = findParentFile("gradlew")
        if not gradlew:
            print("ERROR: Unable to find gradlew executable, so cannot generate dependencies.", file=sys.stderr)
            sys.exit(1)
        args = [gradlew, "--no-daemon", "dependencies", "--configuration", "compile"]
        gradleOutput = subprocess.check_output(args, cwd=tempDir)
        return processGradleOutput(gradleOutput, topLevelDeps, currentDeps)
    finally:
        shutil.rmtree(tempDir)


# -------- Start main program ---------

parser = argparse.ArgumentParser(description="Generate Bazel dependencies for Maven artifacts")
parser.add_argument("-w", "--workspace", help="The Bazel WORKSPACE file to use", type=argparse.FileType("r"))
parser.add_argument("mavenDeps", help="File containing top-level Maven dependencies", type=argparse.FileType("r"))
args = parser.parse_args()

# Get the top-level dependencies
topLevelDeps = [dep for dep in re.split("\s+", args.mavenDeps.read()) if dep]
args.mavenDeps.close()

# Read existing Maven dependencies from WORKSPACE
currentDeps = extractMavenDependenciesFromWORKSPACE(args.workspace)

# Get the dependencies from the top level, using the current deps
transitiveDeps = calculateTransitiveDependencies(topLevelDeps, currentDeps)

# Walk the output dependencies
workspaceLines = []
buildLines = []
for dep in transitiveDeps:
    name, version = dep.rsplit(":", 1)

    # Add to WORKSPACE lines if not already there
    if not name in currentDeps:
        workspaceLines.append('maven_dep(')
        workspaceLines.append('    artifact = "{0}",'.format(dep))
        workspaceLines.append('    license = ""')
        workspaceLines.append(')\n')
    elif currentDeps[name] != version:
        print("WARNING! The current WORKSPACE has maven artifact "+name+" at version "+currentDeps[name]);
        print("  but we wanted to add version "+version+". This needs to be resolved.")

    # Add to build lines
    buildName = name.split(":")[1]
    buildName = buildName.replace('-', '_').replace('.', '_') + '-jar'
    buildLines.append('        "//external:{0}",'.format(buildName))

# Tell the user what to add
print("\nAdd the following lines to the WORKSPACE file:")
print("\n".join(workspaceLines))
print("\nAdd the following lines to the BUILD file:")
print("\n".join(buildLines))


"""
The steps we need to take are:

1) Pass in a file with the top-level dependencies listed, one per line
2) Read that file to get the top-level dependencies
3) Create a temporary directory, create a build.gradle file in that directory
4) Populate the build.gradle file with the top-level dependencies
5) Execute the gradle dependencies command in that temporary directory, capture the output
6) Walk the output to get the dependencies
    - The top-level dependencies are always added as given to the output
    - Only start parsing lines after the header lines have been consumed
    - Stop parsing lines when an empty line is encountered
    - Pick up the artifact from the line (text after --- )
    - May need to strip trailing characters from the line ( -> newer version)
    - Maybe pick up the top-level dependency we are processing for later use
"""
