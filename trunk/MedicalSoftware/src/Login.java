package MedicalSoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			if (password == admin.find(userName).getInfo().getPassword()) {
				status = 1;
			}
		}
		else if (type == 1) {
			// Doctor
			if (password == doctor.find(userName).getInfo().getPassword()) {
				status = 1;
			} 
		}else if (type == 2) {
			// Nurse
			if (password == nurse.find(userName).getInfo().getPassword()) {
				status = 1;
			} 
		}else if (type == 3) {
			//Patient
			if (password == patient.find(userName).getInfo().getPassword()) {
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
				systemAdmin.setInfo(info);
				admin.insert(name, systemAdmin);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Doctor information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Doctor.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				doc.setInfo(info);
				doctor.insert(name, doc);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Nurse information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Nurse.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				nur.setInfo(info);
				nurse.insert(name, nur);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Patient information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("Patient.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				person.setInfo(info);
				patient.insert(name, person);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
	
	// Saves the AVL trees with user information of all types
	public void save() throws IOException {
		
		// Saves SystemAdmin information into tree
		try {
			File adminFile = new File("Admin.txt");
			adminFile.delete();
			File adminNewFile = new File("Admin.txt");
			adminNewFile.createNewFile();
			BSTNode<String, SystemAdmin> name;
			FileWriter outFile = new FileWriter("Admin.txt");
			PrintWriter out0 = new PrintWriter(outFile);
			while (admin.getRoot() != null) {
			name = admin.getRoot();
			admin.remove(name.getKey());
			out0.println(admin.find(name.getKey()).getInfo().getName());
			out0.println(admin.find(name.getKey()).getInfo().getPassword());
			out0.println(admin.find(name.getKey()).getInfo().getUserName());
			out0.println(admin.find(name.getKey()).getInfo().getEmail());
			out0.println(admin.find(name.getKey()).getInfo().getAddress());
			out0.println(admin.find(name.getKey()).getInfo().getState());
			out0.println(admin.find(name.getKey()).getInfo().getCountry());
			out0.println(admin.find(name.getKey()).getInfo().getSSN());
			out0.println(admin.find(name.getKey()).getInfo().getZip());
			out0.println(admin.find(name.getKey()).getInfo().getBirthday());
			out0.println(admin.find(name.getKey()).getInfo().getType());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Saves Doctor information into tree
		try {
			File docFile = new File("Doctor.txt");
			docFile.delete();
			File docNewFile = new File("Doctor.txt");
			docNewFile.createNewFile();
			BSTNode<String, Doctor> nameDoc;
			FileWriter outFile = new FileWriter("Doctor.txt");
			PrintWriter out1 = new PrintWriter(outFile);
			while (doctor.getRoot() != null) {
				nameDoc = doctor.getRoot();
				doctor.remove(nameDoc.getKey());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getName());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getPassword());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getUserName());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getEmail());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getAddress());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getState());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getCountry());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getSSN());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getZip());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getBirthday());
				out1.println(doctor.find(nameDoc.getKey()).getInfo().getType());
				}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Saves Nurse information into tree
		try {
			File nurFile = new File("Nurse.txt");
			nurFile.delete();
			File nurNewFile = new File("Nurse.txt");
			nurNewFile.createNewFile();
			BSTNode<String, Nurse> nameNur;
			FileWriter outFile = new FileWriter("Nurse.txt");
			PrintWriter out2 = new PrintWriter(outFile);
			while (nurse.getRoot() != null) {
				nameNur = nurse.getRoot();
				nurse.remove(nameNur.getKey());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getName());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getPassword());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getUserName());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getEmail());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getAddress());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getState());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getCountry());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getSSN());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getZip());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getBirthday());
				out2.println(nurse.find(nameNur.getKey()).getInfo().getType());
				}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Saves Patient information into tree
		try {
			File pFile = new File("Patient.txt");
			pFile.delete();
			File pNewFile = new File("Doctor.txt");
			pNewFile.createNewFile();
			BSTNode<String, Patient> namePatient;
			FileWriter outFile = new FileWriter("Patient.txt");
			PrintWriter out3 = new PrintWriter(outFile);
			while (patient.getRoot() != null) {
				namePatient = patient.getRoot();
				nurse.remove(namePatient.getKey());
				out3.println(patient.find(namePatient.getKey()).getInfo().getName());
				out3.println(patient.find(namePatient.getKey()).getInfo().getPassword());
				out3.println(patient.find(namePatient.getKey()).getInfo().getUserName());
				out3.println(patient.find(namePatient.getKey()).getInfo().getEmail());
				out3.println(patient.find(namePatient.getKey()).getInfo().getAddress());
				out3.println(patient.find(namePatient.getKey()).getInfo().getState());
				out3.println(patient.find(namePatient.getKey()).getInfo().getCountry());
				out3.println(patient.find(namePatient.getKey()).getInfo().getSSN());
				out3.println(patient.find(namePatient.getKey()).getInfo().getZip());
				out3.println(patient.find(namePatient.getKey()).getInfo().getBirthday());
				out3.println(patient.find(namePatient.getKey()).getInfo().getType());
				}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
}
