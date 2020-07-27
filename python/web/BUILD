package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_build")

py_binary(
    name = "rest",
    srcs = ["rest.py"],
    data = [],
    main = "rest.py",
    deps = [
    ],
)

docker_build(
    name = "docker",
    base = "@python2//image",
    cmd = "/root/rest.py",
    directory = "/root",
    files = [
        ":rest",
    ],
)

load("@io_bazel_rules_docker//docker:docker.bzl", "docker_push")

docker_push(
    name = "push",
    image = ":docker",
    registry = "index.docker.io",
    repository = "harshkarora/python",
    tag = "dev",
)

load("@k8s_deploy//:defaults.bzl", "k8s_deploy")

k8s_deploy(
    name = "dev",
    template = ":deployment.yaml",
)
