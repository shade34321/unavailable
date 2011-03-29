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
	private Appointment appt;
	private DoctorsOrders orders;
	private TreatmentRecords record;
	private PatientInvoice invoice;
	private AVL<String, Patient> patient;
	private AVL<String, Doctor> doctor;
	
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
		this.patient = new AVL<String, Patient>();
		this.doctor = new AVL<String, Doctor>();
		this.appt = new Appointment();
		this.record = new TreatmentRecords();
		this.invoice = new PatientInvoice();
		this.orders = new DoctorsOrders();
		myLogger.log(Level.INFO, "Creating new Patient: " + info);
	}
	
	/**
	 * Constructor
	 * 
	 * @param user
	 * @param p
	 * @param d
	 */
	Patient(String user, AVL<String, Patient> p, AVL<String, Doctor> d) {		
		this.patient = p;
		this.doctor = d;
		this.info = patient.find(user).getInfo();
		this.appt = patient.find(user).getAppt();
		this.record = patient.find(user).getTreatmentRecords();
		this.invoice = patient.find(user).getPatientInvoice();
		this.orders = patient.find(user).getOrders();
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
		invoice.create(name, doc, total, due, paid);
	}

	/**
	 * Deletes an invoice
	 * 
	 * @param due
	 * @param name
	 */
	public void deleteInvoice(int due, String name) {
		invoice.cancel(due, name);
	}
	
	// Patient Invoice getter and setter
	public PatientInvoice getPatientInvoice() {
		myLogger.log(Level.CONFIG, "Getting Patient Invoice");
		return this.invoice;
	}
	
	public void setPatientInvoice(PatientInvoice invoice) {
		this.invoice = invoice;
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
		appt.create(date, time, name, doctor, reason);
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
		appt.cancel(date, time, user, doc);
		
	}
	
	public Appointment getAppt() {
		myLogger.log(Level.INFO, "Getting appointment: " + info);
		return appt;
	}

	public void setAppt(Appointment appt) {
		this.appt = appt;
		myLogger.log(Level.INFO, "Setting appointment");
	}
	
	// TreatmentRecords getter and setter
	public TreatmentRecords getTreatmentRecords() {
		myLogger.log(Level.INFO, "Getting treatment records");
		return this.record;
	}

	public void setTreatmentRecords(TreatmentRecords record) {
		this.record = record;
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
	public void addRecords(String name, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight) {
		record.create(name, date, time, symptoms, bloodPressure, pulse, temp, height, weight);
	}
	
	/**
	 * Delets treatment records
	 * 
	 * @param date
	 * @param time
	 */
	public void deleteRecords(int date, int time) {
		record.cancel(date, time);
	}
	
	
	/**
	 * Searches the system for a doctor
	 * 
	 * @param user
	 * @return Doctor
	 */
	public Doctor Search(String user) {
		Doctor ret = doctor.find(user);
		myLogger.log(Level.INFO, "Searching for: " + user);

		return ret;
	}

	// DoctorsOrders getter and setter
	public void setOrders(DoctorsOrders orders) {
		this.orders = orders;
		myLogger.log(Level.INFO, "Setting orders");
	}

	public DoctorsOrders getOrders() {
		myLogger.log(Level.INFO, "Getting doctors orders");
		return orders;
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
		orders.create(user, date, time, prescrip, labW, followUp, other);
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
		orders.cancel(date, time, user, prescrip);
	}
	
	
	/**
	 * Update
	 */
	public void update() {
		
	}

	/**
	 * Updating the AVL trees for searching
	 * 
	 * @param patient
	 * @param doctor
	 */
	public void updateTree(AVL<String, Patient> patient, AVL<String, Doctor> doctor) {
		this.patient = patient;
		this.doctor = doctor;
	}

	
}
