package MedicalSoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for letting users login to the system
 * 
 * @author Nathan Heard
 * 
 */
public class Login {
	private static int suspended = 0;
	private SystemAdmin systemAdmin;
	private Doctor doc;
	private Nurse nur;
	private Patient person;
	private static AVL<String, Info> information;
	private static AVL<String, Info> informationName;

	/**
	 * Constructor
	 * 
	 * @param informationUserName
	 * @param informationName
	 */
	Login(AVL<String, Info> informationUserName,
			AVL<String, Info> informationName) {
		this.information = informationUserName;
		this.informationName = informationName;
	}

	/**
	 * Runs the UI's and accesses the information needed
	 * 
	 * @throws IOException
	 */
	public void run() throws IOException {
		String userName = "", password = "", input = "";
		// Runs GUIS HERE!!!
		loginUser(userName, password);
	}

	/**
	 * Method for logging in
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginUser(String userName, String password) {

		boolean status = false;

		if (suspended == 3) {
			if (information.find(userName) != null) {
				information.find(userName).setSusp(true);
			}
		} else {

			suspended++;
			if (password.equals(information.find(userName).getPassword())) {
				
				if (information.find(userName).getSusp() != true) {
					status = true;
					suspended = 0;
				}
			}
		}
		return status;
	}

	/**
	 * Creates a new user
	 * 
	 * @param name
	 * @param password
	 * @param userName
	 * @param email
	 * @param address
	 * @param state
	 * @param country
	 * @param SSN
	 * @param zip
	 * @param birthday
	 * @param type
	 */
	public void createUser(String name, String password, String userName,
			String email, String address, String state, String country,
			int SSN, int zip, int birthday, int type) {
		Info form = new Info(name, password, userName, email, address, state,
				country, SSN, zip, birthday, type, false);
		information.insert(userName, form);
		informationName.insert(name, form);
		update(information, informationName);
	}

	private void update(AVL<String, Info> information2,
			AVL<String, Info> informationName2) {
		// TODO Auto-generated method stub

	}
}
