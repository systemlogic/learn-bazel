package(default_visibility = ["//visibility:public"])

java_library(
    name = "HelloWorld",
    srcs = [
        "HelloWorld.java",
    ],
    deps = [
        "//external:javax_servlet_api-jar",
    ],
)

java_binary(
    name = "Hello",
    main_class = "Hello",
    runtime_deps = [":helloLib"],
)

java_library(
    name = "helloLib",
    srcs = [
        ":Hello.java",
    ],
    visibility = ["//javatests/com:__pkg__"],
)
