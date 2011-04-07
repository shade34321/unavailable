package MedicalSoftware;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Includes a main method used for testing
 * 
 * @author Nathan Heard
 *
 */
public class MedicalMain {
	static AVL<String, String> inform;
	/**
	 * Main method used for testing
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Server ser = new Server();
		AVL<String, Info> informationUserName = ser.load();
		AVL<String, Info> informationName = setup(informationUserName);
		//Login log = new Login(information);
	}

	/*
	 * setUp creates the ArrayList of names to enable searching by names
	 * 
	 */
	private static AVL<String, Info> setup(AVL<String, Info> form) {
		// TODO Auto-generated method stub
		BSTNode<String, Info> temp = form.getRoot();
		AVL<String, Info> avl = new AVL<String, Info>();
		avl.setRoot(setNames(temp));
		return avl;
	}
	
	/*
	 * setNames creates a binary tree using the user's name as the key instead of username
	 */
	private static BSTNode<String, Info> setNames(BSTNode<String, Info> temp) {
		
		if (temp != null) {
			setNames(temp.getLeft());
			temp.setKey(temp.getValue().getName());
			setNames(temp.getRight());
		}
		return temp;
	}
}