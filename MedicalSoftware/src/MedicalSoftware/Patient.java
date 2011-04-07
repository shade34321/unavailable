package MedicalSoftware;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * A class created to access patient information create appointments and other such patient functions 

 * @author Kevin Zhou 
 *
 */
public class Patient{
	private Info info;
	private AVL<String, Info> information;
	private AVL<String, Info> informationName;
	
	private static Logger myLogger = Logger.getLogger("Patient");
    
    static {
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        myLogger.addHandler(ch);
        myLogger.setLevel(Level.ALL);
        myLogger.setUseParentHandlers(false);
        
        try {
            FileHandler fh = new FileHandler("Patient.html");
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
	 * @param info
	 */
	Patient(Info info) {
		this.info = info;
		this.information = new AVL<String, Info>();
		this.informationName = new AVL<String, Info>();
		myLogger.log(Level.INFO, "Creating new Patient: " + info);
	}
	
	/**
	 * Constructor
	 * 
	 * @param user
	 * @param p
	 * @param d
	 */
	Patient(String user, AVL<String, Info> inform, AVL<String, Info> informName) {		
		this.info = inform.find(user);
		this.information = inform;
		this.informationName = informName;
		myLogger.log(Level.INFO, "Creating new Patient: " + user);
	}
	
	/**
	 * Creates a new invoice
	 * 
	 * @param name
	 * @param doc
	 * @param total
	 * @param due
	 * @param paid
	 */
	public void addInvoice(String name, String doc, int total, int due, Boolean paid) {
		info.getInvoice().create(name, doc, total, due, paid);
	}

	/**
	 * Deletes an invoice
	 * 
	 * @param due
	 * @param name
	 */
	public void deleteInvoice(int due, String name) {
		info.getInvoice().cancel(due, name);
	}
	
	// Patient Invoice getter and setter
	public PatientInvoice getPatientInvoice() {
		myLogger.log(Level.CONFIG, "Getting Patient Invoice");
		return this.info.getInvoice();
	}
	
	public void setPatientInvoice(PatientInvoice invoice) {
		this.info.setInvoice(invoice);
		myLogger.log(Level.FINE, "Setting Patient Invoice: " + invoice);
	}
	
	// Info getter and setter
	public Info getInfo() {
		myLogger.log(Level.CONFIG, "Getting Patient Info");
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
		myLogger.log(Level.FINE, "Setting Patient Info: "+ info);
	}

	
	/**
	 * Creates an appointment
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param doctor
	 * @param reason
	 */
	public void createAppt(int date, int time, String name, String doctor, String reason) {
		myLogger.log(Level.INFO, "Creating appointment");
		info.getAppt().create(date, time, name, doctor, reason);
	}
	
	/**
	 * Deletes an appointment
	 * 
	 * @param date
	 * @param time
	 * @param user
	 * @param doc
	 */
	public void cancelAppt(int date, int time, String user, String doc) {
		info.getAppt().cancel(date, time, user, doc);
		
	}
	
	public Appointment getAppt() {
		myLogger.log(Level.INFO, "Getting appointment: " + info);
		return info.getAppt();
	}

	public void setAppt(Appointment appt) {
		this.info.setAppt(appt);
		myLogger.log(Level.INFO, "Setting appointment");
	}
	
	// TreatmentRecords getter and setter
	public TreatmentRecords getTreatmentRecords() {
		myLogger.log(Level.INFO, "Getting treatment records");
		return this.info.getRecord();
	}

	public void setTreatmentRecords(TreatmentRecords record) {
		this.info.setRecord(record);
		myLogger.log(Level.INFO, "Setting treatment records");
	}
	
	/**
	 * Adds treatment records
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
	public void addRecords(String name, String doctor, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight) {
		info.getRecord().create(name, doctor, date, time, symptoms, bloodPressure, pulse, temp, height, weight);
	}
	
	/**
	 * Deletes treatment records
	 * 
	 * @param date
	 * @param time
	 */
	public void deleteRecords(String name, int date, int time) {
		info.getRecord().cancel(name, date, time);
	}
	
	
	/**
	 * Searches the system for a doctor
	 * 
	 * @param user
	 * @return Doctor
	 */
	public Info Search(String user) {
		myLogger.log(Level.INFO, "Searching for: " + user);

		Info ret;
			if ((ret = informationName.find(user)).getType() == 1){
				return ret;
			} else {
				return null;
			}		
	}

	// DoctorsOrders getter and setter
	public void setOrders(DoctorsOrders orders) {
		this.info.setOrders(orders);
		myLogger.log(Level.INFO, "Setting orders");
	}

	public DoctorsOrders getOrders() {
		myLogger.log(Level.INFO, "Getting doctors orders");
		return info.getOrders();
	}

	/**
	 * Adds a doctors order
	 * 
	 * @param user
	 * @param date
	 * @param time
	 * @param prescrip
	 * @param labW
	 * @param followUp
	 * @param other
	 */
	public void addOrders(String user, int date, int time, String prescrip, String labW, String followUp, String other) {
		info.getOrders().create(user, date, time, prescrip, labW, followUp, other);
	}
	
	/**
	 * Deletes a doctors order
	 * 
	 * @param user
	 * @param date
	 * @param time
	 * @param prescrip
	 */
	public void deleteOrders(String user, int date, int time, String prescrip) {
		info.getOrders().cancel(date, time, user, prescrip);
	}
	
	
	/**
	 * Update
	 */
	public void update() {
		
	}

	
}
