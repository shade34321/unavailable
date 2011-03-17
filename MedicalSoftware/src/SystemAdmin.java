package MedicalSoftware;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/*
 * SystemAdmin class designed to allow systemAdmin to control certain things in the medical software system.
 * @author Nathanial Heard
 * 
 */
public class SystemAdmin{
	private AVL<String, Info> information;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	private AVL<String, SystemAdmin> systemAdmin;
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
            myLogger.log(Level.SEVERE, "Security Exception creating a file handler", e);
            e.printStackTrace();
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "IO Exception creating a file handler", e);
            e.printStackTrace();
        } 
        
    }

	// Constructor for creating a new admin
	SystemAdmin (Info info) {
		this.information = new AVL<String, Info>();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
		this.doctor = new AVL<String, Doctor>();
		this.systemAdmin = new AVL<String, SystemAdmin>();
		this.info = info;
		myLogger.log(Level.INFO, "Creating new System Admin: " + info);
	}
	
	// Constructor used for when AVL trees are passed in to be able to search the system and access system admin's information
	SystemAdmin(String user, AVL<String, Info> i, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa) {
		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.info = (Info) ((SystemAdmin) Search(user, 0)).getInfo();
		myLogger.log(Level.INFO, "Creating new System Admin: " + user);
	}
	
	// Suspension getter and setter
	public void setSusp(String user, int type, Boolean status) {
		myLogger.log(Level.CONFIG, "Setting suspension for: " + user);
		if (type ==0) {
			// System Admin
			systemAdmin.find(user).getInfo().setSusp(status);
		}
		else if (type == 1) {
			// Doctor
			doctor.find(user).getInfo().setSusp(status);
		}else if (type == 2) {
			// Nurse
			nurse.find(user).getInfo().setSusp(status);
		}else if (type == 3) {
			//Patient
			patient.find(user).getInfo().setSusp(status);
		}
	}
	
	public boolean getSusp(String user, int type) {
		myLogger.log(Level.CONFIG, "Getting suspension for: " + user);
		boolean status = false;
		if (type ==0) {
			// System Admin
			status = systemAdmin.find(user).getInfo().getSusp();
		}
		else if (type == 1) {
			// Doctor
			status = doctor.find(user).getInfo().getSusp();
		}else if (type == 2) {
			// Nurse
			status = nurse.find(user).getInfo().getSusp();
		}else if (type == 3) {
			//Patient
			status = patient.find(user).getInfo().getSusp();
		}
		return status;
	}
	
	// Creating and deleting users class
	public void createUser(String name, String password, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday, int type) {
		myLogger.log(Level.FINER, "Creating new user: " + name);
		Info form = new Info(name, password, userName, email, address, state, country, SSN, zip, birthday, type, false);
		if (type ==0) {
			// System Admin
			SystemAdmin sa = new SystemAdmin(form);
			systemAdmin.insert(name, sa);
			sa.updateTree(this.patient, this.nurse, this.doctor, this.systemAdmin, this.information);
			
		}
		else if (type == 1) {
			// Doctor
			Doctor doc = new Doctor(form);
			doctor.insert(name, doc);
			doc.updateTree(this.patient, this.nurse, this.doctor, this.information);
			
		}else if (type == 2) {
			// Nurse
			Nurse n = new Nurse(form);
			nurse.insert(name, n);
			n.updateTree(this.patient, this.nurse, this.doctor, this.information);
			
		}else if (type == 3) {
			//Patient
			Patient p = new Patient(form);
			patient.insert(name, p);
				p.updateTree(this.patient, this.doctor);
			
		}
	}
	
	public void deleteUser(String user, int type) {
		myLogger.log(Level.FINEST, "Deleting user: " + user);
		if (type ==0) {
			// System Admin
			systemAdmin.remove(user);
		}
		else if (type == 1) {
			// Doctor
			doctor.remove(user);
		}else if (type == 2) {
			// Nurse
			nurse.remove(user);
		}else if (type == 3) {
			//Patient
			patient.remove(user);
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
		return this.information.find(user);
	}
	
	// Search method
	public Object Search(String user, int type) {
		Object ret = null;
		if (type ==0) {
			// System Admin
			ret = systemAdmin.find(user);
		}else if (type == 1) {
			// Doctor
			ret = doctor.find(user);
		}else if (type == 2) {
			// Nurse
			ret = nurse.find(user);
		}else if (type == 3) {
			//Patient
			ret = patient.find(user);
		}
		myLogger.log(Level.INFO, "Searching for: " + user);
		return ret;
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
		myLogger.log(Level.INFO, "Creating appointment for: " + user);
	}
	
	public void cancelAppt(String user, String doc, int date, int time){
		patient.find(user).cancelAppt(date, time, user, doc);
		myLogger.log(Level.INFO, "Canceling appointment for: " + user);
	}	

	public Appointment findAppt(String user) {
		myLogger.log(Level.INFO, "Finding appointment for: " + user);
		return patient.find(user).getAppt();
	}
	
	// Suspension getter and setter
	public Boolean getSusp(String name) {
		myLogger.log(Level.INFO, "Getting suspensions for: " + name);
		return info.getSusp();
	}

	public void setSusp(String name, Boolean susp) {
		info.setSusp(susp);
		myLogger.log(Level.INFO, "Setting suspensions for: " + name);
	}
	
	// Update
	public void update() {
	}
	
	// Update trees
	public void updateTree(AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa, AVL<String, Info> i) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.information = i;
	}
}
