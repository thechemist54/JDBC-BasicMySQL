package college.jdbc.sqlConnection; // defining package name for sql connection

//importing required libraries/packages
import java.util.*;
import java.sql.*;
import java.io.*;

/**
 * This class determines whether the sql connects 
 * successfully or not.
 * @author Aaman Bhandari
 *
 */
public class JdbcConnection 
{
	//Supresses warnings of deprecation
	//The deprecation is due to deprecated driver used for
	//JDBC.
	@SuppressWarnings("deprecation") 
	public static Connection connection() 
	{
		Connection con = null;
		
		try
		{
			/**
			 * Read .properties file and get
			 * required database user, password, driver and url. 
			 */
			FileReader read = new FileReader("con8.properties"); 
			Properties properT = new Properties();
			properT.load(read);

			String dbdriver = properT.getProperty("db.driver");
			String dbuser = properT.getProperty("db.user");
			String dbpassword = properT.getProperty("db.password");
			String dburl = properT.getProperty("db.url");
			
			Class.forName(dbdriver).newInstance();
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			
			
			if(!con.isClosed())
			{
				System.out.println("Successfully connected to MySql server using TCP/IP...");
				return con;
				
			}
			
			return con;
				
		}
		
		catch(Exception e)
		{
			
			System.err.println("Exception: "+e.getMessage());
			System.exit(0);
			return con;
			
		}
		
		
	
	}
}
