package gregKing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;

//import org.eclipse.swt.layout.GridLayout;//
//import org.eclipse.swt.graphics.Color;

import javax.swing.event.ListSelectionListener;




/**
 * The Class Main.
 * 
 * @author Greg Hendrickson (gph052000atutdallasdotedu)
 */
public class GregMain extends javax.swing.JFrame
{
   
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	//Stiking variable out there
    /** The main jswing output class. */
	private static GregMain gregr;
    
    /** The database for saving info. */
    private SmoothieDataBase db;
    
    /** The day array. */
    private BiWeekDay[] dayArray;
    
    /** The tabbed pane. */
    private JTabbedPane tabber;
    
    /** One of the freaking JPanels. */
    private JPanel leftPanel,rightBottom,rightTop,page1,page2,tab2BTopRight,tab2BTopLeft;
    
    /** One of the many labels. */
    private JLabel emp1Label, emp2Label, adjLabel;
    
    /** The looks. */
    private UIManager.LookAndFeelInfo looks[];
    
    /** The splitpanes. */
    private JSplitPane hpane, vpane;
    
    /** The combo boxes box. */
    private JComboBox employeeBox1, employeeBox2, daysBox;
    
    /** The jbuttons. */
    private JButton eSave,leftb,rightb,addEmp,remEmp,saveday;
    
    /** The list box. */
    private JList listBox;
    
    /** The spane. */
    private JScrollPane spane;
    
    /** The s. */
    private ObjectOutputStream s;
    //private JTextPane textPane;
    /** The emp number. */
    private JTextField adjustment,empName,empEr,empSex,empNotes,empBsal,empTadj,empTsal,empNumber;
    
    /** The c. */
    private Container c;
    
    /** The ihandler. */
    private ItemListener ihandler;
    
    /** The left right do. */
    private ActionListener leftRightDo;
    
    /** The days all. */
    private String[] employeeNames, dayNames, daysAll;
    
    /** The decimal formatf. */
    private DecimalFormat df;
   // private static Dimension dim;
    /** The days ordered. */
   private java.lang.String[] daysOrdered;
    
    //private String text,text2,text3;
    
    /** The view employee number. */
    private int viewEmployeeNumber;
    
    /**
     * Creates a new instance of Main.
     */
    public GregMain()
    {
        setTitle("Greg's Smoothie King Check Adjustment Program!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("s.gif")));
        //setIconImage(new ImageIcon("r.gif"));
        // Make sure we have nice window decorations.
        //setDefaultLookAndFeelDecorated(true);
        df = new DecimalFormat("¤#,##0.00");
        //setSize(600, 670);
       // dim = new Dimension(500,700);
        db            = new SmoothieDataBase();
        for (int i =0;i<50;i++)
		{
			db.setEmployee(i, new Employee());
			//System.out.println("the emplye number "+i);
		}
        
        readAccount();
        dayArray      = new BiWeekDay[14];
        //adjustArray	  = new double[50];
        dayNames      = new String[dayArray.length];     
        daysAll       = new String[27];
        daysOrdered   = new String[14];
        dayNames[0]="Monday";
        dayNames[1]="Tuesday";
        dayNames[2]="Wednesday";
        dayNames[3]="Thursday";
        dayNames[4]="Friday";
        dayNames[5]="Saturday";
        dayNames[6]="Sunday";
        
        for (int i=0;i<20;i++)
        {
            daysAll[i]="Monday";
            i++;
            daysAll[i]="Tuesday";
            i++;
            daysAll[i]="Wednesday";
            i++;
            daysAll[i]="Thursday";
            i++;
            daysAll[i]="Friday";
            i++;
            daysAll[i]="Saturday";
            i++;
            daysAll[i]="Sunday";
        }
        
        for (int i =0; i<daysOrdered.length;i++)
        {
            daysOrdered[i]=daysAll[i+(db.getStartDay())]+" Day #"+(i+1);
        }        
        for (int i = 0; i < dayArray.length; i++)
        {
            //String studentString = studentData.getNextString();
            //Student tempStudent = new Student(studentString);
            BiWeekDay tempDay = new BiWeekDay(i,daysOrdered[i]);
            dayArray[i] = tempDay;
        }
        employeeNames = new String[(db.getNumEmployees())];
        
        c = getContentPane();
        
        makeData();
        makeTab1();
        makeTab2();
        makeTabber();
        
        
	}
    
    /**
     * Make data.
     */
    public void makeData()
    {
        
        for (int i = 0; i < dayArray.length; i++)
        {
            //System.out.println(dayArray[i].getName());
            dayNames[i]="#"+(i+1)+": "+daysAll[i+db.getStartDay()];
        }
        employeeNames = new String[db.getNumEmployees()];
        for (int i = 0; i < db.getNumEmployees(); i++)
        {
            //System.out.println(db.getEmployee(i).getName());
        	//System.out.println("trying to set employee name number "+i);
            employeeNames[i]=db.getEmployee(i).getName();
        }
        
        
        //employeeArray[0] = new Employee("Laura Norman","Linda","Female","My Fiancee",250.0,25.0);
        //makeTab1();
    }
    
    /**
     * Make tab1.
     */
    public void makeTab1()
    {
    	rightTop = new JPanel();
    	final Color colr = rightTop.getBackground();
    	rightTop.setBackground(Color.RED);
    	rightTop.setLayout(new BorderLayout());
        listBox = new JList(dayNames);
        listBox.setSelectedIndex(0);
        listBox.addListSelectionListener
        (
                new ListSelectionListener()
                {
                    public void valueChanged(ListSelectionEvent e)
                    {
                    	
						try 
						{
							employeeBox1.setSelectedIndex(dayArray[listBox.getSelectedIndex()].getEmployee(1).getEmpID());
							employeeBox2.setSelectedIndex(dayArray[listBox.getSelectedIndex()].getEmployee(2).getEmpID());
							adjustment.setText(df.format(dayArray[listBox.getSelectedIndex()].getdoff()));
							adjustment.setText(df.format(dayArray[listBox.getSelectedIndex()].getdoff()));
							rightTop.setBackground(colr);
						}
						catch (Exception exeption) 
						{
							
							rightTop.setBackground(Color.RED);
							adjustment.setText("0.00");
						}
                    }
                }
        );
        employeeBox1=new JComboBox(employeeNames);
        employeeBox2=new JComboBox(employeeNames);
        
        emp1Label = new JLabel("Employee #1");
        emp2Label = new JLabel("Employee #2");
        adjLabel  = new JLabel("Adjustment (posistive if over, negative if short)");
        adjustment = new JTextField("0.00", 5);
        saveday = new JButton("Save");
        saveday.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	if(listBox.getSelectedIndex()>=0 && employeeBox1.getSelectedIndex() >=0 && employeeBox2.getSelectedIndex()>=0)
                	{
                		dayArray[listBox.getSelectedIndex()].setEmployee(1, db.getEmployee(employeeBox1.getSelectedIndex()));
                		dayArray[listBox.getSelectedIndex()].setEmployee(2, db.getEmployee(employeeBox2.getSelectedIndex()));
                		dayArray[listBox.getSelectedIndex()].setdoff(Double.valueOf(adjustment.getText()).doubleValue());
                		rightTop.setBackground(colr);
                		setEmpData();
                	}
                	else
                	{
                		JOptionPane.showMessageDialog(gregr,"Please Make Sure you have a day and two employees selected");
                	}
                }
            }
        );
        saveday.setPreferredSize(new Dimension(200,50));
        //dayBox = new JComboBox(dayNames);
               
        looks = UIManager.getInstalledLookAndFeels();
        try
        {
            UIManager.setLookAndFeel
                    (
                    looks[0].getClassName()
                    );
            SwingUtilities.updateComponentTreeUI( this );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        
        
        
        spane = new JScrollPane();
        spane.getViewport().add( listBox );
        //spane.setBounds(20, 20, 2000, 499);
        //spane.setSize(400,400);
        spane.setPreferredSize(new Dimension(250,200));
       
        
        leftPanel = new JPanel();
        	leftPanel.setLayout(new BorderLayout());
        	leftPanel.add(spane,BorderLayout.CENTER);
        
        
        rightTop.add(emp1Label);
        rightTop.add(employeeBox1);
        rightTop.add(new JLabel(""));
        rightTop.add(emp2Label);
        rightTop.add(employeeBox2);
        rightTop.setPreferredSize(new Dimension(150,250));
        
        rightBottom = new JPanel();
        rightBottom.setLayout(new GridLayout(0,1));
        rightBottom.add(adjLabel);
        rightBottom.add(adjustment);
        //rightBottom.add(new JLabel("ladfa"));
        //rightBottom.add(new JLabel("ladfa"));
               
        
        vpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rightTop, rightBottom);
        
        hpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, vpane);
        //hpane.setSize(1600, 600);
        //hpane.setSize(dim);
        page1 = new JPanel();
        page1.setLayout(new BorderLayout());
        page1.add(hpane,BorderLayout.CENTER);
        page1.add(saveday,BorderLayout.PAGE_END);
        //page1.setSize(dim);
        //page1.setSize(700,700);
    }
    
    /**
     * Make tab2.
     */
    public void makeTab2()
    {
        ihandler = new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                //System.out.println(a1337box.getSelectedItem());
                
                db.setStartDay(daysBox.getSelectedIndex());
                System.out.println("set start day to "+daysBox.getSelectedIndex());
                makeData();
                System.out.println("The start day is on "+db.getStartDay());
                
                listBox.setListData( dayNames );
                spane.revalidate();
                spane.repaint();
            }
        };
        leftRightDo = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==leftb)
                {
                    if(viewEmployeeNumber>0)
                    {
                    viewEmployeeNumber--;
                    }
                    else
                    {
                    	viewEmployeeNumber=db.getNumEmployees()-1;
                    }
                }
                else if(e.getSource()==rightb)
                {
                    if(viewEmployeeNumber < db.getNumEmployees()-1)
                    {
                    	viewEmployeeNumber++;
                    }
                    else
                    {
                    	viewEmployeeNumber=0;
                    }
                    //System.out.println("viewempnumber is now"+viewEmployeeNumber);
                }
                else if(e.getSource()==rightb)
                {
                    if(viewEmployeeNumber < db.getNumEmployees())
                    {
                    	viewEmployeeNumber++;
                    	viewEmployeeNumber=db.getNumEmployees();
                    }
                    //System.out.println("viewempnumber is now"+viewEmployeeNumber);
                }
                else if(e.getSource()==remEmp)
                {
                    db.setNumEmployees(db.getNumEmployees()-1);
                    if(viewEmployeeNumber>(db.getNumEmployees()-1))
                    {
                    	viewEmployeeNumber=db.getNumEmployees()-1;
                    }
                    //System.out.println("viewempnumber is now"+viewEmployeeNumber);
                }
                else if(e.getSource()==addEmp)
                {
                	db.setNumEmployees(db.getNumEmployees()+1);
                	viewEmployeeNumber=db.getNumEmployees()-1;
                    //System.out.println("viewempnumber is now"+viewEmployeeNumber);
                }
                
                setEmpData();
                db.getEmployee(viewEmployeeNumber).setName(empName.getText());
                db.getEmployee(viewEmployeeNumber).setEmployer(empEr.getText());
                db.getEmployee(viewEmployeeNumber).setSex(empSex.getText());
                db.getEmployee(viewEmployeeNumber).setNotes(empNotes.getText());
                db.getEmployee(viewEmployeeNumber).setBaseSalary(Double.valueOf(empBsal.getText()).doubleValue());
                db.getEmployee(viewEmployeeNumber).setEmpID(viewEmployeeNumber);
                makeData();
                employeeBox1.setModel(new DefaultComboBoxModel(employeeNames));
                employeeBox2.setModel(new DefaultComboBoxModel(employeeNames));
                setEmpData();
            }
        };
        //daysLabel = new JLabel("Select Start Day");
        daysBox=new JComboBox(new String[] { "Monday", "Teusday",
        "Wednesday", "Thursday", "Friday","Saturday","Sunday"} );
        daysBox.addItemListener(ihandler);
        daysBox.setSelectedIndex(db.getStartDay());
        
        leftb = new JButton("<");
            leftb.addActionListener(leftRightDo);
        rightb= new JButton(">");
            rightb.addActionListener(leftRightDo);
        addEmp= new JButton("Add Employee");
        	addEmp.addActionListener(leftRightDo);
        remEmp= new JButton("Remove Employee");
        	remEmp.addActionListener(leftRightDo);
        eSave = new JButton("Save Employee Information");
        
        eSave.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    db.getEmployee(viewEmployeeNumber).setName(empName.getText());
                    db.getEmployee(viewEmployeeNumber).setEmployer(empEr.getText());
                    db.getEmployee(viewEmployeeNumber).setSex(empSex.getText());
                    db.getEmployee(viewEmployeeNumber).setNotes(empNotes.getText());
                    db.getEmployee(viewEmployeeNumber).setBaseSalary(Double.valueOf(empBsal.getText()).doubleValue());
                    makeData();
                    employeeBox1.setModel(new DefaultComboBoxModel(employeeNames));
                    employeeBox2.setModel(new DefaultComboBoxModel(employeeNames));
                    writeAccount();
                    setEmpData();
                }
            }
        );
        
        empNumber=new JTextField();
            empNumber.setText((viewEmployeeNumber+1)+"");
        empNumber.setEditable(false);
        empNumber.setAlignmentY(CENTER_ALIGNMENT);
        empName = new JTextField(db.getEmployee(viewEmployeeNumber).getName());
        empEr   = new JTextField(db.getEmployee(viewEmployeeNumber).getEmployer());
        empSex  = new JTextField(db.getEmployee(viewEmployeeNumber).getSex());
        empNotes= new JTextField(db.getEmployee(viewEmployeeNumber).getNotes());
        String tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getBaseSalary());
        empBsal = new JTextField(tbsal);
        tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getAdjustments());
        empTadj = new JTextField(tbsal);
        empTadj.setEditable(false);
        tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getFinalSalary());
        empTsal = new JTextField(tbsal);
        empTsal.setEditable(false);
        
        tab2BTopLeft = new JPanel();
            tab2BTopLeft.setLayout(new GridLayout(0,3));
            tab2BTopLeft.add(leftb);
            tab2BTopLeft.add(empNumber);
            tab2BTopLeft.add(rightb);
        tab2BTopRight = new JPanel();
            tab2BTopRight.add(addEmp);
            tab2BTopRight.add(remEmp);
        page2 = new JPanel();
            page2.setLayout(new GridLayout(0,2,0,8));
        page2.add(new JLabel("Set Start Day"));
            page2.add(daysBox);
        page2.add(new JLabel(""));
            page2.add(new JLabel(""));
        page2.add(tab2BTopLeft);
            page2.add(tab2BTopRight);
        page2.add(new JLabel("Employee Name"));
            page2.add(empName);
        page2.add(new JLabel("Employer"));
            page2.add(empEr);
        page2.add(new JLabel("Sex"));
            page2.add(empSex);
        page2.add(new JLabel("Notes"));
            page2.add(empNotes);
        page2.add(new JLabel("Base Salary"));
            page2.add(empBsal);
        page2.add(new JLabel("Total Adjustments"));
            page2.add(empTadj);
        page2.add(new JLabel("Total Salary"));
            page2.add(empTsal);
        page2.add(new JLabel("Save your changes -->"));
            page2.add(eSave);
        setEmpData();
        //page2.setSize(700,700);
    }
    
    /**
     * Make tabber.
     */
    public void makeTabber()
    {
        JPanel topPanel = new JPanel();
        //topPanel.setLayout(new BorderLayout());
        
        tabber = new JTabbedPane();
        
        topPanel.setLayout(new BorderLayout());
        
        tabber.addTab("Main", new ImageIcon("r.gif"), page1,"Allows you to enter data for each day!");
        tabber.addTab("View/Edit Employees", new ImageIcon("v.gif"), page2,"Allows you to modify or view your DataBase!");
        //tabber.addTab("Display Student", new ImageIcon("s.gif"), page3,"Allows you to display the schedual by student");
        
        //tabber.setEnabledAt(1,false);
        //tabber.setEnabledAt(2,false);
        
        //tabber.setDisabledIconAt(1, new ImageIcon("noc.gif"));
        //tabber.setDisabledIconAt(2, new ImageIcon("nos.gif"));
        //tabber.setDisabledIconAt(0, new ImageIcon("nor.gif"));
        
        tabber.setForegroundAt(0, Color.red);
        tabber.setForegroundAt(1, Color.blue);
        //tabber.setForegroundAt(2, Color.green);
        
        //tabber.setBackgroundAt(0, Color.red);
        //tabber.setBackgroundAt(1, Color.blue);
        //tabber.setBackgroundAt(2, Color.green);
        tabber.setMnemonicAt(0,'m');
        tabber.setMnemonicAt(1,'v');
        //tabber.setMnemonicAt(2,'t');
        
        topPanel.add(tabber,BorderLayout.CENTER);
        //topPanel.setSize(dim);
        //topPanel.setSize(new Dimension(1000,1000));
        
        c.add(topPanel);
        //c.setSize(dim);
        //c.setMinimumSize(new Dimension(1000,1000));
    }
    
    /**
     * Sets the emp data.
     */
    public void setEmpData()
    {
        empNumber.setText((viewEmployeeNumber+1)+"");
        empName.setText(db.getEmployee(viewEmployeeNumber).getName());
        empEr.setText(db.getEmployee(viewEmployeeNumber).getEmployer());
        empSex.setText(db.getEmployee(viewEmployeeNumber).getSex());
        empNotes.setText(db.getEmployee(viewEmployeeNumber).getNotes());
        String tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getBaseSalary());
        empBsal.setText(tbsal);
        //tbsal = Double.toString(generateAdjustments(viewEmployeeNumber));
        empTadj.setText(df.format(generateAdjustments(viewEmployeeNumber)));
        //tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getBaseSalary()+generateAdjustments(viewEmployeeNumber));
        empTsal.setText(df.format(db.getEmployee(viewEmployeeNumber).getBaseSalary()+generateAdjustments(viewEmployeeNumber)));
        makeData();
        
        
    }
    
    /**
     * Creates the and show GUI.
     */
    private static void createAndShowGUI()
    {
        // Create and set up the window.
        gregr = new GregMain();
        // Display the window.
        gregr.pack();
        gregr.setVisible(true);
        //gregr.setAlwaysOnTop(true);
        //setDefaultLookAndFeelDecorated(true);
        //gregr.setSize(dim);
    }
    
    /**
     * Write account.
     */
    public void writeAccount()
   	{
      try
      {
        //char base[] = baseDir.toCharArray();
        try{
        	String destination = ("SmoothieData.smoothiedb");
            System.out.println(destination);
           
        
            s = new ObjectOutputStream(
	            new FileOutputStream( destination ) );
	            
	        //s.writeObject("Witre object string");
//			s.writeObject(new Account(urlt.getText(), (String) a1337box.getSelectedItem(),
//	                        ((Integer) a1337lbox.getSelectedItem()).intValue(), (String) hashBox.getSelectedItem(), charst
//	                                .getText(), Integer.parseInt(lengtht.getText()), usert.getText(), modt.getText(), pret
//	                                .getText(), sut.getText()));
            s.writeObject(db);
			s.flush();
			s.close();
			

		}
		catch(IndexOutOfBoundsException e)
		{
			System.err.println("Error, file must be inside ");

		}
		
		writeDB();
      }
      catch ( IOException ioException )
      {
         System.err.println( "Error write account." );
      } // end catch
       
    } // end method openFile
  	
	  /**
	   * Write DB.
	   */
	  public void writeDB()
  	{
  		try
  		{
  			
  		 			
  			
  			ObjectOutputStream out1 = new ObjectOutputStream(
                           new FileOutputStream("SmoothieData.smoothiedb"));
          	out1.writeObject( db);
          	out1.flush();
          	out1.close();
          	
    		
                       
        	}
        catch(IOException ioException )
        {
        	System.err.println("Eroor 1101");
        }
  	}
  	
	  /**
	   * Read DB.
	   */
	  public void readDB()
  	{
 		try
  		{  			
  			ObjectInputStream in1 = new ObjectInputStream(
                           new FileInputStream("SmoothieData.smoothiedb"));
                           
            db =(SmoothieDataBase)in1.readObject();
			              
             
          	in1.close();
          	
    		
                       
        }
        catch(IOException ioException )
        {
        	System.err.println("Eroor 1102");
        }
        catch(ClassNotFoundException ce)
        {
        	System.err.println("cls not found");
        }
  	}
  	
	  /**
	   * Read account.
	   */
	  public void readAccount()
  	{
  		try
  		{
  			//char base[] = baseDir.toCharArray();
  			//botom line for jlist
  			//String target = ("Accounts/"+(String)accountList.getSelectedValue()) + ".act";
  			
  			//this line for file choser
  			//String target = ("Accounts/"+filet.getText());
  			
  			
			String target = ("SmoothieData.smoothiedb");
         	
  			FileInputStream in = new FileInputStream(target);
			ObjectInputStream r = new ObjectInputStream(in);
			//String today = (String)s.readObject();
			//Account account1 = new Account();
			this.db =(SmoothieDataBase)r.readObject();
			//this.db = new SmoothieDataBase();
			
			r.close();
		}
		catch (Throwable e) 
  		{
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
                //this.db = new SmoothieDataBase();
        }
        
        		
  	}
  	
	  /**
	   * Generate adjustments.
	   * 
	   * @param x the x
	   * 
	   * @return the double
	   */
	  public Double generateAdjustments(int x)
  	{
  		double a=0;
  		for(int i=0;i<14;i++)
  		{
			try 
			{
				if(dayArray[i].getEmployee(1).getEmpID()==x)
				{
					a+=(dayArray[i].getdoff())/2;
				}
				
			}
			catch (Exception e)
			{
				//JOptionPane.showConfirmDialog(gregr, "Um, we hit an error here, ok?"+e.printStackTrace());
				//e.printStackTrace();
				System.out.println(" "+i+" not found");
			} 
			try 
			{
				if(dayArray[i].getEmployee(2).getEmpID()==x)
				{
					a+=(dayArray[i].getdoff())/2;
				}
				
			}
			catch (Exception e)
			{
				//JOptionPane.showConfirmDialog(gregr, "Um, we hit an error here, ok?"+e.printStackTrace());
				//e.printStackTrace();
			}
			
  		}
  		return a;
  	}
    
    /**
     * The main method.
     * 
     * @param args the args
     */
    public static void main(String[] args)
    {
        //code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
        
        
    }
}
