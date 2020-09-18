load("//thirdparty/bzl/examples/executable:fortune.bzl", "haiku_fortune")

exports_files(["fortune.bzl"])

haiku_fortune(
    name = "bazel_haikus",
    srcs = [
        "correct.txt",
        "extensible.txt",
        "fast.txt",
        "incremental.txt",
        "polyglot.txt",
        "reproducible.txt",
    ],
)
