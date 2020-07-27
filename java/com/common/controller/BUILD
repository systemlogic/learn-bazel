package(default_visibility = ["//visibility:public"])

java_library(
    name = "controller",
    srcs = glob(["*.java"]),
    deps = [
        "//java/com/common/connection",
        "//java/com/common/mapper",
        "//java/com/common/model",
        "@servlet_api//jar",
        "@spring_beans//jar",
        "@spring_context//jar",
        "@spring_tx//jar",
        "@spring_web//jar",
        "@spring_webmvc//jar",
    ],
)
