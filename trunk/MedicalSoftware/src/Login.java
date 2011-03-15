package MedicalSoftware;

import java.util.logging.Level;

public class Login {
	private SystemAdmin systemAdmin;
	private Doctor doc;
	private Nurse nur;
	private Patient person;
	private AVL<String, Info> information;
	private AVL<String, SystemAdmin> admin;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	
	Login() {
		this.admin = new AVL<String, SystemAdmin>();
		this.doctor = new AVL<String, Doctor>();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
	}

	Login(AVL<String, SystemAdmin> admin, AVL<String, Doctor> doctor, AVL<String, Nurse> nurse, AVL<String, Patient> patient) {
		this.admin = admin;
		this.doctor = doctor;
		this.nurse = nurse;
		this.patient = patient;
	}
	
	public void run(Object user) {
		
	}

	public boolean loginUser(String userName, String password, int type) {
		
		boolean status = false;
		if (type ==0) {
			// System Admin
			if (password == admin.find(userName).getInfo().getPassword()) {
				status = true;
			}
		}
		else if (type == 1) {
			// Doctor
			if (password == doctor.find(userName).getInfo().getPassword()) {
				status = true;
			} 
		}else if (type == 2) {
			// Nurse
			if (password == nurse.find(userName).getInfo().getPassword()) {
				status = true;
			} 
		}else if (type == 3) {
			//Patient
			if (password == patient.find(userName).getInfo().getPassword()) {
				status = true;
			}
		}
		return status;
	}
	
	public void createUser(String name, String password, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday, int type) {
		Info form = new Info(name, password, userName, email, address, state, country, SSN, zip, birthday, type, false);
		if (type ==0) {
			// System Admin
			SystemAdmin sa = new SystemAdmin(form, this.patient, this.nurse, this.doctor, this.admin, this.information);
			admin.insert(name, sa);
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
}
