package com.simplilearn.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String token=req.getParameter("userid");
	    String pas=req.getParameter("pass");
		System.out.println("token"+token);
		System.out.println(pas);
		//add user to Http Session
		PrintWriter out=resp.getWriter();
	
	if(token.equals("Admin")&&pas.equals("admin@123"))
	{
	HttpSession session=req.getSession();
	session.setAttribute("key", token);
//	System.out.println(key);
	 resp.sendRedirect("dashboard");
	}
	else {
	
		out.print("enter valid details");
		req.getRequestDispatcher("index.html").include(req, resp);  
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
