package com.admin.demo;


import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
 
 
 
@WebServlet("/logoutuser") 
public class userlogout extends HttpServlet { 
 
private static final long serialVersionUID = 1L; 
 
protected void service(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
try { 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
user.usersession=false; 
HttpSession s=request.getSession(false); 
s.invalidate(); 
response.sendRedirect("logout.html"); 
} 
catch (Exception e) { 
e.printStackTrace(); 
} 
 
} 
}