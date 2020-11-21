package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	  {
		//get connection
		res.setContentType("text/html");    
		String uname=req.getParameter("username");
		String pwd=req.getParameter("password");
		String p="";
		System.out.print(uname+","+pwd);
		
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps;
			try 
			{
				ps=con.prepareStatement("select * from loginIfo where username=? and password=?");
				ps.setString(1, uname);
				ps.setString(2, pwd);
				int t=ps.executeUpdate();
				if(t==1)
				{
					req.setAttribute("uname", uname);
					RequestDispatcher rd=req.getRequestDispatcher("gaurav2");
					rd.forward(req,res);
				}
				else
				{
					   PrintWriter out=res.getWriter();
					   out.println("<script type=\"text/javascript\">");
				       out.println("alert('Username or password incorrect');");
				       out.println("</script>");
					   RequestDispatcher rd=req.getRequestDispatcher("login.html");
					   rd.include(req,res); 
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.print(",,,,,,");
			}
	  }
}
