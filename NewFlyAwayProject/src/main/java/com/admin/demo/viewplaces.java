package com.admin.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@WebServlet("/viewplaces")
public class viewplaces extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 
		 
try { 
	//1. build hibernate session factory 
	SessionFactory factory = HibernateSessionUtil.getSessionFactory(); 

	//2. create session object 
	Session session = factory.openSession(); 

	//3. read products 
	List<places> obj = session.createQuery("from places").list(); 
		//show data as table. 
    out.print("<h4 style='text-align:center;'>Available Sources and Destinations  :- </h4>"); 
	out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
	out.print("<center><table >"); 
	out.print("<tr>"); 
	out.print("<th> ID</th>"+"<th> Sources</th>"+"<th> Destinations</th>"); 
	out.print("</tr>"); 
	for(places p : obj) {
	out.print("<tr>"); 
	out.print("<td>"+p.getId()+"</td>"); 
	out.print("<td>"+p.getSource()+"</td>"); 
	out.print("<td>"+p.getDestination()+"</td>"); 
	out.print("</tr>"); 
	System.out.println(p.getId()); 
	System.out.println(p.getSource()); 
	System.out.println(p.getDestination()); 
	}
	out.print("</table></center>"); 
	out.print("<a href="+"optionsadmin.html"+">Go Back </a>");
	 session.close(); 
	}
	catch (Exception e) { 
	out.print("<h3 style='color:red'> Hibernate session is failed ! "+e+"</h3>"); 
	} 
	}
	}
	

