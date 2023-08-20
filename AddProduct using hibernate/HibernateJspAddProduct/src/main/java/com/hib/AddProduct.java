package com.hib;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.HibernateUtil;
import com.hib.Product;

@WebServlet("/save")
public class AddProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String company=req.getParameter("Company");
		
	
		Product product=new Product(name,new BigDecimal(price),company);


		SessionFactory factory=HibernateUtil.getSessionFactory();

		Session session=factory.openSession();

		Transaction tx= session.beginTransaction();
		//System.out.print("Session Started"); 
		session.save(product);

		tx.commit();

		session.close();

		out.print("Data Added Successfully"); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
