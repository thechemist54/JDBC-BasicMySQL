package college.jdbc.program; //initializing package name

/**
 * This class is used to encapsulate data from 
 * projects table
 * @author Aaman Bhandari
 *
 */
public class Projects
{
	//instance variables
	private String Pname;
	private int Dnum;
	
	/**
	 * Constructor
	 * @param Pname Project name
	 * @param Dnum Department number
	 */
	public Projects(String Pname, int Dnum)
	{
		this.Pname = Pname;
		this.Dnum = Dnum;
	}
	
	/**
	 * Get Project name
	 * @return Project Name
	 */
	public String getPname() {
		return Pname;
	}
	
	/**
	 * Set Project Name
	 * @param pname Project name to be changed to
	 */
	public void setPname(String pname) {
		Pname = pname;
	}
	
	/**
	 * Get Department num of project
	 * @return department num of project
	 */
	public int getDnum() {
		return Dnum;
	}
	
	/**
	 * Set Department number
	 * @param dnum Department number to be changed to
	 */
	public void setDnum(int dnum) {
		Dnum = dnum;
	}
}
