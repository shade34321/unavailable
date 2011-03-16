package MedicalSoftware;

import junit.framework.TestCase;

public class M5 extends TestCase {

	public void Login(){
		
	}
	
	public void createDoctor(){
		AVL<String,Doctor> docTree = new AVL<String,Doctor>();
		Doctor doc0 = new Doctor("Michael", null, null,null, null);
		Doctor doc1 = new Doctor("Nathan", null, null,null, null);
		Doctor doc2 = new Doctor("Shade", null, null,null, null);
		Doctor doc3 = new Doctor("Kevin", null, null,null, null);
		
		docTree.insert("Michael", doc0);
		docTree.insert("Nathan", doc1);
		docTree.insert("Shade", doc2);
		docTree.insert("Kevin", doc3);
		
		assertEquals("KevinMichaelNathanShade", docTree.inorder());
	}
	
	public void createNurse(){
		
	}
	
	public void createPatient(){
		
	}
	
	public void createAdmin(){
		
	}
	
	public void deleteDoctor(){
		
	}
	
	public void deleteNurse(){
		
	}
	
	public void deletePatient(){
		
	}
	
	public void deleteAdmin(){
		
	}
	
	public void viewDoctorInfo(){
		
	}
	
	public void viewNurseInfo(){
		
	}
	
	public void viewPatientInfo(){
		
	}
	
	public void viewAdminInfo(){
		
	}
	
	
	
	
}
