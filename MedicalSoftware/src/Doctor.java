package MedicalSoftware;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

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
        FileHandler fh = null;
        try {
            fh = new FileHandler("Doctor.log");
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
	
	// Constructors
	Doctor(String user, AVL<String, Info> i, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d) {

		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.info = (Info) ((Doctor) Search(user, 1)).getInfo();
		
        myLogger.log(Level.INFO, "Creating new Doctor: " + user);
	}
	
	Doctor (Info info, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, Info> i) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.information = i;
		this.info = info;
		
        myLogger.log(Level.INFO, "Creating new Doctor: " + info);
	}
	
	// Patient deleting and creating
	public void createPatient(String name, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday) {
		Info form = new Info(name, userName, email, address, state, country, SSN, zip, birthday, 3, false);
		Patient p = new Patient(form, this.patient, this.doctor);
		patient.insert(name, p);
		
		myLogger.log(Level.FINE, "Creating Patient: " + name);
	}
	
	public void deletePatient(String name){
		patient.remove(name);
		
		myLogger.log(Level.FINEST, "Removing patient: " + name);
	}
	
	public Patient getPatient(String name){
		myLogger.log(Level.CONFIG, "Returning Patient: " + name);
		return patient.find(name);
	}
	
	// Creating, canceling, and finding DoctorOrders
	public void createOrder(String user, int date, int time, String prescrip, String labW, String followUp, String other){
		DoctorsOrders order = patient.find(user).getOrders();
		order.create(user, date, time, prescrip, labW, followUp, other);
		myLogger.log(Level.FINE, "Creating Doctors Orders");
	}
	
	public void cancelDoctorOrder(int date, int time, String name, String prescrip){
		DoctorsOrders order = patient.find(name).getOrders();
		order.cancel(date, time, name, prescrip);
		myLogger.log(Level.FINEST, "Canceling Doctors Orders");
	}
	
	public DoctorsOrders getOrders(String name){
		myLogger.log(Level.CONFIG, "Returning Doctors Orders: " + name);
		return patient.find(name).getOrders();
	}
	
	// PatientInvoice creating, canceling, and finding methods
	public void createInvoice(String name, String doc, int total, int due, Boolean paid){
		PatientInvoice invoice = patient.find(name).getPatientInvoice();
		invoice.create(name, doc, total, due, paid);
	}
	
	public void cancelInvoice(String name, int due){
		PatientInvoice invoice = patient.find(name).getPatientInvoice();
		invoice.cancel(due, name);
	}
	
	public PatientInvoice getInvoice(String name){
		return patient.find(name).getPatientInvoice();
	}
	
	// TreatmentRecords find method
	public void createTreatmentRecords(String name, int date, int time, DoctorsOrders orders, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight){
		TreatmentRecords record = patient.find(name).getTreatmentRecords();
		record.create(name, date, time, orders, symptoms, bloodPressure, pulse, temp, height, weight);
	}
	
	public void removeTreatmentRecord(String name, int date, int time){
		TreatmentRecords tr = patient.find(name).getTreatmentRecords();
		tr.cancel(date, time);
	}
	
	public TreatmentRecords getTreatmentRecords(String name){
			return patient.find(name).getTreatmentRecords();
	}
	
	// Appointment find method for patient, create method for patient, and cancel appointment for patient
	public void createAppt(String user, int date, int time, String doc, String reason){
		Appointment appt = findAppt(user);
		appt.create(date, time, user, doc, reason);
	}
	
	public void cancelAppt(String user, String doc, int date, int time){
		Appointment appt = findAppt(user);
		appt.cancel(date, time, user, doc);
	}	

	public Appointment findAppt(String user) {
		return patient.find(user).getAppt();
	}
	
	// Suspension getter and setter
	public Boolean getSusp(String name) {
		return info.getSusp();
	}

	public void setSusp(String name, Boolean susp) {
		info.setSusp(susp);
	}
	
	// Info getter, setter, and find method to 
	public Info getInfo() {
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}
	
	public Info findInfo(String user) {
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
		return ret;
	}
}