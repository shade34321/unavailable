package MedicalSoftware;

import java.util.ArrayList;

/*
 * SystemAdmin class designed to allow systemAdmin to control certain things in the medical software system.
 * @author Nathanial Heard
 */
public class SystemAdmin {
	private String input;
	private AVL<String, Info> information;
	private AVL<String, Report> report;
	private AVL<String, Patient> patient;
	private AVL<String, nurse> nurse;
	private AVL<String, Doctor> doctor;
	private AVL<String, SystemAdmin> systemAdmin;
	private Info info;
	
	// Basic constructor when no AVL trees are passed in and access system admin's information
	SystemAdmin(String user) {
		this.info = (Info) ((SystemAdmin) Search(user, 0)).getInfo();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, nurse>();
		this.doctor = new AVL<String, Doctor>();
		this.systemAdmin = new AVL<String, SystemAdmin>();
		this.report = new AVL<String, Report>();
		this.information = new AVL<String, Info>();
	}
	
	// Constructor used for when AVL trees are passed in to be able to search the system and access system admin's information
	SystemAdmin(String user, AVL<String, Info> i, AVL<String, Report> r, AVL<String, Patient> p, AVL<String, nurse> n, AVL<String, Doctor> d, AVL<String, SystemAdmin> sa) {
		this.report = r;
		this.information = i;
		this.patient = p;
		this.nurse = n;
		this.doctor = d;
		this.systemAdmin = sa;
		this.info = (Info) ((SystemAdmin) Search(user, 0)).getInfo();
	}
	
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
		boolean status;
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
	
	public Info getInfo() {
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}
	
	public Info findInfo(String user) {
		return this.information.find(user);
	}
	
	public Object Search(String user, int type) {
		Object ret;
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
