package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_docker//container:container.bzl", "container_image")
load("@rest_deps//:requirements.bzl", "requirement")
load("@rules_python//python:defs.bzl", "py_binary", "py_test")

py_binary(
    name = "rest",
    srcs = ["rest.py"],
    data = [],
    main = "rest.py",
    deps = [
        requirement("httpserver")
    ],
)

container_image(
    name = "docker",
    base = "@python3//image",
    cmd = "pip install  -r /root/requirements.txt && python /root/rest.py",
    directory = "/root",
    files = [
        ":rest",
        ":requirements.txt"
    ],
)

load("@io_bazel_rules_docker//container:container.bzl", "container_push")

container_push(
    name = "push",
    image = ":docker",
    registry = "index.docker.io",
    repository = "harshkarora/python",
    tag = "dev",
    format = "Docker",
)

load("@k8s_deploy//:defaults.bzl", "k8s_deploy")

k8s_deploy(
    name = "dev",
    template = ":deployment.yaml",
)
