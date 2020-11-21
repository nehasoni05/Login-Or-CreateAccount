package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class AddData  extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	  {
		res.setContentType("text/html");
		String NAME=req.getParameter("name");
		String USERNAME=req.getParameter("username");
		String PASSWORD=req.getParameter("password");
		int AGE=Integer.valueOf(req.getParameter("age"));
		int SALARY=Integer.valueOf(req.getParameter("salary"));
		String GENDER=req.getParameter("recommend");
		
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps;
		try
		{
			ps=con.prepareStatement("insert into loginIfo values (?,?)");
			ps.setString(1, USERNAME);
			ps.setString(2, PASSWORD);
			int s=ps.executeUpdate();
			ps=con.prepareStatement("insert into userinfo values (?,?,?,?,?)");
			ps.setString(1, USERNAME);
			ps.setString(2, NAME);
			ps.setString(3, GENDER);
			ps.setInt(4, AGE);
			ps.setInt(5, SALARY);
			int t=ps.executeUpdate();
		if(t==1)
		{
			 RequestDispatcher rd=req.getRequestDispatcher("login.html");
			 rd.include(req,res); 
		}
		}
		catch(Exception e)
		{
			System.out.println("Exceptipon");
		}
	  }

}
