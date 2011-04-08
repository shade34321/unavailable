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

	public void testCreateUserandTestSaveandTestLoad(){
		Server ser = new Server(); 
		AVL<String,Info> tree = ser.load();
		AVL<String,Info> treeName = ser.load();
		setup(treeName);
		SystemAdmin nathan = new SystemAdmin("nheard",tree,treeName);
		
		// Create new user
		nathan.createUser("Michael2", "password", "msambol2", "sambolmd@gmail.com",
			"9953 Drive", "NE", "USA", 505923212, 68114,
			3031991, 3);
		assertEquals(tree.find("msambol2").getName(),"Michael2");
		assertEquals(tree.find("msambol2").getSSN(),505923212);
		assertEquals(tree.find("msambol2").getPassword(),"password");
		assertEquals(tree.find("msambol2").getAddress(),"9953 Drive");
		assertEquals(tree.find("msambol2").getEmail(),"sambolmd@gmail.com");
		assertEquals(tree.find("msambol2").getCountry(),"USA");
		assertEquals(tree.find("msambol2").getState(),"NE");
		
		// Save patient		
		ser.save(tree);
		assertEquals(tree.getRoot(),null);
		tree = ser.load();
		
		
		// Delete user
		nathan.deleteUser("Michael2");
		assertEquals(treeName.find("Michael2"), null);
		ser.save(treeName);
	}
	
	public void testCreateAppt(){
		Server ser = new Server(); 
		AVL<String,Info> tree = ser.load();
		AVL<String,Info> treeName = ser.load();
		setup(treeName);
		Patient nathan = new Patient("nheard",tree,treeName);
		nathan.getInfo().setAppt(new Appointment());
		
		// Create new appointment
		nathan.createAppt(4112011, 1030, "Nathan", "Dr. Sambol", "Sick as a dog");
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol").getDate(), 4112011);
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol").getTime(), 1030);
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol").getDoctor(), "Dr. Sambol");
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol").getReason(), "Sick as a dog");
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol").getName(), "Nathan");
		
		// Delete appointment
		nathan.cancelAppt(4112011, 1030, "Nathan", "Dr. Sambol");
		assertEquals(nathan.getAppt().find(4112011, 1030, "Nathan",	"Dr. Sambol"), null);
	}
	
	public void testLogin(){
		Server ser = new Server(); 
		AVL<String,Info> tree = ser.load();
		AVL<String,Info> treeName = ser.load();
		setup(treeName);
		Login log = new Login(tree,treeName);
		
		// Test correct login
		assertEquals(log.loginUser("msambol", "pe"),1);
		
		// Test suspensions
		assertEquals(log.loginUser("msambol", "p3e"),0);
		assertEquals(log.loginUser("msambol", "p3e"),0);
		assertEquals(log.loginUser("msambol", "p3e"),0);
		assertEquals(log.loginUser("msambol", "p3e"),-1);
		
	}
	
	private static AVL<String, Info> setup(AVL<String, Info> form) {
		BSTNode<String, Info> temp = form.getRoot();
		AVL<String, Info> avl = new AVL<String, Info>();
		avl.setRoot(createNames(temp));
		return avl;
	}

	/*
	 * createNames creates a binary tree using the user's name as the key
	 * instead of username
	 */
	private static BSTNode<String, Info> createNames(BSTNode<String, Info> temp) {

		if (temp != null) {
			createNames(temp.getLeft());
			temp.setKey(temp.getValue().getName());
			createNames(temp.getRight());
		}
		return temp;
	}

}
