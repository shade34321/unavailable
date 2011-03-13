package MedicalSoftware;

/**
 * A class created to access patient information create appointments and other such patient functions 
 * @author Kevin Zhou 
 *
 */

public class Patient {
	private Info info;
	private Appointment appt;
	private DoctorsOrders orders;
	private TreatmentRecords record;
	private PatientInvoice invoice;
	private AVL<String, Patient> patient;
	private AVL<String, Doctor> doctor;


	// Constructors
	Patient(Info info, AVL<String, Patient> p, AVL<String, Doctor> d) {		
		this.patient = p;
		this.doctor = d;
		this.info = info;
		this.appt = new Appointment();
		this.record = new TreatmentRecords();
		this.invoice = new PatientInvoice();
		this.orders = new DoctorsOrders();
	}
	
	Patient(String user, AVL<String, Patient> p, AVL<String, Doctor> d) {		
		this.patient = p;
		this.doctor = d;
		this.info = patient.find(user).getInfo();
		this.appt = patient.find(user).getAppt();
		this.record = patient.find(user).getTreatmentRecords();
		this.invoice = patient.find(user).getPatientInvoice();
		this.orders = patient.find(user).getOrders();
	}

	// Patient Invoice getter and setter
	public PatientInvoice getPatientInvoice() {
		return this.invoice;
	}
	
	public void setPatientInvoice(PatientInvoice invoice) {
		this.invoice = invoice;
	}

	// Info getter and setter
	public Info getInfo() {
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
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
