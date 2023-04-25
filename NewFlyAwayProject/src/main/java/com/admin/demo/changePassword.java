package com.admin.demo;

import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
 
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
 
 
 
@WebServlet("/changePassword") 
public class changePassword extends HttpServlet { 
 
private static final long serialVersionUID = 1L; 
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter();
//fetch data from form 
String oldpassword = request.getParameter("oldpassword"); 
System.out.println( oldpassword );
String newpassword = request.getParameter("newpassword");
System.out.println( newpassword );
String cnfpassword = request.getParameter("cnfpassword");
System.out.println( cnfpassword );
try { 
HttpSession s=request.getSession(false); 
if(s!=null) { 
// 1. build hibernate session factory 
SessionFactory factory = HibernateSessionUtil.getSessionFactory(); 
 // 2. create session object 
Session session = factory.openSession(); 
int f=0;int id=0; 
if(newpassword.equals(cnfpassword)) {
List<admin> obj=session.createQuery("from admin").list(); 
for(admin i:obj) { 
if(i.getPassword().equals(oldpassword)){ 
f=1;
id=i.getId();

} 
} 
}
else {
	out.print("<h3 style='color:red'>New Password and Confirm new password should be same  </h3>"); 
}
if(f==1) { 
// 3. begin transaction 
	Transaction tx = session.beginTransaction(); 
// 4. create a product object 
	admin obj = session.load(admin.class, id);
     obj.setPassword(newpassword);
// 5. update product 
  session.update(obj); 
  System.out.println(obj);
// 6. commit transaction 
    tx.commit(); 
  out.print("<h3 style='color:green'> Password is updated sucessfully ! </h3>");
  out.print("<a href="+"optionsadmin.html"+">Go Back </a>");
// 7. close session 
session.close(); 
} 
}
}catch (Exception e) { 
out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>"); 
out.print("<a href="+"changepassword.html"+">Go Back </a>");
}
}
}
 

