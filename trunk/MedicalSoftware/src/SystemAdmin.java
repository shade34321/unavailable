package MedicalSoftware;

/*
 * SystemAdmin class designed to allow systemAdmin to control certain things in the medical software system.
 * @author Nathanial Heard
 * 
 */
public class SystemAdmin {
	private String input;
	private AVL<String, Info> information;
	private AVL<String, Report> report;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doctor;
	private AVL<String, SystemAdmin> systemAdmin;
	private Info info;
	
	// Basic constructor when no AVL trees are passed in and access system admin's information
	SystemAdmin(String user) {
		this.info = (Info) ((SystemAdmin) Search(user, 0)).getInfo();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
		this.doctor = new AVL<String, Doctor>();
		this.systemAdmin = new AVL<String, SystemAdmin>();
		this.report = new AVL<String, Report>();
		this.information = new AVL<String, Info>();
	}
	
	// Constructor for creating a new admin
	SystemAdmin (Info info, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa, AVL<String, Info> i, AVL<String, Report> r) {		
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.information = i;
		this.report = r;
		this.info = info;
	}
	
	// Constructor used for when AVL trees are passed in to be able to search the system and access system admin's information
	SystemAdmin(String user, AVL<String, Info> i, AVL<String, Report> r, AVL<String, Patient> p, AVL<String, Nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa) {
		this.report = r;
		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.info = (Info) ((SystemAdmin) Search(user, 0)).getInfo();
	}
	
	// Suspension getter and setter
	public void setSusp(String user, int type, Boolean status) {
		if (type ==0) {
			// System Admin
			systemAdmin.find(user).getInfo().setSusp(status);
		}
		else if (type == 1) {
			// Doctor
			doctor.find(user).getInfo().setSusp(status);
		}else if (type == 2) {
			// Nurse
			nurse.find(user).getInfo().setSusp(status);
		}else if (type == 3) {
			//Patient
			patient.find(user).getInfo().setSusp(status);
		}
	}
	
	public boolean getSusp(String user, int type) {
		boolean status = false;
		if (type ==0) {
			// System Admin
			status = systemAdmin.find(user).getInfo().getSusp();
		}
		else if (type == 1) {
			// Doctor
			status = doctor.find(user).getInfo().getSusp();
		}else if (type == 2) {
			// Nurse
			status = nurse.find(user).getInfo().getSusp();
		}else if (type == 3) {
			//Patient
			status = patient.find(user).getInfo().getSusp();
		}
		return status;
	}
	
	public Report getReports(String user) {
			return this.report.find(user).getReport();
	}
	
	// Creating and deleting users class
	public void createUser(String name, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday, int type) {
		Info form = new Info(name, userName, email, address, state, country, SSN, zip, birthday, type, false);
		if (type ==0) {
			// System Admin
			SystemAdmin sa = new SystemAdmin(form, this.patient, this.nurse, this.doctor, this.systemAdmin, this.information, this.report);
			systemAdmin.insert(name, sa);
		}
		else if (type == 1) {
			// Doctor
			Doctor doc = new Doctor(form, this.patient, this.nurse, this.doctor, this.information, this.report);
			doctor.insert(name, doc);
		}else if (type == 2) {
			// Nurse
			Nurse n = new Nurse(form, this.patient, this.nurse, this.doctor, this.information, this.report);
			nurse.insert(name, n);
		}else if (type == 3) {
			//Patient
			Patient p = new Patient(form, this.patient, this.doctor);
			patient.insert(name, p);
		}
	}
	
	private void deleteUser(String user, int type) {
		if (type ==0) {
			// System Admin
			systemAdmin.remove(user);
		}
		else if (type == 1) {
			// Doctor
			doctor.remove(user);
		}else if (type == 2) {
			// Nurse
			nurse.remove(user);
		}else if (type == 3) {
			//Patient
			patient.remove(user);
		}
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
		if (type ==0) {
			// System Admin
			ret = systemAdmin.find(user);
		}else if (type == 1) {
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
