package com.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.connection.DeptConnection;
import com.common.connection.EmpConnection;

@Controller
public class EmployeeController {

	@Autowired
	EmpConnection connection;
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public ModelAndView getEmp(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelAndView model) throws Exception{
		String result ;
		model.setViewName("result");
		try{
			result = connection.getEmp(id);
		}catch(Exception e){
			model.addObject("message", e.getMessage());
			return model;	
		}
		model.addObject("message",result);
		return model;

	}
	
	@RequestMapping(value="/empList/{id}",method=RequestMethod.GET)
	public String getEmpList(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.getEmpList(id);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";	
		}
		model.addAttribute("message",result);
		return "result";

	}
	
	
	@RequestMapping(value="/emp/{id}/{firstName}/{lastName}/{dept}",method=RequestMethod.POST)
	@Transactional
	public String postEmp(@PathVariable int id,@PathVariable String firstName,
			@PathVariable String lastName,@PathVariable String dept,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.postEmp(id, firstName, lastName, dept);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		model.addAttribute("message", result);
		return "result";
	}
	@RequestMapping(value="/emp/{id}/{firstName}/{lastName}/{dept}",method=RequestMethod.PUT)
	@Transactional
	public String putEmp(@PathVariable int id,@PathVariable String firstName,
			@PathVariable String lastName,@PathVariable String dept,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.putEmp(id, firstName, lastName, dept);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		model.addAttribute("message", result);
		return "result";

	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	@Transactional 
	public String deleteEmp(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.deleteEmp(id);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";	
		}
		model.addAttribute("message", result);
		return "result";

	}
	
}
