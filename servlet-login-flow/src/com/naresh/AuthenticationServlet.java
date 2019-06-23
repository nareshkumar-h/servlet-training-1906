package com.naresh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//How to get the form values
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			//Business Logic
			if ("admin".equals(username) && password.equals("admin")) {
				//response.sendRedirect("welcome.html");
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1*60); //seconds
				session.setAttribute("LOGGED_IN_USER", username);
				System.out.println("Created Session:" + session.getId());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.html");
				dispatcher.forward(request, response);
			}
			else
			{
				throw new Exception ("Invalid Username/Password");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("login.html?error_msg=" + e.getMessage());
		}
		
		
		
	}

}
