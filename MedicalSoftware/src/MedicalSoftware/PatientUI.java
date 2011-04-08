package MedicalSoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientUI extends JFrame {

	private JPanel contentPane;
	
	private JTextField textFieldDate;
	
	private JTextField textFieldTime;
	
	private JTextField textFieldReason;
	
	private JTextField textFieldDesiredDoctor;
	
	private Patient patient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientUI frame = new PatientUI();
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
	public PatientUI() {
		initialize();
	}

	public PatientUI(Patient patient) {
		this();
		this.patient = patient;
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JLabel lblUsername = new JLabel(" username");
		menuBar.add(lblUsername);

		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginUI login = new LoginUI();
			}
		});
		menuBar.add(btnLogout);

		JButton btnRefresh = new JButton("refresh");
		menuBar.add(btnRefresh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);

		JPanel InfoPanel = new JPanel();
		tabbedPane.addTab("Info/History", null, InfoPanel, null);
		GridBagLayout gbl_InfoPanel = new GridBagLayout();
		gbl_InfoPanel.columnWidths = new int[]{211, 0, 10, 0};
		gbl_InfoPanel.rowHeights = new int[]{10, 0, 0};
		gbl_InfoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_InfoPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		InfoPanel.setLayout(gbl_InfoPanel);
		
		JLabel label = new JLabel("Medical History");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		InfoPanel.add(label, gbc_label);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		InfoPanel.add(panel, gbc_panel);
		
		JLabel lblHistory = new JLabel("");
		lblHistory.setText(patient.getInfo().getRecord().getRecords().toString());
		GridBagConstraints gbc_lblHistory = new GridBagConstraints();
		gbc_lblHistory.gridwidth = 3;
		gbc_lblHistory.insets = new Insets(0, 0, 0, 5);
		gbc_lblHistory.gridx = 0;
		gbc_lblHistory.gridy = 1;
		InfoPanel.add(lblHistory, gbc_lblHistory);
		/**
		 * ArrayList<TRecords> records =
		 * (patient.getTreatmentRecords).getRecords();
		 */

		JPanel RequestApptPanel = new JPanel();
		tabbedPane.addTab("Request Appointment", null, RequestApptPanel, null);
		GridBagLayout gbl_RequestApptPanel = new GridBagLayout();
		gbl_RequestApptPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_RequestApptPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_RequestApptPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_RequestApptPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		RequestApptPanel.setLayout(gbl_RequestApptPanel);

		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		RequestApptPanel.add(lblDate, gbc_lblDate);

		textFieldDate = new JTextField();
		GridBagConstraints gbc_textFieldDate = new GridBagConstraints();
		gbc_textFieldDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDate.gridx = 1;
		gbc_textFieldDate.gridy = 0;
		RequestApptPanel.add(textFieldDate, gbc_textFieldDate);
		textFieldDate.setColumns(10);

		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 1;
		RequestApptPanel.add(lblTime, gbc_lblTime);

		textFieldTime = new JTextField();
		GridBagConstraints gbc_textFieldTime = new GridBagConstraints();
		gbc_textFieldTime.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTime.gridx = 1;
		gbc_textFieldTime.gridy = 1;
		RequestApptPanel.add(textFieldTime, gbc_textFieldTime);
		textFieldTime.setColumns(10);

		JLabel lblReason = new JLabel("Reason:");
		GridBagConstraints gbc_lblReason = new GridBagConstraints();
		gbc_lblReason.anchor = GridBagConstraints.EAST;
		gbc_lblReason.insets = new Insets(0, 0, 5, 5);
		gbc_lblReason.gridx = 0;
		gbc_lblReason.gridy = 2;
		RequestApptPanel.add(lblReason, gbc_lblReason);

		textFieldReason = new JTextField();
		GridBagConstraints gbc_textFieldReason = new GridBagConstraints();
		gbc_textFieldReason.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldReason.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldReason.gridx = 1;
		gbc_textFieldReason.gridy = 2;
		RequestApptPanel.add(textFieldReason, gbc_textFieldReason);
		textFieldReason.setColumns(10);

		JLabel lblDesiredDoctor = new JLabel("Desired Doctor:");
		GridBagConstraints gbc_lblDesiredDoctor = new GridBagConstraints();
		gbc_lblDesiredDoctor.anchor = GridBagConstraints.EAST;
		gbc_lblDesiredDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesiredDoctor.gridx = 0;
		gbc_lblDesiredDoctor.gridy = 3;
		RequestApptPanel.add(lblDesiredDoctor, gbc_lblDesiredDoctor);

		textFieldDesiredDoctor = new JTextField();
		GridBagConstraints gbc_textFieldDesiredDoctor = new GridBagConstraints();
		gbc_textFieldDesiredDoctor.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDesiredDoctor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDesiredDoctor.gridx = 1;
		gbc_textFieldDesiredDoctor.gridy = 3;
		RequestApptPanel.add(textFieldDesiredDoctor, gbc_textFieldDesiredDoctor);
		textFieldDesiredDoctor.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int date = Integer.parseInt(textFieldDate.getText());
				int time = Integer.parseInt(textFieldTime.getText());
				String reason = textFieldReason.getText();
				String doc = textFieldDesiredDoctor.getText();
				String name = patient.getInfo().getName();
				Appointment appt = new Appointment();
				appt.create(date, time, name, doc, reason);
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 4;
		RequestApptPanel.add(btnSubmit, gbc_btnSubmit);
	}
}
