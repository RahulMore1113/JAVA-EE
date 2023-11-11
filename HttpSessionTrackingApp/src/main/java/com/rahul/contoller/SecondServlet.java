package com.rahul.contoller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String squal = request.getParameter("squal");
		String sdesg = request.getParameter("sdesg");

		HttpSession session = request.getSession(false);
		session.setAttribute("squal", squal);
		session.setAttribute("sdesg", sdesg);

		RequestDispatcher rd = request.getRequestDispatcher("./form3.html");
		rd.forward(request, response);
	}

}
