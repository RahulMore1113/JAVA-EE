package com.rahul.controller;

import java.io.IOException;

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
			throws IOException, ServletException {
		String sid = request.getParameter("sid");

		Student student = stdService.searchStudent(Integer.parseInt(sid));

		RequestDispatcher rd = null;

		if (student != null) {
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../updateForm.jsp");
			rd.forward(request, response);
		}

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
			request.setAttribute("status", "success");
			rd = request.getRequestDispatcher("../deleteResult.jsp");
			rd.forward(request, response);
		} else if (msg.equalsIgnoreCase("failure")) {
			request.setAttribute("status", "failure");
			rd = request.getRequestDispatcher("../deleteResult.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("status", "not found");
			rd = request.getRequestDispatcher("../deleteResult.jsp");
			rd.forward(request, response);

		}
	}

	private void searchForm(HttpServletRequest request, HttpServletResponse response, IStudentService stdService)
			throws IOException, ServletException {
		String sid = request.getParameter("sid");

		Student student = stdService.searchStudent(Integer.parseInt(sid));
		request.setAttribute("student", student);

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("../display.jsp");
		rd.forward(request, response);

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

		String status = stdService.addstudent(student);

		if (status.equals("success")) {
			request.setAttribute("status", "success");
			rd = request.getRequestDispatcher("../insertResult.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("status", "failure");
			rd = request.getRequestDispatcher("../insertResult.jsp");
			rd.forward(request, response);
		}

	}
}
