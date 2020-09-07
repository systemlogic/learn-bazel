package com.systemlogic.sample;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import com.systemlogic.sample.Hello;

public class HelloTest {
  @Test
  public void testGreetMessage() {
    String expectedOutput = "Hello Systemlogic, greetings sent from java src code";
    assertThat(Hello.sayHello("Systemlogic")).isEqualTo(expectedOutput);
  }
}
