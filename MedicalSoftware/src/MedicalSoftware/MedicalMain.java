package MedicalSoftware;

import java.io.IOException;

/**
 * Includes a main method used for testing
 * 
 * @author Nathan Heard
 * 
 */
public class MedicalMain {
	public static AVL<String, String> inform;

	/**
	 * Main method used for testing
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Server ser = new Server();
		AVL<String, Info> informationUserName = ser.load();
		AVL<String, Info> informationName = ser.load();
		setup(informationName);
		
		informationName = ser.loadAppt(informationName);
		
		informationName = ser.loadTreatment(informationName);
		
		informationName = ser.loadOrders(informationName);
		
		informationName = ser.loadInvoice(informationName);
		
		//Login log = new Login(informationUserName, informationName);
		//LoginUI logging = new LoginUI(log);
		ser.saveAppt(informationName);
		ser.save(informationUserName);
		ser.saveTreatment(informationName);
		ser.saveOrders(informationName);
		ser.saveInvoice(informationName);
	}

	/*
	 * setUp creates the ArrayList of names to enable searching by names
	 */
	private static AVL<String, Info> setup(AVL<String, Info> form) {
		// TODO Auto-generated method stub
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