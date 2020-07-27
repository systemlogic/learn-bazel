package com.common.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UID")
public class UID {
	String firstname;
	String lastName;
	public UID(){
	}
	public UID(String f,String l){
		firstname = f ;
		lastName = l;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
