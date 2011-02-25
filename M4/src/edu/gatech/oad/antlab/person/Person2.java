package edu.gatech.oad.antlab.person;
import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	 
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	
		// Random number generator
		Random rand = new Random();
		// Temporary value for new string
		int temp;
		// Input string as array
		char[] ch = input.toCharArray();
		// Array for random string
		char[] random = new char[input.length()];

		// Initialize new array with spaces
		for (int i = 0; i < input.length(); i++)
			random[i] = ' ';

		// For each character in the input array, find a new, random position
		for (int j = 0; j < input.length(); j++) {
			temp = rand.nextInt(input.length());
			while (random[temp] != ' ') {
				temp = rand.nextInt(input.length());
			}
			random[temp] = ch[j];
		}

		// String to return
		String message = new String(random);
		return message;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
