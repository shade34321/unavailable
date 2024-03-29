package MedicalSoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DoctorUI extends JFrame {

	private JPanel contentPane;
	
	private JTextField textFieldPrescription;
	
	private JTextField textFieldLabWork;
	
	private JTextField textFieldFollowUp;
	
	private JTextField textFieldOtherIns;
	private JTextField textFieldNameSearch;
	private JTextField textFieldNewPatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorUI frame = new DoctorUI();
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
	public DoctorUI() {
		initialize();
	}

	public DoctorUI(Login log) {
		this();
	}

	private void initialize() {
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

		JPanel patientsTab = new JPanel();
		tabbedPane.addTab("Patients", null, patientsTab, null);
		patientsTab.setLayout(new CardLayout(0, 0));

		JTabbedPane patientsTabPane = new JTabbedPane(JTabbedPane.LEFT);
		patientsTabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		patientsTab.add(patientsTabPane);

		JPanel PersonalInfoPanel = new JPanel();
		patientsTabPane.addTab("Personal Info", null, PersonalInfoPanel, null);
		GridBagLayout gbl_PersonalInfoPanel = new GridBagLayout();
		gbl_PersonalInfoPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_PersonalInfoPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_PersonalInfoPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_PersonalInfoPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		PersonalInfoPanel.setLayout(gbl_PersonalInfoPanel);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		PersonalInfoPanel.add(lblName, gbc_lblName);

		JLabel lblNameInfo = new JLabel("no info");
		GridBagConstraints gbc_lblNameInfo = new GridBagConstraints();
		gbc_lblNameInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameInfo.gridx = 1;
		gbc_lblNameInfo.gridy = 0;
		PersonalInfoPanel.add(lblNameInfo, gbc_lblNameInfo);

		JButton btnNameEdit = new JButton("edit");
		GridBagConstraints gbc_btnNameEdit = new GridBagConstraints();
		gbc_btnNameEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnNameEdit.gridx = 2;
		gbc_btnNameEdit.gridy = 0;
		PersonalInfoPanel.add(btnNameEdit, gbc_btnNameEdit);

		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		PersonalInfoPanel.add(lblAddress, gbc_lblAddress);

		JLabel lblAddressInfo = new JLabel("no info");
		GridBagConstraints gbc_lblAddressInfo = new GridBagConstraints();
		gbc_lblAddressInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddressInfo.gridx = 1;
		gbc_lblAddressInfo.gridy = 1;
		PersonalInfoPanel.add(lblAddressInfo, gbc_lblAddressInfo);

		JButton btnAddressEdit = new JButton("edit");
		GridBagConstraints gbc_btnAddressEdit = new GridBagConstraints();
		gbc_btnAddressEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddressEdit.gridx = 2;
		gbc_btnAddressEdit.gridy = 1;
		PersonalInfoPanel.add(btnAddressEdit, gbc_btnAddressEdit);

		JLabel lblPhone = new JLabel("Phone:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 2;
		PersonalInfoPanel.add(lblPhone, gbc_lblPhone);

		JLabel lblPhoneInfo = new JLabel("no info");
		GridBagConstraints gbc_lblPhoneInfo = new GridBagConstraints();
		gbc_lblPhoneInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneInfo.gridx = 1;
		gbc_lblPhoneInfo.gridy = 2;
		PersonalInfoPanel.add(lblPhoneInfo, gbc_lblPhoneInfo);

		JButton btnPhoneEdit = new JButton("edit");
		GridBagConstraints gbc_btnPhoneEdit = new GridBagConstraints();
		gbc_btnPhoneEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnPhoneEdit.gridx = 2;
		gbc_btnPhoneEdit.gridy = 2;
		PersonalInfoPanel.add(btnPhoneEdit, gbc_btnPhoneEdit);

		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		PersonalInfoPanel.add(lblEmail, gbc_lblEmail);

		JLabel lblEmailInfo = new JLabel("no info");
		GridBagConstraints gbc_lblEmailInfo = new GridBagConstraints();
		gbc_lblEmailInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailInfo.gridx = 1;
		gbc_lblEmailInfo.gridy = 3;
		PersonalInfoPanel.add(lblEmailInfo, gbc_lblEmailInfo);

		JButton btnEmailEdit = new JButton("edit");
		GridBagConstraints gbc_btnEmailEdit = new GridBagConstraints();
		gbc_btnEmailEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmailEdit.gridx = 2;
		gbc_btnEmailEdit.gridy = 3;
		PersonalInfoPanel.add(btnEmailEdit, gbc_btnEmailEdit);

		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 4;
		PersonalInfoPanel.add(lblGender, gbc_lblGender);

		JLabel lblGenderInfo = new JLabel("no info");
		GridBagConstraints gbc_lblGenderInfo = new GridBagConstraints();
		gbc_lblGenderInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenderInfo.gridx = 1;
		gbc_lblGenderInfo.gridy = 4;
		PersonalInfoPanel.add(lblGenderInfo, gbc_lblGenderInfo);

		JButton btnGenderEdit = new JButton("edit");
		GridBagConstraints gbc_btnGenderEdit = new GridBagConstraints();
		gbc_btnGenderEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenderEdit.gridx = 2;
		gbc_btnGenderEdit.gridy = 4;
		PersonalInfoPanel.add(btnGenderEdit, gbc_btnGenderEdit);

		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.insets = new Insets(0, 0, 0, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 5;
		PersonalInfoPanel.add(lblAge, gbc_lblAge);

		JLabel lblAgeInfo = new JLabel("no info");
		GridBagConstraints gbc_lblAgeInfo = new GridBagConstraints();
		gbc_lblAgeInfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblAgeInfo.gridx = 1;
		gbc_lblAgeInfo.gridy = 5;
		PersonalInfoPanel.add(lblAgeInfo, gbc_lblAgeInfo);

		JButton btnAgeEdit = new JButton("edit");
		GridBagConstraints gbc_btnAgeEdit = new GridBagConstraints();
		gbc_btnAgeEdit.gridx = 2;
		gbc_btnAgeEdit.gridy = 5;
		PersonalInfoPanel.add(btnAgeEdit, gbc_btnAgeEdit);

		JPanel MedicalInfoPanel = new JPanel();
		patientsTabPane.addTab("Medical Info", null, MedicalInfoPanel, null);
		GridBagLayout gbl_MedicalInfoPanel = new GridBagLayout();
		gbl_MedicalInfoPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_MedicalInfoPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_MedicalInfoPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_MedicalInfoPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		MedicalInfoPanel.setLayout(gbl_MedicalInfoPanel);

		JLabel lblPharmacy = new JLabel("Pharmacy:");
		GridBagConstraints gbc_lblPharmacy = new GridBagConstraints();
		gbc_lblPharmacy.insets = new Insets(0, 0, 5, 5);
		gbc_lblPharmacy.gridx = 0;
		gbc_lblPharmacy.gridy = 0;
		MedicalInfoPanel.add(lblPharmacy, gbc_lblPharmacy);

		JLabel lblPharmacyInfo = new JLabel("no info");
		GridBagConstraints gbc_lblPharmacyInfo = new GridBagConstraints();
		gbc_lblPharmacyInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPharmacyInfo.gridx = 1;
		gbc_lblPharmacyInfo.gridy = 0;
		MedicalInfoPanel.add(lblPharmacyInfo, gbc_lblPharmacyInfo);

		JButton btnPharmacyEdit = new JButton("edit");
		GridBagConstraints gbc_btnPharmacyEdit = new GridBagConstraints();
		gbc_btnPharmacyEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnPharmacyEdit.gridx = 2;
		gbc_btnPharmacyEdit.gridy = 0;
		MedicalInfoPanel.add(btnPharmacyEdit, gbc_btnPharmacyEdit);

		JLabel lblInsuranceCarrier = new JLabel("Insurance Carrier:");
		GridBagConstraints gbc_lblInsuranceCarrier = new GridBagConstraints();
		gbc_lblInsuranceCarrier.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuranceCarrier.gridx = 0;
		gbc_lblInsuranceCarrier.gridy = 1;
		MedicalInfoPanel.add(lblInsuranceCarrier, gbc_lblInsuranceCarrier);

		JLabel lblInsuranceInfo = new JLabel("no info");
		GridBagConstraints gbc_lblInsuranceInfo = new GridBagConstraints();
		gbc_lblInsuranceInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuranceInfo.gridx = 1;
		gbc_lblInsuranceInfo.gridy = 1;
		MedicalInfoPanel.add(lblInsuranceInfo, gbc_lblInsuranceInfo);

		JButton btnInsuranceEdit = new JButton("edit");
		GridBagConstraints gbc_btnInsuranceEdit = new GridBagConstraints();
		gbc_btnInsuranceEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsuranceEdit.gridx = 2;
		gbc_btnInsuranceEdit.gridy = 1;
		MedicalInfoPanel.add(btnInsuranceEdit, gbc_btnInsuranceEdit);

		JLabel lblAllergies = new JLabel("Allergies:");
		GridBagConstraints gbc_lblAllergies = new GridBagConstraints();
		gbc_lblAllergies.insets = new Insets(0, 0, 0, 5);
		gbc_lblAllergies.gridx = 0;
		gbc_lblAllergies.gridy = 2;
		MedicalInfoPanel.add(lblAllergies, gbc_lblAllergies);

		JLabel lblAllergiesInfo = new JLabel("no info");
		GridBagConstraints gbc_lblAllergiesInfo = new GridBagConstraints();
		gbc_lblAllergiesInfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblAllergiesInfo.gridx = 1;
		gbc_lblAllergiesInfo.gridy = 2;
		MedicalInfoPanel.add(lblAllergiesInfo, gbc_lblAllergiesInfo);

		JButton btnAllergiesEdit = new JButton("edit");
		GridBagConstraints gbc_btnAllergiesEdit = new GridBagConstraints();
		gbc_btnAllergiesEdit.gridx = 2;
		gbc_btnAllergiesEdit.gridy = 2;
		MedicalInfoPanel.add(btnAllergiesEdit, gbc_btnAllergiesEdit);

		JPanel TreatmentRecordsPanel = new JPanel();
		patientsTabPane.addTab("Treatment Records", null, TreatmentRecordsPanel, null);
		GridBagLayout gbl_TreatmentRecordsPanel = new GridBagLayout();
		gbl_TreatmentRecordsPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_TreatmentRecordsPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_TreatmentRecordsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_TreatmentRecordsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		TreatmentRecordsPanel.setLayout(gbl_TreatmentRecordsPanel);

		JButton btnNewTreatmentRecord = new JButton("New");
		GridBagConstraints gbc_btnNewTreatmentRecord = new GridBagConstraints();
		gbc_btnNewTreatmentRecord.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewTreatmentRecord.gridx = 0;
		gbc_btnNewTreatmentRecord.gridy = 0;
		TreatmentRecordsPanel.add(btnNewTreatmentRecord, gbc_btnNewTreatmentRecord);

		JButton btnGetTreatmentRecord = new JButton("Get Treatment Record");
		GridBagConstraints gbc_btnGetTreatmentRecord = new GridBagConstraints();
		gbc_btnGetTreatmentRecord.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTreatmentRecord.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetTreatmentRecord.gridx = 1;
		gbc_btnGetTreatmentRecord.gridy = 0;
		TreatmentRecordsPanel.add(btnGetTreatmentRecord, gbc_btnGetTreatmentRecord);

		JScrollBar scrollBarTreatmentRecords = new JScrollBar();
		GridBagConstraints gbc_scrollBarTreatmentRecords = new GridBagConstraints();
		gbc_scrollBarTreatmentRecords.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBarTreatmentRecords.gridheight = 7;
		gbc_scrollBarTreatmentRecords.gridx = 2;
		gbc_scrollBarTreatmentRecords.gridy = 0;
		TreatmentRecordsPanel.add(scrollBarTreatmentRecords, gbc_scrollBarTreatmentRecords);

		JLabel lblTreatingDoctor = new JLabel("Treating Doctor:");
		GridBagConstraints gbc_lblTreatingDoctor = new GridBagConstraints();
		gbc_lblTreatingDoctor.anchor = GridBagConstraints.WEST;
		gbc_lblTreatingDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreatingDoctor.gridx = 0;
		gbc_lblTreatingDoctor.gridy = 1;
		TreatmentRecordsPanel.add(lblTreatingDoctor, gbc_lblTreatingDoctor);

		JLabel lblTreatingDoctorInfo = new JLabel("select treament record");
		GridBagConstraints gbc_lblTreatingDoctorInfo = new GridBagConstraints();
		gbc_lblTreatingDoctorInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreatingDoctorInfo.gridx = 1;
		gbc_lblTreatingDoctorInfo.gridy = 1;
		TreatmentRecordsPanel.add(lblTreatingDoctorInfo, gbc_lblTreatingDoctorInfo);

		JLabel lblDatetime = new JLabel("Date/Time:");
		GridBagConstraints gbc_lblDatetime = new GridBagConstraints();
		gbc_lblDatetime.anchor = GridBagConstraints.WEST;
		gbc_lblDatetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatetime.gridx = 0;
		gbc_lblDatetime.gridy = 2;
		TreatmentRecordsPanel.add(lblDatetime, gbc_lblDatetime);

		JLabel lblDateTimeInfo = new JLabel("select treatment record");
		GridBagConstraints gbc_lblDateTimeInfo = new GridBagConstraints();
		gbc_lblDateTimeInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateTimeInfo.gridx = 1;
		gbc_lblDateTimeInfo.gridy = 2;
		TreatmentRecordsPanel.add(lblDateTimeInfo, gbc_lblDateTimeInfo);

		JLabel lblAttendingNurse = new JLabel("Attending Nurse:");
		GridBagConstraints gbc_lblAttendingNurse = new GridBagConstraints();
		gbc_lblAttendingNurse.anchor = GridBagConstraints.WEST;
		gbc_lblAttendingNurse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttendingNurse.gridx = 0;
		gbc_lblAttendingNurse.gridy = 3;
		TreatmentRecordsPanel.add(lblAttendingNurse, gbc_lblAttendingNurse);

		JLabel lblAttendingNurseInfo = new JLabel(
				"select treatment record");
		GridBagConstraints gbc_lblAttendingNurseInfo = new GridBagConstraints();
		gbc_lblAttendingNurseInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttendingNurseInfo.gridx = 1;
		gbc_lblAttendingNurseInfo.gridy = 3;
		TreatmentRecordsPanel.add(lblAttendingNurseInfo, gbc_lblAttendingNurseInfo);

		JLabel lblDoctorsOrders = new JLabel("Doctor's Orders:");
		GridBagConstraints gbc_lblDoctorsOrders = new GridBagConstraints();
		gbc_lblDoctorsOrders.anchor = GridBagConstraints.WEST;
		gbc_lblDoctorsOrders.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorsOrders.gridx = 0;
		gbc_lblDoctorsOrders.gridy = 4;
		TreatmentRecordsPanel.add(lblDoctorsOrders, gbc_lblDoctorsOrders);

		JButton btnViewDoctorsOrders = new JButton("view");
		GridBagConstraints gbc_btnViewDoctorsOrders = new GridBagConstraints();
		gbc_btnViewDoctorsOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewDoctorsOrders.gridx = 1;
		gbc_btnViewDoctorsOrders.gridy = 4;
		TreatmentRecordsPanel.add(btnViewDoctorsOrders, gbc_btnViewDoctorsOrders);

		JLabel lblChiefComplaint = new JLabel("Chief Complaint:");
		GridBagConstraints gbc_lblChiefComplaint = new GridBagConstraints();
		gbc_lblChiefComplaint.anchor = GridBagConstraints.WEST;
		gbc_lblChiefComplaint.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiefComplaint.gridx = 0;
		gbc_lblChiefComplaint.gridy = 5;
		TreatmentRecordsPanel.add(lblChiefComplaint, gbc_lblChiefComplaint);

		JLabel lblChiefComplaintInfo = new JLabel(
				"select treatment record");
		GridBagConstraints gbc_lblChiefComplaintInfo = new GridBagConstraints();
		gbc_lblChiefComplaintInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiefComplaintInfo.gridx = 1;
		gbc_lblChiefComplaintInfo.gridy = 5;
		TreatmentRecordsPanel.add(lblChiefComplaintInfo, gbc_lblChiefComplaintInfo);

		JLabel lblVitalSigns = new JLabel("Vital Signs:");
		GridBagConstraints gbc_lblVitalSigns = new GridBagConstraints();
		gbc_lblVitalSigns.anchor = GridBagConstraints.WEST;
		gbc_lblVitalSigns.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitalSigns.gridx = 0;
		gbc_lblVitalSigns.gridy = 6;
		TreatmentRecordsPanel.add(lblVitalSigns, gbc_lblVitalSigns);

		JButton btnViewVitalSigns = new JButton("view");
		GridBagConstraints gbc_btnViewVitalSigns = new GridBagConstraints();
		gbc_btnViewVitalSigns.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewVitalSigns.gridx = 1;
		gbc_btnViewVitalSigns.gridy = 6;
		TreatmentRecordsPanel.add(btnViewVitalSigns, gbc_btnViewVitalSigns);

		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		GridBagConstraints gbc_lblDiagnosis = new GridBagConstraints();
		gbc_lblDiagnosis.anchor = GridBagConstraints.WEST;
		gbc_lblDiagnosis.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiagnosis.gridx = 0;
		gbc_lblDiagnosis.gridy = 7;
		TreatmentRecordsPanel.add(lblDiagnosis, gbc_lblDiagnosis);

		JLabel lblDiagnosisInfo = new JLabel(
				"select treatment record");
		GridBagConstraints gbc_lblDiagnosisInfo = new GridBagConstraints();
		gbc_lblDiagnosisInfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiagnosisInfo.gridx = 1;
		gbc_lblDiagnosisInfo.gridy = 7;
		TreatmentRecordsPanel.add(lblDiagnosisInfo, gbc_lblDiagnosisInfo);

		JPanel DoctorsOrdersPanel = new JPanel();
		patientsTabPane.addTab("Doctor's Orders", null, DoctorsOrdersPanel, null);
		GridBagLayout gbl_DoctorsOrdersPanel = new GridBagLayout();
		gbl_DoctorsOrdersPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_DoctorsOrdersPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_DoctorsOrdersPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_DoctorsOrdersPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		DoctorsOrdersPanel.setLayout(gbl_DoctorsOrdersPanel);

		JLabel lblPrescription = new JLabel("Prescription:");
		GridBagConstraints gbc_lblPrescription = new GridBagConstraints();
		gbc_lblPrescription.anchor = GridBagConstraints.EAST;
		gbc_lblPrescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrescription.gridx = 0;
		gbc_lblPrescription.gridy = 0;
		DoctorsOrdersPanel.add(lblPrescription, gbc_lblPrescription);

		textFieldPrescription = new JTextField();
		GridBagConstraints gbc_textFieldPrescription = new GridBagConstraints();
		gbc_textFieldPrescription.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrescription.gridx = 1;
		gbc_textFieldPrescription.gridy = 0;
		DoctorsOrdersPanel.add(textFieldPrescription, gbc_textFieldPrescription);
		textFieldPrescription.setColumns(10);

		JLabel lblLabWorkPerformed = new JLabel("Lab Work Performed:");
		GridBagConstraints gbc_lblLabWorkPerformed = new GridBagConstraints();
		gbc_lblLabWorkPerformed.anchor = GridBagConstraints.EAST;
		gbc_lblLabWorkPerformed.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabWorkPerformed.gridx = 0;
		gbc_lblLabWorkPerformed.gridy = 1;
		DoctorsOrdersPanel.add(lblLabWorkPerformed, gbc_lblLabWorkPerformed);

		textFieldLabWork = new JTextField();
		GridBagConstraints gbc_textFieldLabWork = new GridBagConstraints();
		gbc_textFieldLabWork.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLabWork.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLabWork.gridx = 1;
		gbc_textFieldLabWork.gridy = 1;
		DoctorsOrdersPanel.add(textFieldLabWork, gbc_textFieldLabWork);
		textFieldLabWork.setColumns(10);

		JLabel lblFollowUpInstructions = new JLabel("Follow Up Instructions:");
		GridBagConstraints gbc_lblFollowUpInstructions = new GridBagConstraints();
		gbc_lblFollowUpInstructions.anchor = GridBagConstraints.EAST;
		gbc_lblFollowUpInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblFollowUpInstructions.gridx = 0;
		gbc_lblFollowUpInstructions.gridy = 2;
		DoctorsOrdersPanel.add(lblFollowUpInstructions, gbc_lblFollowUpInstructions);

		textFieldFollowUp = new JTextField();
		GridBagConstraints gbc_textFieldFollowUp = new GridBagConstraints();
		gbc_textFieldFollowUp.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFollowUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFollowUp.gridx = 1;
		gbc_textFieldFollowUp.gridy = 2;
		DoctorsOrdersPanel.add(textFieldFollowUp, gbc_textFieldFollowUp);
		textFieldFollowUp.setColumns(10);

		JLabel lblOtherInstructions = new JLabel("Other Instructions:");
		GridBagConstraints gbc_lblOtherInstructions = new GridBagConstraints();
		gbc_lblOtherInstructions.anchor = GridBagConstraints.EAST;
		gbc_lblOtherInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtherInstructions.gridx = 0;
		gbc_lblOtherInstructions.gridy = 3;
		DoctorsOrdersPanel.add(lblOtherInstructions, gbc_lblOtherInstructions);

		textFieldOtherIns = new JTextField();
		GridBagConstraints gbc_textFieldOtherIns = new GridBagConstraints();
		gbc_textFieldOtherIns.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldOtherIns.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOtherIns.gridx = 1;
		gbc_textFieldOtherIns.gridy = 3;
		DoctorsOrdersPanel.add(textFieldOtherIns, gbc_textFieldOtherIns);
		textFieldOtherIns.setColumns(10);

		JButton btnCreateDoctorsOrders = new JButton("Create");
		GridBagConstraints gbc_btnCreateDoctorsOrders = new GridBagConstraints();
		gbc_btnCreateDoctorsOrders.gridx = 1;
		gbc_btnCreateDoctorsOrders.gridy = 4;
		DoctorsOrdersPanel.add(btnCreateDoctorsOrders, gbc_btnCreateDoctorsOrders);

		JPanel ReportsPanel = new JPanel();
		patientsTabPane.addTab("Reports", null, ReportsPanel, null);
		GridBagLayout gbl_ReportsPanel = new GridBagLayout();
		gbl_ReportsPanel.columnWidths = new int[] { 0, 0 };
		gbl_ReportsPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_ReportsPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_ReportsPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		ReportsPanel.setLayout(gbl_ReportsPanel);

		JButton btnGetHealthHistory = new JButton("Get Health History");
		GridBagConstraints gbc_btnGetHealthHistory = new GridBagConstraints();
		gbc_btnGetHealthHistory.insets = new Insets(0, 0, 5, 0);
		gbc_btnGetHealthHistory.gridx = 0;
		gbc_btnGetHealthHistory.gridy = 0;
		ReportsPanel.add(btnGetHealthHistory, gbc_btnGetHealthHistory);

		JButton btnPrintIncomeStatement = new JButton("Print Income Statement");
		GridBagConstraints gbc_btnPrintIncomeStatement = new GridBagConstraints();
		gbc_btnPrintIncomeStatement.gridx = 0;
		gbc_btnPrintIncomeStatement.gridy = 1;
		ReportsPanel.add(btnPrintIncomeStatement, gbc_btnPrintIncomeStatement);

		JPanel InvoicesPanel = new JPanel();
		patientsTabPane.addTab("Invoices", null, InvoicesPanel, null);
		GridBagLayout gbl_InvoicesPanel = new GridBagLayout();
		gbl_InvoicesPanel.columnWidths = new int[] { 0, 0 };
		gbl_InvoicesPanel.rowHeights = new int[] { 0, 0 };
		gbl_InvoicesPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_InvoicesPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		InvoicesPanel.setLayout(gbl_InvoicesPanel);

		JLabel lblNotFunctionalYet = new JLabel("not functional yet");
		GridBagConstraints gbc_lblNotFunctionalYet = new GridBagConstraints();
		gbc_lblNotFunctionalYet.gridx = 0;
		gbc_lblNotFunctionalYet.gridy = 0;
		InvoicesPanel.add(lblNotFunctionalYet, gbc_lblNotFunctionalYet);

		JPanel BillingPanel = new JPanel();
		patientsTabPane.addTab("Billing", null, BillingPanel, null);

		JLabel lblNotFunctionalYet_1 = new JLabel("not functional yet");
		BillingPanel.add(lblNotFunctionalYet_1);
		
		JPanel SearchPanel = new JPanel();
		patientsTabPane.addTab("Search", null, SearchPanel, null);
		GridBagLayout gbl_SearchPanel = new GridBagLayout();
		gbl_SearchPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_SearchPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_SearchPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_SearchPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		SearchPanel.setLayout(gbl_SearchPanel);
		
		JLabel lblName_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.anchor = GridBagConstraints.EAST;
		gbc_lblName_1.gridx = 0;
		gbc_lblName_1.gridy = 2;
		SearchPanel.add(lblName_1, gbc_lblName_1);
		
		textFieldNameSearch = new JTextField();
		GridBagConstraints gbc_textFieldNameSearch = new GridBagConstraints();
		gbc_textFieldNameSearch.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNameSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNameSearch.gridx = 1;
		gbc_textFieldNameSearch.gridy = 2;
		SearchPanel.add(textFieldNameSearch, gbc_textFieldNameSearch);
		textFieldNameSearch.setColumns(10);
		
		JList NameList = new JList();
		GridBagConstraints gbc_NameList = new GridBagConstraints();
		gbc_NameList.gridheight = 6;
		gbc_NameList.insets = new Insets(0, 0, 5, 0);
		gbc_NameList.fill = GridBagConstraints.BOTH;
		gbc_NameList.gridx = 2;
		gbc_NameList.gridy = 0;
		SearchPanel.add(NameList, gbc_NameList);
		
		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 3;
		SearchPanel.add(btnSearch, gbc_btnSearch);
		
		JButton btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 6;
		SearchPanel.add(btnSelect, gbc_btnSelect);
		
		JPanel NewPatientPanel = new JPanel();
		patientsTabPane.addTab("New Patient", null, NewPatientPanel, null);
		GridBagLayout gbl_NewPatientPanel = new GridBagLayout();
		gbl_NewPatientPanel.columnWidths = new int[]{0, 0, 0};
		gbl_NewPatientPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_NewPatientPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_NewPatientPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		NewPatientPanel.setLayout(gbl_NewPatientPanel);
		
		JLabel lblNewPatientsName = new JLabel("New Patient's Name: ");
		GridBagConstraints gbc_lblNewPatientsName = new GridBagConstraints();
		gbc_lblNewPatientsName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPatientsName.anchor = GridBagConstraints.EAST;
		gbc_lblNewPatientsName.gridx = 0;
		gbc_lblNewPatientsName.gridy = 2;
		NewPatientPanel.add(lblNewPatientsName, gbc_lblNewPatientsName);
		
		textFieldNewPatient = new JTextField();
		GridBagConstraints gbc_textFieldNewPatient = new GridBagConstraints();
		gbc_textFieldNewPatient.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNewPatient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNewPatient.gridx = 1;
		gbc_textFieldNewPatient.gridy = 2;
		NewPatientPanel.add(textFieldNewPatient, gbc_textFieldNewPatient);
		textFieldNewPatient.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 1;
		gbc_btnCreate.gridy = 3;
		NewPatientPanel.add(btnCreate, gbc_btnCreate);

		JPanel AppointmentsTabPane = new JPanel();
		tabbedPane.addTab("Appointments", null, AppointmentsTabPane, null);
		GridBagLayout gbl_AppointmentsTabPane = new GridBagLayout();
		gbl_AppointmentsTabPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_AppointmentsTabPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_AppointmentsTabPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_AppointmentsTabPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		AppointmentsTabPane.setLayout(gbl_AppointmentsTabPane);

		JButton btnScheduleAppointment = new JButton("Schedule Appointment");
		GridBagConstraints gbc_btnScheduleAppointment = new GridBagConstraints();
		gbc_btnScheduleAppointment.insets = new Insets(0, 0, 5, 0);
		gbc_btnScheduleAppointment.gridx = 1;
		gbc_btnScheduleAppointment.gridy = 0;
		AppointmentsTabPane.add(btnScheduleAppointment, gbc_btnScheduleAppointment);

		JLabel lblAppointments = new JLabel("Appointments:");
		GridBagConstraints gbc_lblAppointments = new GridBagConstraints();
		gbc_lblAppointments.insets = new Insets(0, 0, 0, 5);
		gbc_lblAppointments.gridx = 0;
		gbc_lblAppointments.gridy = 1;
		AppointmentsTabPane.add(lblAppointments, gbc_lblAppointments);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		AppointmentsTabPane.add(scrollPane, gbc_scrollPane);

		JList AppointmentsListField = new JList();
		scrollPane.setViewportView(AppointmentsListField);
	}

}
