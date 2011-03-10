
public interface User {
	/**
	 * sets suspensions
	 * takes in a name and boolean and returns a string
	 * @param String and Boolean
	 * @return String
	 */
	public void setSusp(String name, Boolean susp);
	
	/**
	 * gets Suspension status
	 * Takes in a name and returns a boolean
	 * @param String
	 * @return Boolean
	 */
	
	public Boolean getSusp(String name);
	
	/**
	 * allows user to view the record
	 * Takes in name and switches view to allow the user to view the record
	 * @param String
	 */
	public void viewRecords(String name);
	
	/**
	 * 
	 */
	
}
