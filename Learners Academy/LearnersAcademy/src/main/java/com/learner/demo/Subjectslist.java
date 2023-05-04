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


@WebServlet("/viewsubjects")
public class Subjectslist extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		try
		{
		SessionFactory factory =HibernateSessionUtil.getSessionfactory();
		Session session=factory.openSession();
		resp.setContentType("text/html");
		List<Subject> obj = session.createQuery("from Subject").list(); 
		//show data as table. 
    out.print("<h4 style='text-align:center;'>LIST OF SUBJECTS </h4>"); 
	out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
	out.print("<center><table >"); 
	out.print("<tr>"); 
	out.print("<th> ID</th>"+"<th>SubjectName</th>"+"<th>SubjectCode</th>"+"<th>Standard</th>"); 
	out.print("</tr>"); 
	for(Subject p : obj) {
	out.print("<tr>"); 
	out.print("<td>"+p.getId()+"</td>");
	out.print("<td>"+p.getSubname()+"</td>");
	out.print("<td>"+p.getSubjectcode()+"</td>");
	out.print("<td>"+p.getStd()+"</td>"); 
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

