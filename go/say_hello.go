package main


import(
  "fmt"
  "github.systemlogic.com/systemlogic/intro-to-bazel/go/A"
  "github.systemlogic.com/systemlogic/intro-to-bazel/go/B"
)

func main() {
  fmt.Println(A.SayHello("Systemlogic"))
  fmt.Println(B.SayHello("Systemlogic"))
}
