package com.rahul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TargetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static {

		System.out.println("TargetServlet.class file is loaded...");

	}

	public TargetServlet() {

		System.out.println("TargetServlet object instantiated...");

	}

	@Override
	public void init() throws ServletException {

		System.out.println("TargetServlet initialized...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1>This is Target Servlet...</h1>");

	}

	@Override
	public void destroy() {

		System.out.println("TargetServlet DeInstantiated...");

	}

}
