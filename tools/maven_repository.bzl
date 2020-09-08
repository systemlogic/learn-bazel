# ================================================================
# Maven Dependencies should be added to this file instead of
# WORKSPACE
# ================================================================

load("//tools:java_dependencies.bzl", "java_dependencies")
load("//tools:dependencies.bzl", "maven_dep")

def define_java_dependencies():
    for dep in java_dependencies:
        #print(dep)
        name = dep['name']
        if native.existing_rule(name):
          print('Warning: maven dependency already exists: ' + name)
          continue

        maven_dep(**dep)

    for dep in java_dependencies:
        left, sep, right = dep['artifact'].rpartition(':')
        replacement = left.replace(':', '_').replace('-', '_').replace('.', '_')
        if native.existing_rule(replacement):
          # Already exists, we can ignore that.
          continue

        # Copying the dependency definition, but replacing the name with the full
        # canonical name.  
        copy_of_dep = {}
        for key, value in dep.items():
          if key == 'name':
            copy_of_dep['name'] = replacement
          else:
            copy_of_dep[key] = value
        maven_dep(**copy_of_dep)
