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


@WebServlet("/viewclasses")
public class FetchClassesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		try
		{
		SessionFactory factory =HibernateSessionUtil.getSessionfactory();
		Session session=factory.openSession();
		resp.setContentType("text/html");
		List<classes_table> obj = session.createQuery("from classes_table").list(); 
		//show data as table. 
    out.print("<h4 style='text-align:center;'>Scheduled Classes :- </h4>"); 
	out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
	out.print("<center><table >"); 
	out.print("<tr>"); 
	out.print("<th> ID</th>"+"<th> Standard</th>"+"<th> Time</th>"+"<th> Teacher</th>"+"<th>Subject</th>"); 
	out.print("</tr>"); 
	for(classes_table p : obj) {
		teacher t1 =new teacher();
		t1=p.getTeacher();
		Subject s1 =new Subject();
		s1=p.getSubject();
	out.print("<tr>"); 
	out.print("<td>"+p.getId()+"</td>");
	out.print("<td>"+p.getStd()+"</td>");
	out.print("<td>"+p.getTime()+"</td>");
	out.print("<td>"+t1.getTname()+"</td>"); 
	out.print("<td>"+s1.getSubname()+"</td>");
	
	out.print("</tr>"); 
	System.out.println(p.getId()); 
	System.out.println(p.getTime()); 
	//System.out.println(p.get()); 
	}
	out.print("</table></center>");
	out.print("<a href="+"adminoptions.html"+">Go Back </a>");
	 session.close(); 
	}
	catch (Exception e) { 
	out.print("<h3 style='color:red'> Hibernate session is failed ! "+e+"</h3>"); 
	} 
	}
		/*List<classes_table> list=session.createQuery("from classes_table").list();
		for(classes_table p:list) {
			out.print("<br>------------------------------<br>");
			out.print("<b>Id:</b>"+p.getId()+"<br>");
			out.print("<b>Standard:</b>"+p.getStd()+"<br>");
			out.print("<b>Time:</b>"+p.getTime()+"<br>");
			out.print("<b>Teacher:</b>"+p.getTeacher()+"<br>");
			out.print("<b>Subject:</b>"+p.getSubject()+"<br>");
		 
		}*/
		
		
		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
