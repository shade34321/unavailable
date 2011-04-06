package MedicalSoftware;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;


public class InvoiceUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceUI window = new InvoiceUI();
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
	public InvoiceUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name:");
		frame.getContentPane().add(lblName, "cell 0 0");
		
		JLabel lblPatient = new JLabel("");
		frame.getContentPane().add(lblPatient, "cell 2 0");
		
		JLabel lblDoctor = new JLabel("Doctor:");
		frame.getContentPane().add(lblDoctor, "cell 0 1");
		
		JLabel lblDoc = new JLabel("");
		frame.getContentPane().add(lblDoc, "cell 2 1");
		
		JLabel lblDueDate = new JLabel("Due Date:");
		frame.getContentPane().add(lblDueDate, "cell 0 2");
		
		JLabel lblDate = new JLabel("");
		frame.getContentPane().add(lblDate, "cell 2 2");
		
		JLabel lblTotal = new JLabel("Total:");
		frame.getContentPane().add(lblTotal, "cell 0 8");
		
		JLabel lblTot = new JLabel("");
		frame.getContentPane().add(lblTot, "cell 2 8");
		
		JLabel lblPaid = new JLabel("Paid:");
		frame.getContentPane().add(lblPaid, "cell 0 9,aligny baseline");
		
		JLabel lblDone = new JLabel("");
		frame.getContentPane().add(lblDone, "cell 2 9");
	}

}
