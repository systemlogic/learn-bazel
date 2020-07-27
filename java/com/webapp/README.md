To setup ingress locally, please refer
https://github.com/jnewland/local-dev-with-docker-for-mac-kubernetes

once installed, please add following entry
```
git_repository(
    name = "io_bazel_rules_k8s",
    remote = "https://github.com/bazelbuild/rules_k8s.git",
    tag = "v0.1",
)

load("@io_bazel_rules_k8s//k8s:k8s.bzl", "k8s_repositories","k8s_defaults")

k8s_repositories()

k8s_defaults(
  name = "k8s_deploy",
  kind = "deployment",
#  cluster = "cedp-us-south",
  cluster = "docker-for-desktop-cluster",
)
```

To Deploy on cluser 
bazel run :dev.apply

If deployment is successful url http://tomcat.localhost/myapp/ would be accessable.

To Delete on Cluster
bazel run :dev.delete

To Describe the yaml
bazel run :dev.describe


