package MedicalSoftware;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	private Info info;
	private SystemAdmin systemAdmin;
	private Doctor doctor;
	private Nurse nur;
	private Patient pp;
	private AVL<String, SystemAdmin> admin;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Doctor> doc;
	
	Login() {
		admin = new AVL<String, SystemAdmin>();
		doc = new AVL<String, Doctor>();
		patient = new AVL<String, Patient>();
		nurse = new AVL<String, Nurse>();
	}

	public void run() throws IOException {
		setup();
	}

	private void setup() throws IOException {
		String name;
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Info.txt"));
			while ((name = br.readLine()) != null) {
				this.info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				this.systemAdmin.setInfo(info);
				this.admin.insert(name, systemAdmin);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
}
