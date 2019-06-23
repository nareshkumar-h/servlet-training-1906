package com.naresh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCookie
 */
@WebServlet("/AddCookie")
public class AddCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Cookie cookie = new Cookie("LOGGED_IN_USERNAME","naresh");
		cookie.setMaxAge(20);
		
		response.addCookie(cookie);
		
		response.getWriter().append("Added data to Cookie");
	}


}
