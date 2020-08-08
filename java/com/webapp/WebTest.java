package com.webapp;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testcontainers.containers.GenericContainer;

import java.io.FileReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(JUnit4.class)
public class WebTest {

  private String page = "index.html";
  private static final int PORT = 8080;
  private static String ipAddress ;
  @ClassRule public static GenericContainer webContainer = new GenericContainer("harshkarora/tomcat:dev");

  @BeforeClass
  public static void initializeConnection() {
    webContainer.start(); 
    webContainer.addExposedPort(8080);
    ipAddress = webContainer.getContainerInfo().getNetworkSettings().getIpAddress();
    System.out.println("IP address = " + ipAddress.toString());
  }

  @Test
  public void checkURL() throws Exception {


    URL url = new URL("http://" + ipAddress + ":" + PORT + "/myapp/HelloWorld");
    System.out.println("Address = " + url.toString());
    BufferedReader in = new BufferedReader( new InputStreamReader(url.openStream()));
    String inputLine;
    String content = "";
    while ((inputLine = in.readLine()) != null)
      content += inputLine;

    Assert.assertTrue(content.equals("Hello")) ;
    in.close(); 
  }

}

