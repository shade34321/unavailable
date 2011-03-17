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
		AVL<String,Info> infoTree = new AVL<String,Info>();
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
		
		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);
		
		docTree.find("Michael").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Nathan").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Shade").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Kevin").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), docTree, infoTree);
		
		// Check to see if info AVL trees match
		assertEquals(docTree.find("Kevin").findInfo("Nathan"), docTree.find("Shade").findInfo("Nathan"));
		
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
		
		// Testing create patient method
		docTree.find("Shade").createPatient("Bob", "password", "userName", "email", "address", "state", "country", 55588555, 33033, 90887);
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getPassword(), "password");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getUserName(), "userName");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getEmail(), "email");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getAddress(), "address");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getState(), "state");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getCountry(), "country");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getSSN(), 55588555);
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getZip(), 33033);
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo().getBirthday(), 90887);
		
		docTree.find("Shade").createPatient("John", "password1", "userName1", "email1", "address1", "state1", "country1", 555885551, 330331, 908871);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getPassword(), "password1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getUserName(), "userName1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getEmail(), "email1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getAddress(), "address1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getState(), "state1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getCountry(), "country1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getSSN(), 555885551);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getZip(), 330331);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getBirthday(), 908871);
		
		// Creating Appointments
		docTree.find("Shade").createAppt("Bob", 90811, 2, "Shade", "Stomach hurts and puking all of last night.");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(90811, 2, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(90811, 2, "Bob", "Shade").getName(), "Bob");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(90811, 2, "Bob", "Shade").getTime(), 2);
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(90811, 2, "Bob", "Shade").getDate(), 90811);
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(90811, 2, "Bob", "Shade").getReason(), "Stomach hurts and puking all of last night.");
		
		docTree.find("Shade").createAppt("Bob", 91411, 5, "Shade", "Stomach still hurts.");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(91411, 5, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(91411, 5, "Bob", "Shade").getName(), "Bob");
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(91411, 5, "Bob", "Shade").getTime(), 5);
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(91411, 5, "Bob", "Shade").getDate(), 91411);
		assertEquals(docTree.find("Shade").getPatient("Bob").getAppt().find(91411, 5, "Bob", "Shade").getReason(), "Stomach still hurts.");
		
		// Creating doctors orders
		docTree.find("Shade").createOrder("Bob", 91411, 6, "Drugs", "lab", "Take for x number of days.", "");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getDate(), 91411);
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getTime(), 6);
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getPrescription(), "Drugs");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getLabWork(), "lab");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getFollowUpIns(), "Take for x number of days.");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(91411, 6, "Bob", "Drugs").getOtherIns(), "");
		
		docTree.find("Shade").createOrder("Bob", 90811, 7, "Drugs2", "lab1", "Take for n number of days.", "other");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getDate(), 90811);
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getTime(), 7);
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getPrescription(), "Drugs2");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getLabWork(), "lab1");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getFollowUpIns(), "Take for n number of days.");
		assertEquals(docTree.find("Shade").getOrders("Bob").find(90811, 7, "Bob", "Drugs2").getOtherIns(), "other");
		
		docTree.find("Shade").createOrder("John", 70811, 7, "Drugs2", "lab1", "Take for n number of days.", "other");
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getDate(), 70811);
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getTime(), 7);
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getPrescription(), "Drugs2");
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getLabWork(), "lab1");
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getFollowUpIns(), "Take for n number of days.");
		assertEquals(docTree.find("Shade").getOrders("John").find(70811, 7, "John", "Drugs2").getOtherIns(), "other");
		
		// Creating treatment records
		docTree.find("Shade").createTreatmentRecords("Bob", 91411, 7, "Stomach hurts", 90, 75, 91, 6, 180);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getDate(), 91411);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getTime(), 7);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getSymptoms(), "Stomach hurts");
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getBloodPressure(), 90);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getPulse(), 75);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getTemperature(), 91);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getHeight(), 6);
		assertEquals(docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7).getWeight(), 180);

		docTree.find("Shade").createTreatmentRecords("John", 81411, 3, "Stomach hurts again", 90, 75, 91, 6, 180);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getDate(), 81411);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getTime(), 3);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getSymptoms(), "Stomach hurts again");
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getBloodPressure(), 90);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getPulse(), 75);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getTemperature(), 91);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getHeight(), 6);
		assertEquals(docTree.find("Shade").getTreatmentRecords("John").find(81411, 3).getWeight(), 180);
		
		// Creating patient invoice
		docTree.find("Shade").createInvoice("Bob", "Shade", 2300, 100711, false);
		assertEquals(docTree.find("Shade").getInvoice("Bob").find(100711, "Bob").getDueDate(), 100711);
		assertEquals(docTree.find("Shade").getInvoice("Bob").find(100711, "Bob").getDoctor(), "Shade");
		assertEquals(docTree.find("Shade").getInvoice("Bob").find(100711, "Bob").getTotal(), 2300);
		assertEquals(docTree.find("Shade").getInvoice("Bob").find(100711, "Bob").getPaid(), false);
		
		docTree.find("Shade").createInvoice("John", "Shade", 2500, 112311, false);
		assertEquals(docTree.find("Shade").getInvoice("John").find(112311, "John").getDueDate(), 112311);
		assertEquals(docTree.find("Shade").getInvoice("John").find(112311, "John").getDoctor(), "Shade");
		assertEquals(docTree.find("Shade").getInvoice("John").find(112311, "John").getTotal(), 2500);
		assertEquals(docTree.find("Shade").getInvoice("John").find(112311, "John").getPaid(), false);
		
		// Deleting patients
		docTree.find("Shade").deletePatient("Bob");
		assertEquals(docTree.find("Shade").getPatient("Bob"), null);
		
		assertEquals(docTree.find("Shade").getPatient("John").getInfo().getSSN(), 555885551);
		
		docTree.find("Shade").deletePatient("John");
		assertEquals(docTree.find("Shade").getPatient("John"), null);
		
		
	}
	
	public void testCreateNurse(){
		AVL<String,Info> infoTree = new AVL<String,Info>();
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
		
		
		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);
		
		nurTree.find("Michael").updateTree(new AVL<String, Patient>(), nurTree, new AVL<String, Doctor>(), infoTree);
		nurTree.find("Nathan").updateTree(new AVL<String, Patient>(), nurTree, new AVL<String, Doctor>(), infoTree);
		nurTree.find("Shade").updateTree(new AVL<String, Patient>(), nurTree, new AVL<String, Doctor>(), infoTree);
		nurTree.find("Kevin").updateTree(new AVL<String, Patient>(), nurTree, new AVL<String, Doctor>(), infoTree);
		
		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", nurTree.inorder());
		
		// Checks info classes stored within each doctor class stored in the nurTree AVL tree
		assertEquals("Kevin", nurTree.find("Kevin").getInfo().getName());
		assertEquals("Nathan", nurTree.find("Nathan").getInfo().getName());
		assertEquals("Michael", nurTree.find("Michael").getInfo().getName());
		assertEquals("Shade", nurTree.find("Shade").getInfo().getName());
		
		assertEquals("kk", nurTree.find("Kevin").getInfo().getPassword());
		assertEquals("nn", nurTree.find("Nathan").getInfo().getPassword());
		assertEquals("mm", nurTree.find("Michael").getInfo().getPassword());
		assertEquals("ss", nurTree.find("Shade").getInfo().getPassword());
		
		assertEquals("kzhou", nurTree.find("Kevin").getInfo().getUserName());
		assertEquals("nheard", nurTree.find("Nathan").getInfo().getUserName());
		assertEquals("msimbal", nurTree.find("Michael").getInfo().getUserName());
		assertEquals("shade3", nurTree.find("Shade").getInfo().getUserName());
		
		assertEquals("kzhou@gmail.com", nurTree.find("Kevin").getInfo().getEmail());
		assertEquals("nheard@gmail.com", nurTree.find("Nathan").getInfo().getEmail());
		assertEquals("msimbal@gmail.com", nurTree.find("Michael").getInfo().getEmail());
		assertEquals("shade@gmail.com", nurTree.find("Shade").getInfo().getEmail());
		
		assertEquals("111 anywhere", nurTree.find("Kevin").getInfo().getAddress());
		assertEquals("888 anywhere", nurTree.find("Nathan").getInfo().getAddress());
		assertEquals("999 anywhere", nurTree.find("Michael").getInfo().getAddress());
		assertEquals("777 anywhere", nurTree.find("Shade").getInfo().getAddress());
		
		assertEquals("GA", nurTree.find("Kevin").getInfo().getState());
		assertEquals("GA", nurTree.find("Nathan").getInfo().getState());
		assertEquals("GA", nurTree.find("Michael").getInfo().getState());
		assertEquals("GA", nurTree.find("Shade").getInfo().getState());
		
		assertEquals("USA", nurTree.find("Kevin").getInfo().getCountry());
		assertEquals("USA", nurTree.find("Nathan").getInfo().getCountry());
		assertEquals("USA", nurTree.find("Michael").getInfo().getCountry());
		assertEquals("USA", nurTree.find("Shade").getInfo().getCountry());
		
		assertEquals(55544555, nurTree.find("Kevin").getInfo().getSSN());
		assertEquals(55542555, nurTree.find("Nathan").getInfo().getSSN());
		assertEquals(55541555, nurTree.find("Michael").getInfo().getSSN());
		assertEquals(55543555, nurTree.find("Shade").getInfo().getSSN());
		
		assertEquals(33033, nurTree.find("Kevin").getInfo().getZip());
		assertEquals(33033, nurTree.find("Nathan").getInfo().getZip());
		assertEquals(33033, nurTree.find("Michael").getInfo().getZip());
		assertEquals(33033, nurTree.find("Shade").getInfo().getZip());
		
		assertEquals(41291, nurTree.find("Kevin").getInfo().getBirthday());
		assertEquals(72291, nurTree.find("Nathan").getInfo().getBirthday());
		assertEquals(91391, nurTree.find("Michael").getInfo().getBirthday());
		assertEquals(82691, nurTree.find("Shade").getInfo().getBirthday());
		
		assertEquals(2, nurTree.find("Kevin").getInfo().getType());
		assertEquals(2, nurTree.find("Nathan").getInfo().getType());
		assertEquals(2, nurTree.find("Michael").getInfo().getType());
		assertEquals(2, nurTree.find("Shade").getInfo().getType());
		
		assertEquals(false, nurTree.find("Kevin").getInfo().getSusp());
		assertEquals(false, nurTree.find("Nathan").getInfo().getSusp());
		assertEquals(false, nurTree.find("Michael").getInfo().getSusp());
		assertEquals(false, nurTree.find("Shade").getInfo().getSusp());
	}
	
	public void testCreatePatient(){
		AVL<String,Patient> patientTree = new AVL<String,Patient>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com", "999 anywhere", "GA", "USA", 55541555, 33033, 91391, 3, false);
		Patient p0 = new Patient(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com", "888 anywhere", "GA", "USA", 55542555, 33033, 72291, 3, false);
		Patient p1 = new Patient(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com", "777 anywhere", "GA", "USA", 55543555, 33033, 82691, 3, false);
		Patient p2 = new Patient(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com", "111 anywhere", "GA", "USA", 55544555, 33033, 41291, 3, false);
		Patient p3 = new Patient(kInfo);
		
		patientTree.insert("Michael", p0);
		patientTree.insert("Nathan", p1);
		patientTree.insert("Shade", p2);
		patientTree.insert("Kevin", p3);
		
		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", patientTree.inorder());
		
		// Checks info classes stored within each doctor class stored in the patientTree AVL tree
		assertEquals("Kevin", patientTree.find("Kevin").getInfo().getName());
		assertEquals("Nathan", patientTree.find("Nathan").getInfo().getName());
		assertEquals("Michael", patientTree.find("Michael").getInfo().getName());
		assertEquals("Shade", patientTree.find("Shade").getInfo().getName());
		
		assertEquals("kk", patientTree.find("Kevin").getInfo().getPassword());
		assertEquals("nn", patientTree.find("Nathan").getInfo().getPassword());
		assertEquals("mm", patientTree.find("Michael").getInfo().getPassword());
		assertEquals("ss", patientTree.find("Shade").getInfo().getPassword());
		
		assertEquals("kzhou", patientTree.find("Kevin").getInfo().getUserName());
		assertEquals("nheard", patientTree.find("Nathan").getInfo().getUserName());
		assertEquals("msimbal", patientTree.find("Michael").getInfo().getUserName());
		assertEquals("shade3", patientTree.find("Shade").getInfo().getUserName());
		
		assertEquals("kzhou@gmail.com", patientTree.find("Kevin").getInfo().getEmail());
		assertEquals("nheard@gmail.com", patientTree.find("Nathan").getInfo().getEmail());
		assertEquals("msimbal@gmail.com", patientTree.find("Michael").getInfo().getEmail());
		assertEquals("shade@gmail.com", patientTree.find("Shade").getInfo().getEmail());
		
		assertEquals("111 anywhere", patientTree.find("Kevin").getInfo().getAddress());
		assertEquals("888 anywhere", patientTree.find("Nathan").getInfo().getAddress());
		assertEquals("999 anywhere", patientTree.find("Michael").getInfo().getAddress());
		assertEquals("777 anywhere", patientTree.find("Shade").getInfo().getAddress());
		
		assertEquals("GA", patientTree.find("Kevin").getInfo().getState());
		assertEquals("GA", patientTree.find("Nathan").getInfo().getState());
		assertEquals("GA", patientTree.find("Michael").getInfo().getState());
		assertEquals("GA", patientTree.find("Shade").getInfo().getState());
		
		assertEquals("USA", patientTree.find("Kevin").getInfo().getCountry());
		assertEquals("USA", patientTree.find("Nathan").getInfo().getCountry());
		assertEquals("USA", patientTree.find("Michael").getInfo().getCountry());
		assertEquals("USA", patientTree.find("Shade").getInfo().getCountry());
		
		assertEquals(55544555, patientTree.find("Kevin").getInfo().getSSN());
		assertEquals(55542555, patientTree.find("Nathan").getInfo().getSSN());
		assertEquals(55541555, patientTree.find("Michael").getInfo().getSSN());
		assertEquals(55543555, patientTree.find("Shade").getInfo().getSSN());
		
		assertEquals(33033, patientTree.find("Kevin").getInfo().getZip());
		assertEquals(33033, patientTree.find("Nathan").getInfo().getZip());
		assertEquals(33033, patientTree.find("Michael").getInfo().getZip());
		assertEquals(33033, patientTree.find("Shade").getInfo().getZip());
		
		assertEquals(41291, patientTree.find("Kevin").getInfo().getBirthday());
		assertEquals(72291, patientTree.find("Nathan").getInfo().getBirthday());
		assertEquals(91391, patientTree.find("Michael").getInfo().getBirthday());
		assertEquals(82691, patientTree.find("Shade").getInfo().getBirthday());
		
		assertEquals(3, patientTree.find("Kevin").getInfo().getType());
		assertEquals(3, patientTree.find("Nathan").getInfo().getType());
		assertEquals(3, patientTree.find("Michael").getInfo().getType());
		assertEquals(3, patientTree.find("Shade").getInfo().getType());
		
		assertEquals(false, patientTree.find("Kevin").getInfo().getSusp());
		assertEquals(false, patientTree.find("Nathan").getInfo().getSusp());
		assertEquals(false, patientTree.find("Michael").getInfo().getSusp());
		assertEquals(false, patientTree.find("Shade").getInfo().getSusp());
	}
	
	public void testCreateAdmin(){
		AVL<String,Info> infoTree = new AVL<String,Info>();
		AVL<String,SystemAdmin> adminTree = new AVL<String,SystemAdmin>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com", "999 anywhere", "GA", "USA", 55541555, 33033, 91391, 0, false);
		SystemAdmin nur0 = new SystemAdmin(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com", "888 anywhere", "GA", "USA", 55542555, 33033, 72291, 0, false);
		SystemAdmin nur1 = new SystemAdmin(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com", "777 anywhere", "GA", "USA", 55543555, 33033, 82691, 0, false);
		SystemAdmin nur2 = new SystemAdmin(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com", "111 anywhere", "GA", "USA", 55544555, 33033, 41291, 0, false);
		SystemAdmin nur3 = new SystemAdmin(kInfo);
		
		adminTree.insert("Michael", nur0);
		adminTree.insert("Nathan", nur1);
		adminTree.insert("Shade", nur2);
		adminTree.insert("Kevin", nur3);
		
		
		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);
		
		adminTree.find("Michael").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree, infoTree);
		adminTree.find("Nathan").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree, infoTree);
		adminTree.find("Shade").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree, infoTree);
		adminTree.find("Kevin").updateTree(new AVL<String, Patient>(), new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree, infoTree);
		
		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", adminTree.inorder());
		
		// Checks info classes stored within each doctor class stored in the adminTree AVL tree
		assertEquals("Kevin", adminTree.find("Kevin").getInfo().getName());
		assertEquals("Nathan", adminTree.find("Nathan").getInfo().getName());
		assertEquals("Michael", adminTree.find("Michael").getInfo().getName());
		assertEquals("Shade", adminTree.find("Shade").getInfo().getName());
		
		assertEquals("kk", adminTree.find("Kevin").getInfo().getPassword());
		assertEquals("nn", adminTree.find("Nathan").getInfo().getPassword());
		assertEquals("mm", adminTree.find("Michael").getInfo().getPassword());
		assertEquals("ss", adminTree.find("Shade").getInfo().getPassword());
		
		assertEquals("kzhou", adminTree.find("Kevin").getInfo().getUserName());
		assertEquals("nheard", adminTree.find("Nathan").getInfo().getUserName());
		assertEquals("msimbal", adminTree.find("Michael").getInfo().getUserName());
		assertEquals("shade3", adminTree.find("Shade").getInfo().getUserName());
		
		assertEquals("kzhou@gmail.com", adminTree.find("Kevin").getInfo().getEmail());
		assertEquals("nheard@gmail.com", adminTree.find("Nathan").getInfo().getEmail());
		assertEquals("msimbal@gmail.com", adminTree.find("Michael").getInfo().getEmail());
		assertEquals("shade@gmail.com", adminTree.find("Shade").getInfo().getEmail());
		
		assertEquals("111 anywhere", adminTree.find("Kevin").getInfo().getAddress());
		assertEquals("888 anywhere", adminTree.find("Nathan").getInfo().getAddress());
		assertEquals("999 anywhere", adminTree.find("Michael").getInfo().getAddress());
		assertEquals("777 anywhere", adminTree.find("Shade").getInfo().getAddress());
		
		assertEquals("GA", adminTree.find("Kevin").getInfo().getState());
		assertEquals("GA", adminTree.find("Nathan").getInfo().getState());
		assertEquals("GA", adminTree.find("Michael").getInfo().getState());
		assertEquals("GA", adminTree.find("Shade").getInfo().getState());
		
		assertEquals("USA", adminTree.find("Kevin").getInfo().getCountry());
		assertEquals("USA", adminTree.find("Nathan").getInfo().getCountry());
		assertEquals("USA", adminTree.find("Michael").getInfo().getCountry());
		assertEquals("USA", adminTree.find("Shade").getInfo().getCountry());
		
		assertEquals(55544555, adminTree.find("Kevin").getInfo().getSSN());
		assertEquals(55542555, adminTree.find("Nathan").getInfo().getSSN());
		assertEquals(55541555, adminTree.find("Michael").getInfo().getSSN());
		assertEquals(55543555, adminTree.find("Shade").getInfo().getSSN());
		
		assertEquals(33033, adminTree.find("Kevin").getInfo().getZip());
		assertEquals(33033, adminTree.find("Nathan").getInfo().getZip());
		assertEquals(33033, adminTree.find("Michael").getInfo().getZip());
		assertEquals(33033, adminTree.find("Shade").getInfo().getZip());
		
		assertEquals(41291, adminTree.find("Kevin").getInfo().getBirthday());
		assertEquals(72291, adminTree.find("Nathan").getInfo().getBirthday());
		assertEquals(91391, adminTree.find("Michael").getInfo().getBirthday());
		assertEquals(82691, adminTree.find("Shade").getInfo().getBirthday());
		
		assertEquals(0, adminTree.find("Kevin").getInfo().getType());
		assertEquals(0, adminTree.find("Nathan").getInfo().getType());
		assertEquals(0, adminTree.find("Michael").getInfo().getType());
		assertEquals(0, adminTree.find("Shade").getInfo().getType());
		
		assertEquals(false, adminTree.find("Kevin").getInfo().getSusp());
		assertEquals(false, adminTree.find("Nathan").getInfo().getSusp());
		assertEquals(false, adminTree.find("Michael").getInfo().getSusp());
		assertEquals(false, adminTree.find("Shade").getInfo().getSusp());
	}
	
	public void testLogin() {
		
	}
	
	
}
