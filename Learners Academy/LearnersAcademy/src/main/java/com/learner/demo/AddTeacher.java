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



@WebServlet("/addteacher") 
public class AddTeacher extends HttpServlet { 

private static final long serialVersionUID = 1L; 

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 

response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 

HttpSession s=request.getSession(false); 
if(s!=null) { 
//fetch data from form 
String tname = request.getParameter("tname"); 
String email = request.getParameter("email"); 
String password =request.getParameter("password");
String gender = request.getParameter("gender"); 
String dob = request.getParameter("dob"); 
String mobile =request.getParameter("mobile"); 
String address =request.getParameter("address"); 
String Subject=request.getParameter("Subject"); 
try { 
//1. build hibernate session factory 
SessionFactory factory = HibernateSessionUtil.getSessionfactory(); 

//2. create session object 
Session session = factory.openSession(); 
//3. create a object 
teacher obj = new teacher(tname,email,password,gender,dob,mobile,address,Subject); 

//4. begin transaction 
Transaction tx = session.beginTransaction(); 

//5. save product 
session.save(obj); 
System.out.println(obj);

//6. commit transaction 
tx.commit(); 

if(session != null ) { 
request.getRequestDispatcher("adminoptions.html").include(request, response); 
out.print("<h3 style='color:green'> New Teacher data added sucessfully </h3>");
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

}

