package com.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.model.Dept;
import com.common.model.Message;

@Controller
public class crossdomain {
	@ResponseBody @RequestMapping(value="/crossdomain.xml",method=RequestMethod.GET)
	public String getDept(HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result = "<?xml version='1.0'?>"
				+ "<!DOCTYPE cross-domain-policy SYSTEM '/xml/dtds/cross-domain-policy.dtd'>"
				+ "<cross-domain-policy>"
				+ "<site-control permitted-cross-domain-policies='all'/>"
				+ "<allow-access-from domain='*' to-ports='*' />"
				+ "<allow-http-request-headers-from domain='*' headers='*'/>"
				+ "</cross-domain-policy>";
		
		return result;

	}
}
