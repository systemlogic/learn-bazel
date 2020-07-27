package com.common.mapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;


import noNamespace.CompanyDocument;
import noNamespace.impl.CompanyDocumentImpl;
import noNamespace.impl.CompanyDocumentImpl.CompanyImpl.DeptImpl;

import org.springframework.jdbc.core.RowMapper;

import com.common.model.Emp;

public class EmpRowMapper implements RowMapper {

	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpID(rs.getInt("EmpID"));
		emp.setFirstName(rs.getString("FirstName"));
		emp.setLastName(rs.getString("LastName"));
		emp.setDepartment(rs.getString("DeptDesc"));
		return emp;
	}
}
