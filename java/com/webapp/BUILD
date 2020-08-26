package(default_visibility = ["//visibility:public"])
exports_files(["dns.yaml"])
exports_files(["file.yaml"])
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
        "//external:javax_servlet-jar",
        "//external:taglibs_standard_spec-jar",
        "//external:taglibs_standard_impl-jar",
    ],
)

docker_build(
    name = "docker",
    base ="@tomcat//image",
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
    tags = ["continuous_deployment"],
)

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_push")

docker_push(
    name = "push",
    image = ":docker",
    registry = "index.docker.io",
    repository = "harshkarora/tomcat",
    tag = "dev",
    tags = ["cd"],
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

    tags = ["continuous_deployment",],
)

java_test(
    name = "WebTest",
    srcs = ["WebTest.java"],
    data = ["index.html"],
    deps = [
       "//external:commons_compress-jar",
       "//external:duct_tape-jar",
       "//external:guava-jar",
       "//external:junit-jar",
       "//external:log4j-jar",
       "//external:slf4j_api-jar",
       "//external:slf4j_ext-jar",
       "//external:slf4j_log4j12-jar",
       "//external:sun_jna-jar",
       "//external:testcontainers-jar",
       "//external:visible_assertions-jar",
       "//external:docker_java-jar"
    ],
    tags = ["skip_test",]
    # add manual tag to skip from test //...
)
