package MedicalSoftware;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class AppointmentUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentUI window = new AppointmentUI();
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
	public AppointmentUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPatient = new JButton("Patient");
		frame.getContentPane().add(btnPatient);
		
		JButton btnAppoint = new JButton("Appointments");
		frame.getContentPane().add(btnAppoint);
		
		JButton btnRefresh = new JButton("Refresh");
		frame.getContentPane().add(btnRefresh);
		
		JButton btnBack = new JButton("back");
		frame.getContentPane().add(btnBack);
	}

}
