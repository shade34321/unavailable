package MedicalSoftware;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class UserInfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldEmail;
	private JTextField txtFieldAddress;
	private JTextField textFieldState;
	private JTextField textFieldCountry;
	private JTextField textFieldSSN;
	private JTextField textFieldZipCode;
	private JTextField textFieldBirthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserInfoDialog dialog = new UserInfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserInfoDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEmail = new JLabel("Email: ");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 0;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			textFieldEmail = new JTextField();
			GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
			gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEmail.gridx = 1;
			gbc_textFieldEmail.gridy = 0;
			contentPanel.add(textFieldEmail, gbc_textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address: ");
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.anchor = GridBagConstraints.EAST;
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 0;
			gbc_lblAddress.gridy = 1;
			contentPanel.add(lblAddress, gbc_lblAddress);
		}
		{
			txtFieldAddress = new JTextField();
			GridBagConstraints gbc_txtFieldAddress = new GridBagConstraints();
			gbc_txtFieldAddress.insets = new Insets(0, 0, 5, 0);
			gbc_txtFieldAddress.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldAddress.gridx = 1;
			gbc_txtFieldAddress.gridy = 1;
			contentPanel.add(txtFieldAddress, gbc_txtFieldAddress);
			txtFieldAddress.setColumns(10);
		}
		{
			JLabel lblState = new JLabel("State: ");
			GridBagConstraints gbc_lblState = new GridBagConstraints();
			gbc_lblState.anchor = GridBagConstraints.EAST;
			gbc_lblState.insets = new Insets(0, 0, 5, 5);
			gbc_lblState.gridx = 0;
			gbc_lblState.gridy = 2;
			contentPanel.add(lblState, gbc_lblState);
		}
		{
			textFieldState = new JTextField();
			GridBagConstraints gbc_textFieldState = new GridBagConstraints();
			gbc_textFieldState.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldState.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldState.gridx = 1;
			gbc_textFieldState.gridy = 2;
			contentPanel.add(textFieldState, gbc_textFieldState);
			textFieldState.setColumns(10);
		}
		{
			JLabel lblCountry = new JLabel("Country: ");
			GridBagConstraints gbc_lblCountry = new GridBagConstraints();
			gbc_lblCountry.anchor = GridBagConstraints.EAST;
			gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
			gbc_lblCountry.gridx = 0;
			gbc_lblCountry.gridy = 3;
			contentPanel.add(lblCountry, gbc_lblCountry);
		}
		{
			textFieldCountry = new JTextField();
			GridBagConstraints gbc_textFieldCountry = new GridBagConstraints();
			gbc_textFieldCountry.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCountry.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCountry.gridx = 1;
			gbc_textFieldCountry.gridy = 3;
			contentPanel.add(textFieldCountry, gbc_textFieldCountry);
			textFieldCountry.setColumns(10);
		}
		{
			JLabel lblSsn = new JLabel("SSN: ");
			GridBagConstraints gbc_lblSsn = new GridBagConstraints();
			gbc_lblSsn.anchor = GridBagConstraints.EAST;
			gbc_lblSsn.insets = new Insets(0, 0, 5, 5);
			gbc_lblSsn.gridx = 0;
			gbc_lblSsn.gridy = 4;
			contentPanel.add(lblSsn, gbc_lblSsn);
		}
		{
			textFieldSSN = new JTextField();
			GridBagConstraints gbc_textFieldSSN = new GridBagConstraints();
			gbc_textFieldSSN.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldSSN.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSSN.gridx = 1;
			gbc_textFieldSSN.gridy = 4;
			contentPanel.add(textFieldSSN, gbc_textFieldSSN);
			textFieldSSN.setColumns(10);
		}
		{
			JLabel lblZipCode = new JLabel("Zip Code: ");
			GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
			gbc_lblZipCode.anchor = GridBagConstraints.EAST;
			gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
			gbc_lblZipCode.gridx = 0;
			gbc_lblZipCode.gridy = 5;
			contentPanel.add(lblZipCode, gbc_lblZipCode);
		}
		{
			textFieldZipCode = new JTextField();
			GridBagConstraints gbc_textFieldZipCode = new GridBagConstraints();
			gbc_textFieldZipCode.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldZipCode.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldZipCode.gridx = 1;
			gbc_textFieldZipCode.gridy = 5;
			contentPanel.add(textFieldZipCode, gbc_textFieldZipCode);
			textFieldZipCode.setColumns(10);
		}
		{
			JLabel lblBirthday = new JLabel("Birthday: ");
			GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
			gbc_lblBirthday.anchor = GridBagConstraints.EAST;
			gbc_lblBirthday.insets = new Insets(0, 0, 0, 5);
			gbc_lblBirthday.gridx = 0;
			gbc_lblBirthday.gridy = 6;
			contentPanel.add(lblBirthday, gbc_lblBirthday);
		}
		{
			textFieldBirthday = new JTextField();
			GridBagConstraints gbc_textFieldBirthday = new GridBagConstraints();
			gbc_textFieldBirthday.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldBirthday.gridx = 1;
			gbc_textFieldBirthday.gridy = 6;
			contentPanel.add(textFieldBirthday, gbc_textFieldBirthday);
			textFieldBirthday.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
