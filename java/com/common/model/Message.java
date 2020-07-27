package com.common.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Result")
public class Message {
	String result;

	public String getMsg() {
		return result;
	}

	public void setMsg(String msg) {
		this.result = msg;
	}	
}
