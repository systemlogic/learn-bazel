package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_build")
load("@io_bazel_rules_docker//java:image.bzl", "war_image")
load("//tools/appengine:appengine.bzl", "java_war")

java_war(
    name = "myapp",
    data = [
        "WEB-INF/web.xml",
        "index.html",
    ],
    data_path = "",
    jars = [
        "//java/com:HelloWorld",
        "@javax_servlet//jar",
        "@taglibs_standard_spec//jar",
        "@taglibs_standard_impl//jar",
    ],
)

docker_build(
    name = "docker",
    base = "@tomcat//image",
    directory = "/root",
    files = [
        ":myapp",
    ],
    ports = [
        "8080",
    ],
    symlinks = {
        "/usr/local/tomcat/webapps/myapp.war": "/root/myapp.war",
    },
)

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_push")

docker_push(
    name = "push",
    image = ":docker",
    registry = "index.docker.io",
    repository = "harshkarora/tomcat",
    tag = "dev",
    tags = ["continuous_deployment"],
)

load("@k8s_deploy//:defaults.bzl", "k8s_deploy")

k8s_deploy(
    name = "dev",
    template = ":deployment.yaml",
)

load("@io_bazel_rules_k8s//k8s:objects.bzl", "k8s_objects")

k8s_objects(
    name = "deployment",
    args = [
        "--v=2",
    ],
    objects = [
        ":dev",
    ],
)

java_test(
    name = "WebTest",
    srcs = ["WebTest.java"],
    data = ["index.html"],
    deps = [
        "@commons_compress//jar",
        "@duct_tape//jar",
        "@guava//jar",
        "@junit//jar",
        "@log4j//jar",
        "@slf4j_api//jar",
        "@slf4j_ext//jar",
        "@slf4j_log4j12//jar",
        "@sun_jna//jar",
        "@testcontainers//jar",
        "@visible_assertions//jar",
        "@docker_java//jar"
    ],
)
