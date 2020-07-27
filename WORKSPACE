
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")


git_repository(
    name = "io_bazel_rules_docker",
    remote = "https://github.com/bazelbuild/rules_docker.git",
    tag = "v0.6.0",
)

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_repositories", "docker_pull")

load(
    "@io_bazel_rules_docker//java:image.bzl",
    _java_image_repos = "repositories",
)

_java_image_repos()

docker_repositories()

docker_pull(
    name = "jetty_image_base",
    registry = "index.docker.io",
    repository = "library/openjdk",
    tag = "8-jre",
)

docker_pull(
    name = "tomcat",
    registry = "index.docker.io",
    repository = "library/tomcat",
    tag = "8",
)

docker_pull(
    name = "python2",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "2",
)

docker_pull(
    name = "python3",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "3",
)

load("//tools:dependencies.bzl", "maven_dep")

maven_dep(
    name = "junit",
    artifact = "junit:junit-dep:4.9",
)

maven_dep(
    name = "netty",
    artifact = 'io.netty:netty-all:4.1.26.Final',
)

maven_dep(
    name = "abbot",
    artifact = 'abbot:abbot:1.4.0',
)

maven_dep(
    name = "javax_servlet",
    artifact = 'javax.servlet:servlet-api:2.5',
)

maven_dep(
    name = "taglibs_standard_impl",
    artifact = 'org.apache.taglibs:taglibs-standard-impl:1.2.5',
)
maven_dep(
    name = "taglibs_standard_spec",
    artifact = 'org.apache.taglibs:taglibs-standard-spec:1.2.5',
)

maven_dep(
    name = "testcontainers",
    artifact = 'org.testcontainers:testcontainers:1.8.1',
)

maven_dep(
    name = "commons_compress",
    artifact = 'org.apache.commons:commons-compress:1.13',
)

maven_dep(
    name = "duct_tape",
    artifact = "org.rnorth.duct-tape:duct-tape:1.0.7",
)

maven_dep(
    name= "slf4j_ext",
    artifact= "org.slf4j:slf4j-ext:1.7.25",
)


maven_dep(
    name= "slf4j_api",
    artifact= "org.slf4j:slf4j-api:1.7.23",
)


maven_dep(
    name = "slf4j_log4j12",
    artifact = "org.slf4j:slf4j-log4j12:1.7.25",
)

maven_dep(
    name = "sun_jna",
    artifact = "com.sun.jna:jna:3.0.9",
)

maven_dep(
    name = "guava",
    artifact = "com.google.guava:guava:21.0",
)


maven_dep(
    name = "log4j",
    artifact = "log4j:log4j:1.2.15",
)


maven_dep(
    name = "visible_assertions",
    artifact = "org.rnorth.visible-assertions:visible-assertions:2.1.1",
)

maven_dep( name = "spring_web", artifact = "org.springframework:spring-web:3.0.4.RELEASE")
maven_dep( name = "jaxb_api", artifact = "javax.xml.bind:jaxb-api:2.1")
maven_dep( name = "jaxb_impl", artifact = "com.sun.xml.bind:jaxb-impl:2.1.2")
maven_dep( name = "aopalliance", artifact = "aopalliance:aopalliance:1.0")
maven_dep( name = "spring_oxm_3", artifact = "org.springframework:spring-oxm:3.0.4.RELEASE")
maven_dep( name = "spring_xml", artifact = "org.springframework.ws:spring-xml:1.5.4")
maven_dep( name = "spring_core", artifact = "org.springframework:spring-core:3.0.4.RELEASE")
maven_dep( name = "activation", artifact = "javax.activation:activation:1.1")
maven_dep( name = "spring_aop", artifact = "org.springframework:spring-aop:3.0.4.RELEASE")
maven_dep( name = "jackson_core_asl", artifact = "org.codehaus.jackson:jackson-core-asl:1.5.0")
maven_dep( name = "jsr173_api", artifact = "javax.xml.bind:jsr173_api:1.0")
maven_dep( name = "jstl", artifact = "javax.servlet:jstl:1.2")
maven_dep( name = "commons_dbcp", artifact = "commons-dbcp:commons-dbcp:1.2.2")
maven_dep( name = "mysql_connector_java", artifact = "mysql:mysql-connector-java:8.0.12")
maven_dep( name = "spring_expression", artifact = "org.springframework:spring-expression:3.0.4.RELEASE")
maven_dep( name = "commons_pool", artifact = "commons-pool:commons-pool:1.3")
maven_dep( name = "standard", artifact = "taglibs:standard:1.1.2")
maven_dep( name = "commons_logging", artifact = "commons-logging:commons-logging:1.1.1")
maven_dep( name = "spring_tx", artifact = "org.springframework:spring-tx:3.0.4.RELEASE")
maven_dep( name = "spring_oxm_1", artifact = "org.springframework.ws:spring-oxm:1.5.4")
maven_dep( name = "spring_beans", artifact = "org.springframework:spring-beans:3.0.4.RELEASE")
maven_dep( name = "spring_context", artifact = "org.springframework:spring-context:3.0.4.RELEASE")
maven_dep( name = "iama1_0", artifact = "org.example:iama1.0:system")
maven_dep( name = "spring_asm", artifact = "org.springframework:spring-asm:3.0.4.RELEASE")
maven_dep( name = "spring_jdbc", artifact = "org.springframework:spring-jdbc:3.0.4.RELEASE")
maven_dep( name = "spring_context_support", artifact = "org.springframework:spring-context-support:3.0.4.RELEASE")
maven_dep( name = "jackson_mapper_asl", artifact = "org.codehaus.jackson:jackson-mapper-asl:1.5.0")
maven_dep( name = "spring_webmvc", artifact = "org.springframework:spring-webmvc:3.0.4.RELEASE")
maven_dep( name = "servlet_api", artifact = "javax.servlet:servlet-api:2.3")
maven_dep( name = "spring_oxm_tiger", artifact = "org.springframework.ws:spring-oxm-tiger:1.5.4")
maven_dep( name = "stax_api", artifact = "stax:stax-api:1.0.1")

git_repository(
    name = "io_bazel_rules_k8s",
    remote = "https://github.com/bazelbuild/rules_k8s.git",
    tag = "v0.1",
)

load("@io_bazel_rules_k8s//k8s:k8s.bzl", "k8s_repositories","k8s_defaults")

k8s_repositories()

k8s_defaults(
  name = "k8s_deploy",
  kind = "deployment",
#  cluster = "cedp-us-south",
  cluster = "docker-for-desktop-cluster",
)


