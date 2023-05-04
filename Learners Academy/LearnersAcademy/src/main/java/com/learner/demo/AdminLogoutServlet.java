package com.learner.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		  HttpSession s=request.getSession();
		 if(s!=null) {
			  s.invalidate();
				 out.print("<h3 style='color:green'>ADMIN Logged out  Successfully</h3><br><br>");
				 out.print("<a href="+"index.html"+">Go Back </a>");
			 }
			 else {
				 out.print("Kindly Login First<br><br>");
				 out.print("<a href="+"index.html"+">Go Back </a>");
			 }
		} 
		catch (Exception e) { 
		e.printStackTrace(); 
		} 
		   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}


