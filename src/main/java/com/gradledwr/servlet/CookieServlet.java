package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	private static final long serialVersionUID = 6756159099920415728L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cobrand = (String) request.getParameter("cobrand");
		System.out
				.println("Redirecting page to dwrdemo/provider/index.jsp for Cobrand "
						+ cobrand + ".");
		String endUrl = response
				.encodeRedirectURL("/dwrdemo/provider/index.jsp");
		response.sendRedirect(endUrl);
	}
}
