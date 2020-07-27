java_binary(
    name = "Hello",
    srcs = [
        ":Hello.java",
    ],
    main_class = "Hello",
)

java_test(
    name = "HelloTest",
    srcs = [
        "Hello.java",
        "HelloTest.java",
    ],
    deps = [
        "@abbot//jar",
        "@junit//jar",
        "@netty//jar",
    ],
)
