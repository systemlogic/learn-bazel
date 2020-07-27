package main

import(
  "fmt"
  "github.systemlogic.com/systemlogic/intro-to-bazel/go/A"
  "github.systemlogic.com/systemlogic/intro-to-bazel/go/B"
)

func main() {
  fmt.Println(A.SayHello("IBM"))
  fmt.Println(B.SayHello("IBM"))
}
