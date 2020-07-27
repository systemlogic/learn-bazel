package(default_visibility = ["//visibility:public"])

java_library(
    name = "hello",
    srcs = ["Hello.java"],
    deps = [],
)

java_binary(
    name = "Hello",
    main_class = "com.systemlogic.sample.Hello",
    runtime_deps = [":hello"],
)
