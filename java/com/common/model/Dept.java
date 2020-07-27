package com.common.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Departments")
public class Dept {
	private String department;
	private String deptDesc;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String toString(){
			
		return "<Dept>" +
				"\n\t\t<department>" + this.getDepartment()+"</department>" +
				"\n\t\t<deptDesc>" + this.getDeptDesc() + "</deptDesc>"+
				"\n\t</Dept>" ;
	}
}
