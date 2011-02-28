package edu.gatech.oad.antlab.person;
/**
 * A simple class for person 4 returns their name and a modified string
 * 
 * @author Bob
 * @version 1.1
 */
public class Person4 {
	/** Holds the persons real name */
	private String name;

	/**
	 * The constructor, takes in the persons name
	 * 
	 * @param pname
	 *            the person's real name
	 */
	public Person4(String pname) {
		name = pname;
	}

	/**
	 * This method should take the string input and return its characters
	 * rotated 2 positions. given "gtg123b" it should return "g123bgt".
	 * 
	 * @param input
	 *            the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
		// Person 4 put your implementation here
		char[] array = new char[input.length()];
		char[] arrayInput = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			if (i == input.length() - 2) {
				array[0] = arrayInput[i];
			}
			else if (i == input.length() - 1) {
				array[1] = arrayInput[i];
			} else {
				array[i + 2] = arrayInput[i];
			}
		}
		String name = new String(array);
		return name;
	}

	/**
	 * Return a string rep of this object that varies with an input string
	 * 
	 * @param input
	 *            the varying string
	 * @return the string representing the object
	 */
	public String toString(String input) {
		return name + calc(input);
	}
}
