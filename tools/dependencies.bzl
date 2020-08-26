# Generate external dependencies in the WORKSPACE file
load("@bazel_tools//tools/build_defs/repo:java.bzl", "java_import_external")

def maven_dep(artifact, sha256,  name = None, server_url = "https://repo.maven.apache.org/maven2/"):
    """Comments goes here.
    """
    splits = artifact.split(':')
    if len(splits) != 3:
        fail("Expected artifact to be a package, name, and " +
             "version delimited by colons")
    if name == None:
        name = splits[1].replace('-', '_').replace('.', '_')
    if '-' in name or '.' in name:
        fail("Invalid name, '" + name + "'.  Can not have a dash or period.")




    java_artifact = "{}/{}/{}/{}-{}.jar".format(splits[0].replace(".","/"), splits[1], splits[2], splits[1], splits[2])

    java_import_external(
        name = name,
        jar_sha256 = sha256,
        licenses = ["notice"],
        jar_urls = [
        "{}/{}".format(server_url, java_artifact),
        ],
    )
    print("@{0}")
    print("@{1}")
    native.bind(
        name = name + '-jar',
        actual = '//external:@{0}'.format(name)
    )
