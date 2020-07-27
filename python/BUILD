package(default_visibility = ["//visibility:public"])

py_binary(
    name = "Hello",
    srcs = [
        ":lib",
    ],
)

py_library(
    name = "lib",
    srcs = [
        "Hello.py",
    ],
)

py_test(
    name = "HelloTest",
    srcs = [
        ":HelloTest.py",
    ],
    deps = [
        ":lib",
    ],
)
