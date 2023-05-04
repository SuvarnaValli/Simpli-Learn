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


@WebServlet("/viewteachers")
public class ListofTeachers extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		try
		{
		SessionFactory factory =HibernateSessionUtil.getSessionfactory();
		Session session=factory.openSession();
		resp.setContentType("text/html");
		List<teacher> obj = session.createQuery("from teacher").list(); 
		//show data as table. 
    out.print("<h4 style='text-align:center;'>LIST OF TEACHERS </h4>"); 
	out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
	out.print("<center><table >"); 
	out.print("<tr>"); 
	out.print("<th> ID</th>"+"<th>Name</th>"+"<th>Email</th>"+"<th>Password</th>"+"<th>Gender</th>"); 
	out.print("<th> Date of Birth</th>"+"<th>Mobile</th>"+"<th>Address</th>"); 
	out.print("</tr>"); 
	for(teacher p : obj) {
	out.print("<tr>"); 
	out.print("<td>"+p.getId()+"</td>");
	out.print("<td>"+p.getTname()+"</td>");
	out.print("<td>"+p.getEmail()+"</td>");
	out.print("<td>"+p.getPassword()+"</td>"); 
	out.print("<td>"+p.getGender()+"</td>");
	out.print("<td>"+p.getDob()+"</td>");
	out.print("<td>"+p.getMobile()+"</td>");
	out.print("<td>"+p.getAddress()+"</td>");
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
