load("@k8s_deploy//:defaults.bzl", "k8s_deploy")

k8s_deploy(
    name = "pv",
    template = ":pv.yaml",
)

k8s_deploy(
    name = "pvc",
    template = ":pvc.yaml",
)

k8s_deploy(
    name = "mongo",
    template = ":mongo.yaml",
)
