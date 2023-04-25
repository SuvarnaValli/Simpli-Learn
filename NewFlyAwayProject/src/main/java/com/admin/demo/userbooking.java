package com.admin.demo;



import java.io.IOException; 
import java.io.PrintWriter; 
import java.text.DateFormat; 
import java.text.Format; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
 
 
@WebServlet("/userbooking") 
public class userbooking extends HttpServlet{ 
 
private static final long serialVersionUID = 1L; 
 
protected void service(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
request.getRequestDispatcher("bookflight.html").include(request, response); 
int flightnumber=Integer.parseInt(request.getParameter("flightnumber")); 
System.out.println(flightnumber);
HttpSession ss=request.getSession(false); 
if(ss!=null) { 
 
try { 
// 1. build hibernate session factory 
SessionFactory factory = HibernateSessionUtil.getSessionFactory(); 
 
// 2. create session object 
Session session = factory.openSession(); 
 
// 3. read products 
List<flight> obj = session.createQuery("from flight").list(); 
for(flight p : obj) { 
if(p.getId()==flightnumber) { 
ss.setAttribute("idvalue", p.getId()); 
System.out.println(p.getId());
ss.setAttribute("flightname",p.getAirline());
System.out.println(p.getAirline());
ss.setAttribute("sourceplace", p.getSource());
System.out.println(p.getSource());
ss.setAttribute("destinationplace", p.getDestination()); 
response.sendRedirect("payment.html"); 
} 
} 
 
// 3. close session 
session.close(); 
 
} catch (Exception e1) { 
// TODO Auto-generated catch block 
e1.printStackTrace(); 
} 
} 
} 
}