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


@WebServlet("/availableflights") 
public class availableflights extends HttpServlet{ 

private static final long serialVersionUID = 1L; 

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
//request.getRequestDispatcher("useroptions.html").include(request, response); 
String source=request.getParameter("source"); 
String destination=request.getParameter("destination"); 
String userdate=request.getParameter("dateoftravel"); 
String no_of_people=request.getParameter("numberofpersons"); 
//my logic to check date is which day 


SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
Date dt1;
HttpSession ss=request.getSession(false); 
if(ss!=null) { 
try { 
	Date todayDate =  format1.parse(format1.format(new Date()));	
dt1 = format1.parse(userdate);
System.out.println(dt1);
System.out.println(todayDate);
if(dt1.compareTo(todayDate) >=0) {
DateFormat format2 = new SimpleDateFormat("EEEE"); 
String str = format2.format(dt1); 
System.out.println(str);


try { 
//1. build hibernate session factory 
SessionFactory factory = HibernateSessionUtil.getSessionFactory(); 

//2. create session object 
Session session = factory.openSession(); 

//3. read products 
List<flight> obj = session.createQuery("from flight").list(); 

int flag=0; 
for(flight p : obj) {
//res has days stored on which flights are available 
//str has the user required day 
String[] res = p.getAvailabledays().split("[,]", 0); 
System.out.println(res);
for(String myStr: res) { 
//check user source destination with flight path along with date availability 
if(myStr.equals(str)&&p.getSource().equalsIgnoreCase(source)&& p.getDestination().equalsIgnoreCase(destination)) { 
flag=1; 
}
} 
} 
//show data as table. 
out.print("<h4 style='text-align:center;'>Available Flights for "+userdate+" :- </h4>"); 
if(flag==1) { 
flag=0; 
out.print("<style> table,td,th {" + "border:2px solid ;text-align:center;" + "padding: 10px; " + "}</style>"); 
out.print("<center><table >"); 
out.print("<tr>"); 
out.print("<th> ID</th>"+"<th> Airline Name</th>"+"<th> Ticket Price</th>"); 
out.print("</tr>"); 
int flag2=0; 
for(flight p : obj) {
String[] res = p.getAvailabledays().split("[,]", 0); 
for(String myStr: res) { 
if(myStr.equals(str)&&p.getSource().equalsIgnoreCase(source)&& p.getDestination().equalsIgnoreCase(destination)) { 
flag2=1; 
} 
} 
if(flag2==1) {
flag2=0; 
out.print("<tr>"); 
out.print("<td>"+p.getId()+"</td>"); 
out.print("<td>"+p.getAirline()+"</td>"); 
out.print("<td>"+p.getPrice()+"</td>"); 
out.print("</tr>"); 
System.out.println(p.getId()); 
System.out.println(p.getAirline()); 
System.out.println(p.getPrice()); 
} 
} 
out.print("</table></center>"); 
out.print("<a href="+"bookflight.html"+">Proceed to Book  </a><br><br>");
out.print("<a href="+"searchForm.html"+">Go Back to Search for Another Date</a>");
} 
//if flight is unavailable on that day 
else { 
out.print("<h4 style='color:red'>No Flights for selected date</h4>"); 
out.print("<a href="+"searchForm.html"+">Go Back to Search for Another Flight</a>");
} 
//3. close session 
ss.setAttribute("numberofpeople", no_of_people);
ss.setAttribute("userdate", userdate); 
System.out.println(no_of_people);
session.close(); 
} catch (Exception e) { 
out.print("<h3 style='color:red'> Hibernate session is failed ! "+e+"</h3>"); 
} 
}
else{
	out.print("<h3 style='color:red'> Enter a valid date ! </h3>"); 
	out.print("<a href="+"searchForm.html"+">Go Back to Search for Another Date</a>");
}
}
catch (ParseException e1) { 
//TODO Auto-generated catch block 
e1.printStackTrace(); 
} 
}
}}
