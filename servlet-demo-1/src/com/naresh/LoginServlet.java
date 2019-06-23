package com.naresh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		response.getWriter().append("Username:" + username + ",password:" + password);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request,response);
	}
	
	
	/*
	 
	http://localhost:8080/servlet-demo-1/LoginServlet?username=naresh&password=pass123
		
		*/

}
