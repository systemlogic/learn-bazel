load("//thirdparty/bzl/examples/expand_template:hello.bzl", "hello")

exports_files(["hello.bzl"])

# Generates a C++ source file that says "Hello John!".
hello(
    name = "hello_john_src",
    firstname = "John",
)

cc_binary(
    name = "hello",
    srcs = [":hello_john_src"],
)
