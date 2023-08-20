package com.simplilearn.demo;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/retrieve")
public class RetrieveData extends HttpServlet  {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Properties props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		try {
		resp.setContentType("text/html");

		Connection conn=DBConfig.getConnection(props);

		PrintWriter out= resp.getWriter();

		String param=req.getParameter("pid");
		int id=Integer.parseInt(param);
			System.out.println(id);
		if(conn!=null) {
			
				PreparedStatement stmt= conn.prepareStatement("select * from product where id=?");
				stmt.setInt(1,id);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					out.print("<br>"+rs.getInt(1)+","+rs.getString(2)+","+rs.getBigDecimal(3)+","+rs.getTimestamp(4)+"<br>");
					
				}
			
		else {
					out.print("Error While fetching the data");
				}
			} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
