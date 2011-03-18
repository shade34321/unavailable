package MedicalSoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
	private static int suspended = 0;
	private Info info;
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
	
	public void run() throws IOException {
		setup();
		
	}

	public int loginUser(String userName, String password, int type) {
		int status = 0;
		suspended++;
		if (suspended == 3) {
			status = 2;
		}
		if (type ==0) {
			// System Admin
			if (password.equals(admin.find(userName).getInfo().getPassword())) {
				status = 1;
			}
		}
		else if (type == 1) {
			// Doctor
			if (password.equals(doctor.find(userName).getInfo().getPassword())) {
				status = 1;
			} 
		}else if (type == 2) {
			// Nurse
			if (password.equals(nurse.find(userName).getInfo().getPassword())) {
				status = 1;
			} 
		}else if (type == 3) {
			//Patient
			if (password.equals(patient.find(userName).getInfo().getPassword())) {
				status = 1;
			}
		}
		return status;
	}
	
	public void createUser(String name, String password, String userName, String email, String address, String state, String country, int SSN, int zip, int birthday, int type) {
		Info form = new Info(name, password, userName, email, address, state, country, SSN, zip, birthday, type, false);
		if (type ==0) {
			// System Admin
			SystemAdmin sa = new SystemAdmin(form);
			admin.insert(name, sa);
			sa.updateTree(this.patient, this.nurse, this.doctor, this.admin, this.information);
			
		}
		else if (type == 1) {
			// Doctor
			Doctor d = new Doctor(form);
			doctor.insert(name, d);
			d.updateTree(this.patient, this.nurse, this.doctor, this.information);
			
		}else if (type == 2) {
			// Nurse
			Nurse n = new Nurse(form);
			nurse.insert(name, n);
			n.updateTree(this.patient, this.nurse, this.doctor, this.information);
			
		}else if (type == 3) {
			//Patient
			Patient p = new Patient(form);
			patient.insert(name, p);
				p.updateTree(this.patient, this.doctor);
			
		}
	}
	
	// Loads the AVL trees with user information of all types
	public void setup() throws IOException {
		String name;
		
		// Loads SystemAdmin information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				systemAdmin = new SystemAdmin(info);
				admin.insert(name, systemAdmin);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Doctor information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Doctor.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				doc =  new Doctor(info);
				doctor.insert(name, doc);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Nurse information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Nurse.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				nur =  new Nurse(info);
				nurse.insert(name, nur);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Patient information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Patient.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				person = new Patient(info);
				patient.insert(name, person);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
	
	// Saves the AVL trees with user information of all types
	public void save() throws IOException {
		
		// Saves SystemAdmin information into tree
		try {
			BSTNode<String, SystemAdmin> name;
			BufferedWriter br = new BufferedWriter(new FileWriter("Admin.txt"));
			while (admin.getRoot() != null) {
				name = admin.getRoot();
				br.write(name.getValue().getInfo().getName());
				br.newLine();
				br.write(name.getValue().getInfo().getPassword());
				br.newLine();
				br.write(name.getValue().getInfo().getUserName());
				br.newLine();
				br.write(name.getValue().getInfo().getEmail());
				br.newLine();
				br.write(name.getValue().getInfo().getAddress());
				br.newLine();
				br.write(name.getValue().getInfo().getState());
				br.newLine();
				br.write(name.getValue().getInfo().getCountry());
				br.newLine();
				br.write(Integer.toString(name.getValue().getInfo().getSSN()));
				br.newLine();
				br.write(Integer.toString(name.getValue().getInfo().getZip()));
				br.newLine();
				br.write(Integer.toString(name.getValue().getInfo().getBirthday()));
				br.newLine();
				br.write(Integer.toString(name.getValue().getInfo().getType()));
				br.newLine();
				admin.remove(admin.getRoot().getKey());
				}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		try {
			BSTNode<String, Doctor> nameDoc;
			BufferedWriter br = new BufferedWriter(new FileWriter("Doctor.txt"));
			while (doctor.getRoot() != null) {
				nameDoc = doctor.getRoot();
				br.write(nameDoc.getValue().getInfo().getName());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getPassword());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getUserName());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getEmail());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getAddress());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getState());
				br.newLine();
				br.write(nameDoc.getValue().getInfo().getCountry());
				br.newLine();
				br.write(Integer.toString(nameDoc.getValue().getInfo().getSSN()));
				br.newLine();
				br.write(Integer.toString(nameDoc.getValue().getInfo().getZip()));
				br.newLine();
				br.write(Integer.toString(nameDoc.getValue().getInfo().getBirthday()));
				br.newLine();
				br.write(Integer.toString(nameDoc.getValue().getInfo().getType()));
				br.newLine();
				doctor.remove(doctor.getRoot().getKey());
				}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		try {
			BSTNode<String, Nurse> nameNur;
			BufferedWriter br = new BufferedWriter(new FileWriter("Nurse.txt"));
			while (nurse.getRoot() != null) {
				nameNur = nurse.getRoot();
				br.write(nameNur.getValue().getInfo().getName());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getPassword());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getUserName());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getEmail());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getAddress());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getState());
				br.newLine();
				br.write(nameNur.getValue().getInfo().getCountry());
				br.newLine();
				br.write(Integer.toString(nameNur.getValue().getInfo().getSSN()));
				br.newLine();
				br.write(Integer.toString(nameNur.getValue().getInfo().getZip()));
				br.newLine();
				br.write(Integer.toString(nameNur.getValue().getInfo().getBirthday()));
				br.newLine();
				br.write(Integer.toString(nameNur.getValue().getInfo().getType()));
				br.newLine();
				nurse.remove(nurse.getRoot().getKey());
				}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		try {
			BSTNode<String, Patient> namePatient;
			BufferedWriter br = new BufferedWriter(new FileWriter("Patient.txt"));
			while (patient.getRoot() != null) {
				namePatient = patient.getRoot();
				br.write(namePatient.getValue().getInfo().getName());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getPassword());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getUserName());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getEmail());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getAddress());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getState());
				br.newLine();
				br.write(namePatient.getValue().getInfo().getCountry());
				br.newLine();
				br.write(Integer.toString(namePatient.getValue().getInfo().getSSN()));
				br.newLine();
				br.write(Integer.toString(namePatient.getValue().getInfo().getZip()));
				br.newLine();
				br.write(Integer.toString(namePatient.getValue().getInfo().getBirthday()));
				br.newLine();
				br.write(Integer.toString(namePatient.getValue().getInfo().getType()));
				br.newLine();
				patient.remove(patient.getRoot().getKey());
				}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
	}
	
	// For test purposes only
	public Object getTree(int type) {
		if (type ==0) {
			// System Admin
			return this.admin;
		}
		else if (type == 1) {
			// Doctor
			return this.doctor;
		}else if (type == 2) {
			// Nurse
			return this.nurse;
		}else if (type == 3) {
			//Patient
			return this.patient;
			
		}
		return null;
	}
}
