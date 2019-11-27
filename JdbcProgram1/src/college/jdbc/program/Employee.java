package college.jdbc.program; //declaring package name

/**
 * This class encapsulates data
 * in Employee table
 * @author Aaman Bhandari
 *
 */
public class Employee 
{
	//instance variables
	private String fullName;
	private int Ssn;
	private int Dno;
	
	/**
	 * Constructor
	 * @param fullName Full name of Employee
	 * @param Ssn Ssn of Employee
	 * @param Dno Department number of Employee
	 */
	public Employee(String fullName, int Ssn, int Dno)
	{
		this.fullName = fullName;
		this.Ssn = Ssn;
		this.Dno = Dno;
		
	}
	
	/**
	 * Get fullName of Employee
	 * @return fullName fullName of Employee
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Set fullName of Employee
	 * @param fullName The fullName to be changed to.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Get Ssn of Employee
	 * @return Ssn of Employee
	 */
	public int getSsn() {
		return Ssn;
	}
	
	/**
	 * Set Ssn of Employee
	 * @param ssn The Ssn to be changed to
	 */
	public void setSsn(int ssn) {
		Ssn = ssn;
	}
	
	/**
	 * Get Department number of Employee
	 * @return Department number of Employee
	 */
	public int getDno() {
		return Dno;
	}
	
	/**
	 * Set the Department number of Employee
	 * @param dno Department number to be changed to
	 */
	public void setDno(int dno) {
		Dno = dno;
	}
	
}
