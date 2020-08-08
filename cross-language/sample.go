package main

import (
	"fmt"
	"log"
	"os"
	"os/exec"
	"path"
	"path/filepath"
	"strings"
)

func getRunFilesDir() (string, error) {
	binaryPath := filepath.Dir(os.Args[0])
 fmt.Printf(binaryPath)
	binary := filepath.Base(os.Args[0])
 fmt.Printf(binary)
	if index := strings.LastIndex(binaryPath, binary+".runfiles/learn_bazel/"); index > 0 {
		binaryPath = binaryPath[:index]
	}
	return filepath.Abs(path.Join(binaryPath, binary+".runfiles", "learn_bazel"))
}

func callJavaHello() (string, error) {
	dir, err := getRunFilesDir()
	if err != nil {
		return "", err
	}

	jarPath := filepath.Join(dir, "java/com/systemlogic/sample/Hello_deploy.jar")

	byteOut, err := exec.Command("java", "-jar", jarPath).Output()
	if err != nil {
		return "", err
	}

	return strings.TrimSpace(string(byteOut)), nil
}

func main() {
	val, err := callJavaHello()
	if err != nil {
		log.Fatalf("Error in callJavaHello: %v", err)
		return
	}

	fmt.Printf(val)
}
