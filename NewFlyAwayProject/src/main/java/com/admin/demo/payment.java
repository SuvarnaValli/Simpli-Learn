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
 
import org.hibernate.Query; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
 
 

@WebServlet("/payment") 
public class payment extends HttpServlet{ 
 
private static final long serialVersionUID = 1L; 
 
@SuppressWarnings("deprecation")
protected void service(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
request.getRequestDispatcher("payment.html").include(request, response); 
String password=request.getParameter("password"); 
System.out.println(password);
HttpSession ss=request.getSession(false); 
if(ss!=null) { 
try { 
// 1. build hibernate session factory 
SessionFactory factory = HibernateSessionUtil.getSessionFactory(); 
 
// 2. create session object 
Session session = factory.openSession(); 
int userid=0;
// 3. read products 
List<user> obj = session.createQuery("from user").list(); 
List<flight> obj2 = session.createQuery("from flight").list(); 
int flag=0; 
double temp=0.0; 
double tempf=0.0; 
for(user p : obj) { 
if(p.getPassword().equals(password)) { 
//update user balance 
int val=(Integer)ss.getAttribute("idvalue"); 
System.out.println(val);
int price=Integer.parseInt((String) ss.getAttribute("numberofpeople"));
System.out.println(price);
for(flight x:obj2) { 
if(x.getId()==val){ 
temp=(double)x.getPrice()*price;
System.out.println(temp);//if user has booked tickets for 2 people then 2*ticketprice 
} 
} 
 userid=p.getId(); 
tempf=p.getBalance()-temp;
} 
}
System.out.println(tempf);
//insufficient balance in account 
if(tempf<0) { 
out.write("<h3 style='color:red')>Insufficient Account Balance !</h3>"); 
} 
else { 
Transaction tx= session.beginTransaction(); 
Query<?> q=session.createQuery("update user set balance=:n where id=:i"); 
q.setParameter("n",tempf); 
q.setParameter("i",userid); 
int status=q.executeUpdate();  
tx.commit(); 
ss.setAttribute("usersid", userid); 
System.out.println(userid);
response.sendRedirect("ticket");  
} 
session.close(); 
} catch (Exception e) { 
out.print("<h3 style='color:red'> Hibernate session is failed ! "+e+"</h3>"); 
} 
} 
else { 
out.write("<h2 style='color:red;'>Please Check the Credentials</h2>"); 
} 
 
} 
} 