package com.rahul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pcatagory = request.getParameter("pcatagory");
		String pmanifacture = request.getParameter("pmanifacture");

		Cookie[] cookies = request.getCookies();
		String pname = cookies[0].getValue();
		String cost = cookies[1].getValue();
		String brand = cookies[2].getValue();
		String quantity = cookies[3].getValue();

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'>PRODUCT DETAILS...</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		out.println("<tr><td>PNAME</td><td>" + pname + "</td></tr>");
		out.println("<tr><td>PCOST</td><td>" + cost + "</td></tr>");
		out.println("<tr><td>PBRAND</td><td>" + brand + "</td></tr>");
		out.println("<tr><td>PQTY</td><td>" + quantity + "</td></tr>");
		out.println("<tr><td>CATEGORY</td><td>" + pcatagory + "</td></tr>");
		out.println("<tr><td>MANUFACTURER</td><td>" + pmanifacture + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

}
