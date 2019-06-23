package com.naresh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet");

		String custName = (String) request.getAttribute("customer_name");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		response.getWriter().append("Served from HomeServlet" + custName + ",email:" + email);
		

		}


}
