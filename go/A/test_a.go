package A

import (
	"testing"
)

func TestA(t *testing.T) {
	inp := "Systemlogic"
	expResult := "hello Systemlogic, greetings from package A"
	if out := SayHello(inp); out != expResult {
		t.Fatalf("Test Case failed, expected result: %s, actual result: %s", expResult, out)
	}
}
