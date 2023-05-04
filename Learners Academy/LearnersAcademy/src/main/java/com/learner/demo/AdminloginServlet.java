package com.learner.demo;


import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 

import java.io.IOException; 
import java.io.PrintWriter; 

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 


@WebServlet("/adminlogin") 
public class AdminloginServlet extends HttpServlet { 

private static final long serialVersionUID = 1L; 

protected void service(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 
	//add top nav 
	request.getRequestDispatcher("adminlogin.html").include(request, response);  
	// fetch data from form 
	String adminname = request.getParameter("adminname");
	System.out.println(adminname);
	String password = request.getParameter("password"); 
	System.out.println(password); 
	try { 
	
	HttpSession s=request.getSession(); 
	s.setAttribute("key", adminname);
	s.setAttribute("key1", password);

	if(s!=null) {
		String USERNAME=(String) s.getAttribute("key");
		String PASSWORD=(String) s.getAttribute("key1");
		if(USERNAME.equals("Admin")&&PASSWORD.equals("admin@123")) {
			out.print("<b>Admin Login successful</b>");
			response.sendRedirect("adminoptions.html");
			
			}
	else { 
	out.print("<h3 style='color:red'> Login failed ! </h3>"); 
	out.print("<b>Kindly Login First</b>");
	} 
	}
	  } catch (Exception e) { 
	e.printStackTrace(); 
	} 
	} 
	} 
