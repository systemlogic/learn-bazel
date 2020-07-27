package com.common.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeptList {
	List<Dept> dept;

	public List<Dept> getDept() {
		return dept;
	}

	public void setDept(List<Dept> dept) {
		this.dept = dept;
	}
}
