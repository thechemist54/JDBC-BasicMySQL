/**
 * Name: Aaman Bhandari
 * Theory of DBMS
 * Date: Nov 26, 2019
 * Program Description: This program generates a report utilizing JDBC and 
 * accessing COMPANY database. The report will generate a list of what 
 * projects an employee works on for each department and how many hours plus a 
 * summary of the total hours they work, and the hours each department generates. 
 */

package college.jdbc.program; //declare package name for sql program and formatting

/**
 * import required files and libraries
 */
import java.sql.*;
import java.util.*;

import college.jdbc.sqlConnection.JdbcConnection; //import package data from jdbc connection

/**
 * This class is used as the driver class for putting all
 * data from database into easily accessible and easily manipulated 
 * data structures.
 * @author Aaman Bhandari
 *
 */
public class QueriesDriver 
{
	public static void main(String[] args) 
	{
		//initiating data structures;
		Map<Integer, Employee> employeeData= new TreeMap<>();
		Map<Integer, String> deptData = new TreeMap<>();
		Map<Integer,Projects> projData = new TreeMap<>();
		Map<String, Integer> employeeOrder = new TreeMap<>();
		List<Integer> Essn = new ArrayList<>();
		List<Integer> Pno = new ArrayList<>();
		List<Double> Hours = new ArrayList<>();
		Statement stmt;
		Statement stmt1;
		Statement stmt2;
		Statement stmt3;
		ResultSet result;
		ResultSet result1;
		ResultSet result2;
		ResultSet result3;
		String query;
		String query1;
		String query2;
		String query3;
		Connection connect = JdbcConnection.connection();
		try 
		{
			stmt = connect.createStatement();
			stmt1 = connect.createStatement();
			stmt2 = connect.createStatement();
			stmt3 = connect.createStatement();
			
			/**
			 * Required queries
			 */
			query = "SELECT * FROM EMPLOYEE";
			query1 = "SELECT * FROM DEPARTMENT";
			query2 = "SELECT * FROM PROJECT";
			query3 = "SELECT * FROM WORKS_ON";
			
			result = stmt.executeQuery(query);
			
			/**
			 * Employee table in Map
			 */
			while(result.next())
			{
				String fullName = (result.getString("Fname")+" "+result.getString("Minit")+" "+result.getString("Lname"))
				.equals(null) ? "0":result.getString("Fname")+" "+result.getString("Minit")+" "+result.getString("Lname");
				int Ssn = Integer.parseInt(result.getString("Ssn"));
				int Dno = result.getString("Dno")!=null ? Integer.parseInt(result.getString("Dno")):0; 
				employeeOrder.put(fullName,Ssn);
				employeeData.put(Ssn,new Employee(fullName,Ssn,Dno));
				
			}
			
			result1 = stmt1.executeQuery(query1);
			
			/**
			 * Department table in Map
			 */
			
			while(result1.next())
			{
				int Dnum = Integer.parseInt(result1.getString("Dnumber"));
				String Dname = (result1.getString("Dname"));
				deptData.put(Dnum, Dname);
			}
			
			
			result2 = stmt2.executeQuery(query2);
			
			/**
			 * Project table in Map
			 */
			while(result2.next())
			{
				int Pnumber = Integer.parseInt(result2.getString("Pnumber"));
				String Pname = result2.getString("Pname").equals(null)? "0":result2.getString("Pname");
				int Dnum = result2.getString("Dnum")==null? 0:Integer.parseInt(result2.getString("Dnum"));
				projData.put(Pnumber,new Projects(Pname,Dnum));
			}
			
			result3 = stmt3.executeQuery(query3);
			
			/**
			 * Works_on table in arraylist
			 */
			while(result3.next())
			{
				int dumPno = result3.getString("Pno")==null?0:Integer.parseInt(result3.getString("Pno"));
				Pno.add(dumPno);
				
				int dumEssn = result3.getString("Essn")==null?0:Integer.parseInt(result3.getString("Essn"));
				Essn.add(dumEssn);
				
				double dumHours = result3.getString("Hours")==null? 0:(Double.parseDouble(result3.getString("Hours")));
				Hours.add(dumHours);
				
				
			}
			/**
			 * Format data
			 */
			 new DataFormatting(employeeData, deptData, projData, Essn, Pno, Hours, employeeOrder);
			
//			System.out.println(employeeData);
//			System.out.println(deptData);
//			System.out.println(projData);
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.err.println("Error while executing sql: "+e.getMessage());
		}
		finally 
		{
			try 
			{
				/**
				 * Check if connection closed properly
				 */
				connect.close();
				System.out.println("\nConnection closed successfully!");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.err.println("Error while closing connection: "+e.getMessage());
			}
		}
			
	}
	
}
