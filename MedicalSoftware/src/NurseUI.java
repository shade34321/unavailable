import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class NurseUI {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtPrescription;
	private JTextField txtLabWork;
	private JTextField txtFollowUp;
	private JTextField txtOther;
	private JTextField txtName2;
	private JTextField txtPass;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtState;
	private JTextField txtCountry;
	private JTextField txtZip;
	private JTextField txtSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseUI window = new NurseUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NurseUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel outerPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new FlowLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.RIGHT);
		
		topPanel.add(btnLogOut);
		
		JTabbedPane pane = new JTabbedPane();
		pane.setTabPlacement(JTabbedPane.LEFT);

		JPanel jp0 = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		
		JButton btnDoctor = new JButton("Get Doctors");
		JTextArea txtAdoc = new JTextArea();
		jp0.add(btnDoctor);
		jp0.add(txtAdoc);
		
		JButton btnNurse = new JButton("Get Nurse");
		JTextArea txtAnurse = new JTextArea();
		jp1.add(btnNurse);
		jp1.add(txtAnurse);
		
		JButton btnPatient = new JButton("Get Patients");
		JTextArea txtAPatient = new JTextArea();
		jp2.add(btnPatient);
		jp2.add(txtAPatient);
		
		JLabel lblAppt = new JLabel("Appointments:");
		JTextArea txtAppt = new JTextArea();
		jp3.add(lblAppt);
		jp3.add(txtAppt);
		jp4.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("110px"),
				ColumnSpec.decode("101px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnCreate = new JButton("Create Orders");
		jp4.add(btnCreate, "1, 2");
		
		JLabel lblName = new JLabel("Name:");
		jp4.add(lblName, "2, 2, right, default");
		
		txtName = new JTextField();
		jp4.add(txtName, "4, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		jp4.add(lblDate, "1, 4, right, default");
		
		txtDate = new JTextField();
		jp4.add(txtDate, "2, 4, fill, default");
		txtDate.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		jp4.add(lblTime, "1, 6, right, default");
		
		txtTime = new JTextField();
		jp4.add(txtTime, "2, 6, fill, default");
		txtTime.setColumns(10);
		
		JLabel lblPrescription = new JLabel("Prescription:");
		jp4.add(lblPrescription, "1, 8, right, default");
		
		txtPrescription = new JTextField();
		jp4.add(txtPrescription, "2, 8, 3, 3, fill, default");
		txtPrescription.setColumns(10);
		
		JLabel lblLabWork = new JLabel("Lab Work:");
		jp4.add(lblLabWork, "1, 12, right, bottom");
		
		txtLabWork = new JTextField();
		jp4.add(txtLabWork, "2, 12, 3, 3, fill, default");
		txtLabWork.setColumns(10);
		
		JLabel lblFollowUpInstructions = new JLabel("Follow Up Instructions:");
		jp4.add(lblFollowUpInstructions, "1, 16, right, default");
		
		txtFollowUp = new JTextField();
		jp4.add(txtFollowUp, "2, 16, 3, 3, fill, default");
		txtFollowUp.setColumns(10);
		
		JLabel lblOtherIntructions = new JLabel("Other Intructions");
		jp4.add(lblOtherIntructions, "1, 20, right, default");
		
		txtOther = new JTextField();
		jp4.add(txtOther, "2, 20, 3, 1, fill, default");
		txtOther.setColumns(10);
		
		
		
		JTextField txtname = new JTextField(45);
		JButton btnSearch = new JButton();
		btnSearch.setText("Search");		
		jp6.add(txtname);
		jp6.add(btnSearch);
				
		pane.addTab("Doctors", jp0);
		pane.addTab("Nurses", jp1);
		pane.addTab("Patients", jp2);
		pane.addTab("Appointments", jp3);
		pane.addTab("Create Orders", jp4);
		pane.addTab("Create Patient", jp5);
		jp5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnCreatePatient = new JButton("Create Patient");
		btnCreatePatient.setHorizontalAlignment(SwingConstants.LEFT);
		jp5.add(btnCreatePatient, "2, 2");
		
		JLabel lblName_1 = new JLabel("Name:");
		jp5.add(lblName_1, "2, 4, right, default");
		
		txtName2 = new JTextField();
		jp5.add(txtName2, "4, 4, fill, default");
		txtName2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		jp5.add(lblPassword, "2, 6, right, default");
		
		txtPass = new JTextField();
		jp5.add(txtPass, "4, 6, fill, default");
		txtPass.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username: ");
		jp5.add(lblUsername, "2, 8, right, default");
		
		txtUser = new JTextField();
		jp5.add(txtUser, "4, 8, fill, default");
		txtUser.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		jp5.add(lblEmail, "2, 10, right, default");
		
		txtEmail = new JTextField();
		jp5.add(txtEmail, "4, 10, fill, default");
		txtEmail.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		jp5.add(lblAddress, "2, 12, right, default");
		
		txtAddress = new JTextField();
		jp5.add(txtAddress, "4, 12, fill, default");
		txtAddress.setColumns(10);
		
		JLabel lblState = new JLabel("State: ");
		jp5.add(lblState, "2, 14, right, default");
		
		txtState = new JTextField();
		jp5.add(txtState, "4, 14, fill, default");
		txtState.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country: ");
		jp5.add(lblCountry, "2, 16, right, default");
		
		txtCountry = new JTextField();
		jp5.add(txtCountry, "4, 16, fill, default");
		txtCountry.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		jp5.add(lblZipCode, "2, 18, right, default");
		
		txtZip = new JTextField();
		jp5.add(txtZip, "4, 18, fill, default");
		txtZip.setColumns(10);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number: ");
		jp5.add(lblSocialSecurityNumber, "2, 20, right, default");
		
		txtSSN = new JTextField();
		jp5.add(txtSSN, "4, 20, fill, default");
		txtSSN.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		jp5.add(lblBirthday, "2, 22");
		pane.addTab("Search", jp6);
		

		
		
		centerPanel.add(pane);

		outerPanel.add(topPanel, BorderLayout.NORTH);
		outerPanel.add(centerPanel, BorderLayout.CENTER);
	}

}
