load(":execute.bzl", "execute")

exports_files(["execute.bzl"])

# `bazel build //thirdparty/bzl/examples/runfiles:all` will create an executable.
# `bazel run //thirdparty/bzl/examples/runfiles:all` will run it.
execute(
    name = "e",
    # The location will be expanded to "pkg/data.txt", and it will reference
    # the data.txt file in runfiles when this target is invoked as
    # "bazel run //thirdparty/bzl/examples/pkg:e".
    command = "cat $(location :data.txt)",
    data = [":data.txt"],
)
