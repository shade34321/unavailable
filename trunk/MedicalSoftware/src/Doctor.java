package MedicalSoftware;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
* This class contains the methods that a doctor will use when on the medical system.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

public class Doctor{

	private Info info;
	private AVL<String, Info> information;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	
	private static Logger myLogger = Logger.getLogger("Doctor");
    
    static {
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        myLogger.addHandler(ch);
        myLogger.setLevel(Level.ALL);
        myLogger.setUseParentHandlers(false);
        
        try {
            FileHandler fh = new FileHandler("Doctor.html");
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
	
	// Constructors
	Doctor(String user, AVL<String, Info> i, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d) {

		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.info = (Info) ((Doctor) Search(user, 1)).getInfo();
		
        myLogger.log(Level.INFO, "Creating new Doctor: " + user);
	}
	
	// Creating a new doctor constructor
	Doctor (Info info) {
		this.information = new AVL<String, Info>();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
		this.doctor = new AVL<String, Doctor>();
		this.info = info;
		
        myLogger.log(Level.INFO, "Creating new Doctor: " + info);
	}
	
	// Patient deleting and creating
	public void createPatient(String name, String password, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday) {
		Info form = new Info(name, password, userName, email, address, state, country, SSN, zip, birthday, 3, false);
		Patient p = new Patient(form);
		this.patient.insert(name, p);
	    p.updateTree(this.patient, this.doctor);
	    
		
		myLogger.log(Level.FINE, "Creating Patient: " + name);
	}
	
	public void deletePatient(String name){
		this.patient.remove(name);
		
		myLogger.log(Level.FINEST, "Removing patient: " + name);
	}
	
	public Patient getPatient(String name){
		myLogger.log(Level.CONFIG, "Returning Patient: " + name);
		
		return patient.find(name);
	}
	
	// Creating, canceling, and finding DoctorOrders
	public void createOrder(String user, int date, int time, String prescrip, String labW, String followUp, String other){
		patient.find(user).addOrders(user, date, time, prescrip, labW, followUp, other);
		
		myLogger.log(Level.FINE, "Creating Doctors Orders");
	}
	
	public void cancelDoctorOrder(int date, int time, String name, String prescrip){
		patient.find(name).deleteOrders(name, date, time, prescrip);
		
		myLogger.log(Level.FINEST, "Canceling Doctors Orders");
	}
	
	public DoctorsOrders getOrders(String name){
		myLogger.log(Level.CONFIG, "Returning Doctors Orders: " + name);
		
		return patient.find(name).getOrders();
	}
	
	// PatientInvoice creating, canceling, and finding methods
	public void createInvoice(String name, String doc, int total, int due, Boolean paid){
		patient.find(name).addInvoice(name, doc, total, due, paid);
		myLogger.log(Level.FINE, "Creating an invoice for: " + name);
	}
	
	public void cancelInvoice(String name, int due){
		patient.find(name).deleteInvoice(due, name);
		myLogger.log(Level.FINEST, "Canceling invoice for: " + name);
	}
	
	public PatientInvoice getInvoice(String name){
		myLogger.log(Level.FINER, "Getting invoice for: " + name);
		
		return patient.find(name).getPatientInvoice();
	}
	
	// TreatmentRecords find method
	public void createTreatmentRecords(String name, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight){
		patient.find(name).addRecords(name, date, time, symptoms, bloodPressure, pulse, temp, height, weight);
		
		myLogger.log(Level.CONFIG, "Creating a treatment record for: " + name);
	}
	
	public void removeTreatmentRecord(String name, int date, int time){
		patient.find(name).deleteRecords(date, time);
		
		myLogger.log(Level.FINE, "Removing treatment for: " + name);
	}
	
	public TreatmentRecords getTreatmentRecords(String name){
		myLogger.log(Level.FINER, "Getting treatment record for: " + name);
		return patient.find(name).getTreatmentRecords();
	}
	
	// Appointment find method for patient, create method for patient, and cancel appointment for patient
	public void createAppt(String user, int date, int time, String doc, String reason){
		patient.find(user).createAppt(date, time, user, doc, reason);
		myLogger.log(Level.CONFIG, "Creating appointment for: " + user);
	}
	
	public void cancelAppt(String user, String doc, int date, int time){
		patient.find(user).cancelAppt(date, time, user, doc);
		myLogger.log(Level.FINE, "Canceling appointment for: " + user);
	}	

	public Appointment findAppt(String user) {
		myLogger.log(Level.FINEST, "Finding appointment for: " + user);
		
		return patient.find(user).getAppt();
	}
	
	// Suspension getter and setter
	public Boolean getSusp(String name) {	
		myLogger.log(Level.FINE, "Getting suspensions for: " + name);
		
		return info.getSusp();
	}

	public void setSusp(String name, Boolean susp) {
		myLogger.log(Level.FINE, "Setting suspensions for: " + name);
		
		info.setSusp(susp);
	}
	
	// Info getter, setter, and find method to 
	public Info getInfo() {
		myLogger.log(Level.FINE, "Getting info");
		
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
		
		myLogger.log(Level.FINE, "Getting info: " + info);
	}
	
	public Info findInfo(String user) {
		myLogger.log(Level.FINE, "Looking up info for: " + user);
		
		return this.information.find(user);
	}
	
	// Search method
	public Object Search(String user, int type) {
		Object ret = null;
		if (type == 1) {
			// Doctor
			ret = doctor.find(user);
		}else if (type == 2) {
			// Nurse
			ret = nurse.find(user);
		}else if (type == 3) {
			//Patient
			ret = patient.find(user);
		}
		
		myLogger.log(Level.FINE, "Searching for: " + user);
		
		return ret;
	}
	
	// Update
	public void update() {
		
		
	}
	
	// Update trees
	public void updateTree(AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, Info> i) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.information = i;
	}
}