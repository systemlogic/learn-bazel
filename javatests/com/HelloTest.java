package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import Hello;

@RunWith(JUnit4.class)
public class HelloTest {

   @Test
   public void getAllClassifiersTest() throws Exception {
     Hello hello = new Hello(5);
     Assert.assertTrue(hello.getValue()==5);
   }

}
