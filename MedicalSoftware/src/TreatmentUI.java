import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class TreatmentUI {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtSym;
	private JTextField txtBlood;
	private JTextField txtPulse;
	private JTextField txtTemp;
	private JTextField txtHeight;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatmentUI window = new TreatmentUI();
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
	public TreatmentUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][][][][][][][][][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name:");
		frame.getContentPane().add(lblName, "cell 0 0,alignx trailing");
		
		txtName = new JTextField();
		frame.getContentPane().add(txtName, "cell 1 0,growx");
		txtName.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		frame.getContentPane().add(lblDate, "cell 0 1,alignx trailing");
		
		txtDate = new JTextField();
		frame.getContentPane().add(txtDate, "cell 1 1,growx");
		txtDate.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		frame.getContentPane().add(lblTime, "cell 0 2,alignx trailing");
		
		txtTime = new JTextField();
		frame.getContentPane().add(txtTime, "cell 1 2,growx");
		txtTime.setColumns(10);
		
		JLabel lblSymptoms = new JLabel("Symptoms:");
		frame.getContentPane().add(lblSymptoms, "cell 0 3,alignx trailing");
		
		txtSym = new JTextField();
		frame.getContentPane().add(txtSym, "cell 1 3,growx");
		txtSym.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		frame.getContentPane().add(lblBloodPressure, "cell 0 4,alignx trailing");
		
		txtBlood = new JTextField();
		frame.getContentPane().add(txtBlood, "cell 1 4,growx");
		txtBlood.setColumns(10);
		
		JLabel lblPulse = new JLabel("Pulse:");
		frame.getContentPane().add(lblPulse, "cell 0 5,alignx trailing");
		
		txtPulse = new JTextField();
		frame.getContentPane().add(txtPulse, "cell 1 5,growx");
		txtPulse.setColumns(10);
		
		JLabel lblTemperature = new JLabel("Temperature:");
		frame.getContentPane().add(lblTemperature, "cell 0 6,alignx trailing");
		
		txtTemp = new JTextField();
		frame.getContentPane().add(txtTemp, "cell 1 6,growx");
		txtTemp.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		frame.getContentPane().add(lblHeight, "cell 0 7,alignx trailing");
		
		txtHeight = new JTextField();
		frame.getContentPane().add(txtHeight, "cell 1 7,growx");
		txtHeight.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		frame.getContentPane().add(lblWeight, "cell 0 8,alignx trailing");
		
		txtWeight = new JTextField();
		frame.getContentPane().add(txtWeight, "cell 1 8,growx");
		txtWeight.setColumns(10);
		
		JButton btnCreateRecord = new JButton("Create Record");
		
		frame.getContentPane().add(btnCreateRecord, "cell 12 11");
	}

}
