# Bazel Query
Tool to play with artifacts, builds and CI.

## Bazel build label of file
```
bazel query java/Hello.java
echo "That is how it is represented in bazel world."
```

## Bazel query a target
```
bazel query java:Hello
bazel query java/com/systemlogic/sample:hello 
bazel query python:Hello
bazel query python/...
```
## Bazel query all targets
```
bazel query python/...
bazel query java/...
bazel query //...
```
## Bazel query output package of targers
```
bazel query java/Hello.java --output package
bazel query 'java/...' --output package
bazel query //... --output package
```
## Bazel query output label_kind of targets
```
bazel query //... --output label_kind
```
## Bazel query type rules
```
bazel query 'kind(rule, //...)' --output label_kind
```
## Bazel query for binaries
```
bazel query 'kind(.*_binary, //...)' --output label_kind
```
## Bazel query for test cases
```
bazel query 'kind(.*_test, //...)' --output label_kind
```
## Bazel query Reverse Dependency of target x in transitive closure y.
```
echo "bazel query 'rdeps(set(y), set(x))'"
bazel query 'rdeps(set(//java/...), set(//java:Hello.java))' 
bazel query 'rdeps(set(//...), set(//java:Hello.java))' 
```
## Bazel query Reverse Dependency of target spreaded over multiple package  <--- Affected targets
```
bazel query 'rdeps(set(//java/...), set(java/com/systemlogic/sample:Hello.java))'
bazel query 'rdeps(set(//java/... //python/...), set(java/com/systemlogic/sample:Hello.java))'
bazel query 'rdeps(set(//java/... //python/... //cross-language/...), set(java/com/systemlogic/sample:Hello.java))'
bazel query 'rdeps(set(//...), set(java/com/systemlogic/sample:Hello.java))'
echo "Simply removing file name targets"
bazel query 'rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java)'
bazel query 'rdeps(//..., set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java)'
```

## List all affected test cases
```
bazel query 'kind(".*_test rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )))'

bazel test `bazel query 'kind(".*_test rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )))'`
```
## List of affected test cases except failed one or compute intensive.
```
bazel query 'kind(".*_test rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )) except set(//java/com/webapp:WebTest) )'

echo "OR simply tag the test case with skip_test or any custome string. skip_test is used in this perticular case."

bazel query 'kind(".*_test rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )) except attr(tags, "skip_test", kind(".*_test rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )))) )'
//javatests/com/systemlogic/sample:HelloTest

```
## Run test case in serial mode
Please use exclusive tag in tags attribute.


## List all affected library rules
```
bazel query 'kind(".*_library rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )))'
```
## List all affected binarys
```
bazel query 'kind(".*_binary rule", rdeps(set(//...), set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html )))'
```

## List of affected rules
```
bazel query 'kind("rule", rdeps(//..., set(//java/com/systemlogic/sample:Hello.java java/com/webapp/deployment.yaml  java/com/webapp/index.html)) )' --output label_kind

echo "Please note: appengine_war_base, container_image_, and _k8s_object are not in category of binary, library, test case"
```



## Find list of changed files
```
git diff --name-only origin/master..origin/branchName
```

## Action Query
Interested in the properties of the Actions/Artifacts generated.
```
bazel aquery 'deps(//java:Hello)'
bazel aquery 'mnemonic("JavaDeployJar", deps(//java/...))'
bazel aquery 'inputs(".*systemlogic/sample/Hello.jar" ,deps(//java/com/systemlogic/sample:Hello))'
bazel aquery 'outputs("bazel-out/k8-fastbuild/internal/_middlemen/java_Scom_Ssystemlogic_Ssample_SHello-runfiles" ,deps(//java/com/systemlogic/sample:Hello))'
```
where inputs, outputs and mnemonic are filter function.

## Configurable Query

