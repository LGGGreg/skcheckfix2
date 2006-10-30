/*
 * SmoothieDataBase.java
 *
 * Created on October 17, 2006, 10:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gregKing;

import java.io.Serializable;


/**
 * The Class SmoothieDataBase.
 * 
 * @author Greg Hendrickson
 */
public class SmoothieDataBase implements Serializable
{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The start day. */
	private int startDay;
    
    /** The num employees. */
    private int numEmployees;
    
    /** The employee array. */
    private Employee[] employeeArray = new Employee[50]; 
    
    /**
     * The Mega Constructor.
     */
    public SmoothieDataBase()
    {
        this(0,50);
    }
    
    /**
     * The Constructor.
     * 
     * @param numemp the number of max employees
     * @param sday the start day of the week
     */
    public SmoothieDataBase(int sday, int numemp)
    {
        this.startDay = sday;
        this.numEmployees = numemp;
        employeeArray =	new Employee[50];  //Room for 50 employees
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
     * Gets the number of employees.
     * 
     * @return the num employees
     */
    public int getNumEmployees()
    {
        return numEmployees;
    }
    
    /**
     * Gets the employee.
     * 
     * @param i the employees number
     * 
     * @return the employee
     */
    public Employee getEmployee(int i)
    {
        return this.employeeArray[i];
    }

    /**
     * Gets the start day.
     * 
     * @return the start day
     */
    public int getStartDay()
    {
        return startDay;
    }

    /**
     * Sets the employee array.
     * 
     * @param employeeArray the employee array
     */
    public void setEmployeeArray(Employee[] employeeArray)
    {
        this.employeeArray = employeeArray;
    }

    /**
     * Sets the num employees.
     * 
     * @param numEmployees the num employees
     */
    public void setNumEmployees(int numEmployees)
    {
        this.numEmployees = numEmployees;
    }
    
    /**
     * Sets the employee.
     * 
     * @param num the num
     * @param emp the emp
     */
    public void setEmployee(int num, Employee emp)
    {
        this.employeeArray[num] = emp;
    }

    /**
     * Sets the start day.
     * 
     * @param startDay the start day
     */
    public void setStartDay(int startDay)
    {
        this.startDay = startDay;
    }
    
}
