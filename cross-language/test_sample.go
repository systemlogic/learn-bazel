package main

import (
	"testing"
)

func TestHello(t *testing.T) {
	expResult := "Hello IBM, greetings sent from java src code"
	if out, _ := callJavaHello(); out != expResult {
		t.Fatalf("Test Case failed, expected result: %s, actual result: %s", expResult, out)
	}
}
