package com.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.model.UID;

@Controller
public class CheckController {
	@ResponseBody @RequestMapping(value="/description", method = RequestMethod.GET)
	public UID getDescription(){
		UID uid = new UID("Pranshi", "Dhingra");
	    return uid;
	}
	
	@ResponseBody @RequestMapping(value="/cookies", method = RequestMethod.GET )
	public Map getCookie(@CookieValue("JSESSIONID") String cookie,
			@RequestHeader("Accept-Encoding") String encoding,
			@RequestHeader("Host") String host,
			@RequestHeader("Accept") String accept,
			@RequestHeader("Accept-Language") String lan
			){
	    Map map = new HashMap();
	    map.put("cookie", cookie);
	    map.put("encoding", encoding);
	    map.put("Host", host);
	    map.put("Accept", accept);
	    map.put("Accept-Language", lan);
		return map;
	}
}