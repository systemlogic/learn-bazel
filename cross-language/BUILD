load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_binary", "go_test")

go_library(
    name = "lib",
    srcs = ["sample.go"],
    importpath = "github.com/systemlogic/intro-to-bazel/cross-language",
    deps = [],
    data = [
        "//java/com/systemlogic/sample:Hello_deploy.jar",
    ]
)

go_binary(
    name = "say-hello",
    embed = [
        ":lib",
    ],
    importpath = "github.com/systemlogic/intro-to-bazel/cross-language",
)

go_test(
    name = "test-sample",
    srcs = ["test_sample.go"],
    importpath = "github.com/systemlogic/intro-to-bazel/cross-language",
    embed = [":lib"],
    deps = [],
)
