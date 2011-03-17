package MedicalSoftware;

import junit.framework.TestCase;

public class M5 extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	/*
	 * Test to see if the AVL tree for storing doctors works along with the basic functions of a doctor's class
	 * @Test
	 */
	public void testCreateDoctor(){
		AVL<String,Doctor> docTree = new AVL<String,Doctor>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com", "999 anywhere", "GA", "USA", 55541555, 33033, 91391, 1, false);
		Doctor doc0 = new Doctor(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com", "888 anywhere", "GA", "USA", 55542555, 33033, 72291, 1, false);
		Doctor doc1 = new Doctor(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com", "777 anywhere", "GA", "USA", 55543555, 33033, 82691, 1, false);
		Doctor doc2 = new Doctor(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com", "111 anywhere", "GA", "USA", 55544555, 33033, 41291, 1, false);
		Doctor doc3 = new Doctor(kInfo);
		
		docTree.insert("Michael", doc0);
		docTree.insert("Nathan", doc1);
		docTree.insert("Shade", doc2);
		docTree.insert("Kevin", doc3);
		
		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", docTree.inorder());

		// Checks info classes stored within each doctor class stored in the docTree AVL tree
		assertEquals("Kevin", docTree.find("Kevin").getInfo().getName());
		assertEquals("Nathan", docTree.find("Nathan").getInfo().getName());
		assertEquals("Michael", docTree.find("Michael").getInfo().getName());
		assertEquals("Shade", docTree.find("Shade").getInfo().getName());
		
		assertEquals("kk", docTree.find("Kevin").getInfo().getPassword());
		assertEquals("nn", docTree.find("Nathan").getInfo().getPassword());
		assertEquals("mm", docTree.find("Michael").getInfo().getPassword());
		assertEquals("ss", docTree.find("Shade").getInfo().getPassword());
		
		assertEquals("kzhou", docTree.find("Kevin").getInfo().getUserName());
		assertEquals("nheard", docTree.find("Nathan").getInfo().getUserName());
		assertEquals("msimbal", docTree.find("Michael").getInfo().getUserName());
		assertEquals("shade3", docTree.find("Shade").getInfo().getUserName());
		
		assertEquals("kzhou@gmail.com", docTree.find("Kevin").getInfo().getEmail());
		assertEquals("nheard@gmail.com", docTree.find("Nathan").getInfo().getEmail());
		assertEquals("msimbal@gmail.com", docTree.find("Michael").getInfo().getEmail());
		assertEquals("shade@gmail.com", docTree.find("Shade").getInfo().getEmail());
		
		assertEquals("111 anywhere", docTree.find("Kevin").getInfo().getAddress());
		assertEquals("888 anywhere", docTree.find("Nathan").getInfo().getAddress());
		assertEquals("999 anywhere", docTree.find("Michael").getInfo().getAddress());
		assertEquals("777 anywhere", docTree.find("Shade").getInfo().getAddress());
		
		assertEquals("GA", docTree.find("Kevin").getInfo().getState());
		assertEquals("GA", docTree.find("Nathan").getInfo().getState());
		assertEquals("GA", docTree.find("Michael").getInfo().getState());
		assertEquals("GA", docTree.find("Shade").getInfo().getState());
		
		assertEquals("USA", docTree.find("Kevin").getInfo().getCountry());
		assertEquals("USA", docTree.find("Nathan").getInfo().getCountry());
		assertEquals("USA", docTree.find("Michael").getInfo().getCountry());
		assertEquals("USA", docTree.find("Shade").getInfo().getCountry());
		
		assertEquals(55544555, docTree.find("Kevin").getInfo().getSSN());
		assertEquals(55542555, docTree.find("Nathan").getInfo().getSSN());
		assertEquals(55541555, docTree.find("Michael").getInfo().getSSN());
		assertEquals(55543555, docTree.find("Shade").getInfo().getSSN());
		
		assertEquals(33033, docTree.find("Kevin").getInfo().getZip());
		assertEquals(33033, docTree.find("Nathan").getInfo().getZip());
		assertEquals(33033, docTree.find("Michael").getInfo().getZip());
		assertEquals(33033, docTree.find("Shade").getInfo().getZip());
		
		assertEquals(41291, docTree.find("Kevin").getInfo().getBirthday());
		assertEquals(72291, docTree.find("Nathan").getInfo().getBirthday());
		assertEquals(91391, docTree.find("Michael").getInfo().getBirthday());
		assertEquals(82691, docTree.find("Shade").getInfo().getBirthday());
		
		assertEquals(1, docTree.find("Kevin").getInfo().getType());
		assertEquals(1, docTree.find("Nathan").getInfo().getType());
		assertEquals(1, docTree.find("Michael").getInfo().getType());
		assertEquals(1, docTree.find("Shade").getInfo().getType());
		
		assertEquals(false, docTree.find("Kevin").getInfo().getSusp());
		assertEquals(false, docTree.find("Nathan").getInfo().getSusp());
		assertEquals(false, docTree.find("Michael").getInfo().getSusp());
		assertEquals(false, docTree.find("Shade").getInfo().getSusp());
	}
	
	public void testCreateNurse(){
		AVL<String,Nurse> nurTree = new AVL<String,Nurse>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com", "999 anywhere", "GA", "USA", 55541555, 33033, 91391, 2, false);
		Nurse nur0 = new Nurse(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com", "888 anywhere", "GA", "USA", 55542555, 33033, 72291, 2, false);
		Nurse nur1 = new Nurse(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com", "777 anywhere", "GA", "USA", 55543555, 33033, 82691, 2, false);
		Nurse nur2 = new Nurse(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com", "111 anywhere", "GA", "USA", 55544555, 33033, 41291, 2, false);
		Nurse nur3 = new Nurse(kInfo);
		
		nurTree.insert("Michael", nur0);
		nurTree.insert("Nathan", nur1);
		nurTree.insert("Shade", nur2);
		nurTree.insert("Kevin", nur3);
		
	}
	
	public void testCreatePatient(){
		
	}
	
	public void testCreateAdmin(){
		
	}
	
	public void testDeleteDoctor(){
		
	}
	
	public void testDeleteNurse(){
		
	}
	
	public void testDeletePatient(){
		
	}
	
	public void testDeleteAdmin(){
		
	}
	
	public void testLogin() {
		
	}
	
	
}
