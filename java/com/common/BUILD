package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_build", "docker_push")
#load("@io_bazel_rules_appengine//appengine:java_appengine.bzl", "java_war")
load("//tools/appengine:appengine.bzl", "java_war")

java_war(
    name = "myapp",
    data = [
        "WEB-INF/datasource-servlet.xml",
        "WEB-INF/error/404.jsp",
        "WEB-INF/error/405.jsp",
        "WEB-INF/error/500.jsp",
        "WEB-INF/jdbc.properties",
        "WEB-INF/json-servlet.xml",
        "WEB-INF/pages/error.jsp",
        "WEB-INF/pages/result.jsp",
        "WEB-INF/web.xml",
        "WEB-INF/web-servlet.xml",
        "index.jsp",
    ],
    data_path = "",
    jars = [
        ":common",
    ],
)

java_library(
    name = "common",
    runtime_deps = [
        "//java/com/common/connection",
        "//java/com/common/controller",
        "//java/com/common/mapper",
        "//java/com/common/model",
        "//java/com/common/util",
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

docker_push(
    name = "push",
    image = ":docker",
    registry = "index.docker.io",
    repository = "harshkarora/empdept",
    tag = "dev",
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
