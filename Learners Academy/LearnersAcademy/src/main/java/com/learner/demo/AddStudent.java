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



	@WebServlet("/addstudent") 
	public class AddStudent extends HttpServlet { 

	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException { 

	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	HttpSession s=request.getSession(false);
	System.out.println(s);
	if(s!=null) { 
	//fetch data from form 
	String name = request.getParameter("name"); 
	String fname = request.getParameter("fname"); 
	String lname= request.getParameter("lname"); 
	String gender = request.getParameter("gender"); 
	String dob = request.getParameter("dob"); 
	String doj = request.getParameter("doj");
	String address = request.getParameter("address"); 
	String standard = request.getParameter("standard"); 
	double fee=Double.parseDouble(request.getParameter("fee")); 
	 
	try { 
	//1. build hibernate session factory 
	SessionFactory factory = HibernateSessionUtil.getSessionfactory(); 

	//2. create session object 
	Session session = factory.openSession(); 
	//3. create a object 
	Student st = new Student (name,fname,lname,gender,dob,doj,address,standard,fee); 

	//4. begin transaction 
	Transaction tx = session.beginTransaction(); 

	//5. save product 
	session.save(st); 
	System.out.println(st);

	//6. commit transaction 
	tx.commit(); 

	if(session != null ) { 
	request.getRequestDispatcher("adminoptions.html").include(request, response); 
	out.print("<h3 style='color:green'> Student added sucessfully </h3>");
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


