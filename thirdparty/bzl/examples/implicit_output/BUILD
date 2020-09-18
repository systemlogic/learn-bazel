load(":hash.bzl", "hashes")

exports_files(["hash.bzl"])

# To get the md5 sum, run:
# `bazel build //thirdparty/bzl/examples/implicit_output:build_hash.md5sum`
# If you use `//thirdparty/bzl/examples/implicit_output:build_hash`, you will get only the sha256.
hashes(
    name = "build_hash",
    src = "BUILD",
)
