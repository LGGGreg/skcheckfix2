/*
 * BiWeekDay.java
 *
 * Created on October 17, 2006, 12:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package gregKing;


/**
 * The Class BiWeekDay.
 * 
 * @author Greg Hendrickson (gph052000@utdallas.edu)
 */
public class BiWeekDay
{
    
    /** The day's assigned number. */
    public int dayNumber;
    
    /** The counter (used in wierd sincronous assignments). */
    public int counter = 0;
    
    /** The amount the day was over or short. */
    public double dOff;
    
    /** The day's name. */
    public String dayName;
    
    /** The employee array that lists the 2 employees that worked that day. */
    public Employee employeeArray[];
     
    
    /**
     * Creates a new instance of BiWeekDay.
     */
    public BiWeekDay()
    {
        this(1,"Monday");
    }
    
    /**
     * The Constructor.
     * 
     * @param dayNumber the day number
     * @param name the name
     */
    public BiWeekDay(int dayNumber, String name)
    {
        this.dayNumber=dayNumber;
        this.dayName = name;
        this.employeeArray = new Employee[2];
    }
    
    /**
     * Sets the employee.
     * 
     * @param emp the emp
     * @param number the number
     */
    public void setEmployee(int number, Employee emp)
    {
        this.employeeArray[number-1] = emp;
        this.counter = number;
    }
  
    /**
     * Sets the employee.
     * 
     * @param emp the emp
     */
    public void setEmployee(Employee emp)
    {
	this.employeeArray[this.counter]=emp;
	this.counter++;
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName()
    {
        return dayName;
    }

    /**
     * Sets the name.
     * 
     * @param dayName the day name
     */
    public void setName(String dayName)
    {
        this.dayName = dayName;
    }
    
    /**
     * Gets the employee array.
     * 
     * @return the employee array
     */
    public Employee[] getEmployeeArray()
    {
        return employeeArray;
    }
    
    /**
     * Gets the employee.
     * 
     * @param number the number
     * 
     * @return the employee
     */
    public Employee getEmployee(int number)
    {
        return this.employeeArray[number-1];
    }
	
	/**
	 * Set the amount the day ended over or short.
	 * 
	 * @param off the amount the day was off
	 */
	public void setdoff(double off) {
		dOff = off;
	}
	
	/**
	 * Getdoff.
	 * 
	 * @return the stored amount that the day was over or short
	 */
	public double getdoff()
	{
		return dOff;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
    
}
