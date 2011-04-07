package MedicalSoftware;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class DefaultUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultUI frame = new DefaultUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DefaultUI() {
		initialize();
	}
	
	public DefaultUI(){
		this();
	}
	
	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JLabel lblUsername = new JLabel(" username");
		menuBar.add(lblUsername);
		
		JButton btnLogout = new JButton("logout");
		menuBar.add(btnLogout);
		
		JButton btnRefresh = new JButton("Refresh");
		menuBar.add(btnRefresh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Patients", null, panel, null);
		panel.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.add(tabbedPane_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Personal Info", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel_2.add(lblName, gbc_lblName);
		
		JLabel lblNoInformation = new JLabel("no info");
		GridBagConstraints gbc_lblNoInformation = new GridBagConstraints();
		gbc_lblNoInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInformation.gridx = 1;
		gbc_lblNoInformation.gridy = 0;
		panel_2.add(lblNoInformation, gbc_lblNoInformation);
		
		JButton btnEdit = new JButton("edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 0;
		panel_2.add(btnEdit, gbc_btnEdit);
		
		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		panel_2.add(lblAddress, gbc_lblAddress);
		
		JLabel lblNoInfo = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo = new GridBagConstraints();
		gbc_lblNoInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInfo.gridx = 1;
		gbc_lblNoInfo.gridy = 1;
		panel_2.add(lblNoInfo, gbc_lblNoInfo);
		
		JButton btnEdit_1 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_1 = new GridBagConstraints();
		gbc_btnEdit_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_1.gridx = 2;
		gbc_btnEdit_1.gridy = 1;
		panel_2.add(btnEdit_1, gbc_btnEdit_1);
		
		JLabel lblPhone = new JLabel("Phone:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 2;
		panel_2.add(lblPhone, gbc_lblPhone);
		
		JLabel lblNoInfo_1 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_1 = new GridBagConstraints();
		gbc_lblNoInfo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInfo_1.gridx = 1;
		gbc_lblNoInfo_1.gridy = 2;
		panel_2.add(lblNoInfo_1, gbc_lblNoInfo_1);
		
		JButton btnEdit_2 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_2 = new GridBagConstraints();
		gbc_btnEdit_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_2.gridx = 2;
		gbc_btnEdit_2.gridy = 2;
		panel_2.add(btnEdit_2, gbc_btnEdit_2);
		
		JLabel lblEmail = new JLabel("email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		panel_2.add(lblEmail, gbc_lblEmail);
		
		JLabel lblNoInfo_2 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_2 = new GridBagConstraints();
		gbc_lblNoInfo_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInfo_2.gridx = 1;
		gbc_lblNoInfo_2.gridy = 3;
		panel_2.add(lblNoInfo_2, gbc_lblNoInfo_2);
		
		JButton btnEdit_3 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_3 = new GridBagConstraints();
		gbc_btnEdit_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_3.gridx = 2;
		gbc_btnEdit_3.gridy = 3;
		panel_2.add(btnEdit_3, gbc_btnEdit_3);
		
		JLabel lblGender = new JLabel("gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 4;
		panel_2.add(lblGender, gbc_lblGender);
		
		JLabel lblNoInfo_3 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_3 = new GridBagConstraints();
		gbc_lblNoInfo_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInfo_3.gridx = 1;
		gbc_lblNoInfo_3.gridy = 4;
		panel_2.add(lblNoInfo_3, gbc_lblNoInfo_3);
		
		JButton btnEdit_4 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_4 = new GridBagConstraints();
		gbc_btnEdit_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_4.gridx = 2;
		gbc_btnEdit_4.gridy = 4;
		panel_2.add(btnEdit_4, gbc_btnEdit_4);
		
		JLabel lblAge = new JLabel("age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.insets = new Insets(0, 0, 0, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 5;
		panel_2.add(lblAge, gbc_lblAge);
		
		JLabel lblNoInfo_4 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_4 = new GridBagConstraints();
		gbc_lblNoInfo_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNoInfo_4.gridx = 1;
		gbc_lblNoInfo_4.gridy = 5;
		panel_2.add(lblNoInfo_4, gbc_lblNoInfo_4);
		
		JButton btnEdit_5 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_5 = new GridBagConstraints();
		gbc_btnEdit_5.gridx = 2;
		gbc_btnEdit_5.gridy = 5;
		panel_2.add(btnEdit_5, gbc_btnEdit_5);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("Medical Info", null, panel_9, null);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblPharmacy = new JLabel("Pharmacy:");
		GridBagConstraints gbc_lblPharmacy = new GridBagConstraints();
		gbc_lblPharmacy.insets = new Insets(0, 0, 5, 5);
		gbc_lblPharmacy.gridx = 0;
		gbc_lblPharmacy.gridy = 0;
		panel_9.add(lblPharmacy, gbc_lblPharmacy);
		
		JLabel lblNoInformation_1 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInformation_1 = new GridBagConstraints();
		gbc_lblNoInformation_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInformation_1.gridx = 1;
		gbc_lblNoInformation_1.gridy = 0;
		panel_9.add(lblNoInformation_1, gbc_lblNoInformation_1);
		
		JButton btnEdit_6 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_6 = new GridBagConstraints();
		gbc_btnEdit_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_6.gridx = 2;
		gbc_btnEdit_6.gridy = 0;
		panel_9.add(btnEdit_6, gbc_btnEdit_6);
		
		JLabel lblInsuranceCarrier = new JLabel("Insurance Carrier:");
		GridBagConstraints gbc_lblInsuranceCarrier = new GridBagConstraints();
		gbc_lblInsuranceCarrier.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuranceCarrier.gridx = 0;
		gbc_lblInsuranceCarrier.gridy = 1;
		panel_9.add(lblInsuranceCarrier, gbc_lblInsuranceCarrier);
		
		JLabel lblNoInfo_5 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_5 = new GridBagConstraints();
		gbc_lblNoInfo_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoInfo_5.gridx = 1;
		gbc_lblNoInfo_5.gridy = 1;
		panel_9.add(lblNoInfo_5, gbc_lblNoInfo_5);
		
		JButton btnEdit_7 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_7 = new GridBagConstraints();
		gbc_btnEdit_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit_7.gridx = 2;
		gbc_btnEdit_7.gridy = 1;
		panel_9.add(btnEdit_7, gbc_btnEdit_7);
		
		JLabel lblAllergies = new JLabel("Allergies:");
		GridBagConstraints gbc_lblAllergies = new GridBagConstraints();
		gbc_lblAllergies.insets = new Insets(0, 0, 0, 5);
		gbc_lblAllergies.gridx = 0;
		gbc_lblAllergies.gridy = 2;
		panel_9.add(lblAllergies, gbc_lblAllergies);
		
		JLabel lblNoInfo_6 = new JLabel("no info");
		GridBagConstraints gbc_lblNoInfo_6 = new GridBagConstraints();
		gbc_lblNoInfo_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNoInfo_6.gridx = 1;
		gbc_lblNoInfo_6.gridy = 2;
		panel_9.add(lblNoInfo_6, gbc_lblNoInfo_6);
		
		JButton btnEdit_8 = new JButton("edit");
		GridBagConstraints gbc_btnEdit_8 = new GridBagConstraints();
		gbc_btnEdit_8.gridx = 2;
		gbc_btnEdit_8.gridy = 2;
		panel_9.add(btnEdit_8, gbc_btnEdit_8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Treatment Records", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNew = new JButton("New");
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 0;
		gbc_btnNew.gridy = 0;
		panel_3.add(btnNew, gbc_btnNew);
		
		JButton btnGetTreatmentRecord = new JButton("Get Treatment Record");
		GridBagConstraints gbc_btnGetTreatmentRecord = new GridBagConstraints();
		gbc_btnGetTreatmentRecord.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTreatmentRecord.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetTreatmentRecord.gridx = 1;
		gbc_btnGetTreatmentRecord.gridy = 0;
		panel_3.add(btnGetTreatmentRecord, gbc_btnGetTreatmentRecord);
		
		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBar.gridheight = 7;
		gbc_scrollBar.gridx = 2;
		gbc_scrollBar.gridy = 0;
		panel_3.add(scrollBar, gbc_scrollBar);
		
		JLabel lblTreatingDoctor = new JLabel("Treating Doctor:");
		GridBagConstraints gbc_lblTreatingDoctor = new GridBagConstraints();
		gbc_lblTreatingDoctor.anchor = GridBagConstraints.WEST;
		gbc_lblTreatingDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreatingDoctor.gridx = 0;
		gbc_lblTreatingDoctor.gridy = 1;
		panel_3.add(lblTreatingDoctor, gbc_lblTreatingDoctor);
		
		JLabel lblSelectTreamentRecord = new JLabel("select treament record");
		GridBagConstraints gbc_lblSelectTreamentRecord = new GridBagConstraints();
		gbc_lblSelectTreamentRecord.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectTreamentRecord.gridx = 1;
		gbc_lblSelectTreamentRecord.gridy = 1;
		panel_3.add(lblSelectTreamentRecord, gbc_lblSelectTreamentRecord);
		
		JLabel lblDatetime = new JLabel("Date/Time:");
		GridBagConstraints gbc_lblDatetime = new GridBagConstraints();
		gbc_lblDatetime.anchor = GridBagConstraints.WEST;
		gbc_lblDatetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatetime.gridx = 0;
		gbc_lblDatetime.gridy = 2;
		panel_3.add(lblDatetime, gbc_lblDatetime);
		
		JLabel lblSelectTreatmentRecord = new JLabel("select treatment record");
		GridBagConstraints gbc_lblSelectTreatmentRecord = new GridBagConstraints();
		gbc_lblSelectTreatmentRecord.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectTreatmentRecord.gridx = 1;
		gbc_lblSelectTreatmentRecord.gridy = 2;
		panel_3.add(lblSelectTreatmentRecord, gbc_lblSelectTreatmentRecord);
		
		JLabel lblAttendingNurse = new JLabel("Attending Nurse:");
		GridBagConstraints gbc_lblAttendingNurse = new GridBagConstraints();
		gbc_lblAttendingNurse.anchor = GridBagConstraints.WEST;
		gbc_lblAttendingNurse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttendingNurse.gridx = 0;
		gbc_lblAttendingNurse.gridy = 3;
		panel_3.add(lblAttendingNurse, gbc_lblAttendingNurse);
		
		JLabel lblSelectTreatmentRecord_1 = new JLabel("select treatment record");
		GridBagConstraints gbc_lblSelectTreatmentRecord_1 = new GridBagConstraints();
		gbc_lblSelectTreatmentRecord_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectTreatmentRecord_1.gridx = 1;
		gbc_lblSelectTreatmentRecord_1.gridy = 3;
		panel_3.add(lblSelectTreatmentRecord_1, gbc_lblSelectTreatmentRecord_1);
		
		JLabel lblDoctorsOrders = new JLabel("Doctor's Orders:");
		GridBagConstraints gbc_lblDoctorsOrders = new GridBagConstraints();
		gbc_lblDoctorsOrders.anchor = GridBagConstraints.WEST;
		gbc_lblDoctorsOrders.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorsOrders.gridx = 0;
		gbc_lblDoctorsOrders.gridy = 4;
		panel_3.add(lblDoctorsOrders, gbc_lblDoctorsOrders);
		
		JButton btnView = new JButton("view");
		GridBagConstraints gbc_btnView = new GridBagConstraints();
		gbc_btnView.insets = new Insets(0, 0, 5, 5);
		gbc_btnView.gridx = 1;
		gbc_btnView.gridy = 4;
		panel_3.add(btnView, gbc_btnView);
		
		JLabel lblChiefComplaint = new JLabel("Chief Complaint:");
		GridBagConstraints gbc_lblChiefComplaint = new GridBagConstraints();
		gbc_lblChiefComplaint.anchor = GridBagConstraints.WEST;
		gbc_lblChiefComplaint.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiefComplaint.gridx = 0;
		gbc_lblChiefComplaint.gridy = 5;
		panel_3.add(lblChiefComplaint, gbc_lblChiefComplaint);
		
		JLabel lblSelectTreatmentRecord_2 = new JLabel("select treatment record");
		GridBagConstraints gbc_lblSelectTreatmentRecord_2 = new GridBagConstraints();
		gbc_lblSelectTreatmentRecord_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectTreatmentRecord_2.gridx = 1;
		gbc_lblSelectTreatmentRecord_2.gridy = 5;
		panel_3.add(lblSelectTreatmentRecord_2, gbc_lblSelectTreatmentRecord_2);
		
		JLabel lblVitalSigns = new JLabel("Vital Signs:");
		GridBagConstraints gbc_lblVitalSigns = new GridBagConstraints();
		gbc_lblVitalSigns.anchor = GridBagConstraints.WEST;
		gbc_lblVitalSigns.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitalSigns.gridx = 0;
		gbc_lblVitalSigns.gridy = 6;
		panel_3.add(lblVitalSigns, gbc_lblVitalSigns);
		
		JButton btnView_1 = new JButton("view");
		GridBagConstraints gbc_btnView_1 = new GridBagConstraints();
		gbc_btnView_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnView_1.gridx = 1;
		gbc_btnView_1.gridy = 6;
		panel_3.add(btnView_1, gbc_btnView_1);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		GridBagConstraints gbc_lblDiagnosis = new GridBagConstraints();
		gbc_lblDiagnosis.anchor = GridBagConstraints.WEST;
		gbc_lblDiagnosis.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiagnosis.gridx = 0;
		gbc_lblDiagnosis.gridy = 7;
		panel_3.add(lblDiagnosis, gbc_lblDiagnosis);
		
		JLabel lblSelectTreatmentRecord_3 = new JLabel("select treatment record");
		GridBagConstraints gbc_lblSelectTreatmentRecord_3 = new GridBagConstraints();
		gbc_lblSelectTreatmentRecord_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelectTreatmentRecord_3.gridx = 1;
		gbc_lblSelectTreatmentRecord_3.gridy = 7;
		panel_3.add(lblSelectTreatmentRecord_3, gbc_lblSelectTreatmentRecord_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Doctor's Orders", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblPrescription = new JLabel("Prescription:");
		GridBagConstraints gbc_lblPrescription = new GridBagConstraints();
		gbc_lblPrescription.anchor = GridBagConstraints.EAST;
		gbc_lblPrescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrescription.gridx = 0;
		gbc_lblPrescription.gridy = 0;
		panel_4.add(lblPrescription, gbc_lblPrescription);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblLabWorkPerformed = new JLabel("Lab Work Performed:");
		GridBagConstraints gbc_lblLabWorkPerformed = new GridBagConstraints();
		gbc_lblLabWorkPerformed.anchor = GridBagConstraints.EAST;
		gbc_lblLabWorkPerformed.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabWorkPerformed.gridx = 0;
		gbc_lblLabWorkPerformed.gridy = 1;
		panel_4.add(lblLabWorkPerformed, gbc_lblLabWorkPerformed);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFollowUpInstructions = new JLabel("Follow Up Instructions:");
		GridBagConstraints gbc_lblFollowUpInstructions = new GridBagConstraints();
		gbc_lblFollowUpInstructions.anchor = GridBagConstraints.EAST;
		gbc_lblFollowUpInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblFollowUpInstructions.gridx = 0;
		gbc_lblFollowUpInstructions.gridy = 2;
		panel_4.add(lblFollowUpInstructions, gbc_lblFollowUpInstructions);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_4.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOtherInstructions = new JLabel("Other Instructions:");
		GridBagConstraints gbc_lblOtherInstructions = new GridBagConstraints();
		gbc_lblOtherInstructions.anchor = GridBagConstraints.EAST;
		gbc_lblOtherInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtherInstructions.gridx = 0;
		gbc_lblOtherInstructions.gridy = 3;
		panel_4.add(lblOtherInstructions, gbc_lblOtherInstructions);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_4.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 1;
		gbc_btnCreate.gridy = 4;
		panel_4.add(btnCreate, gbc_btnCreate);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Reports", null, panel_5, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton btnGetHealthHistory = new JButton("Get Health History");
		GridBagConstraints gbc_btnGetHealthHistory = new GridBagConstraints();
		gbc_btnGetHealthHistory.insets = new Insets(0, 0, 5, 0);
		gbc_btnGetHealthHistory.gridx = 0;
		gbc_btnGetHealthHistory.gridy = 0;
		panel_5.add(btnGetHealthHistory, gbc_btnGetHealthHistory);
		
		JButton btnPrintIncomeStatement = new JButton("Print Income Statement");
		GridBagConstraints gbc_btnPrintIncomeStatement = new GridBagConstraints();
		gbc_btnPrintIncomeStatement.gridx = 0;
		gbc_btnPrintIncomeStatement.gridy = 1;
		panel_5.add(btnPrintIncomeStatement, gbc_btnPrintIncomeStatement);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Invoices", null, panel_6, null);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNotFunctionalYet = new JLabel("not functional yet");
		GridBagConstraints gbc_lblNotFunctionalYet = new GridBagConstraints();
		gbc_lblNotFunctionalYet.gridx = 0;
		gbc_lblNotFunctionalYet.gridy = 0;
		panel_6.add(lblNotFunctionalYet, gbc_lblNotFunctionalYet);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Billing", null, panel_7, null);
		
		JLabel lblNotFunctionalYet_1 = new JLabel("not functional yet");
		panel_7.add(lblNotFunctionalYet_1);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Search", null, panel_8, null);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblName_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.anchor = GridBagConstraints.EAST;
		gbc_lblName_1.gridx = 0;
		gbc_lblName_1.gridy = 0;
		panel_8.add(lblName_1, gbc_lblName_1);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 0;
		panel_8.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 0;
		panel_8.add(list, gbc_list);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		GridBagConstraints gbc_lblPatientId = new GridBagConstraints();
		gbc_lblPatientId.anchor = GridBagConstraints.EAST;
		gbc_lblPatientId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientId.gridx = 0;
		gbc_lblPatientId.gridy = 1;
		panel_8.add(lblPatientId, gbc_lblPatientId);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 1;
		panel_8.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_8.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Appointments", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnScheduleAppointment = new JButton("Schedule Appointment");
		GridBagConstraints gbc_btnScheduleAppointment = new GridBagConstraints();
		gbc_btnScheduleAppointment.insets = new Insets(0, 0, 5, 0);
		gbc_btnScheduleAppointment.gridx = 1;
		gbc_btnScheduleAppointment.gridy = 0;
		panel_1.add(btnScheduleAppointment, gbc_btnScheduleAppointment);
		
		JLabel lblAppointments = new JLabel("Appointments:");
		GridBagConstraints gbc_lblAppointments = new GridBagConstraints();
		gbc_lblAppointments.insets = new Insets(0, 0, 0, 5);
		gbc_lblAppointments.gridx = 0;
		gbc_lblAppointments.gridy = 1;
		panel_1.add(lblAppointments, gbc_lblAppointments);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
	}

}
