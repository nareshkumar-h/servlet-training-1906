package com.naresh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginServlet");
		//response.sendRedirect("welcome.html");
		//response.sendRedirect("http://google.com");
		
		request.setAttribute("customer_name", "Adam");
		
		HttpSession session = request.getSession();
		session.setAttribute("email", "nareshkumarh@live.com");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
		dispatcher.forward(request, response);
		
		//dead code
		/*
		 dispatcher.include(request, response);
		 response.getWriter().append("Send Response from LoginServlet");
		 */
		
		
	}
}
