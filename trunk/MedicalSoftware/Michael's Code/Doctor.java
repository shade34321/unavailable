/**
* This class creates a new Doctor.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

public class Doctor{

	private String info;
	ArrayList<Patient> patients;
	private boolean suspended;
	private String input;
	ArrayList<Nurse> nurses;
	
	public void getInfo(String name){
		System.out.println(info(name))
	}
	
	public void createOrder(String newOrder){
		doctorsOrders order = new doctorsOrders(newOrder);
	}
	
	public void createInvoice(String newInvoice){
		patientInvoice invoice = new patientInvoice(newInvoice);
	}
	
	// TODO
	public void viewRecords(){
		
	}
	
	// TODO
	public void viewReports(){
	}
	
	// TODO
	public void viewAppt(){
	}
	
	// TODO
	public void update(String arg0, String arg1){
	
	}
	
	public void createPatient(String arg0, String arg1){
		Patient pat = new Patient(arg0, arg1);
	}
	
	public void createAppt(String arg0){
		Appointment appt = new Apppointment(arg0);
	}
	
	// TODO
	public void cancelAppt(String argo){
	}
	
}