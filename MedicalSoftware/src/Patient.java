package MedicalSoftware;

/**
 * A class created to access patient information create appointments and other such patient functions 
 * @author Kevin Zhou 
 *
 */

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Patient {
	private Info info;
	private Appointment appt;
	private DoctorsOrders orders;
	private TreatmentRecords record;
	private PatientInvoice invoice;
	private AVL<String, Patient> patient;
	private AVL<String, Doctor> doctor;
	
	private static Logger myLogger = Logger.getLogger("Patient");
    
    static {       
        FileHandler fh = null;
        try {
            fh = new FileHandler("Patient.log");
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
	Patient(Info info, AVL<String, Patient> p, AVL<String, Doctor> d) {		
		this.patient = p;
		this.doctor = d;
		this.info = info;
		this.appt = new Appointment();
		this.record = new TreatmentRecords();
		this.invoice = new PatientInvoice();
		this.orders = new DoctorsOrders();
		myLogger.log(Level.INFO, "Creating new Patient: " + info);
	}
	
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

	// Appointment methods
	public void createAppt(int date, int time, String doctor, String reason) {
		appt = new Appointment();
	}
	
	public Appointment getAppt() {
		return appt;
	}

	public void setAppt(Appointment appt) {
		this.appt = appt;
	}
	
	// TreatmentRecords getter and setter
	public TreatmentRecords getTreatmentRecords() {
		return this.record;
	}

	public void setTreatmentRecords(TreatmentRecords record) {
		this.record = record;
	}
	
	// Searches system for doctors
	public Doctor Search(String user) {
		Doctor ret = doctor.find(user);

		return ret;
	}

	// DoctorsOrders getter and setter
	public void setOrders(DoctorsOrders orders) {
		this.orders = orders;
	}

	public DoctorsOrders getOrders() {
		return orders;
	}
}
