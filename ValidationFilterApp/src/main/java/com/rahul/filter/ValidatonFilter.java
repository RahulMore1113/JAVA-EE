package com.rahul.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ValidatonFilter implements Filter 
{
       
    public void init(FilterConfig fConfig) throws ServletException 
    {
    	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String eid_error_msg = "", ename_error_msg = "", eage_error_msg = "", email_error_msg = "", mobile_error_msg = "";
		boolean flag = true;
		
		PrintWriter out = response.getWriter();
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		if (eid == null || eid.equals(""))
		{
			eid_error_msg = "Employee ID is required";
			flag = false;
		}
		else
		{
			if (!eid.startsWith("iNeuron-"))
			{
				eid_error_msg = "Employee ID should Starts with iNeuron-";
				flag = false;
			}
			else
				flag = true;
		}
		
		if (ename == null || ename.equals(""))
		{
			ename_error_msg = "Employee name is required";
			flag = false;
		}
		else
		{
			if (ename.length()<=3)
			{
				ename_error_msg = "Employee name length should not less than 3";
				flag = false;
			}
			else
				flag = true;
		}
		
		if (eage == null || eage.equals(""))
		{
			eage_error_msg = "Employee age required";
			flag = false;
		}
		else
		{
			if (Integer.parseInt(eage) < 20 || Integer.parseInt(eage) > 30)
			{
				eage_error_msg = "Employee age should be within 20-30";
				flag = false;
			}
			else
				flag = true;
		}
		
		if (email == null || email.equals(""))
		{
			email_error_msg = "Employee email required";
			flag = false;
		}
		else
		{
			if (!email.endsWith("@ineuron.ai"))
			{
				email_error_msg = "Employee email should be end with @ineuron.ai";
				flag = false;
			}
			else
				flag = true;
		}
		
		if (mobile == null || mobile.equals(""))
		{
			mobile_error_msg = "Employee mobile number required";
			flag = false;
		}
		else
		{
			if (!mobile.startsWith("91-"))
			{
				mobile_error_msg = "Employee mobile number should start with 91-";
				flag = false;
			}
			else
				flag = true;
		}
		
		if (flag == true)
			chain.doFilter(request, response);
		else
		{
			out.println("<html><head><title>OUTPUT</title></head>");
			out.println("<body bgcolor = 'lightgreen'>");
			out.println("<center>");
			out.println("<h1 style = 'color: blue; text-align : center;'>EMPLOYEE REGISTRATION DETAILS</h1>");
			out.println("<form method = 'post' action = './reg'>");
			out.println("<table>");
			out.println("<tr><th>EID</th><td><input type = 'text' name = 'eid' value = " + eid + " /></td><td><font color = 'red' size = '5'> " + eid_error_msg + " </td></tr>");
			out.println("<tr><th>ENAME</th><td><input type = 'text' name = 'ename' value = " + ename + " /></td><td><font color = 'red' size = '5'> " + ename_error_msg + " </td></tr>");
			out.println("<tr><th>EAGE</th><td><input type = 'text' name = 'eage' value = " + eage + " /></td><td><font color = 'red' size = '5'> " + eage_error_msg + " </td></tr>");
			out.println("<tr><th>EMAIL</th><td><input type = 'text' name = 'email' value = " + email + " /></td><td><font color = 'red' size = '5'> " + email_error_msg + " </td></tr>");
			out.println("<tr><th>MOBILE</th><td><input type = 'text' name = 'mobile' value = " + mobile + " /></td><td><font color = 'red' size = '5'> " + mobile_error_msg + " </td></tr>");
			out.println("<tr><th></th><td></td><td><input type = 'submit' value = 'reg'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	public void destroy() 
	{
		
	}

}
