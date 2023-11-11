package com.rahul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rahul.dto.Employee;
import com.rahul.util.JdbcUtil;

public class EmployeeDaoImpl implements IEmployeeDao
{
	@Override
	public String insert(Employee employee) 
	{
		PreparedStatement pstmt = null;
		String status = null;
		
		try 
		{
			Connection con = JdbcUtil.getJdbcConnection();
			
			if (con != null)
				pstmt = con.prepareStatement("insert into employee(eid,ename,eage,email,mobile) values (?,?,?,?,?)");
			
			if (pstmt != null)
			{
				pstmt.setString(1, employee.getEid());
				pstmt.setString(2, employee.getEname());
				pstmt.setInt(3, employee.getEage());
				pstmt.setString(4, employee.getEmail());
				pstmt.setString(5, employee.getMobile());
				
				int affectedRow = pstmt.executeUpdate();
				
				if (affectedRow == 1)
					status = "success";
				else
					status = "failure";
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
}
