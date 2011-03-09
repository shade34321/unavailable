package MedicalSoftware;

public class Login {
	private SystemAdmin systemAdmin;
	private Doctor doc;
	private Nurse nur;
	private Patient person;
	private AVL<String, SystemAdmin> admin;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	
	Login() {
		this.admin = new AVL<String, SystemAdmin>();
		this.doc = new AVL<String, Doctor>();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
	}

	Login(AVL<String, SystemAdmin> admin, AVL<String, Doctor> doctor, AVL<String, Nurse> nurse, AVL<String, Patient> patient) {
		this.admin = admin;
		this.doctor = doctor;
		this.nurse = nurse;
		this.patient = patient;
	}
	
	public void run() {
		loginUser();
	}

	private void loginUser() {
		String userName;
		String password;
	}
}
