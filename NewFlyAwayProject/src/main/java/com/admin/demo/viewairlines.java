package com.admin.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/viewairlines") 
public class viewairlines extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		SessionFactory factory =HibernateSessionUtil.getSessionFactory();
		Session session=factory.openSession();
		resp.setContentType("text/html");
		
		List<flight> list=session.createQuery("from flight").list();
		for(flight product:list) {
			out.print("<br>------------------------------<br>");
			out.print("<b>Airline</b>"+product.getAirline()+"<br>");
			out.print("<b>Source:</b>"+product.getSource()+"<br>");
			out.print("<b>Destination:</b>"+product.getDestination()+"<br>");
			
			 
		}
		out.print("<a href="+"optionsadmin.html"+">Go Back </a>");
		session.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
