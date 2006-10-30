package gregKing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GregMainApp extends org.eclipse.swt.widgets.Composite {

	{
		try {
	         //UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
	         //UIManager.setLookAndFeel("org.fife.plaf.OfficeXP.OfficeXPLookAndFeel");
	         UIManager.setLookAndFeel("org.fife.plaf.VisualStudio2005.VisualStudio2005LookAndFeel");
	      } catch (Exception e) {
	         System.err.println("Oops!  Something went wrong!");
	      }
	}


	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private CLabel cLabel8;
	private Text cempNotes;
	private Composite awtswt;
	private Button saveempb;
	private Text cempTsal;
	private Group group3;
	private Group group2;
	private StyledText outputStyled;
	private Group group1;
	private CTabItem proveTab;
	private Text cempAsal;
	private Text cempBsal;
	private Text cempSex;
	private Text cempEr;
	private CLabel cLabel7;
	private CLabel cLabel6;
	private CLabel cLabel5;
	private CLabel cLabel4;
	private CLabel cLabel3;
	private Button cleftb;
	private Button cremempb;
	private Button caddempb;
	private Composite composite2;
	private StyledText cempNumber;
	private Button crightb;
	private Composite buttonBox;
	private Composite composite1;
	private Text cempName;
	private Combo combo1;
	private CLabel cLabel2;
	private CLabel cLabel1;
	private CTabItem CtabItem2;
	private CTabItem cTabItem1;
	private CTabFolder cTabFolderMain;
	
	/** The database for saving info. */
    private SmoothieDataBase db;
    
    /** The day array. */
    private BiWeekDay[] dayArray;
    
    /** The tabbed pane. */
    //private JTabbedPane tabber;
    
    /** One of the freaking JPanels. */
    private JPanel leftPanel,rightBottom,rightTop;
    
    private Frame page1;
    
    /** One of the many labels. */
    private JLabel emp1Label, emp2Label, adjLabel;
    
    /** The looks. */
    //private UIManager.LookAndFeelInfo looks[];
    
    /** The splitpanes. */
    private JSplitPane hpane, vpane;
    
    /** The combo boxes box. */
    private JComboBox employeeBox1, employeeBox2;
    
    /** The jbuttons. */
    private JButton saveday;
    
    /** The list box. */
    private JList listBox;
    
    /** The spane. */
    private JScrollPane spane;
    
    /** The s. */
    private ObjectOutputStream s;
    //private JTextPane textPane;
    /** The emp number. */
    private JTextField adjustment;
        
    /** The ihandler. */
    //private ItemListener ihandler;
    
    /** The left right do. */
    //private ActionListener leftRightDo;
    
    /** The days all. */
    private String[] employeeNames, dayNames, daysAll;
    
    /** The decimal formatf. */
    private DecimalFormat df;
   // private static Dimension dim;
    /** The days ordered. */
    private java.lang.String[] daysOrdered;
   
   
    
    //private String text,cempEr,cempSex;
    
    /** The view employee number. */
    private int viewEmployeeNumber;
    //private GregMainApp inst;

	public GregMainApp(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	/**
	* Initializes the GUI.
	* 
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			
			//this.setSize(502, 666);
			FillLayout thisLayout = new FillLayout(
				org.eclipse.swt.SWT.HORIZONTAL);
			this.setLayout(thisLayout);
			{
				cTabFolderMain = new CTabFolder(this, SWT.TOP
					| SWT.NO_RADIO_GROUP
					| SWT.EMBEDDED
					| SWT.H_SCROLL);
				
				{
					cTabItem1 = new CTabItem(cTabFolderMain, SWT.NONE);
					cTabItem1.setText("Main");
					cTabItem1.setToolTipText("This is where you can set who worked on what day, and enter the amount over or short!");
					cTabItem1.setImage(SWTResourceManager.getImage("gregKing/r.gif"));
					{
						group3 = new Group(cTabFolderMain, SWT.NONE);
						cTabItem1.setControl(group3);
						FillLayout group3Layout = new FillLayout(
							org.eclipse.swt.SWT.HORIZONTAL);
						group3.setLayout(group3Layout);
						group3.setText("Adjustment Editing");
						{
							awtswt = new Composite(group3, SWT.EMBEDDED
								| SWT.BORDER);
							GridLayout awtswtLayout = new GridLayout();
							awtswtLayout.makeColumnsEqualWidth = true;
							awtswt.setLayout(awtswtLayout);
						}
					}
				}
				{
					CtabItem2 = new CTabItem(cTabFolderMain, SWT.NONE);
					CtabItem2.setText("View/Edit Employees");
					CtabItem2.setImage(SWTResourceManager.getImage("gregKing/v.gif"));
					CtabItem2.setToolTipText("Allows you to edit the employee DataBase and view Check amounts");
					{
						composite1 = new Composite(
							cTabFolderMain,
							SWT.NO_RADIO_GROUP);
						CtabItem2.setControl(composite1);
						FillLayout composite1Layout = new FillLayout(
							org.eclipse.swt.SWT.HORIZONTAL);
						composite1.setLayout(composite1Layout);
						composite1.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_CROSS));
						{
							group2 = new Group(composite1, SWT.H_SCROLL);
							GridLayout group2Layout = new GridLayout();
							group2Layout.makeColumnsEqualWidth = true;
							group2Layout.numColumns = 2;
							group2.setLayout(group2Layout);
							group2.setText("Employee DataBase");
							{
								cLabel1 = new CLabel(group2, SWT.SHADOW_OUT
									| SWT.CENTER
									| SWT.LEFT
									| SWT.NO_FOCUS
									| SWT.EMBEDDED
									| SWT.BORDER);
								cLabel1.setText("Select Start Day");
								cLabel1.setImage(SWTResourceManager
									.getImage("gregKing/s.gif"));
								GridData cLabel1LData = new GridData();
								cLabel1.setLayoutData(cLabel1LData);
							}
							{
								combo1 = new Combo(group2, SWT.READ_ONLY
									| SWT.BORDER);
								combo1.setText("combo1");
								combo1.setItems(new String[] { "Monday",
										"Tuesday", "Wednesday", "Thursday",
										"Friday", "Saturday", "Sunday" });
								GridData combo1LData = new GridData();
								combo1LData.grabExcessHorizontalSpace = true;
								combo1LData.horizontalAlignment = GridData.FILL;
								combo1.setLayoutData(combo1LData);
								combo1
									.setToolTipText("Allows you to choose what day the week should start on");
								combo1
									.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(
										SelectionEvent evt) {
										System.out
											.println("combo1.widgetSelected, event="
												+ evt);
										db.setStartDay(combo1.getSelectionIndex());
						                System.out.println("set start day to "+combo1.getSelectionIndex());
						                makeData();
						                System.out.println("The start day is on "+db.getStartDay());
						                
						                listBox.setListData( dayNames );
						                spane.revalidate();
						                spane.repaint();
										
									}
									});
							}
							{
								buttonBox = new Composite(group2, SWT.NONE);
								RowLayout buttonBoxLayout = new RowLayout(
									org.eclipse.swt.SWT.HORIZONTAL);
								buttonBoxLayout.justify = true;
								GridData buttonBoxLData = new GridData();
								buttonBox.setLayoutData(buttonBoxLData);
								buttonBox.setLayout(buttonBoxLayout);
								{
									cleftb = new Button(buttonBox, SWT.ARROW
										| SWT.LEFT);
									cleftb.setText("-->");
									RowData button1LData1 = new RowData();
									button1LData1.width = 32;
									button1LData1.height = 28;

									cleftb.setLayoutData(button1LData1);
									cleftb
										.setToolTipText("Views the previous employee");
									cleftb.setCursor(SWTResourceManager
										.getCursor(SWT.CURSOR_SIZEWE));
									cleftb.addMouseListener(new MouseAdapter() {
										public void mouseUp(MouseEvent evt) {
											button1MouseUp(evt);
										}
									});
								}
								{
									cempNumber = new StyledText(
										buttonBox,
										SWT.SINGLE
											| SWT.FULL_SELECTION
											| SWT.READ_ONLY
											| SWT.NO_BACKGROUND
											| SWT.NO_FOCUS
											| SWT.EMBEDDED);
									RowData styledText2LData = new RowData();
									styledText2LData.width = 51;
									styledText2LData.height = 49;
									cempNumber.setLayoutData(styledText2LData);
									cempNumber.setFont(SWTResourceManager
										.getFont(
											"Times New Roman",
											36,
											1,
											false,
											false));
									cempNumber.setOrientation(SWT.VERTICAL);
									cempNumber.setBackground(composite1
										.getBackground()); //.getColor(128, 0, 0));
									cempNumber.setEnabled(false);
									cempNumber.setText("44");
									cempNumber
										.setToolTipText("The number of the emplyee you are viewing");
								}
								{
									crightb = new Button(buttonBox, SWT.ARROW
										| SWT.RIGHT);
									RowData button2LData = new RowData();
									button2LData.width = 32;
									button2LData.height = 28;
									crightb.setLayoutData(button2LData);
									crightb.setText("-->");
									crightb
										.setToolTipText("View next employee");
									crightb.setCursor(SWTResourceManager
										.getCursor(SWT.CURSOR_SIZEWE));
									crightb
										.addMouseListener(new MouseAdapter() {
											public void mouseUp(MouseEvent evt) {
												button1MouseUp(evt);
											}
										});
								}
							}
							{
								composite2 = new Composite(group2, SWT.NONE);
								GridLayout composite2Layout = new GridLayout();
								composite2Layout.numColumns = 2;
								composite2Layout.makeColumnsEqualWidth = true;
								composite2Layout.verticalSpacing = 0;
								composite2Layout.horizontalSpacing = 0;
								composite2Layout.marginWidth = 2;
								composite2.setLayout(composite2Layout);
								GridData composite2LData = new GridData();
								composite2.setLayoutData(composite2LData);
								{
									caddempb = new Button(composite2, SWT.PUSH
										| SWT.CENTER);
									caddempb.setText("Add Employee");
									caddempb
										.setToolTipText("Adds an aditional employee to the data base");
									caddempb
										.addMouseListener(new MouseAdapter() {
											public void mouseUp(MouseEvent evt) {
												button1MouseUp(evt);
											}
										});
								}
								{
									cremempb = new Button(composite2, SWT.PUSH
										| SWT.CENTER);
									GridData button4LData = new GridData();
									button4LData.widthHint = 100;
									button4LData.heightHint = 23;
									cremempb.setLayoutData(button4LData);
									cremempb.setText("Remove Employee");
									cremempb
										.setToolTipText("Allows you to remove the last emplyee");
									cremempb
										.addMouseListener(new MouseAdapter() {
											public void mouseUp(MouseEvent evt) {
												button1MouseUp(evt);
											}
										});
								}
							}
							{
								cLabel2 = new CLabel(group2, SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED
									| SWT.BORDER);
								cLabel2.setText("Employee Name");
								cLabel2.setImage(SWTResourceManager.getImage("gregKing/buller.gif"));
								GridData cLabel2LData = new GridData();
								cLabel2LData.grabExcessHorizontalSpace = true;
								cLabel2.setLayoutData(cLabel2LData);
								cLabel2.setToolTipText("The employees name");
							}
							{
								cempName = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempName.setText("cempName");
								GridData text1LData = new GridData();
								text1LData.horizontalAlignment = GridData.FILL;
								text1LData.verticalAlignment = GridData.FILL;
								text1LData.grabExcessHorizontalSpace = true;
								cempName.setLayoutData(text1LData);
								cempName.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempName.setOrientation(SWT.VERTICAL);
								cempName.setToolTipText("The employees name");
							}
							{
								cLabel8 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel8.setText("Employer");
								cLabel8.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel8LData = new GridData();
								cLabel8.setLayoutData(cLabel8LData);
								cLabel8.setAlignment(SWT.RIGHT);
								cLabel8
									.setToolTipText("The person who pays the emplyee");
							}
							{
								cempEr = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempEr.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempEr.setText("cempName");
								cempEr.setOrientation(SWT.VERTICAL);
								GridData text2LData = new GridData();
								text2LData.horizontalAlignment = GridData.FILL;
								text2LData.verticalAlignment = GridData.FILL;
								text2LData.grabExcessHorizontalSpace = true;
								cempEr.setLayoutData(text2LData);
								cempEr.setToolTipText("The person who pays this employee");
							}
							{
								cLabel7 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel7.setText("Sex");
								cLabel7.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel7LData = new GridData();
								cLabel7.setLayoutData(cLabel7LData);
								cLabel7.setToolTipText("The employees sex");
							}
							{
								cempSex = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempSex.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempSex.setText("cempName");
								cempSex.setOrientation(SWT.VERTICAL);
								GridData text3LData = new GridData();
								text3LData.horizontalAlignment = GridData.FILL;
								text3LData.verticalAlignment = GridData.FILL;
								text3LData.grabExcessHorizontalSpace = true;
								cempSex.setLayoutData(text3LData);
								cempSex.setToolTipText("The employee's sex");
							}
							{
								cLabel5 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel5.setText("Notes");
								cLabel5.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel5LData = new GridData();
								cLabel5.setLayoutData(cLabel5LData);
								cLabel5
									.setToolTipText("Anjy notes you have for the employee");
							}
							{
								cempNotes = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempNotes.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempNotes.setText("cempName");
								cempNotes.setOrientation(SWT.VERTICAL);
								GridData text4LData = new GridData();
								text4LData.horizontalAlignment = GridData.FILL;
								text4LData.verticalAlignment = GridData.FILL;
								text4LData.grabExcessHorizontalSpace = true;
								cempNotes.setLayoutData(text4LData);
								cempNotes.setToolTipText("Notes you may have on the employee");
							}
							{
								cLabel6 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel6.setText("Base Salary");
								cLabel6.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel6LData = new GridData();
								cLabel6.setLayoutData(cLabel6LData);
								cLabel6
									.setToolTipText("The employees base salary after taxes");
							}
							{
								cempBsal = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempBsal.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempBsal.setText("cempName");
								cempBsal.setOrientation(SWT.VERTICAL);
								GridData text5LData = new GridData();
								text5LData.horizontalAlignment = GridData.FILL;
								text5LData.verticalAlignment = GridData.FILL;
								text5LData.grabExcessHorizontalSpace = true;
								cempBsal.setLayoutData(text5LData);
								cempBsal.setToolTipText("The employees check after taxes");
							}
							{
								cLabel4 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel4.setText("Adjustments");
								cLabel4.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel4LData = new GridData();
								cLabel4.setLayoutData(cLabel4LData);
								cLabel4
									.setToolTipText("Adjustments made to the base salary");
							}
							{
								cempAsal = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempAsal.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempAsal.setText("cempName");
								cempAsal.setOrientation(SWT.VERTICAL);
								GridData text6LData = new GridData();
								text6LData.horizontalAlignment = GridData.FILL;
								text6LData.verticalAlignment = GridData.FILL;
								text6LData.grabExcessHorizontalSpace = true;
								cempAsal.setLayoutData(text6LData);
								cempAsal.setEditable(false);
								cempAsal.setToolTipText("Adjustments that need to be made because of days where the register was off.");
							}
							{
								cLabel3 = new CLabel(group2, SWT.SHADOW_IN
									| SWT.CENTER
									| SWT.RIGHT
									| SWT.NO_BACKGROUND
									| SWT.NO_FOCUS
									| SWT.EMBEDDED);
								cLabel3.setText("Total Salary");
								cLabel3.setImage(SWTResourceManager
									.getImage("gregKing/buller.gif"));
								GridData cLabel3LData = new GridData();
								cLabel3.setLayoutData(cLabel3LData);
								cLabel3
									.setToolTipText("The employee's final salary");
							}
							{
								cempTsal = new Text(group2, SWT.SINGLE
									| SWT.LEFT
									| SWT.WRAP
									| SWT.H_SCROLL
									| SWT.BORDER);
								cempTsal.setFont(SWTResourceManager.getFont("Tempus Sans ITC",14,0,false,false));
								cempTsal.setText("cempName");
								cempTsal.setOrientation(SWT.VERTICAL);
								GridData text7LData = new GridData();
								text7LData.horizontalAlignment = GridData.FILL;
								text7LData.verticalAlignment = GridData.FILL;
								text7LData.grabExcessHorizontalSpace = true;
								cempTsal.setLayoutData(text7LData);
								cempTsal.setEditable(false);
								cempTsal.setToolTipText("The employee's final salary after all adjustments have been made");
							}
							{
								saveempb = new Button(group2, SWT.PUSH
									| SWT.FLAT
									| SWT.CENTER);
								GridData saveLData = new GridData();
								saveLData.horizontalAlignment = GridData.FILL;
								saveLData.horizontalSpan = 2;
								saveLData.verticalAlignment = GridData.FILL;
								saveLData.grabExcessHorizontalSpace = true;
								saveempb.setLayoutData(saveLData);
								saveempb.setText("Save Employee Info");
								saveempb.setToolTipText("Saves employee information for future use!");
								saveempb.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										button1MouseUp(evt);
									}
								});

							}
						}
						composite1.addFocusListener(new FocusAdapter() {
							public void focusGained(FocusEvent evt) {
								System.out
									.println("composite1.focusGained, event="
										+ evt);
								makeData();
								setEmpData();
							}
						});
					}
				}
				{
					proveTab = new CTabItem(cTabFolderMain, SWT.NONE);
					proveTab.setText("Prove/Show Adjustments");
					proveTab.setToolTipText("This Formats all the output into a nice text document!");
					proveTab.setImage(SWTResourceManager.getImage("gregKing/p.gif"));
					{
						group1 = new Group(cTabFolderMain, SWT.SHADOW_IN
							| SWT.EMBEDDED
							| SWT.H_SCROLL
							| SWT.BORDER);
						GridLayout group1Layout = new GridLayout();
						group1Layout.makeColumnsEqualWidth = true;
						group1.setLayout(group1Layout);
						proveTab.setControl(group1);
						group1.setText("Organized Text Display");
						group1.setToolTipText("Holds the prety text below.");
						{
							outputStyled = new StyledText(group1, SWT.MULTI
								| SWT.FULL_SELECTION
								| SWT.READ_ONLY
								| SWT.V_SCROLL);
							GridData outputStyledLData = new GridData();
							outputStyledLData.grabExcessVerticalSpace = true;
							outputStyledLData.horizontalAlignment = GridData.FILL;
							outputStyledLData.verticalAlignment = GridData.FILL;
							outputStyledLData.grabExcessHorizontalSpace = true;
							outputStyled.setLayoutData(outputStyledLData);
							outputStyled.setText("Basic Text");
						}
					}
				}
				cTabFolderMain.setForeground(SWTResourceManager.getColor(255, 128, 0));
				cTabFolderMain.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						System.out.println("cTabFolderMain.mouseDown, event="
							+ evt);
						makeData();
						setEmpData();
						Shell shell = new Shell();
						Display display = shell.getDisplay();
						outputStyled.setText("");
//						int l[]= new int[50];
//						char c[];
						for(int g = 0; g < db.getNumEmployees();g++)
						{
							int a =outputStyled.getCharCount();
							outputStyled.append("Employee: "+db.getEmployee(g).getName()+"\n");
							int b =outputStyled.getCharCount();
							outputStyled.append(generateSAdjustments(g));
							
							StyleRange styleRange = new StyleRange();
							styleRange.start = a;
							styleRange.length = 9;
							styleRange.fontStyle = SWT.BOLD;
							styleRange.foreground = display.getSystemColor(SWT.COLOR_DARK_RED);
							outputStyled.setStyleRange(styleRange);
							
							styleRange = new StyleRange();
							styleRange.start = a+9;
							styleRange.length = b-a-9;
							styleRange.fontStyle = SWT.BOLD;
							styleRange.foreground = display.getSystemColor(SWT.COLOR_RED);
							outputStyled.setStyleRange(styleRange);
//							c=generateAdjustments(g).toString().toCharArray();
//							String t = (g-1)+"";
//							char tchar =t.charAt(0);
//							l[g]=output1.indexOf(tchar);
//							System.out.println("the length was "+ l[g]);
						}
						//System.out.println("output 1 is "+output1);
						
						//output1 += generateSAdjustments(0);
						
//						int a =0;
//						outputStyled.setText(output1);
//						for(int g = 0; g < 10;g++)
//						{
//							a =l[g];
//							StyleRange styleRange = new StyleRange();
//							styleRange.start = a;
//							styleRange.length = 8;
//							styleRange.fontStyle = SWT.BOLD;
//							styleRange.foreground = display.getSystemColor(SWT.COLOR_RED);
//							outputStyled.setStyleRange(styleRange);
//						}
						
					}
				});
				cTabFolderMain.setSelection(0);
			}
			this.layout();
			rightTop = new JPanel(true);
	    	final Color colr = rightTop.getBackground();
	    	rightTop.setBackground(Color.RED);
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
								adjustment.setText((dayArray[listBox.getSelectedIndex()].getdoff())+"");
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

	        emp1Label = new JLabel("Employee #1");
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
	                		//System.out.println(""+listBox.getSelectedIndex());
	                		try 
	                		{
								dayArray[listBox.getSelectedIndex()].setEmployee(1, db.getEmployee(employeeBox1.getSelectedIndex()));
								dayArray[listBox.getSelectedIndex()].setEmployee(2, db.getEmployee(employeeBox2.getSelectedIndex()));
								dayArray[listBox.getSelectedIndex()].setdoff(Double.valueOf(adjustment.getText()).doubleValue());
								rightTop.setBackground(colr);
							} catch (NumberFormatException e1) 
							{
								JOptionPane.showMessageDialog(hpane, "Error, you must make sure the amount over is a number, do not include \"$\"s");
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
	                		//JOptionPane.showMessageDialog(rightTop, "arg1");
	                		
	                	}
	                	else
	                	{
	                		JOptionPane.showMessageDialog(rightTop, "Please Make Sure you have a day and two employees selected");
	                		//JOptionPane.showMessageDialog("Please Make Sure you have a day and two employees selected");
	                	}
	                }
	            }
	        );
	        saveday.setPreferredSize(new Dimension(200,50));
	        //dayBox = new JComboBox(dayNames);
	               
	        
	        
	        
	        
	        spane = new JScrollPane();
	        spane.getViewport().add( listBox );
	        //spane.setBounds(20, 20, 2000, 499);
	        //spane.setSize(400,400);
	        spane.setMinimumSize(new Dimension(150,300));
	       
	        
	        leftPanel = new JPanel();
	        	leftPanel.setLayout(new BorderLayout());
	        	leftPanel.add(spane,BorderLayout.CENTER);
	        
	        
	        //rightTop.setLayout(new GridLayout(0,1));
	        
	        rightTop.add(emp1Label,BorderLayout.NORTH);
	        rightTop.add(employeeBox1,BorderLayout.CENTER);
	        //rightTop.add(new JLabel(""));
			{
				emp2Label = new JLabel("Employee #2");
				rightTop.add(emp2Label);
			}
			{
				employeeBox2 = new JComboBox(employeeNames);
				rightTop.add(employeeBox2);
			}
	        rightTop.setPreferredSize(new Dimension(110,300));
	        rightTop.setMinimumSize(new Dimension(100,100));
	        
	        rightBottom = new JPanel();
	        rightBottom.setLayout(new BorderLayout());
	        //rightBottom.setLayout(new GridLayout(0,1));
	        rightBottom.add(adjLabel,BorderLayout.NORTH);
	        rightBottom.add(adjustment,BorderLayout.SOUTH);
	        rightBottom.setPreferredSize(new Dimension(100,100));
	        //rightBottom.add(new JLabel("ladfa"));
	        //rightBottom.add(new JLabel("ladfa"));
	               
	        
	        vpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rightTop, rightBottom);
	        
	        
	        hpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, vpane);
	        hpane.setPreferredSize(new Dimension(200,600));
	        //hpane.setPreferedSize(200, 600);
	        //hpane.setSize(dim);
	        page1 = SWT_AWT.new_Frame(awtswt);
	        page1.add(hpane,BorderLayout.CENTER);
	        page1.add(saveday,BorderLayout.PAGE_END);
	        //showGUI();
	        //page1.setSize(dim);
	        //page1.setSize(700,700);
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeTab1()
    {
    	
    }
	public void setEmpData()
    {
		//cempNumber.setText("3");
        cempNumber.setText((viewEmployeeNumber+1)+"");
		//cempNumber.replaceTextRange(0, 1, "Test replacetext");
		//empNumber.setText((viewEmployeeNumber+1)+"");
        cempName.setText(db.getEmployee(viewEmployeeNumber).getName());
        cempEr.setText(db.getEmployee(viewEmployeeNumber).getEmployer());
        cempSex.setText(db.getEmployee(viewEmployeeNumber).getSex());
        cempNotes.setText(db.getEmployee(viewEmployeeNumber).getNotes());
        String tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getBaseSalary());
        cempBsal.setText(tbsal);
        //tbsal = Double.toString(generateAdjustments(viewEmployeeNumber));
        cempAsal.setText(df.format(generateAdjustments(viewEmployeeNumber)));
        //tbsal = Double.toString(db.getEmployee(viewEmployeeNumber).getBaseSalary()+generateAdjustments(viewEmployeeNumber));
        cempTsal.setText(df.format(db.getEmployee(viewEmployeeNumber).getBaseSalary()+generateAdjustments(viewEmployeeNumber)));
        makeData();
        
        
    }
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
	public void writeAccount()
   	{
      try
      {
        //char base[] = baseDir.toCharArray();
        try{
        	File destination = new File("SmoothieData.smoothiedb");
            System.out.println(destination);
           FileOutputStream fos = new FileOutputStream( destination );
        
            s = new ObjectOutputStream(fos);
	            
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
  			File f =new File("SmoothieData.smoothiedb");
  		 			
  			FileOutputStream fos=new FileOutputStream(f);
  			ObjectOutputStream out1 = new ObjectOutputStream(fos);
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
  			File f = new File("SmoothieData.smoothiedb");
  			FileInputStream fs = new FileInputStream(f);
 			ObjectInputStream in1 = new ObjectInputStream(fs);
 			
                           
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
  			
  			
			File target = new File("SmoothieData.smoothiedb");
         	
  			FileInputStream in = new FileInputStream(target);
  			
			ObjectInputStream r = new ObjectInputStream(in);
			//String today = (String)s.readObject();
			//Account account1 = new Account();
			this.db =(SmoothieDataBase)r.readObject();
			//this.db = new SmoothieDataBase();
			r.close();
			in.close();
			r.close();
		}
		catch (Throwable e) 
  		{
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
                writeAccount();
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
				//System.out.println(" "+i+" not found");
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
	  
	  public String generateSAdjustments(int x)
	  	{
	  		double a=0;
	  		String s="";
	  		for(int i=0;i<14;i++)
	  		{
				try 
				{
					System.out.println("dayArray[i].getEmployee(1).getEmpID() is "+dayArray[i].getEmployee(1).getEmpID() +"\n and x is " + x + "\n and i is " + i + "\n\n");
					if(dayArray[i].getEmployee(1).getEmpID()==x)
					{
						if(dayArray[i].getdoff() != 0)
						{
							a+=(dayArray[i].getdoff())/2;
							s+= "worked on day: " +(dayArray[i].getDayNumber()+1)+"\n\tDay closed " + 
								dayArray[i].getdoff() + " Dollars off.\n\tEmployee Check Adjusted :" +
								(dayArray[i].getdoff()/2) + " Dollars for a running total of\n$" +
								a + " Dollars.\n\n";
						}
						else
						{
							a+=(dayArray[i].getdoff())/2;
							s+= "worked on day: " +(dayArray[i].getDayNumber()+1)+" and closed perfectly even\n";
						}
					}
					else
					{
						//System.out.println("EMployee did not wokr "+i);
					}
					
				}
				catch (Exception e)
				{
					//JOptionPane.showConfirmDialog(gregr, "Um, we hit an error here, ok?"+e.printStackTrace());
					//e.printStackTrace();
					//System.out.println(" "+i+" not found");
				} 
				try 
				{
					if(dayArray[i].getEmployee(2).getEmpID()==x)
					{
						if(dayArray[i].getdoff() != 0)
						{
							a+=(dayArray[i].getdoff())/2;
							s+= "worked on day: " +(dayArray[i].getDayNumber()+1)+"\n\tDay closed " + 
								dayArray[i].getdoff() + " Dollars off.\n\tEmployee Check Adjusted :" +
								(dayArray[i].getdoff()/2) + " Dollars for a running total of\n$" +
								a + " Dollars.\n\n";
						}
						else
						{
							a+=(dayArray[i].getdoff())/2;
							s+= "worked on day: " +(dayArray[i].getDayNumber()+1)+" and closed perfectly even\n";
						}
					}
					
				}
				catch (Exception e)
				{
					//JOptionPane.showConfirmDialog(gregr, "Um, we hit an error here, ok?"+e.printStackTrace());
					//e.printStackTrace();
				}
				
	  		}
	  		//System.out.println("The s retruned is "+s);
	  		return s;
	  	}  
	  
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
		//System.setSecurityManager(null);
		df = new DecimalFormat("¤#,##0.00");
        //setSize(600, 670);
       // dim = new Dimension(500,700);
        db            = new SmoothieDataBase();
        for (int i =0;i<50;i++)
		{
			db.setEmployee(i, new Employee("DefaultEmployee: "+(i+1), i, "Linda", "", "", 0.0, 0.0));
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
        
        makeData();
        
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		makeTab1();
	}

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	**/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			//display.getActiveShell().setSize(460, 500);
			Shell shell = new Shell(display);
			@SuppressWarnings("unused")
			GregMainApp inst = new GregMainApp(shell, SWT.ON_TOP | SWT.Activate);
						
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			@SuppressWarnings("unused")
			Rectangle shellBounds = shell.computeTrim(0,0,400,250);
			//This set Size thing works!!!
			shell.setSize(460, 500);
			
			URL iconURL = ClassLoader.getSystemResource("gregKing/s.gif");
		    Image icon = new Image(display, iconURL.openStream());
		    shell.setImage(icon);
		    shell.setText("Greg's Smoothie King Check Adjuster!");
			
			shell.setBackground(SWTResourceManager.getColor(255, 128, 64));
			shell.forceActive();
			
			shell.setEnabled(true);
			shell.setFocus();
			shell.setVisible(true);
			shell.open();
			shell.forceActive();
			shell.setEnabled(true);
			shell.setFocus();
			shell.setVisible(true);
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void button1MouseUp(MouseEvent evt) {
		System.out.println("cleftb.mouseUp, event=" + evt);
		if(evt.getSource()==cleftb)
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
        else if(evt.getSource()==crightb)
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
        else if(evt.getSource()==crightb)
        {
            if(viewEmployeeNumber < db.getNumEmployees())
            {
            	viewEmployeeNumber++;
            	viewEmployeeNumber=db.getNumEmployees();
            }
            //System.out.println("viewempnumber is now"+viewEmployeeNumber);
        }
        else if(evt.getSource()==cremempb)
        {
            db.setNumEmployees(db.getNumEmployees()-1);
            if(viewEmployeeNumber>(db.getNumEmployees()-1))
            {
            	viewEmployeeNumber=db.getNumEmployees()-1;
            }
            //System.out.println("viewempnumber is now"+viewEmployeeNumber);
        }
        else if(evt.getSource()==caddempb)
        {
        	if(db.getNumEmployees() < 50)
        	{
        		db.setNumEmployees(db.getNumEmployees()+1);
        		viewEmployeeNumber=db.getNumEmployees()-1;
        	}
        	else
        	{
        		Display display = Display.getDefault();
    			Shell shell = new Shell(display);
        		MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR |
        				SWT.OK);
        				messageBox.setMessage("This is the maximum number of employees alowed in this version. (50)\nIf you need more, contact Greg Hendrickson at gph052000atutdallas.edu");
        				messageBox.setText("MessageBoxDemo");
        				int response = messageBox.open();
        				System.out.println("Response was " + response);
        		//JOptionPane.showMessageDialog(rightTop, "This is the maximum number of employees alowed in this version, please contact Greg if you need more");
        	}
            //System.out.println("viewempnumber is now"+viewEmployeeNumber);
        }
        if(evt.getSource()==saveempb)
        {
        	
        	
				try {
					db.getEmployee(viewEmployeeNumber).setName(cempName.getText());
					db.getEmployee(viewEmployeeNumber).setEmployer(cempEr.getText());
					db.getEmployee(viewEmployeeNumber).setSex(cempSex.getText());
					db.getEmployee(viewEmployeeNumber).setNotes(cempNotes.getText());

					db.getEmployee(viewEmployeeNumber).setBaseSalary(Double.valueOf(cempBsal.getText()).doubleValue());
				} catch (NumberFormatException e) 
				{
					e.printStackTrace();
			
					Display display = Display.getDefault();
	    			Shell shell = new Shell(display);
	        		MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR |
	        				SWT.OK);
	        				messageBox.setMessage("There is an error in your input\nPlease make sure your base salary is a number.\nMake sure you did not add \"$\"");
	        				messageBox.setText("MessageBoxDemo");
	        				int response = messageBox.open();
	        				System.out.println("Response was " + response);
				}
				
				
            makeData();
            employeeBox1.setModel(new DefaultComboBoxModel(employeeNames));
            employeeBox2.setModel(new DefaultComboBoxModel(employeeNames));
            writeAccount();
            setEmpData();
        }
        
        setEmpData();
        db.getEmployee(viewEmployeeNumber).setName(cempName.getText());
        db.getEmployee(viewEmployeeNumber).setEmployer(cempEr.getText());
        db.getEmployee(viewEmployeeNumber).setSex(cempSex.getText());
        db.getEmployee(viewEmployeeNumber).setNotes(cempNotes.getText());
        db.getEmployee(viewEmployeeNumber).setBaseSalary(Double.valueOf(cempBsal.getText()).doubleValue());
        db.getEmployee(viewEmployeeNumber).setEmpID(viewEmployeeNumber);
        makeData();
        employeeBox1.setModel(new DefaultComboBoxModel(employeeNames));
        employeeBox2.setModel(new DefaultComboBoxModel(employeeNames));
        setEmpData();
	}
	
	
}
