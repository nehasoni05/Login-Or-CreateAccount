package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet
{
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	 {
		 PrintWriter out=res.getWriter();
		 Connection con=DBUtil.getDBConnection();
		 PreparedStatement ps;
		 String userName=(String) req.getAttribute("uname");
		 try 
		 {
			ps=con.prepareStatement("select * from userinfo where username=?");
			ps.setString(1, userName);
			int t=ps.executeUpdate();
			ResultSet rs=ps.executeQuery();
			out.println("<h1>Here are your details:- <br><br>");
			out.println("<table border=1px solid black><th>USERNAME</th><th>NAME</th><th>GENDER</th><th>AGE</th><th>SALARY</th>");
			if(t==1)
			{
				
				
				if(rs.next())
				{
					out.print("<tr><td>"+rs.getObject(1)+"</td><td>"+rs.getObject(2)+"</td><td>"+rs.getObject(3)+"</td><td>"+rs.getObject(4)+"</td><td>"+rs.getObject(5)+"</td></tr></table>");
			/*		out.println("USERNAME: "+rs.getObject(1)+"<br/>");
					out.println("NAME: "+rs.getObject(2)+"<br/>");
					out.println("GENDER: "+rs.getObject(3)+"<br/>");
					out.println("AGE: "+rs.getObject(4)+"<br/>");
					out.println("SALARY: "+rs.getObject(5)+"<br/>"); */
				}
			}
			
		} 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			System.out.println("exception found");
		}
		 	  
	  
	  
	 }
}
