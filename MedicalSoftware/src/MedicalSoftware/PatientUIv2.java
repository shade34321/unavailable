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
import java.util.ArrayList;

import javax.swing.JMenuBar;

import net.miginfocom.swing.MigLayout;


public class PatientUIv2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Patient patient;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientUIv2 invoice = new PatientUIv2();
					invoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the invoice.
	 */
	public PatientUIv2() {
		initialize();
	}
	
	public PatientUIv2(Patient patient){
		this();
		this.patient = patient;
	}
	
	public PatientUIv2(String username, AVL<String, Info> information,
			AVL<String, Info> informationName) {
		patient = new Patient(username, information, informationName);
		initialize();		
		this.setVisible(true);
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
		
		JButton btnRefresh = new JButton("refresh");
		menuBar.add(btnRefresh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Info/History", null, panel, null);
		
		JLabel lblMedicalHistory = new JLabel("Medical History");
		panel.add(lblMedicalHistory);
		/**
		 * ArrayList<TRecords> records = (patient.getTreatmentRecords).getRecords();
		 */
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Request Appointment", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		panel_1.add(lblDate, gbc_lblDate);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 1;
		panel_1.add(lblTime, gbc_lblTime);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason:");
		GridBagConstraints gbc_lblReason = new GridBagConstraints();
		gbc_lblReason.anchor = GridBagConstraints.EAST;
		gbc_lblReason.insets = new Insets(0, 0, 5, 5);
		gbc_lblReason.gridx = 0;
		gbc_lblReason.gridy = 2;
		panel_1.add(lblReason, gbc_lblReason);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDesiredDoctor = new JLabel("Desired Doctor:");
		GridBagConstraints gbc_lblDesiredDoctor = new GridBagConstraints();
		gbc_lblDesiredDoctor.anchor = GridBagConstraints.EAST;
		gbc_lblDesiredDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesiredDoctor.gridx = 0;
		gbc_lblDesiredDoctor.gridy = 3;
		panel_1.add(lblDesiredDoctor, gbc_lblDesiredDoctor);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnRequest = new JButton("Submit");
		GridBagConstraints gbc_btnRequest = new GridBagConstraints();
		gbc_btnRequest.gridx = 1;
		gbc_btnRequest.gridy = 4;
		panel_1.add(btnRequest, gbc_btnRequest);
		
		JPanel invoice = new JPanel();
		tabbedPane.addTab("Invoice", null, invoice, null);

		invoice.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][]"));

		Invoice temp = null;
		if (patient.getInfo().getInvoice() != null) {
			if (patient.getInfo().getInvoice().getInvoice() != null) {
				ArrayList<Invoice> in = patient.getInfo().getInvoice().getInvoice();
				for (int i = 0; i < in.size(); i++) {
						if (in.get(i).isPaid().equals("N/A")) {
							temp = in.get(i);	
							i = in.size();
						}
				}
				
			}
			
		}
		if (temp != null) {
		JLabel lblName = new JLabel("Name:");
		invoice.add(lblName, "cell 0 0");

		JLabel lblPatient = new JLabel(temp.getName());
		invoice.add(lblPatient, "cell 2 0");

		JLabel lblDoctor = new JLabel("Doctor:");
		invoice.add(lblDoctor, "cell 0 1");

		JLabel lblDoc = new JLabel(temp.getDoctor());
		invoice.add(lblDoc, "cell 2 1");

		JLabel lblDueDate = new JLabel("Due Date:");
		invoice.add(lblDueDate, "cell 0 2");

		JLabel lblDate1 = new JLabel(temp.getDueDate() + "");
		invoice.add(lblDate1, "cell 2 2");
		
		JLabel lblTotal = new JLabel("Total");
		invoice.add(lblTotal, "cell 0 3");
		
		JLabel lbltot = new JLabel(temp.getTotal() + "");
		invoice.add(lbltot, "cell 2 3");
		
		JLabel lblPaid = new JLabel("Paid");
		invoice.add(lblPaid, "cell 0 5");
		
		JLabel lblpay = new JLabel(temp.isPaid());
		invoice.add(lblpay, "cell 2 5");
		}
	
	}
}
