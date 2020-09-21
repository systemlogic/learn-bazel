package com.systemlogic.sample;

import java.lang.String;


public class Hello {
  public static String sayHello(String name) {
    return String.format("Hello %s, greetings sent from java src code", name);
  }
  public static void main(String[] args) {
    System.out.println(sayHello("Systemlogic"));
  }
}
