package MedicalSoftware;

/**
* This class creates a new Doctor.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

public class Doctor{

	private String info;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Report> report;
	private AVL<String, Doctor> doctor;
	private boolean suspended;
	private String input;
	
	public Doctor(){
		this.info = (Info) ((Doctor) Search(user, 1)).getInfo();
		this.patient = new AVL<String, Patient>();
		this.doctor = new AVL<String, Doctor>();
		this.nurse = new AVL<String, Nurse>();
		this.report = new AVL<String, Report>();
		this.suspended = false;
	}
	
	public Patient createPatient(String name){
		return new Patient(name,patient,doctor)
	}
	
	public void deletePatient(String name){
		patient.delete(name);
	}
	
	public Patient viewPatient(String name){
		return patient.find(name);
	}
	
	public void getInfo(String name){
		return this.info.find(name);
	}
	
	public DoctorsOrders createOrder(String newOrder){
		return new DoctorsOrders(newOrder);
	}
	
	public PatientInvoice createInvoice(String newInvoice){
		return new PatientInvoice(newInvoice);
	}
	
	private TreatmentRecord getRecords(String name){
		return this.record.find(name).getRecord();
		//update GUI
	}
	
	public Report getReports(String user) {
		return this.report.find(user).getReport();
	}
	
	private String getAppt(int date, String name){
		return this.patient.find(name).getAppt(); 
		//update GUI
	}
	
	private void createAppt(int date, int time, String doc, String reason){
		appointment appt = new appointment(date, time, doc, reason);
		appt.create();
	}
	
	private void cancelAppt(int date, int time, String doc, String reason){
		appointment appt = new appointment(date, time, doc, reason)
		appt.cancel();
	}	
}