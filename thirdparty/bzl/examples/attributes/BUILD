load("//thirdparty/bzl/examples/attributes:printer.bzl", "printer")

exports_files(["printer.bzl"])

# Run 'bazel build :some_target' to print its information.
printer(
    name = "some_target",
    deps = [
        "BUILD",
        ":other",
    ],
)

# This target is a dependency of 'some_target', so it is automatically analyzed
# when you build 'some_target'.
printer(name = "other")
