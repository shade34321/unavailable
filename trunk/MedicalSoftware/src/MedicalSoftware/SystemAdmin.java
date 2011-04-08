package MedicalSoftware;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * SystemAdmin class designed to allow systemAdmin to control certain things in
 * the medical software system.
 * 
 * @author Nathanial Heard
 * 
 */
public class SystemAdmin {
	private AVL<String, Info> information;
	
	private AVL<String, Info> informationName;
	
	private Info info;

	private static Logger myLogger = Logger.getLogger("SystemAdmin");

	static {

		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.ALL);
		ch.setFormatter(new XMLFormatter());
		myLogger.addHandler(ch);
		myLogger.setLevel(Level.ALL);
		myLogger.setUseParentHandlers(false);

		try {
			FileHandler fh = new FileHandler("SystemAdmin.html");
			fh.setFormatter(new MyHtmlFormatter());
			myLogger.addHandler(fh);
		} catch (SecurityException e) {
			myLogger.log(Level.SEVERE,
					"Security Exception creating a file handler", e);
			e.printStackTrace();
		} catch (IOException e) {
			myLogger.log(Level.SEVERE, "IO Exception creating a file handler",
					e);
			e.printStackTrace();
		}

	}

	/**
	 * Constructor for creating a new admin
	 * 
	 * @param info
	 */
	public SystemAdmin(Info info) {
		this.information = new AVL<String, Info>();
		this.informationName = new AVL<String, Info>();
		this.info = info;
		myLogger.log(Level.INFO, "Creating new System Admin: " + info);
	}

	/**
	 * Constructor used for when AVL trees are passed in to be able to search
	 * the system and access system admin's information
	 * 
	 * @param user
	 * @param i
	 * @param p
	 * @param n
	 * @param d
	 * @param sa
	 */
	public SystemAdmin(String user, AVL<String, Info> i,
			AVL<String, Info> inform) {
		this.information = i;
		this.informationName = inform;
		this.info = informationName.find(user);
		myLogger.log(Level.INFO, "Creating new System Admin: " + user);
	}

	/**
	 * Sets suspensions
	 * 
	 * @param user
	 * @param type
	 * @param status
	 */
	public void setSusp(String user, Boolean status) {
		if (informationName.find(user) != null) {
			myLogger.log(Level.CONFIG, "Setting suspension for: " + user);
			information.find(user).setSusp(status);
		} else {
			myLogger.log(Level.CONFIG, "Could not find: " + user);
		}
	}

	/**
	 * Gets suspensions
	 * 
	 * @param user
	 * @param type
	 * @return boolean
	 */
	public boolean isSusp(String user) {
		boolean status;
		myLogger.log(Level.CONFIG, "Getting suspension for: " + user);
		status = informationName.find(user).isSusp();
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
		myLogger.log(Level.FINER, "Creating new user: " + name);
		Info form = new Info(name, password, userName, email, address, state,
				country, SSN, zip, birthday, type, false);
		informationName.insert(name, form);
		information.insert(userName, form);
	}

	/**
	 * Deletes a user
	 * 
	 * @param user
	 * @param type
	 */
	public void deleteUser(String user) {
		if (informationName.find(user) != null){
			myLogger.log(Level.FINEST, "Deleting user: " + user);
			information.remove(informationName.find(user).getUserName());
			informationName.remove(user);
		}
		else{
			myLogger.log(Level.FINEST, "Can't find: " + user);
		}			
	}

	// Info getter, setter, and find method to
	public Info getInfo() {
		myLogger.log(Level.INFO, "Getting info");
		return this.info;
	}

	public void setInfo(Info info) {
		this.info = info;
		myLogger.log(Level.INFO, "Setting info");
	}

	public Info findInfo(String user) {
		myLogger.log(Level.INFO, "Finding info for: " + user);
		return this.informationName.find(user);
	}

	/**
	 * Searches the system for a user
	 * 
	 * @param user
	 * @param type
	 * @return
	 */
	public Info Search(String user) {
		Info ret = null;
		ret = informationName.find(user);
		myLogger.log(Level.INFO, "Searching for: " + user);
		return ret;
	}

	/**
	 * Creates an invoice
	 * 
	 * @param name
	 * @param doc
	 * @param total
	 * @param due
	 * @param paid
	 */
	public void createInvoice(String name, String doc, int total, int due,
			Boolean paid) {
		if (informationName.find(name) != null) {
			informationName.find(name).getInvoice()
					.create(name, doc, total, due, paid);
			myLogger.log(Level.FINE, "Creating an invoice for: " + name);
		} else {
			myLogger.log(Level.FINE, "Could not find " + name);
		}
	}

	/**
	 * Cancels an invoice
	 * 
	 * @param name
	 * @param due
	 */
	public void cancelInvoice(String name, int due) {
		if (informationName.find(name) != null) {
			informationName.find(name).getInvoice().cancel(due, name);
			myLogger.log(Level.FINE, "Deleteing patient invoice for " + name);
		} else {
			myLogger.log(Level.FINE, "Could not find " + name);
		}
	}

	/**
	 * Gets an invoice
	 * 
	 * @param name
	 * @return PatientInvoice
	 */
	public PatientInvoice getInvoice(String name) {
		myLogger.log(Level.FINER, "Getting invoice for: " + name);

		return informationName.find(name).getInvoice();
	}

	/**
	 * Creates a new treatment records
	 * 
	 * @param name
	 * @param date
	 * @param time
	 * @param symptoms
	 * @param bloodPressure
	 * @param pulse
	 * @param temp
	 * @param height
	 * @param weight
	 */
	public void createTreatmentRecords(String name, String doctor, int date,
			int time, String symptoms, int bloodPressure, int pulse, int temp,
			int height, int weight) {
		if (informationName.find(name) != null) {
			informationName
					.find(name)
					.getRecord()
					.create(name, doctor, date, time, symptoms, bloodPressure,
							pulse, temp, height, weight);
			myLogger.log(Level.CONFIG, "Creating a treatment record for: "
					+ name);
		} else {
			myLogger.log(Level.CONFIG, "Could not find " + name);
		}
	}

	/**
	 * Deletes treatment records
	 * 
	 * @param name
	 * @param date
	 * @param time
	 */
	public void removeTreatmentRecord(String name, int date, int time) {
		if (informationName.find(name) != null) {
			informationName.find(name).getRecord().cancel(name, date, time);
			myLogger.log(Level.CONFIG, "Deleting a treatment record for: "
					+ name);
		} else {
			myLogger.log(Level.CONFIG, "Could not find " + name);
		}
	}

	/**
	 * Gets treatment records
	 * 
	 * @param name
	 * @return TreatmentRecords
	 */
	public TreatmentRecords getTreatmentRecords(String name) {
		myLogger.log(Level.FINER, "Getting treatment record for: " + name);
		return informationName.find(name).getRecord();
	}

	/**
	 * Creates an appointment
	 * 
	 * @param user
	 * @param date
	 * @param time
	 * @param doc
	 * @param reason
	 */
	public void createAppt(String user, int date, int time, String doc,
			String reason) {
		Appointment appt = findAppt(user);
		appt.create(date, time, user, doc, reason);
		myLogger.log(Level.INFO, "Creating appointment for: " + user);
	}

	/**
	 * Deletes an appointment
	 * 
	 * @param user
	 * @param doc
	 * @param date
	 * @param time
	 */
	public void cancelAppt(String user, String doc, int date, int time) {
		Appointment appt = findAppt(user);
		appt.cancel(date, time, user, doc);
		myLogger.log(Level.INFO, "Canceling appointment for: " + user);
	}

	/**
	 * Finds an appointment
	 * 
	 * @param user
	 * @return Appointment
	 */
	public Appointment findAppt(String user) {
		myLogger.log(Level.INFO, "Getting appointment for: " + user);
		return informationName.find(user).getAppt();
	}

	// Suspension getter and setter
	public Boolean getSusp() {
		myLogger.log(Level.INFO, "Getting suspensions for: ");
		return info.isSusp();
	}

	public void setSusp(Boolean susp) {
		info.setSusp(susp);
		myLogger.log(Level.INFO, "Setting suspensions for: " + info.getName());
	}


}
