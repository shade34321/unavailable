package MedicalSoftware;

/**
 * A class created to access Nurse information create appointments and other such Nurse functions 
 * @author Shade 
 *
 */

public class Nurse{
	private AVL<String, Info> information;
	private AVL<String, Report> report;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	private AVL<String, TreatmentRecords> record;
	private Info info;
	private String input;
	
	// Constructor
	Nurse(String user, AVL<String, Info> information, AVL<String, Report> report, AVL<String, Nurse> nurse, AVL<String, Doctor> doctor, AVL<String, Patient> patient, AVL<String, TreatmentRecords> record){
		this.information = information;
		this.report = report;
		this.patient = patient;
		this.nurse = nurse;
		this.doctor = doctor;
		this.record = record;
		this.info = nurse.find(user).getInfo();		
	}
	
	Nurse (Info info, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, Info> i, AVL<String, Report> r) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.information = i;
		this.report = r;
		this.info = info;
	}
	
	private Report getReport(String name){
		return this.report.find(name).getReport();
		//update GUI
	}
	
	// Patient deleting and creating
	public void deletePatient(String name){
		patient.remove(name);
	}
	
	public Patient viewPatient(String name){
		return patient.find(name);
	}
	
	public void createPatient(String name, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday) {
		Info form = new Info(name, userName, email, address, state, country, SSN, zip, birthday, 3, false);
		Patient p = new Patient(form, this.patient, this.doctor);
		patient.insert(name, p);
	}

	// Suspension getter and setter
	public Boolean getSusp(String name) {
		return info.getSusp();
	}

	public void setSusp(String name, Boolean susp) {
		info.setSusp(susp);
	}

	// Info getter, setter, and find method
	public Info getInfo() {
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}
	
	public Info findInfo(String user) {
		return this.information.find(user);
	}
	
	// Appointment find method for patient, create method for patient, and cancel appointment for patient
	private void createAppt(String user, int date, int time, String doc, String reason){
		Appointment appt = findAppt(user);
		appt.create(date, time, user, doc, reason);
	}
	
	private void cancelAppt(String user, String doc, int date, int time){
		Appointment appt = findAppt(user);
		appt.cancel(date, time, user, doc);
	}	

	private Appointment findAppt(String user) {
		return patient.find(user).getAppt();
	}
}
