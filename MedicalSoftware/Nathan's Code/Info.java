package MedicalSoftware;

public class Info {
	
	private String name, email, userName, address, state;
	private int SSN, birthday, zip, type;
	private Boolean suspention;
	
	// Creating user information and then storing them in the class
	Info (String name, String userName, String email, String address, String state, int SSN, int zip, int birthday, int type, Boolean susp) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.state = state;
		this.SSN = SSN;
		this.birthday = birthday;
		this.zip = zip;
		this.type = type;
		this.suspention = susp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getState() {
		return this.state;
	}
	
	public int getSSN() {
		return this.SSN;
	}
	
	public int getBirthday() {
		return this.birthday;
	}
	
	public int getZip() {
		return this.zip;
	}
	
	public int getType() {
		return this.type;
	}
	
	public Boolean getSusp() {
		return this.suspention;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setSSN(int SSN) {
		this.SSN = SSN;
	}
	
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setSusp(Boolean susp) {
		this.suspention = susp;
	}
}
