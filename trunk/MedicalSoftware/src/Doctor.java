package MedicalSoftware;

/**
* This class creates a new Doctor.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

public class Doctor{

	private Info info;
	private AVL<String, Info> information;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Report> report;
	private AVL<String, Doctor> doctor;
	private String input;
	
	// Constructors
	Doctor(String user, AVL<String, Info> i, AVL<String, Report> r, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d) {
		this.report = r;
		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.info = (Info) ((Doctor) Search(user, 1)).getInfo();
	}
	
	Doctor (Info info, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, Info> i, AVL<String, Report> r) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.information = i;
		this.report = r;
		this.info = info;
	}
	
	public Patient createPatient(String name){
		return new Patient(name,patient,doctor);
	}
	
	// Patient deleting and creating
	public void deletePatient(String name){
		patient.remove(name);
	}
	
	public Patient getPatient(String name){
		return patient.find(name);
	}
	
	public void createPatient(String name, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday) {
		Info form = new Info(name, userName, email, address, state, country, SSN, zip, birthday, 3, false);
		Patient p = new Patient(form, this.patient, this.doctor);
		patient.insert(name, p);
	}
	
	// Creating and finding DoctorOrders
	public DoctorsOrders createOrder(String user, int date, int time, String prescrip, String labW, String followUp, String other){
		return new DoctorsOrders(user, date, time, prescrip, labW, followUp, other);
	}
	
	public PatientInvoice createInvoice(String name, String doc, int total, int due, Boolean paid){
		return new PatientInvoice(name, doc, total, due, paid);
	}
	
	// TreatmentRecords find method
	private TreatmentRecords getRecords(String name){
			return patient.find(name).getTreatmentRecords();
	}
	
	public Report getReports(String user) {
		return this.report.find(user).getReport();
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