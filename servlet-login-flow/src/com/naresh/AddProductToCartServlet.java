package com.naresh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProductToCartServlet
 */
@WebServlet("/AddProductToCartServlet")
public class AddProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("product_name");
		String quantityStr = request.getParameter("quantity");
		System.out.println("Product Name:" + productName + ",quanity:" + quantityStr);
		int quantity = Integer.parseInt(quantityStr);
		
		Product product = new Product();
		product.setName(productName);
		product.setQuanity(quantity);
		System.out.println(product);
		HttpSession session = request.getSession(false);
		
		List<Product> productList = (List<Product>) session.getAttribute("PRODUCTS_ADDED_IN_CART");
		//List<Product> productList = new ArrayList<>();
		
		if ( productList == null) {
			productList = new ArrayList<>();
		}		
		productList.add(product);
		System.out.println("Total items in cart :" + productList.size());
		
		session.setAttribute("PRODUCTS_ADDED_IN_CART", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.html");
		dispatcher.forward(request, response);
		
	}


}
