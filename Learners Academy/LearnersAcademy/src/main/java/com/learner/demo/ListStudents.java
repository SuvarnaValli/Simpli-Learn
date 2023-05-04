package com.learner.demo;


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


@WebServlet("/viewstudents")
public class ListStudents extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		try
		{
		SessionFactory factory =HibernateSessionUtil.getSessionfactory();
		Session session=factory.openSession();
		resp.setContentType("text/html");
		List<Student> obj = session.createQuery("from Student").list(); 
		//show data as table. 
    out.print("<h4 style='text-align:center;'>LIST OF STUDENTS  :- </h4>"); 
	out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
	out.print("<center><table >"); 
	out.print("<tr>"); 
	out.print("<th> ID</th>"+"<th>Name</th>"+"<th>FirstName</th>"+"<th>LastName</th>"+"<th>Gender</th>"); 
	out.print("<th> Date of Birth</th>"+"<th>Date of Join</th>"+"<th>Address</th>"+"<th>Class</th>"+"<th>Fee</th>"); 
	out.print("</tr>"); 
	for(Student p : obj) {
		
	out.print("<tr>"); 
	out.print("<td>"+p.getId()+"</td>");
	out.print("<td>"+p.getName()+"</td>");
	out.print("<td>"+p.getFname()+"</td>");
	out.print("<td>"+p.getLname()+"</td>"); 
	out.print("<td>"+p.getGender()+"</td>");
	out.print("<td>"+p.getDob()+"</td>");
	out.print("<td>"+p.getDoj()+"</td>");
	out.print("<td>"+p.getAddress()+"</td>");
	out.print("<td>"+p.getStandard()+"</td>");
	out.print("<td>"+p.getFee()+"</td>");
	
	out.print("</tr>"); 
	
	}
	out.print("</table></center>");
	out.print("<a href="+"adminoptions.html"+">Go Back </a>");
	 session.close(); 
	}
	catch (Exception e) { 
	out.print("<h3 style='color:red'> Hibernate session is failed ! "+e+"</h3>"); 
	} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
