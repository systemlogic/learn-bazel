load("//thirdparty/bzl/examples/depsets:foo.bzl", "foo_library", "foo_binary")

exports_files(["foo.bzl"])

# Our hypothetical Foo compiler.
py_binary(
    name = "foocc",
    srcs = ["foocc.py"],
)

foo_library(
    name = "a",
    srcs = [
        "a.foo",
        "a_impl.foo",
    ],
)

foo_library(
    name = "b",
    srcs = [
        "b.foo",
        "b_impl.foo",
    ],
    deps = [":a"],
)

foo_library(
    name = "c",
    srcs = [
        "c.foo",
        "c_impl.foo",
    ],
    deps = [":a"],
)

foo_binary(
    name = "d",
    srcs = ["d.foo"],
    deps = [
        ":b",
        ":c",
    ],
)
