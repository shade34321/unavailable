package MedicalSoftware;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/*
 * SystemAdmin class designed to allow systemAdmin to control certain things in the medical software system.
 * @author Nathanial Heard
 * 
 */
public class SystemAdmin {
	private AVL<String, Info> information;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	private AVL<String, SystemAdmin> systemAdmin;
	private Info info;
	
	private static Logger myLogger = Logger.getLogger("SystemAdmin");
    
    static {       
        FileHandler fh = null;
        try {
            fh = new FileHandler("SystemAdmin.log");
        } catch (SecurityException e) {
            myLogger.log(Level.SEVERE, "Security Exception creating the logger file handler", e);
            e.printStackTrace();
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "IO Exception creating the logger file handler", e);
            e.printStackTrace();
        }
		
		 fh.setFilter( new Filter() {
            public boolean isLoggable(LogRecord record) {
                return true;
            }
        });
        myLogger.addHandler(fh);
        myLogger.setLevel(Level.ALL);
    }

	// Constructor for creating a new admin
	SystemAdmin (Info info, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa, AVL<String, Info> i) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.information = i;
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
			SystemAdmin sa = new SystemAdmin(form, this.patient, this.nurse, this.doctor, this.systemAdmin, this.information);
			systemAdmin.insert(name, sa);
		}
		else if (type == 1) {
			// Doctor
			Doctor doc = new Doctor(form, this.patient, this.nurse, this.doctor, this.information);
			doctor.insert(name, doc);
		}else if (type == 2) {
			// Nurse
			Nurse n = new Nurse(form, this.patient, this.nurse, this.doctor, this.information);
			nurse.insert(name, n);
		}else if (type == 3) {
			//Patient
			Patient p = new Patient(form, this.patient, this.doctor);
			patient.insert(name, p);
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
	
	// PatientInvoice creating, canceling, and finding methods
	public void createInvoice(String name, String doc, int total, int due, Boolean paid){
		PatientInvoice invoice = patient.find(name).getPatientInvoice();
		invoice.create(name, doc, total, due, paid);
		myLogger.log(Level.INFO, "Creating invoice for: " + name);
	}
	
	public void cancelInvoice(String name, int due){
		PatientInvoice invoice = patient.find(name).getPatientInvoice();
		invoice.cancel(due, name);
		myLogger.log(Level.INFO, "Canceling invoice for: " + name);
	}
	
	public PatientInvoice getInvoice(String name){
		myLogger.log(Level.INFO, "Getting invoice for: " + name);
		return patient.find(name).getPatientInvoice();
	}
	
	// TreatmentRecords find method
	public void createTreatmentRecords(String name, int date, int time, DoctorsOrders orders, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight){
		TreatmentRecords record = patient.find(name).getTreatmentRecords();
		record.create(name, date, time, orders, symptoms, bloodPressure, pulse, temp, height, weight);
		myLogger.log(Level.INFO, "Creating treatment records for: " + name);
	}
	
	public void removeTreatmentRecord(String name, int date, int time){
		TreatmentRecords tr = patient.find(name).getTreatmentRecords();
		tr.cancel(date, time);
		myLogger.log(Level.INFO, "Deleting treatment records for: " + name);
	}
	
	public TreatmentRecords getTreatmentRecords(String name){
		myLogger.log(Level.INFO, "Getting treatment records for: " + name);
			return patient.find(name).getTreatmentRecords();
	}
	
	// Appointment find method for patient, create method for patient, and cancel appointment for patient
	public void createAppt(String user, int date, int time, String doc, String reason){
		Appointment appt = findAppt(user);
		appt.create(date, time, user, doc, reason);
		myLogger.log(Level.INFO, "Creating appointment for: " + user);
	}
	
	public void cancelAppt(String user, String doc, int date, int time){
		Appointment appt = findAppt(user);
		appt.cancel(date, time, user, doc);
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
}