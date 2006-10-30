/**
 * 
 */
package gregKing;

/**
 * @author Greg Hendrickson
 *
 */
import java.io.Serializable;


/**
 * The Class Employee (for Smoothie King).
 */
public final class Employee implements Serializable
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The employee name. */
	private String employeeName;
    
    /** The employee's employer. */
    private String employer;
    
    /** The employee's sex. */
    private String sex;
    
    /** The notes on the employee. */
    private String notes;
    
    /** The employee's base salary. */
    private double baseSalary;
    
    /** The adjustments that can be made to the employee's check. */
    private double adjustments;
    
    /** The employee's final salary. */
    private double finalSalary;
    
    /** The employee's emp ID. */
    private int empID;
    
    /** a counter when creating a certian way counter. */
    public int counter = 0;
    
    /** The emplyee's array of days they worked. */
    public BiWeekDay dayArray[] = new BiWeekDay[20];
   
    
    /**
     * Creates a new instance of Employee.
     */
    public Employee()
    {
        this("Default Name",1,"Linda","","",0.0,0.0);
    }
    
    /**
     * The Constructor.
     * 
     * @param sex the sex
     * @param bsal the base salary
     * @param adjustments the adjustments
     * @param notes the notes
     * @param master the master
     * @param name the name
     */
    public Employee(String name, int empid, String master, String sex, String notes, double bsal, double adjustments)
    {
        this.employeeName = name;
        this.empID = empid;
        this.employer = master;
        this.sex = sex;
        this.notes = notes;
        this.baseSalary = bsal;
        this.adjustments = adjustments;
        this.finalSalary = bsal + adjustments;
    }
    
    /**
     * Prevent cloning -- keeps objects of this type immutable.
     * 
     * @return the object
     * 
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public Object clone() throws CloneNotSupportedException 
    {
        throw new CloneNotSupportedException("Object is immutable.");
    }
    
    /**
     * To string.
     * 
     * @return a nice formated string
     */
    public String toString()
    {
        return "Employee: "+ this.employeeName+
               "\nEmployer: "+ this.employer+
               "\nBase Salary: "+ this.baseSalary+
               "\nTotal Adjustments: "+ this.adjustments+
               "\nFinal Salary: "+ this.finalSalary;
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName()
    {
        return this.employeeName;
    }
    
    /**
     * Gets the employer.
     * 
     * @return the employer
     */
    public String getEmployer()
    {
        return this.employer;
    }
    
    /**
     * Gets the sex.
     * 
     * @return the sex
     */
    public String getSex()
    {
        return this.sex;
    }
    
    /**
     * Gets the notes.
     * 
     * @return the notes
     */
    public String getNotes()
    {
        return this.notes;
    }
    
    /**
     * Gets the base salary.
     * 
     * @return the base salary
     */
    public double getBaseSalary()
    {
        return this.baseSalary;
    }
    
    /**
     * Gets the adjustments.
     * 
     * @return the adjustments
     */
    public double getAdjustments()
    {
        return this.adjustments;
    }
    
    /**
     * Gets the final salary.
     * 
     * @return the final salary
     */
    public double getFinalSalary()
    {
        this.finalSalary = this.baseSalary - this.adjustments;
        return this.finalSalary;
    }
    
    /**
     * Sets the salary.
     * 
     * @param sal the sal
     */
    public void setSalary(Double sal)
    {
        this.baseSalary = sal;
    }
    
    /**
     * Sets the adjustment.
     * 
     * @param adj the adj
     */
    public void setAdjustment(Double adj)
    {
        this.adjustments = adj;
    }
    
    /**
     * Sets the day.
     * 
     * @param day the day
     */
    public void setDay(BiWeekDay day)
    {
        this.dayArray[this.counter]=day;
	this.counter++;
    }
    
    /**
     * Sets the name.
     * 
     * @param employeeName the employee name
     */
    public void setName(String employeeName)
    {
        this.employeeName = employeeName;
    }
    
    /**
     * Sets the employer.
     * 
     * @param employer the employer
     */
    public void setEmployer(String employer)
    {
        this.employer = employer;
    }
    
    /**
     * Sets the base salary.
     * 
     * @param baseSalary the base salary
     */
    public void setBaseSalary(double baseSalary)
    {
        this.baseSalary = baseSalary;
    }
    
    /**
     * Sets the sex.
     * 
     * @param sex the sex
     */
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    /**
     * Sets the notes.
     * 
     * @param notes the notes
     */
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
	
	/**
	 * Gets the emp ID.
	 * 
	 * @return the emp ID
	 */
	public int getEmpID() {
		return empID;
	}
	
	/**
	 * Sets the emp ID.
	 * 
	 * @param empID the emp ID
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}
    
    
}
