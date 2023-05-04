
package com.learner.demo;

import javax.servlet.annotation.WebServlet; 
	import javax.servlet.http.HttpServlet; 

	import java.io.IOException; 
	import java.io.PrintWriter;

import javax.servlet.ServletException; 
	import javax.servlet.http.HttpServletRequest; 
	import javax.servlet.http.HttpServletResponse; 
	import javax.servlet.http.HttpSession; 

	import org.hibernate.Session; 
	import org.hibernate.SessionFactory; 
	import org.hibernate.Transaction;





	@WebServlet("/addclasses") 
	public class AddClasses extends HttpServlet { 

	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException { 

	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	HttpSession s=request.getSession(false);
	System.out.println(s);
	if(s!=null) { 
	//fetch data from form 
	String std = request.getParameter("std"); 
	String time = request.getParameter("time"); 
	int teacher_id=Integer.parseInt(request.getParameter("teacher_id")); 
	int Subject_id= Integer.parseInt(request.getParameter("Subject_id")); 
	System.out.println(std);
	System.out.println(time);
	System.out.println(teacher_id);
	System.out.println(Subject_id);
	 
	try { 
	//1. build hibernate session factory 
	SessionFactory factory = HibernateSessionUtil.getSessionfactory(); 

	//2. create session object 
	Session session = factory.openSession(); 
	

	//4. begin transaction 
	Transaction tx = session.beginTransaction(); 

	//3. create a object 
	
	teacher t1 =new teacher();
	t1=session.get(teacher.class,teacher_id);
	session.save(t1);
	System.out.println(t1);
	
	Subject s1 =new Subject();
	s1=session.get(Subject.class,Subject_id);
	session.save(s1);
	System.out.println(s1);
	
	classes_table st = new classes_table (std,time,t1,s1); 
	System.out.println(st);
	System.out.println(session);
	

	//5. save product 
	session.save(st); 
	System.out.println(st);

	//6. commit transaction 
	tx.commit(); 

	if(session != null ) { 
	request.getRequestDispatcher("adminoptions.html").include(request, response); 
	out.print("<h3 style='color:green'> Class added sucessfully </h3>");
	out.print("<a href="+"adminoptions.html"+">Go Back! </a><br>");
	} 

	//3. close session 
	session.close(); 

	} 
	catch (Exception e) { 
	out.print("<h3 style='color:red'>Addition failed ! </h3>"); 
	out.print("<a href="+"adminoptions.html"+">Go Back 2</a><br>");
	} 
	} 
	else {
	out.print("<h2>Problem with session, please re-login</h2>"); 
	out.print("<a href="+"index.html"+">Go Back 3</a><br>");
	} 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}




