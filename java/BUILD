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
    visibility = ["//javatests:__pkg__"], 
)
