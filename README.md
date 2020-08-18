# Bazel


## Cross language bazel query

```
bazel query 'rdeps(set(//cross-language/... //java/...), set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java)'

bazel query 'rdeps(//..., set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java)'
```

## List all affected test case
```
bazel query 'kind(".*_test rule", rdeps(set(//cross-language/... //java/... //javatests/...), set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java))'
```

## List all affected library rules
```
bazel query 'kind(".*_library rule", rdeps(set(//cross-language/... //java/... //javatests/...), set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java))'
```

## List all affected rules
```
bazel query 'kind(rule, rdeps(set(//cross-language/... //java/... //javatests/...), set(//java/com/systemlogic/sample:Hello.java)) - set(//java/com/systemlogic/sample:Hello.java))'
```
## Find list of changed files
```
git diff --name-only origin/master..origin/branchName
```
