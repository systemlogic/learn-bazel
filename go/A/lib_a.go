package A

import (
	"fmt"
)

func SayHello(name string) string {
	return fmt.Sprintf("hello %s, greetings from package A", name)
}
