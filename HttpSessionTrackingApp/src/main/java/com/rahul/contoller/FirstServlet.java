package com.rahul.contoller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");

		HttpSession session = request.getSession();
		session.setAttribute("sname", sname);
		session.setAttribute("sage", sage);

		RequestDispatcher rd = request.getRequestDispatcher("./form2.html");
		rd.forward(request, response);
	}

}
