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
	
	private AVL<String, Info> information;
	
	private AVL<String, Info> informationName;

	/**
	 * Constructor
	 * 
	 * @param informationUserName
	 * @param informationName
	 */
	public Login(AVL<String, Info> informationUserName,
			AVL<String, Info> informationName) {
		this.information = informationUserName;
		this.informationName = informationName;
	}
	
	public Login(Login log){

		this.information = log.getInformation();
		this.informationName = log.getInformationName();
	}
	
	public AVL<String,Info> getInformation(){
		return this.information;
	}
	
	public AVL<String,Info> getInformationName(){
		return this.informationName;
	}
	/**
	 * Runs the UI's and accesses the information needed
	 * 
	 * @throws IOException
	 */
	public int run(String user) throws IOException {
		Info inform = information.find(user);
		int temp = -1;
		if (inform.getType() == 0) {
			systemAdmin = new SystemAdmin(inform.getName(), information,
					informationName);
			temp = 0;
		} else if (inform.getType() == 1) {
			doc = new Doctor(inform.getName(), information, informationName);
			temp = 1;
		} else if (inform.getType() == 2) {
			nur = new Nurse(inform.getName(), information, informationName);
			temp = 2;
		} else if (inform.getType() == 3) {
			person = new Patient(inform.getName(), information, informationName);
			temp = 3;
		}
		return temp;
	}

	/**
	 * Method for logging in
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public int loginUser(String userName, String password) {

		int status = 0;

		if (suspended >= 3) {
			if (information.find(userName) != null) {
				information.find(userName).setSusp(true);
				status = -1;
			}
		} else {

			suspended++;
			if (password.equals(information.find(userName).getPassword())) {

				if (information.find(userName).isSusp() != true) {
					status = 1;
					suspended = 0;
				} else {
					status = -1;
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
		//update(information, informationName);
	}
	
	public Patient getPatient() {
		return this.person;
	}

	public Nurse getNurse() {
		return this.nur;
	}

	public Doctor getDoctor() {
		return this.doc;
	}

	public SystemAdmin getAdmin() {
		return this.systemAdmin;
	}
}
