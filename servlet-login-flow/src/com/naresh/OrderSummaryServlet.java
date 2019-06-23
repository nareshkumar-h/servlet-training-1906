package com.naresh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderSummaryServlet")
public class OrderSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // default : true, false(existingsession)
		
		response.setContentType("text/html");
		
		if (session == null) {
			response.sendRedirect("login.html");
		} else {
			System.out.println("sessionid:" + session.getId());
			List<Product> productList = (List<Product>) session.getAttribute("PRODUCTS_ADDED_IN_CART");
			System.out.println("Products:" + productList);
			PrintWriter writer = response.getWriter();
			String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
			writer.append("<html>");
			writer.append("<body>");
			writer.append("Name:" + loggedInUsername);
			
			writer.append("<table border='1'>");
			writer.append("<thead><tr><th>Sno</th><th>Product Name</th><th>Quantity</th></tr></thead>");
			writer.append("<tbody>");
			int i = 1;
			for (Product product : productList) {
				writer.append("<tr><td>" + i++ + "</td><td>" + product.getName() +
						"</td><td>"+  product.getQuanity() +"</td></tr>");
			}
			writer.append("</tbody>");
			writer.append("</table>");
			writer.append("</body></html>");
			/*
			 * if (productList == null) {
			 * writer.append("Order Summary: No products in cart"); } else {
			 * writer.append("Order Summary: Number of products in cart: " +
			 * productList.size()); }
			 */
		}
		// empty cart
		// session.removeAttribute("PRODUCTS_ADDED_IN_CART");
	}

}
