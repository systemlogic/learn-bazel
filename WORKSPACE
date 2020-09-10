workspace(name = "learn_bazel")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

git_repository(
    name = "subpar",
    remote = "https://github.com/google/subpar.git",
    tag = "2.0.0",
)

git_repository(
    name = "io_bazel_rules_k8s",
    remote = "https://github.com/bazelbuild/rules_k8s.git",
    tag = "v0.4",
)

load("@io_bazel_rules_k8s//k8s:k8s.bzl", "k8s_defaults", "k8s_repositories")

k8s_repositories()

k8s_defaults(
    name = "k8s_deploy",
    #  cluster = "cedp-us-south",
    cluster = "docker-desktop",
    kind = "deployment",
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "ae6814b6a8e09e7a9f5b20c1add51ada6a2cc664d4659aeca2921c10674e24e3",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.22.9/rules_go-v0.22.9.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.22.9/rules_go-v0.22.9.tar.gz",
    ],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

http_archive(
    name = "bazel_gazelle",
    sha256 = "7fc87f4170011201b1690326e8c16c5d802836e3a0d617d8f75c3af2b23180c4",
    urls = ["https://github.com/bazelbuild/bazel-gazelle/releases/download/0.18.2/bazel-gazelle-0.18.2.tar.gz"],
)

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies", "go_repository")

gazelle_dependencies()

skylib_version = "0.8.0"

http_archive(
    name = "bazel_skylib",
    sha256 = "2c62d8cd4ab1e65c08647eb4afe38f51591f43f7f0885e7769832fa137633dcb",
    url = "https://github.com/bazelbuild/bazel-skylib/archive/0.7.0.tar.gz",
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

git_repository(
    name = "io_bazel_rules_docker",
    remote = "https://github.com/bazelbuild/rules_docker.git",
    tag = "v0.14.4",
)

load(
    "@io_bazel_rules_docker//toolchains/docker:toolchain.bzl",
    docker_toolchain_configure = "toolchain_configure",
)

docker_toolchain_configure(
    name = "docker_config",
    client_config = "/home/fyre/.docker/",
)

load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()

load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")

container_deps()

load(
    "@io_bazel_rules_docker//container:container.bzl",
    "container_pull",
)

container_pull(
    name = "jetty_image_base",
    registry = "index.docker.io",
    repository = "library/openjdk",
    tag = "8-jre",
)

container_pull(
    name = "tomcat",
    registry = "index.docker.io",
    repository = "library/tomcat",
    tag = "8",
)

container_pull(
    name = "python2",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "2",
)

container_pull(
    name = "python3",
    registry = "index.docker.io",
    repository = "library/python",
    tag = "3",
)

load("//tools:maven_repository.bzl", "define_java_dependencies")

define_java_dependencies()

register_toolchains(
    "@io_bazel_rules_docker//toolchains/docker:default_linux_toolchain",
    "@io_bazel_rules_docker//toolchains/docker:default_windows_toolchain",
    "@io_bazel_rules_docker//toolchains/docker:default_osx_toolchain",
)

http_archive(
    name = "rules_python",
    sha256 = "b5668cde8bb6e3515057ef465a35ad712214962f0b3a314e551204266c7be90c",
    strip_prefix = "rules_python-0.0.2",
    url = "https://github.com/bazelbuild/rules_python/releases/download/0.0.2/rules_python-0.0.2.tar.gz",
)

load("@rules_python//python:pip.bzl", "pip_import", "pip_repositories")

pip_repositories()

pip_import(
    name = "rest_deps",
    requirements = "//python/web:requirements.txt",
)

load("@rest_deps//:requirements.bzl", _rest_deps_install = "pip_install")

_rest_deps_install()
