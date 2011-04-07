package MedicalSoftware;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * A class created to access Nurse information create appointments and other such Nurse functions 
 * @author Shade 
 *
 */

public class Nurse {
	private AVL<String, Info> information;
	private AVL<String, Info> informationName;
	private Info info;
	
	private static Logger myLogger = Logger.getLogger("Nurse");
    
    static {
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        myLogger.addHandler(ch);
        myLogger.setLevel(Level.ALL);
        myLogger.setUseParentHandlers(false);
        
        try {
            FileHandler fh = new FileHandler("Nurse.html");
            fh.setFormatter(new MyHtmlFormatter());
            myLogger.addHandler(fh);
        } catch (SecurityException e) {
            myLogger.log(Level.SEVERE, "Security Exception creating a file handler", e);
            e.printStackTrace();
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "IO Exception creating a file handler", e);
            e.printStackTrace();
        } 
        
    }
	
	
	/**
	 * Constructor
	 * 
	 * @param user
	 * @param information
	 * @param nurse
	 * @param doctor
	 * @param patient
	 */
	Nurse(String user, AVL<String, Info> information, AVL<String, Info> informationUser){
		this.information = information;
		this.informationName = informationUser;
		this.info = informationName.find(user);
		myLogger.log(Level.INFO, "Creating new Nurse: " + user);
	}
	
	/**
	 * Constructor
	 * 
	 * @param info
	 */
	Nurse (Info info) {
		this.information = new AVL<String, Info>();
		this.informationName = new AVL<String, Info>();
		this.info = info;
		
		myLogger.log(Level.INFO, "Creating new Nurse: " + info);
	}
	
	
	/**
	 * Creates a new patient
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
	 */
	public void createPatient(String name, String password, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday) {
		Info form = new Info(name, password, userName, email, address, state, country, SSN, zip, birthday, 3, false);
		information.insert(userName, form);
		informationName.insert(name, form);
		
		myLogger.log(Level.FINE, "Creating Patient: " + name);
	}
	
	/**
	 * Deletes a patient
	 * 
	 * @param name
	 */
	public boolean deletePatient(String name){
		boolean status = false;
		String userName = informationName.find(name).getUserName();
		if (informationName.find(name) == null) {
			myLogger.log(Level.CONFIG, "Patient does not exist!.. Or miss typed... " + name);
		} else if (informationName.find(name).getType() == 3) {
			informationName.remove(name);
			information.remove(userName);
			myLogger.log(Level.FINEST, "Removing patient: " + name);
			status = true;
		}
		return status;
	}
	
	/**
	 * Gets a patient
	 * 
	 * @param name
	 * @return Patient
	 */
	public Info getPatient(String name){
		Info temp = null;
		if (informationName.find(name) == null) {
			myLogger.log(Level.CONFIG, "Patient does not exist!.. Or miss typed... " + name);
		} else if (informationName.find(name).getType() == 3) {
			temp = informationName.find(name);
			myLogger.log(Level.CONFIG, "Returning Patient: " + name);
		}
			return temp;
	}

	
	
	/**
	 * Creates new doctors orders
	 * 
	 * @param user
	 * @param date
	 * @param time
	 * @param prescrip
	 * @param labW
	 * @param followUp
	 * @param other
	 */
	public void createOrder(String user, int date, int time, String prescrip, String labW, String followUp, String other){

		if (informationName.find(user) != null) {
			informationName.find(user).getOrders().create(user, date, time, prescrip, labW, followUp, other);
			myLogger.log(Level.FINE, "Creating Doctors Orders");
		} else {
			myLogger.log(Level.FINE, "User did not exist... ");
		}
	}
	
	/**
	 * Cancels doctors orders
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param prescrip
	 */
	public void cancelDoctorOrder(int date, int time, String name, String prescrip){
		
		if (informationName.find(name) != null) {
			informationName.find(name).getOrders().cancel(date, time, name, prescrip);
			myLogger.log(Level.FINE, "Deleting  Doctors Orders");
		} else {
			myLogger.log(Level.FINE, "User did not exist... ");
		}
	}
	
	/**
	 * Gets doctors orders 
	 * 
	 * @param name
	 * @return DoctorsOrders
	 */
	public DoctorsOrders getOrders(String name){
		myLogger.log(Level.CONFIG, "Returning Doctors Orders: " + name);
		return information.find(name).getOrders();
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
	public void createInvoice(String name, String doc, int total, int due, Boolean paid){
		if (informationName.find(name) != null) {
			informationName.find(name).getInvoice().create(name, doc, total, due, paid);
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
	public void cancelInvoice(String name, int due){
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
	public PatientInvoice getInvoice(String name){
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
	public void createTreatmentRecords(String name, String doctor, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight){
		if (informationName.find(name) != null) {
			informationName.find(name).getRecord().create(name, doctor, date, time, symptoms, bloodPressure, pulse, temp, height, weight);
			myLogger.log(Level.CONFIG, "Creating a treatment record for: " + name);
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
	public void removeTreatmentRecord(String name, int date, int time){
		if (informationName.find(name) != null) {
			informationName.find(name).getRecord().cancel(name, date, time);
			myLogger.log(Level.CONFIG, "Deleting a treatment record for: " + name);
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
	public TreatmentRecords getTreatmentRecords(String name){
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
	public void createAppt(String user, int date, int time, String doc, String reason){
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
	public void cancelAppt(String user, String doc, int date, int time){
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
	

	public Boolean getSusp(String name) {
		myLogger.log(Level.INFO, "Getting suspensions for: " + name);
		return info.getSusp();
	}

	public void setSusp(String name, Boolean susp) {
		info.setSusp(susp);
		myLogger.log(Level.INFO, "Setting suspensions for: " + name);
	}
	
	
	public Info getInfo() {
		myLogger.log(Level.INFO, "Getting info");
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
		myLogger.log(Level.INFO, "Setting info: " + info);
	}
	
	public Info findInfo(String user) {
		myLogger.log(Level.INFO, "Getting info for: " + user);
		return this.information.find(user);
	}
	
	
	/**
	 * Update
	 */
	public void update() {
		
	}
}
