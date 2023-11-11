package com.rahul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.rahul.dto.Student;
import com.rahul.service.IStudentService;
import com.rahul.servicefactory.StudentServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher rd = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path Info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform"))
			addForm(request, response, stdService);

		if (request.getRequestURI().endsWith("searchform")) {
			searchForm(request, response, stdService);
		}

		if (request.getRequestURI().endsWith("editform")) {
			editForm(request, response, stdService);
		}

		if (request.getRequestURI().endsWith("deleteform")) {
			deleteForm(request, response, stdService);
		}

		if (request.getRequestURI().endsWith("updateRecord")) {
			updateRecord(request, response, stdService);
		}
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException {
		String sid = request.getParameter("sid");

		Student student = stdService.searchStudent(Integer.parseInt(sid));

		PrintWriter out = response.getWriter();

		if (student != null) {
			out.println("<body>");
			out.println("<center>");
			out.println("<form method ='post' action='./controller/updateRecord'>");
			out.println("<table>");
			out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
			out.println("<input type = 'hidden' name = 'sid' value= '" + student.getSid() + "'/>");
			out.println("<tr><th>NAME</th><td><input type = 'text' name = 'sname' value= '" + student.getSname()
					+ "'/></td></tr>");
			out.println("<tr><th>AGE</th><td><input type = 'text' name = 'sage' value= '" + student.getSage()
					+ "'/></td></tr>");
			out.println("<tr><th>ADDRESS</th><td><input type = 'text' name = 'saddr' value= '" + student.getSaddress()
					+ "'/></td></tr>");
			out.println("<tr><td></td><td><input type='submit' value='UPDATE'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println(
					"<h1 style='Color:blue; text-align:Center;'> RECORD NOT AVAILABLE FOR GIVEN ID : " + sid + "</h1>");
			out.println("</body>");
		}

		out.close();

	}

	private void updateRecord(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException, ServletException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String saddr = request.getParameter("saddr");

		Student student = new Student();
		student.setSid(Integer.parseInt(sid));
		student.setSname(sname);
		student.setSage(Integer.parseInt(sage));
		student.setSaddress(saddr);

		String status = stdService.updateStudent(student);

		if (status.equalsIgnoreCase("success")) {
			rd = request.getRequestDispatcher("../../updatesuccess.html");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("../../updatefailure.html");
			rd.forward(request, response);
		}

	}

	private void deleteForm(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException, ServletException {
		String sid = request.getParameter("sid");

		String msg = stdService.deleteStudent(Integer.parseInt(sid));

		if (msg.equalsIgnoreCase("success")) {
			rd = request.getRequestDispatcher("../deletesuccess.html");
			rd.forward(request, response);
		} else if (msg.equalsIgnoreCase("failure")) {
			rd = request.getRequestDispatcher("../deletefailure.html");
			rd.forward(request, response);

		} else {
			rd = request.getRequestDispatcher("../deletenotfound.html");
			rd.forward(request, response);

		}
	}

	private void searchForm(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException {
		String sid = request.getParameter("sid");

		Student student = stdService.searchStudent(Integer.parseInt(sid));
		PrintWriter out = response.getWriter();

		if (student != null) {
			out.println("<h1 style='Color:blue; text-align:Center;'> STUDENT NAME : " + student.getSid() + "</h1>");
			out.println("<h1 style='Color:blue; text-align:Center;'> STUDENT NAME : " + student.getSname() + "</h1>");
			out.println("<h1 style='Color:blue; text-align:Center;'> STUDENT AGE : " + student.getSage() + "</h1>");
			out.println(
					"<h1 style='Color:blue; text-align:Center;'> STUDENT ADDRESS : " + student.getSaddress() + "</h1>");
		} else
			out.println(
					"<h1 style='Color:blue; text-align:Center;'> RECORD NOT AVAILABLE FOR GIVEN ID : " + sid + "</h1>");

		out.close();
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException, ServletException {
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String saddr = request.getParameter("saddr");

		Student student = new Student();
		student.setSname(sname);
		student.setSage(Integer.parseInt(sage));
		student.setSaddress(saddr);

		String status = stdService.addStudent(student);

		if (status.equals("success")) {
			rd = request.getRequestDispatcher("../success.html");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("../failure.html");
			rd.forward(request, response);
		}

	}
}
