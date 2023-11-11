package com.rahul.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class TargetFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	static {

		System.out.println("TargetFilter.class file is loaded...");

	}

	public TargetFilter() {

		System.out.println("TargetFilter object instantiated...");

	}

	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("TargetFilter initialized...");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by TargetFilter before processing the request...</h1>");

		chain.doFilter(request, response);

		out.println("<h1>This line is added by TargetFilter after processing the request...</h1>");

	}

	public void destroy() {

		System.out.println("TargetFiler DeInstantiated...");

	}

}
