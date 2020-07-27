package com.common.connection;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.common.mapper.DeptRowMapper;
import com.common.mapper.EmpRowMapper;
import com.common.model.Dept;
import com.common.model.Emp;

@Repository
public class EmpConnection {
	@Autowired
	@Qualifier("jdbctemplete")
	private JdbcTemplate jdbctemp;

	public String getEmpList(String id){
		String sql ="SELECT * FROM emp WHERE department=?";
		List<Map<String, Object>> emps = jdbctemp.queryForList(sql,new Object[] { id });
		String result = "<Employees>";
		for(Map emp : emps){
			result+=	"\n\t\t<Employee>" +
			"\n\t\t\t<EmpID>" + emp.get("EmpID")+"</EmpID>" +
			"\n\t\t\t<FirstName>" + emp.get("FirstName")+"</FirstName>" +
			"\n\t\t\t<LastName>" + emp.get("LastName")+"</LastName>" +
			"\n\t\t\t<Department>" + emp.get("department")+"</Department>" +
			"\n\t\t</Employee>" ;
		}
		return result + "\n\t</Employees>";
	}

	public String getEmp(String id){
		String sql ="select e.*, d.DeptDesc from emp e INNER JOIN dept d on d.department=e.department  where e.EmpId=?";
		//String sql = "select emp.EmpId, emp.FirstName, emp.LastName, dept.DeptDesc from emp INNER JOIN dept on dept.department=emp.department  where emp.EmpId=?";
		Emp emp = (Emp)jdbctemp.queryForObject(
				sql, new Object[] { id }, new EmpRowMapper());
		return "<Emp>" +
		"\n\t\t<EmpID>" + emp.getEmpID()+"</EmpID>" +
		"\n\t\t<FirstName>" + emp.getFirstName()+"</FirstName>" +
		"\n\t\t<LastName>" + emp.getLastName()+"</LastName>" +
		"\n\t\t<Department>" + emp.getDepartment()+"</Department>" +
		"\n\t</Emp>" ;
	}


	public String postEmp(int id,String firstName,String lastName,String dept){
		String sql = "insert into emp(EmpID,FirstName,LastName,department) values(?,?,?,?);";
		int k = jdbctemp.update(sql,new Object[] {id, firstName,lastName,dept});
		return "<Result>" + k + " Record has been successfully Inserted to database"+ 
		"</Result>";
	}
	public String putEmp(int id,String firstName,String lastName,String dept){
		String sql = "UPDATE emp set FirstName=?,LastName=?,department=? WHERE EmpID=?";
		int k = jdbctemp.update(sql, new Object[] {firstName,lastName,dept, id});
		return "<Result>" + k + " Record has been successfully Updated in database"+ 
		"</Result>";
	}
	public String deleteEmp(String id){
		String sql = "DELETE FROM emp WHERE EmpID=?";
		int k = jdbctemp.update(sql, new Object[] { id});
		return "<Result>" + k + " Record has been Deleted successfully from database"+ 
		"</Result>";
	}

}
