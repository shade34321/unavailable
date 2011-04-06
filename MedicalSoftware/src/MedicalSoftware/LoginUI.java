
import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class LoginUI implements ActionListener{

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField psfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
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
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblUser = new JLabel("User Name:");
		lblUser.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		frame.getContentPane().add(lblUser, "4, 4, right, default");
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		frame.getContentPane().add(txtUser, "8, 4, fill, default");
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		frame.getContentPane().add(lblPass, "4, 10");
		
		psfPass = new JPasswordField();
		frame.getContentPane().add(psfPass, "8, 10, fill, default");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		btnLogin.addActionListener(this);
		frame.getContentPane().add(btnLogin, "4, 14");
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		frame.getContentPane().add(lblStatus, "4, 16, 5, 1");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}