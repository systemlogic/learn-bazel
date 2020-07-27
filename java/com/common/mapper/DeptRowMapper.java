package com.common.mapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;


import noNamespace.CompanyDocument;
import noNamespace.impl.CompanyDocumentImpl;
import noNamespace.impl.CompanyDocumentImpl.CompanyImpl.DeptImpl;

import org.springframework.jdbc.core.RowMapper;

import com.common.model.Dept;

public class DeptRowMapper implements RowMapper {

	public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dept dept = new Dept();
		dept.setDepartment(rs.getString("department"));
		dept.setDeptDesc(rs.getString("DeptDesc"));
		return dept;
	}
}
