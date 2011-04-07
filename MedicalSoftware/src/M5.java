package MedicalSoftware;

import java.io.IOException;

import junit.framework.TestCase;

/**
 * JUnit tests
 * 
 * @author Michael Sambol, Nathan Heard
 * 
 */
public class M5 extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Tests Doctor
	 */
	public void testCreateDoctor() {
		AVL<String, Doctor> docTree = new AVL<String, Doctor>();
		AVL<String, Info> infoTree = new AVL<String, Info>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com",
				"999 anywhere", "GA", "USA", 55541555, 33033, 91391, 1, false);
		Doctor doc0 = new Doctor(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com",
				"888 anywhere", "GA", "USA", 55542555, 33033, 72291, 1, false);
		Doctor doc1 = new Doctor(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com",
				"777 anywhere", "GA", "USA", 55543555, 33033, 82691, 1, false);
		Doctor doc2 = new Doctor(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com",
				"111 anywhere", "GA", "USA", 55544555, 33033, 41291, 1, false);
		Doctor doc3 = new Doctor(kInfo);

		docTree.insert("Michael", doc0);
		docTree.insert("Nathan", doc1);
		docTree.insert("Shade", doc2);
		docTree.insert("Kevin", doc3);

		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);

		docTree.find("Michael").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Nathan").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Shade").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), docTree, infoTree);
		docTree.find("Kevin").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), docTree, infoTree);

		// Check to see if info AVL trees match
		assertEquals(docTree.find("Kevin").findInfo("Nathan"),
				docTree.find("Shade").findInfo("Nathan"));

		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", docTree.inorder());

		// Checks info classes stored within each doctor class stored in the
		// docTree AVL tree
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

		assertEquals("kzhou@gmail.com", docTree.find("Kevin").getInfo()
				.getEmail());
		assertEquals("nheard@gmail.com", docTree.find("Nathan").getInfo()
				.getEmail());
		assertEquals("msimbal@gmail.com", docTree.find("Michael").getInfo()
				.getEmail());
		assertEquals("shade@gmail.com", docTree.find("Shade").getInfo()
				.getEmail());

		assertEquals("111 anywhere", docTree.find("Kevin").getInfo()
				.getAddress());
		assertEquals("888 anywhere", docTree.find("Nathan").getInfo()
				.getAddress());
		assertEquals("999 anywhere", docTree.find("Michael").getInfo()
				.getAddress());
		assertEquals("777 anywhere", docTree.find("Shade").getInfo()
				.getAddress());

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
		docTree.find("Shade").createPatient("Bob", "password", "userName",
				"email", "address", "state", "country", 55588555, 33033, 90887);
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getPassword(), "password");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getUserName(), "userName");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getEmail(), "email");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getAddress(), "address");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getState(), "state");
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getCountry(), "country");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getInfo().getSSN(),
				55588555);
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getInfo().getZip(),
				33033);
		assertEquals(docTree.find("Shade").getPatient("Bob").getInfo()
				.getBirthday(), 90887);

		docTree.find("Shade").createPatient("John", "password1", "userName1",
				"email1", "address1", "state1", "country1", 555885551, 330331,
				908871);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getPassword(), "password1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getUserName(), "userName1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getEmail(), "email1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getAddress(), "address1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getState(), "state1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getCountry(), "country1");
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getSSN(), 555885551);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getZip(), 330331);
		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getBirthday(), 908871);

		// Creating Appointments
		docTree.find("Shade").createAppt("Bob", 90811, 2, "Shade",
				"Stomach hurts and puking all of last night.");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getName(), "Bob");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getTime(), 2);
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getDate(), 90811);
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getReason(),
				"Stomach hurts and puking all of last night.");

		docTree.find("Shade").createAppt("Bob", 91411, 5, "Shade",
				"Stomach still hurts.");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getName(), "Bob");
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getTime(), 5);
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getDate(), 91411);
		assertEquals(
				docTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getReason(),
				"Stomach still hurts.");

		// Creating doctors orders
		docTree.find("Shade").createOrder("Bob", 91411, 6, "Drugs", "lab",
				"Take for x number of days.", "");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getDate(), 91411);
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getTime(), 6);
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getPrescription(),
				"Drugs");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getLabWork(), "lab");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getFollowUpIns(),
				"Take for x number of days.");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getOtherIns(), "");

		docTree.find("Shade").createOrder("Bob", 90811, 7, "Drugs2", "lab1",
				"Take for n number of days.", "other");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getDate(), 90811);
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getTime(), 7);
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getPrescription(),
				"Drugs2");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getLabWork(), "lab1");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getFollowUpIns(),
				"Take for n number of days.");
		assertEquals(
				docTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getOtherIns(), "other");

		docTree.find("Shade").createOrder("John", 70811, 7, "Drugs2", "lab1",
				"Take for n number of days.", "other");
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getDate(), 70811);
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getTime(), 7);
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getPrescription(),
				"Drugs2");
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getLabWork(), "lab1");
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getFollowUpIns(),
				"Take for n number of days.");
		assertEquals(
				docTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getOtherIns(),
				"other");

		// Creating treatment records
		docTree.find("Shade").createTreatmentRecords("Bob", 91411, 7,
				"Stomach hurts", 90, 75, 91, 6, 180);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getDate(), 91411);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getTime(), 7);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getSymptoms(), "Stomach hurts");
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getBloodPressure(), 90);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getPulse(), 75);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getTemperature(), 91);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getHeight(), 6);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getWeight(), 180);

		docTree.find("Shade").createTreatmentRecords("John", 81411, 3,
				"Stomach hurts again", 90, 75, 91, 6, 180);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getDate(), 81411);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTime(), 3);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getSymptoms(), "Stomach hurts again");
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getBloodPressure(), 90);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getPulse(), 75);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTemperature(), 91);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getHeight(), 6);
		assertEquals(
				docTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getWeight(), 180);

		// Creating patient invoice
		docTree.find("Shade")
				.createInvoice("Bob", "Shade", 2300, 100711, false);
		assertEquals(docTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getDueDate(), 100711);
		assertEquals(docTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getDoctor(), "Shade");
		assertEquals(docTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getTotal(), 2300);
		assertEquals(docTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getPaid(), false);

		docTree.find("Shade").createInvoice("John", "Shade", 2500, 112311,
				false);
		assertEquals(
				docTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDueDate(), 112311);
		assertEquals(
				docTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDoctor(), "Shade");
		assertEquals(
				docTree.find("Shade").getInvoice("John").find(112311, "John")
						.getTotal(), 2500);
		assertEquals(
				docTree.find("Shade").getInvoice("John").find(112311, "John")
						.getPaid(), false);

		// Deleting patients
		docTree.find("Shade").deletePatient("Bob");
		assertEquals(docTree.find("Shade").getPatient("Bob"), null);

		assertEquals(docTree.find("Shade").getPatient("John").getInfo()
				.getSSN(), 555885551);

		docTree.find("Shade").deletePatient("John");
		assertEquals(docTree.find("Shade").getPatient("John"), null);

	}

	/**
	 * Tests Nurse
	 */
	public void testCreateNurse() {
		AVL<String, Info> infoTree = new AVL<String, Info>();
		AVL<String, Nurse> nurTree = new AVL<String, Nurse>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com",
				"999 anywhere", "GA", "USA", 55541555, 33033, 91391, 2, false);
		Nurse nur0 = new Nurse(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com",
				"888 anywhere", "GA", "USA", 55542555, 33033, 72291, 2, false);
		Nurse nur1 = new Nurse(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com",
				"777 anywhere", "GA", "USA", 55543555, 33033, 82691, 2, false);
		Nurse nur2 = new Nurse(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com",
				"111 anywhere", "GA", "USA", 55544555, 33033, 41291, 2, false);
		Nurse nur3 = new Nurse(kInfo);

		nurTree.insert("Michael", nur0);
		nurTree.insert("Nathan", nur1);
		nurTree.insert("Shade", nur2);
		nurTree.insert("Kevin", nur3);

		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);

		nurTree.find("Michael").updateTree(new AVL<String, Patient>(), nurTree,
				new AVL<String, Doctor>(), infoTree);
		nurTree.find("Nathan").updateTree(new AVL<String, Patient>(), nurTree,
				new AVL<String, Doctor>(), infoTree);
		nurTree.find("Shade").updateTree(new AVL<String, Patient>(), nurTree,
				new AVL<String, Doctor>(), infoTree);
		nurTree.find("Kevin").updateTree(new AVL<String, Patient>(), nurTree,
				new AVL<String, Doctor>(), infoTree);

		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", nurTree.inorder());

		// Checks info classes stored within each doctor class stored in the
		// nurTree AVL tree
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

		assertEquals("kzhou@gmail.com", nurTree.find("Kevin").getInfo()
				.getEmail());
		assertEquals("nheard@gmail.com", nurTree.find("Nathan").getInfo()
				.getEmail());
		assertEquals("msimbal@gmail.com", nurTree.find("Michael").getInfo()
				.getEmail());
		assertEquals("shade@gmail.com", nurTree.find("Shade").getInfo()
				.getEmail());

		assertEquals("111 anywhere", nurTree.find("Kevin").getInfo()
				.getAddress());
		assertEquals("888 anywhere", nurTree.find("Nathan").getInfo()
				.getAddress());
		assertEquals("999 anywhere", nurTree.find("Michael").getInfo()
				.getAddress());
		assertEquals("777 anywhere", nurTree.find("Shade").getInfo()
				.getAddress());

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

		// Testing create patient method
		nurTree.find("Shade").createPatient("Bob", "password", "userName",
				"email", "address", "state", "country", 55588555, 33033, 90887);
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getPassword(), "password");
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getUserName(), "userName");
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getEmail(), "email");
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getAddress(), "address");
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getState(), "state");
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getCountry(), "country");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getInfo().getSSN(),
				55588555);
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getInfo().getZip(),
				33033);
		assertEquals(nurTree.find("Shade").getPatient("Bob").getInfo()
				.getBirthday(), 90887);

		nurTree.find("Shade").createPatient("John", "password1", "userName1",
				"email1", "address1", "state1", "country1", 555885551, 330331,
				908871);
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getPassword(), "password1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getUserName(), "userName1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getEmail(), "email1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getAddress(), "address1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getState(), "state1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getCountry(), "country1");
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getSSN(), 555885551);
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getZip(), 330331);
		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getBirthday(), 908871);

		// Creating Appointments
		nurTree.find("Shade").createAppt("Bob", 90811, 2, "Shade",
				"Stomach hurts and puking all of last night.");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getName(), "Bob");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getTime(), 2);
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getDate(), 90811);
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(90811, 2, "Bob", "Shade").getReason(),
				"Stomach hurts and puking all of last night.");

		nurTree.find("Shade").createAppt("Bob", 91411, 5, "Shade",
				"Stomach still hurts.");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getName(), "Bob");
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getTime(), 5);
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getDate(), 91411);
		assertEquals(
				nurTree.find("Shade").getPatient("Bob").getAppt()
						.find(91411, 5, "Bob", "Shade").getReason(),
				"Stomach still hurts.");

		// Creating doctors orders
		nurTree.find("Shade").createOrder("Bob", 91411, 6, "Drugs", "lab",
				"Take for x number of days.", "");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getDate(), 91411);
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getTime(), 6);
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getPrescription(),
				"Drugs");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getLabWork(), "lab");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getFollowUpIns(),
				"Take for x number of days.");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(91411, 6, "Bob", "Drugs").getOtherIns(), "");

		nurTree.find("Shade").createOrder("Bob", 90811, 7, "Drugs2", "lab1",
				"Take for n number of days.", "other");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getDate(), 90811);
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getTime(), 7);
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getPrescription(),
				"Drugs2");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getLabWork(), "lab1");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getFollowUpIns(),
				"Take for n number of days.");
		assertEquals(
				nurTree.find("Shade").getOrders("Bob")
						.find(90811, 7, "Bob", "Drugs2").getOtherIns(), "other");

		nurTree.find("Shade").createOrder("John", 70811, 7, "Drugs2", "lab1",
				"Take for n number of days.", "other");
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getDate(), 70811);
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getTime(), 7);
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getPrescription(),
				"Drugs2");
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getLabWork(), "lab1");
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getFollowUpIns(),
				"Take for n number of days.");
		assertEquals(
				nurTree.find("Shade").getOrders("John")
						.find(70811, 7, "John", "Drugs2").getOtherIns(),
				"other");

		// Creating treatment records
		nurTree.find("Shade").createTreatmentRecords("Bob", 91411, 7,
				"Stomach hurts", 90, 75, 91, 6, 180);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getDate(), 91411);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getTime(), 7);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getSymptoms(), "Stomach hurts");
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getBloodPressure(), 90);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getPulse(), 75);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getTemperature(), 91);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getHeight(), 6);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("Bob").find(91411, 7)
						.getWeight(), 180);

		nurTree.find("Shade").createTreatmentRecords("John", 81411, 3,
				"Stomach hurts again", 90, 75, 91, 6, 180);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getDate(), 81411);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTime(), 3);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getSymptoms(), "Stomach hurts again");
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getBloodPressure(), 90);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getPulse(), 75);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTemperature(), 91);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getHeight(), 6);
		assertEquals(
				nurTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getWeight(), 180);

		// Creating patient invoice
		nurTree.find("Shade")
				.createInvoice("Bob", "Shade", 2300, 100711, false);
		assertEquals(nurTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getDueDate(), 100711);
		assertEquals(nurTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getDoctor(), "Shade");
		assertEquals(nurTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getTotal(), 2300);
		assertEquals(nurTree.find("Shade").getInvoice("Bob")
				.find(100711, "Bob").getPaid(), false);

		nurTree.find("Shade").createInvoice("John", "Shade", 2500, 112311,
				false);
		assertEquals(
				nurTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDueDate(), 112311);
		assertEquals(
				nurTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDoctor(), "Shade");
		assertEquals(
				nurTree.find("Shade").getInvoice("John").find(112311, "John")
						.getTotal(), 2500);
		assertEquals(
				nurTree.find("Shade").getInvoice("John").find(112311, "John")
						.getPaid(), false);

		// Deleting patients
		nurTree.find("Shade").deletePatient("Bob");
		assertEquals(nurTree.find("Shade").getPatient("Bob"), null);

		assertEquals(nurTree.find("Shade").getPatient("John").getInfo()
				.getSSN(), 555885551);

		nurTree.find("Shade").deletePatient("John");
		assertEquals(nurTree.find("Shade").getPatient("John"), null);
	}

	/**
	 * Tests patient
	 */
	public void testCreatePatient() {
		AVL<String, Patient> patientTree = new AVL<String, Patient>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com",
				"999 anywhere", "GA", "USA", 55541555, 33033, 91391, 3, false);
		Patient p0 = new Patient(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com",
				"888 anywhere", "GA", "USA", 55542555, 33033, 72291, 3, false);
		Patient p1 = new Patient(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com",
				"777 anywhere", "GA", "USA", 55543555, 33033, 82691, 3, false);
		Patient p2 = new Patient(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com",
				"111 anywhere", "GA", "USA", 55544555, 33033, 41291, 3, false);
		Patient p3 = new Patient(kInfo);

		patientTree.insert("Michael", p0);
		patientTree.insert("Nathan", p1);
		patientTree.insert("Shade", p2);
		patientTree.insert("Kevin", p3);

		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", patientTree.inorder());

		// Checks info classes stored within each doctor class stored in the
		// patientTree AVL tree
		assertEquals("Kevin", patientTree.find("Kevin").getInfo().getName());
		assertEquals("Nathan", patientTree.find("Nathan").getInfo().getName());
		assertEquals("Michael", patientTree.find("Michael").getInfo().getName());
		assertEquals("Shade", patientTree.find("Shade").getInfo().getName());

		assertEquals("kk", patientTree.find("Kevin").getInfo().getPassword());
		assertEquals("nn", patientTree.find("Nathan").getInfo().getPassword());
		assertEquals("mm", patientTree.find("Michael").getInfo().getPassword());
		assertEquals("ss", patientTree.find("Shade").getInfo().getPassword());

		assertEquals("kzhou", patientTree.find("Kevin").getInfo().getUserName());
		assertEquals("nheard", patientTree.find("Nathan").getInfo()
				.getUserName());
		assertEquals("msimbal", patientTree.find("Michael").getInfo()
				.getUserName());
		assertEquals("shade3", patientTree.find("Shade").getInfo()
				.getUserName());

		assertEquals("kzhou@gmail.com", patientTree.find("Kevin").getInfo()
				.getEmail());
		assertEquals("nheard@gmail.com", patientTree.find("Nathan").getInfo()
				.getEmail());
		assertEquals("msimbal@gmail.com", patientTree.find("Michael").getInfo()
				.getEmail());
		assertEquals("shade@gmail.com", patientTree.find("Shade").getInfo()
				.getEmail());

		assertEquals("111 anywhere", patientTree.find("Kevin").getInfo()
				.getAddress());
		assertEquals("888 anywhere", patientTree.find("Nathan").getInfo()
				.getAddress());
		assertEquals("999 anywhere", patientTree.find("Michael").getInfo()
				.getAddress());
		assertEquals("777 anywhere", patientTree.find("Shade").getInfo()
				.getAddress());

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

		// Creating Appointments
		patientTree.find("Shade").createAppt(90811, 2, "Shade", "Michael",
				"Stomach hurts and puking all of last night.");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(90811, 2, "Shade", "Michael").getDoctor(),
				"Michael");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(90811, 2, "Shade", "Michael").getName(), "Shade");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(90811, 2, "Shade", "Michael").getTime(), 2);
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(90811, 2, "Shade", "Michael").getDate(), 90811);
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(90811, 2, "Shade", "Michael").getReason(),
				"Stomach hurts and puking all of last night.");

		patientTree.find("Shade").createAppt(91411, 5, "Shade", "Michael",
				"Stomach still hurts.");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(91411, 5, "Shade", "Michael").getDoctor(),
				"Michael");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(91411, 5, "Shade", "Michael").getName(), "Shade");
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(91411, 5, "Shade", "Michael").getTime(), 5);
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(91411, 5, "Shade", "Michael").getDate(), 91411);
		assertEquals(
				patientTree.find("Shade").getAppt()
						.find(91411, 5, "Shade", "Michael").getReason(),
				"Stomach still hurts.");

		// Searching for doctors
		AVL<String, Doctor> docTree = new AVL<String, Doctor>();
		mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com",
				"999 anywhere", "GA", "USA", 55541555, 33033, 91391, 1, false);
		Doctor doc0 = new Doctor(mInfo);

		docTree.insert("Michael", doc0);
		p0.updateTree(patientTree, docTree);
		assertEquals(p0.Search("Michael").getInfo().getName(), "Michael");
		assertEquals(p0.Search("Todd"), null);
	}

	/**
	 * Tests admin
	 */
	public void testCreateAdmin() {
		AVL<String, Info> infoTree = new AVL<String, Info>();
		AVL<String, SystemAdmin> adminTree = new AVL<String, SystemAdmin>();
		Info mInfo = new Info("Michael", "mm", "msimbal", "msimbal@gmail.com",
				"999 anywhere", "GA", "USA", 55541555, 33033, 91391, 0, false);
		SystemAdmin nur0 = new SystemAdmin(mInfo);
		Info nInfo = new Info("Nathan", "nn", "nheard", "nheard@gmail.com",
				"888 anywhere", "GA", "USA", 55542555, 33033, 72291, 0, false);
		SystemAdmin nur1 = new SystemAdmin(nInfo);
		Info sInfo = new Info("Shade", "ss", "shade3", "shade@gmail.com",
				"777 anywhere", "GA", "USA", 55543555, 33033, 82691, 0, false);
		SystemAdmin nur2 = new SystemAdmin(sInfo);
		Info kInfo = new Info("Kevin", "kk", "kzhou", "kzhou@gmail.com",
				"111 anywhere", "GA", "USA", 55544555, 33033, 41291, 0, false);
		SystemAdmin nur3 = new SystemAdmin(kInfo);

		adminTree.insert("Michael", nur0);
		adminTree.insert("Nathan", nur1);
		adminTree.insert("Shade", nur2);
		adminTree.insert("Kevin", nur3);

		infoTree.insert("Michael", mInfo);
		infoTree.insert("Nathan", nInfo);
		infoTree.insert("Shade", sInfo);
		infoTree.insert("Kevin", kInfo);

		adminTree.find("Michael").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree,
				infoTree);
		adminTree.find("Nathan").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree,
				infoTree);
		adminTree.find("Shade").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree,
				infoTree);
		adminTree.find("Kevin").updateTree(new AVL<String, Patient>(),
				new AVL<String, Nurse>(), new AVL<String, Doctor>(), adminTree,
				infoTree);

		// Checks tree order
		assertEquals("Kevin Michael Nathan Shade ", adminTree.inorder());

		// Checks info classes stored within each doctor class stored in the
		// adminTree AVL tree
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
		assertEquals("msimbal", adminTree.find("Michael").getInfo()
				.getUserName());
		assertEquals("shade3", adminTree.find("Shade").getInfo().getUserName());

		assertEquals("kzhou@gmail.com", adminTree.find("Kevin").getInfo()
				.getEmail());
		assertEquals("nheard@gmail.com", adminTree.find("Nathan").getInfo()
				.getEmail());
		assertEquals("msimbal@gmail.com", adminTree.find("Michael").getInfo()
				.getEmail());
		assertEquals("shade@gmail.com", adminTree.find("Shade").getInfo()
				.getEmail());

		assertEquals("111 anywhere", adminTree.find("Kevin").getInfo()
				.getAddress());
		assertEquals("888 anywhere", adminTree.find("Nathan").getInfo()
				.getAddress());
		assertEquals("999 anywhere", adminTree.find("Michael").getInfo()
				.getAddress());
		assertEquals("777 anywhere", adminTree.find("Shade").getInfo()
				.getAddress());

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

		// Creating users
		adminTree.find("Shade").createUser("Bob", "password", "userName",
				"email", "address", "state", "country", 55588555, 33033, 90887,
				3);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getPassword(), "password");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getUserName(), "userName");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getEmail(), "email");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getAddress(), "address");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getState(), "state");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getCountry(), "country");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getSSN(), 55588555);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getZip(), 33033);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getInfo().getBirthday(), 90887);

		adminTree.find("Shade").createUser("John", "password1", "userName1",
				"email1", "address1", "state1", "country1", 555885551, 330331,
				908871, 3);
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getPassword(), "password1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getUserName(), "userName1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getEmail(), "email1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getAddress(), "address1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getState(), "state1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getCountry(), "country1");
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getSSN(), 555885551);
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getZip(), 330331);
		assertEquals(((Patient) adminTree.find("Shade").Search("John", 3))
				.getInfo().getBirthday(), 908871);

		// Creating Appointments
		adminTree.find("Shade").createAppt("Bob", 90811, 2, "Shade",
				"Stomach hurts and puking all of last night.");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(90811, 2, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(90811, 2, "Bob", "Shade").getName(), "Bob");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(90811, 2, "Bob", "Shade").getTime(), 2);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(90811, 2, "Bob", "Shade").getDate(), 90811);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(90811, 2, "Bob", "Shade").getReason(),
				"Stomach hurts and puking all of last night.");

		adminTree.find("Shade").createAppt("Bob", 91411, 5, "Shade",
				"Stomach still hurts.");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(91411, 5, "Bob", "Shade").getDoctor(), "Shade");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(91411, 5, "Bob", "Shade").getName(), "Bob");
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(91411, 5, "Bob", "Shade").getTime(), 5);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(91411, 5, "Bob", "Shade").getDate(), 91411);
		assertEquals(((Patient) adminTree.find("Shade").Search("Bob", 3))
				.getAppt().find(91411, 5, "Bob", "Shade").getReason(),
				"Stomach still hurts.");

		// Creating treatment records
		adminTree.find("Shade").createTreatmentRecords("Bob", 91411, 7,
				"Stomach hurts", 90, 75, 91, 6, 180);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getDate(), 91411);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getTime(), 7);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getSymptoms(), "Stomach hurts");
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getBloodPressure(), 90);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getPulse(), 75);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getTemperature(), 91);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getHeight(), 6);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("Bob")
						.find(91411, 7).getWeight(), 180);

		adminTree.find("Shade").createTreatmentRecords("John", 81411, 3,
				"Stomach hurts again", 90, 75, 91, 6, 180);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getDate(), 81411);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTime(), 3);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getSymptoms(), "Stomach hurts again");
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getBloodPressure(), 90);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getPulse(), 75);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getTemperature(), 91);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getHeight(), 6);
		assertEquals(
				adminTree.find("Shade").getTreatmentRecords("John")
						.find(81411, 3).getWeight(), 180);

		// Creating patient invoice
		adminTree.find("Shade").createInvoice("Bob", "Shade", 2300, 100711,
				false);
		assertEquals(
				adminTree.find("Shade").getInvoice("Bob").find(100711, "Bob")
						.getDueDate(), 100711);
		assertEquals(
				adminTree.find("Shade").getInvoice("Bob").find(100711, "Bob")
						.getDoctor(), "Shade");
		assertEquals(
				adminTree.find("Shade").getInvoice("Bob").find(100711, "Bob")
						.getTotal(), 2300);
		assertEquals(
				adminTree.find("Shade").getInvoice("Bob").find(100711, "Bob")
						.getPaid(), false);

		adminTree.find("Shade").createInvoice("John", "Shade", 2500, 112311,
				false);
		assertEquals(
				adminTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDueDate(), 112311);
		assertEquals(
				adminTree.find("Shade").getInvoice("John").find(112311, "John")
						.getDoctor(), "Shade");
		assertEquals(
				adminTree.find("Shade").getInvoice("John").find(112311, "John")
						.getTotal(), 2500);
		assertEquals(
				adminTree.find("Shade").getInvoice("John").find(112311, "John")
						.getPaid(), false);
	}

	/**
	 * Tests login
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void testLogin() throws IOException {
		Login lg = new Login();

		// Loads the system's AVL trees with its corresponding text files
		lg.setup();
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getName(), "Nathan");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getPassword(), "password");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getUserName(), "nheard");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getEmail(), "aronijin@gg");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getAddress(), "111 Somewhere USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getSSN(), 444555667);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Nathan")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getName(), "Michael");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getPassword(), "people");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getUserName(), "msimbal");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getEmail(), "msimbal@gg");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getAddress(), "987 Somewhere USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getSSN(), 444555678);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Michael")
				.getInfo().getType(), 0);

		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getName(), "Kevin Zhou");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getPassword(), "cast");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getUserName(), "kevin3");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getEmail(), "kevin3@gg");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getAddress(), "789 Somewhere USA");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getState(), "GA");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getCountry(), "USA");
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getSSN(), 444555789);
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getZip(), 30000);
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getBirthday(), 72291);
		assertEquals(
				((AVL<String, SystemAdmin>) lg.getTree(0)).find("Kevin Zhou")
						.getInfo().getType(), 0);

		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getName(), "Shade");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getPassword(), "kami");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getUserName(), "shade3");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getEmail(), "shade@gg");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getAddress(), "888 Somewhere USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getSSN(), 444565667);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, SystemAdmin>) lg.getTree(0)).find("Shade")
				.getInfo().getType(), 0);

		// Doctors
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getName(), "Nathan");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getPassword(), "godisok");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getUserName(), "nheard");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getEmail(), "aronijin@gg");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getAddress(), "111 Somewhere USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getSSN(), 444555667);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Nathan")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getName(), "Michael");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getPassword(), "people");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getUserName(), "msimbal");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getEmail(), "msimbal@gg");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getAddress(), "987 Somewhere USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getSSN(), 444555678);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Michael")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getName(), "Kevin Zhou");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getPassword(), "cast");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getUserName(), "kevin3");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getEmail(), "kevin3@gg");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getAddress(), "789 Somewhere USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getSSN(), 444555789);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Kevin Zhou")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getName(), "Shade");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getPassword(), "kami");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getUserName(), "shade3");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getEmail(), "shade@gg");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getAddress(), "888 Somewhere USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getSSN(), 444565667);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Doctor>) lg.getTree(1)).find("Shade")
				.getInfo().getType(), 0);

		// Nurses
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getName(), "Nathan");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getPassword(), "godisok");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getUserName(), "nheard");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getEmail(), "aronijin@gg");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getAddress(), "111 Somewhere USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getSSN(), 444555667);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Nathan")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getName(), "Michael");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getPassword(), "people");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getUserName(), "msimbal");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getEmail(), "msimbal@gg");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getAddress(), "987 Somewhere USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getSSN(), 444555678);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Michael")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getName(), "Kevin Zhou");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getPassword(), "cast");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getUserName(), "kevin3");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getEmail(), "kevin3@gg");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getAddress(), "789 Somewhere USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getSSN(), 444555789);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Kevin Zhou")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getName(), "Shade");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getPassword(), "kami");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getUserName(), "shade3");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getEmail(), "shade@gg");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getAddress(), "888 Somewhere USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getSSN(), 444565667);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Nurse>) lg.getTree(2)).find("Shade")
				.getInfo().getType(), 0);

		// Patients
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getName(), "Nathan");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getPassword(), "godisok");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getUserName(), "nheard");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getEmail(), "aronijin@gg");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getAddress(), "111 Somewhere USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getSSN(), 444555667);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Nathan")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getName(), "Michael");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getPassword(), "people");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getUserName(), "msimbal");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getEmail(), "msimbal@gg");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getAddress(), "987 Somewhere USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getSSN(), 444555678);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Michael")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getName(), "Kevin Zhou");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getPassword(), "cast");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getUserName(), "kevin3");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getEmail(), "kevin3@gg");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getAddress(), "789 Somewhere USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getSSN(), 444555789);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Kevin Zhou")
				.getInfo().getType(), 0);

		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getName(), "Shade");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getPassword(), "kami");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getUserName(), "shade3");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getEmail(), "shade@gg");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getAddress(), "888 Somewhere USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getState(), "GA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getCountry(), "USA");
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getSSN(), 444565667);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getZip(), 30000);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getBirthday(), 72291);
		assertEquals(((AVL<String, Patient>) lg.getTree(3)).find("Shade")
				.getInfo().getType(), 0);

		// Testing the login method
		assertEquals(lg.loginUser("Shade", "kami", 0), 1);
		assertEquals(lg.loginUser("Shade", "kami", 1), 1);
		assertEquals(lg.loginUser("Shade", "kami", 2), 1);
		assertEquals(lg.loginUser("Shade", "kami", 3), 1);

		assertEquals(lg.loginUser("Kevin Zhou", "cast", 0), 1);
		assertEquals(lg.loginUser("Kevin Zhou", "cast", 1), 1);
		assertEquals(lg.loginUser("Kevin Zhou", "cast", 2), 1);
		assertEquals(lg.loginUser("Kevin Zhou", "cast", 3), 1);

		assertEquals(lg.loginUser("Nathan", "password", 0), 1);
		assertEquals(lg.loginUser("Nathan", "godisok", 1), 1);
		assertEquals(lg.loginUser("Nathan", "godisok", 2), 1);
		assertEquals(lg.loginUser("Nathan", "godisok", 3), 1);

		assertEquals(lg.loginUser("Michael", "people", 0), 1);
		assertEquals(lg.loginUser("Michael", "people", 1), 1);
		assertEquals(lg.loginUser("Michael", "people", 2), 1);
		assertEquals(lg.loginUser("Michael", "people", 3), 1);

		// Saves the contents of the system to its corresponding texts files
		lg.createUser("Bob", "password", "userName", "email", "address",
				"state", "country", 55588555, 33033, 90887, 3);
		lg.createUser("Bob", "password", "userName", "email", "address",
				"state", "country", 55588555, 33033, 90887, 2);
		lg.createUser("Bob", "password", "userName", "email", "address",
				"state", "country", 55588555, 33033, 90887, 1);
		lg.createUser("Bob", "password", "userName", "email", "address",
				"state", "country", 55588555, 33033, 90887, 0);
		lg.save();
	}

}
