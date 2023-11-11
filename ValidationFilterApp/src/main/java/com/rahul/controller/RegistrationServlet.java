package com.rahul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.rahul.dao.EmployeeDaoImpl;
import com.rahul.dao.IEmployeeDao;
import com.rahul.dto.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		IEmployeeDao dao = new EmployeeDaoImpl();
		
		Employee employee = new Employee();
		
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setEage(Integer.parseInt(eage));
		employee.setEmail(email);
		employee.setMobile(mobile);
		
		String status = dao.insert(employee);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style = 'color: blue; text-align : center;'>EMPLOYEE REGISTRATION DETAILS</h1>");
		out.println("<table border = '1'>");
		out.println("<tr><th>EID</th><td> " + eid + " </td></tr>");
		out.println("<tr><th>ENAME</th><td> " + ename + " </td></tr>");
		out.println("<tr><th>EAGE</th><td> " + eage + " </td></tr>");
		out.println("<tr><th>EMAIL</th><td> " + email + " </td></tr>");
		out.println("<tr><th>MOBILE</th><td> " + mobile + " </td></tr>");
		out.println("<tr><th>STATUS</th><td> " + status + " </td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
