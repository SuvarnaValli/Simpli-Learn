package com.ap;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addproduct")
public class AddProduct  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=resp.getWriter();
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String type=req.getParameter("type");
		
	
		Product product=new Product(id,name,type,new BigDecimal(price));
		HttpSession session = req.getSession();
		session.setAttribute("data", product);
		req.setAttribute("data", product.getProductDetails());
		RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
		rd.forward(req, resp);

		//out.print("Data Added Successfully"); 
		} catch (NumberFormatException e) {
			out.println(e);
		} catch (Exception e) {
			out.println(e);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	

}
