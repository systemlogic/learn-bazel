load("//thirdparty/bzl/examples/predeclared_outputs:hash.bzl", "word_hashes")

exports_files(["hash.bzl"])
# Run any of the following:
#   bazel build //thirdparty/bzl/examples/predeclared_outputs:animal_hashes
#   bazel build //thirdparty/bzl/examples/predeclared_outputs:animal_hashes.manifest
#   bazel build //thirdparty/bzl/examples/predeclared_outputs:dog.md5
#   bazel build //thirdparty/bzl/examples/predeclared_outputs:cat.md5
#   bazel build //thirdparty/bzl/examples/predeclared_outputs:elephant.md5
# Run "bazel clean" to remove files from a previous build.

word_hashes(
    name = "animal_hashes",
    dictionary = "animals.dict",
    hashes = [
        ":dog.md5",
        ":cat.md5",
        ":elephant.md5",
    ],
)
