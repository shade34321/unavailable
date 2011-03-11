package MedicalSoftware;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MedicalMain {
	
	private static Info info;
	private static SystemAdmin systemAdmin;
	private static Doctor doctor;
	private static Nurse nur;
	private static Patient person;
	private static AVL<String, SystemAdmin> admin;
	private static AVL<String, Patient> patient;
	private static AVL<String, Nurse> nurse;
	private static AVL<String, Doctor> doc;
	
	// Main method to run
	public static void main(String[] args) throws IOException {
		setup();
		Login lg = new Login(admin, doc, nurse, patient);
	}
	
	// Loads the AVL trees with user information of all types
	private static void setup() throws IOException {
		String name;
		
		// Loads SystemAdmin information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Admin.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				systemAdmin.setInfo(info);
				admin.insert(name, systemAdmin);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Doctor information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Doctor.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				doctor.setInfo(info);
				doc.insert(name, doctor);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Nurse information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Nurse.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				nur.setInfo(info);
				nurse.insert(name, nur);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
		
		// Loads Patient information into tree
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Patient.txt"));
			while ((name = br.readLine()) != null) {
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				person.setInfo(info);
				patient.insert(name, person);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
}
