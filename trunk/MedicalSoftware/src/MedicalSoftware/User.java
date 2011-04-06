package MedicalSoftware;


/**
 * This interface represents one of the four types of users
 * 
 * @author Nathan Heard
 *
 */
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
	
	public Info getInfo();
	
	public void setInfo(Info info);
	
	public Info findInfo(String user);
}
