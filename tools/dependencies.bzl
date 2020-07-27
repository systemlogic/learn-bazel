# Generate external dependencies in the WORKSPACE file

def maven_dep(artifact,  name = None, server_url = "https://repo.maven.apache.org/maven2/"):
    """Maven dependency macro to produce //external:<name>-jar targets.
    This rule is used to create an //external:<name>-jar target based
    on a maven artifact.  A name can be manually specified or inferred
    by the second field of the artifact.  For example, if the artifact
    is "com.google.guava:guava:21.0", then the name will match
    "guava".  The generated target will be //external:guava-jar.
    If a name contains periods or dashes, they will automatically be
    replaced by underscores.  For example, the artifact
    "com.google.auto.value:auto-value:1.3" produced the target
    //external:auto_value-jar.
    Args:
        artifact: string, the colon separated maven artifact
        name: string or None, the optional name for the rule
            overridding the inferred name from the artifact.  The
            generated //external rule will always end with a '-jar'.
        server_url: string or None, the optional url for the Maven
            server to download this artifact.  Otherwise, the default
            Maven server is used.
        license: string, a value should be selected from list above
    """
    splits = artifact.split(':')
    if len(splits) != 3:
        fail("Expected artifact to be a package, name, and " +
             "version delimited by colons")
    if name == None:
        name = splits[1].replace('-', '_').replace('.', '_')
    if '-' in name or '.' in name:
        fail("Invalid name, '" + name + "'.  Can not have a dash or period.")

    server = None
    if server_url != None:
        server = name + '_server'
        native.maven_server(
            name = server,
            url = server_url
        )

    native.maven_jar(
        name = name,
        artifact = artifact,
        server = server,
    )

    native.bind(
        name = name + '-jar',
        actual = '@{0}//jar'.format(name)
)
