package com.rahul.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pname = request.getParameter("pname");
		String cost = request.getParameter("cost");

		Cookie c1 = new Cookie("pname", pname);
		Cookie c2 = new Cookie("cost", cost);

		response.addCookie(c1);
		response.addCookie(c2);

		request.getRequestDispatcher("./form2.html").forward(request, response);

	}

}
