
workspace(name = "learn_bazel")


load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")


git_repository(
    name = "subpar",
    remote = "https://github.com/google/subpar.git",
    tag = "2.0.0",
)

git_repository(
    name = "io_bazel_rules_k8s",
    remote = "https://github.com/bazelbuild/rules_k8s.git",
    tag = "v0.4",
)

load("@io_bazel_rules_k8s//k8s:k8s.bzl", "k8s_repositories","k8s_defaults")

k8s_repositories()

k8s_defaults(
  name = "k8s_deploy",
  kind = "deployment",
#  cluster = "cedp-us-south",
  cluster = "docker-for-desktop-cluster",
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "ae6814b6a8e09e7a9f5b20c1add51ada6a2cc664d4659aeca2921c10674e24e3",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.22.9/rules_go-v0.22.9.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.22.9/rules_go-v0.22.9.tar.gz",
    ],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_rules_dependencies", "go_register_toolchains")

go_rules_dependencies()

go_register_toolchains()

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()


http_archive(
    name = "bazel_gazelle",
    sha256 = "7fc87f4170011201b1690326e8c16c5d802836e3a0d617d8f75c3af2b23180c4",
    urls = ["https://github.com/bazelbuild/bazel-gazelle/releases/download/0.18.2/bazel-gazelle-0.18.2.tar.gz"],
)

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies", "go_repository")

gazelle_dependencies()

skylib_version = "0.8.0"


http_archive(
    name = "bazel_skylib",
    url = "https://github.com/bazelbuild/bazel-skylib/archive/0.7.0.tar.gz",
    sha256 = "2c62d8cd4ab1e65c08647eb4afe38f51591f43f7f0885e7769832fa137633dcb",
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()



http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "4521794f0fba2e20f3bf15846ab5e01d5332e587e9ce81629c7f96c793bb7036",
    strip_prefix = "rules_docker-0.14.4",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.14.4/rules_docker-v0.14.4.tar.gz"],
)

load("@io_bazel_rules_docker//toolchains/docker:toolchain.bzl",
    docker_toolchain_configure="toolchain_configure"
)

docker_toolchain_configure(
  name = "docker_config",
  client_config="/home/fyre/.config",
)


load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()
load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")

container_deps()

load(
    "@io_bazel_rules_docker//container:container.bzl",
    "container_pull",
)

container_pull(
    name = "jetty_image_base",
    registry = "index.docker.io",
    repository = "library/openjdk",
    tag = "8-jre",
)

container_pull(
    name = "tomcat",
    registry = "index.docker.io",
    repository = "library/tomcat",
    tag = "8",
)

container_pull(
    name = "python2",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "2",
)

container_pull(
    name = "python3",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "3",
)

load("//tools:dependencies.bzl", "maven_dep")



maven_dep(
    name = "com_google_truth",
    artifact = "com.google.truth:truth:1.0.1",
)

maven_dep(
    name = "com_google_guava",
    artifact = "com.google.guava:guava:28.1-jre",
)

maven_dep(
    name = "com_googlecode_java_diff_utils",
    artifact = "com.googlecode.java-diff-utils:diffutils:1.2",
)


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
maven_dep( name = "javax_servlet_api", artifact = "javax.servlet:javax.servlet-api:4.0.1")


register_toolchains(
    "@io_bazel_rules_docker//toolchains/docker:default_linux_toolchain",
    "@io_bazel_rules_docker//toolchains/docker:default_windows_toolchain",
    "@io_bazel_rules_docker//toolchains/docker:default_osx_toolchain",
)

http_archive(
    name = "rules_python",
    url = "https://github.com/bazelbuild/rules_python/releases/download/0.0.2/rules_python-0.0.2.tar.gz",
    strip_prefix = "rules_python-0.0.2",
    sha256 = "b5668cde8bb6e3515057ef465a35ad712214962f0b3a314e551204266c7be90c",
)


load("@rules_python//python:pip.bzl", "pip_import", "pip_repositories")

pip_repositories()

pip_import(
    name = "rest_deps",
    requirements = "//python/web:requirements.txt",
)

load("@rest_deps//:requirements.bzl", _rest_deps_install = "pip_install")
_rest_deps_install()
