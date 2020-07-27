package com.common.util;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.HiddenHttpMethodFilter;

public class CustomizedHiddenHttpMethodFilter extends HiddenHttpMethodFilter
{
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException
  {
    // Customize Request
    request = new CustomizedRequestWrapper((HttpServletRequest) request);

    String qs = request.getQueryString();
    qs = ( qs == null )? "":("?"+qs);
    System.out.println("Received " + request.getMethod() + " " + request.getRequestURL().toString() + URLDecoder.decode(qs));

   

    super.doFilterInternal(request, response, filterChain);
  }

}