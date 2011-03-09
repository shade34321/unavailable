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
	
	public Doctor(){
		
	}
	
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
	public TreatmentRecords viewRecords(){
		
	}
	
	// TODO
	public Reports viewReports(){
	}
	
	// TODO
	public Appt viewAppt(){
	}
	
	// TODO
	public void update(String arg0, String arg1){
	
	}
	
	public Patient createPatient(String arg0, String arg1){
		return (new Patient(arg0, arg1));
	}
	
	public Apptointment createAppt(String arg0){
		return (new Apppointment(arg0));
	}
	
	// TODO
	public void cancelAppt(String argo){
	}
	
}