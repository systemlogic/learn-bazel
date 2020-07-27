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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.common.connection.DeptConnection;
import com.common.model.Dept;
import com.common.model.DeptList;
import com.common.model.Message;

@Controller
@RequestMapping(value="/dept")
public class CompanyHandler {

	@Autowired
	DeptConnection connection;

	@ResponseBody @RequestMapping(method=RequestMethod.GET)
	public Object getDepts(@RequestParam(value="petId", required=false) Integer petId,
			HttpServletRequest   request,
			HttpServletResponse  response) throws Exception{
		DeptList result = null;
		
		try{
			result = connection.getDepts();
		}catch(Exception e){
			Message msg = new Message();
			msg.setMsg(e.getMessage());
			return msg;
		}
		
		return result;	

	}
	
	@ResponseBody @RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Object getDept(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		Dept result =null;
		try{
			result = connection.getDept(id);
		}catch(Exception e){
			Message msg = new Message();
			msg.setMsg(e.getMessage());
			return msg;	
		}
		return result;

	}
	@ResponseBody @RequestMapping(value="/{deptid}/{deptDesc}",method=RequestMethod.POST)
	@Transactional
	public Message postDept(@PathVariable("deptid") String deptID, @PathVariable String deptDesc,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		Message result = new Message();
		try{
			result.setMsg(connection.postDept(deptID, deptDesc));
		}catch(Exception e){
			result.setMsg(e.getMessage());	
		}
		return result;

	}
	@ResponseBody @RequestMapping(value="/{deptid}/{deptDesc}",method=RequestMethod.PUT)
	@Transactional
	public Message putDept(@PathVariable("deptid") String deptID, @PathVariable String deptDesc,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		Message result = new Message();
		try{
			result.setMsg(connection.putDept(deptID, deptDesc));
		}catch(Exception e){
			result.setMsg(e.getMessage());	
		}
		return result;

	}
	@ResponseBody @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Transactional
	public Message deleteDept(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		Message result = new Message();
		try{
			result.setMsg(connection.deleteDept(id));
		}catch(Exception e){
			result.setMsg(e.getMessage());	
		}
		return result;

	}
}
