package com.rahul.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brand = request.getParameter("brand");
		String quantity = request.getParameter("quantity");

		Cookie c3 = new Cookie("brand", brand);
		Cookie c4 = new Cookie("quantity", quantity);

		response.addCookie(c3);
		response.addCookie(c4);

		request.getRequestDispatcher("./form3.html").forward(request, response);

	}

}
