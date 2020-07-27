load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_binary")

# label would be //go:lib-hello
go_library(
    name = "lib-hello",
    srcs = ["say_hello.go"],
    importpath = "github.systemlogic.com/systemlogic/intro-to-bazel/go",
    deps = [
        "//go/A:lib-a",
        "//go/B:lib-b",
    ]
)

# label would be //go:say-hello
go_binary(
    name = "say-hello",
    embed = [
        ":lib-hello",
    ],
    importpath = "github.systemlogic.com/systemlogic/intro-to-bazel/go",
)
