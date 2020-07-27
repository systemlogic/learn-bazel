package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_test")

# label would be //go/A:lib-a
go_library(
    name = "lib-a",
    srcs = ["lib_a.go"],
    importpath = "github.systemlogic.com/systemlogic/intro-to-bazel/go/A",
    deps = []
)

# label would be //go/A:test-a
go_test(
    name = "test-a",
    srcs = ["test_a.go"],
    importpath = "github.systemlogic.com/systemlogic/intro-to-bazel/go/A",
    embed = [":lib-a"],
    deps = [],
)
