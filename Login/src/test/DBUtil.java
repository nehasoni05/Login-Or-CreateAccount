package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil 
{
	static Connection con=null;
	static
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","NEHA","nehasoni");
			System.out.print("connections done");
		} 
		catch (Exception e)
		{
			System.out.print("connections not done");
		}
	}
	public static Connection getDBConnection()
	{
	    return con;
		
	}
	
}
