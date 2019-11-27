package college.jdbc.program; //initialize package name

/**
 * import required packages
 */
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;

/**
 * This class is used for data formatting
 * @author Aaman Bhandari
 *
 */
public class DataFormatting 
{
	//instance varaibles
	private TreeMap<Integer, Employee> employeeData;
	private TreeMap<Integer, String> deptData;
	private TreeMap<Integer, Projects> projData;
	private TreeMap<String, Integer> employeeOrder;
	private List<Integer> Pno;
	private List<Integer> Essn;
	private List<Double> Hours;
	private int count;
	private double totHours;
	private double indiHours;
	
	/**
	 * Constructor
	 * @param employeeData employee table map
	 * @param deptData department table map
	 * @param projData project table map
	 * @param Essn employee ssn list
	 * @param Pno project number list
	 * @param Hours hours worked on list
	 * @param employeeOrder ordered employee table map
	 */
	public DataFormatting(Map<Integer, Employee> employeeData, 
			Map<Integer, String> deptData, Map<Integer,Projects> projData, 
			List<Integer> Essn, List<Integer> Pno,List<Double> Hours, Map<String, Integer> employeeOrder)
	{
		this.employeeData=(TreeMap<Integer, Employee>) employeeData;
		this.deptData=(TreeMap<Integer, String>) deptData;
		this.projData=(TreeMap<Integer, Projects>) projData;
		this.Essn = Essn;
		this.Pno = Pno;
		this.Hours = Hours;
		this.employeeOrder = (TreeMap<String, Integer>) employeeOrder;
		reqReport();
		
	}
	
	/**
	 * Generate report
	 */
	private void reqReport()
	{
		
		Iterator<Integer> iter = deptData.keySet().iterator();
		while(iter.hasNext())
		{
			totHours=0;
			int item = iter.next();
			
			System.out.println("\n"+deptData.get(item));
			employeeManagement(item);
			
			System.out.println("\nTotal: "+count+" Employee");
			System.out.println("       "+totHours+" Hours");
		}
	}
	
	/**
	 * Look at each department number of employee
	 * @param Dno the department number of employee
	 */
	private void employeeManagement(int Dno)
	{
		
		Iterator<String> iter = employeeOrder.keySet().iterator();
		count = 0;
		while(iter.hasNext())
		{
			String item = iter.next();
			if(employeeData.get(employeeOrder.get(item)).getDno()==Dno)
			{
				System.out.println();
				System.out.println("   "+employeeData.get(employeeOrder.get(item)).getFullName());
				count+=1;
				projManage(employeeOrder.get(item));
				
				
				System.out.printf("%5s%-25s%-18s","","","----");
				System.out.printf("\n%5s%-25s%-18.1f","","",indiHours);
				totHours+=indiHours;
				System.out.println();
				
			}
			
		}
		
		
	}
	
	/**
	 * Look at Project table and locate project name, etc.
	 * @param ssn ssn of employee
	 */
	private void projManage( int ssn)
	{
		indiHours=0;
		Iterator<Integer> iter = projData.keySet().iterator();
		while(iter.hasNext())
		{
			int item = iter.next();
			
				int Pnum = item;
				String Pname = projData.get(item).getPname();
				projTime(Pnum,Pname,ssn);
				
			
		}
	}
	
	/**
	 * Look at works on table lists
	 * @param Pnum project number 
	 * @param Pname project name
	 * @param ssn employee ssn
	 */
	private void projTime(int Pnum, String Pname, int ssn)
	{
		
		for(int i=0;i<Essn.size();i++)
		{
			if(Essn.get(i)==ssn && Pno.get(i)==Pnum)
			{
				System.out.printf("%5s%-25s%-18.1f","",Pname,Hours.get(i));
				indiHours+=Hours.get(i);
				System.out.println();
			}
			
		}
		
		
		
	}
}
