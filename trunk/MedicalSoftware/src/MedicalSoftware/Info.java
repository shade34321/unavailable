package MedicalSoftware;

/**
 * Holds a user's information
 * 
 * @author Nathan Heard
 * 
 */
public class Info {

	private String name, email, password, userName, address, state, country;
	
	private int SSN, birthday, zip, type;
	
	private boolean suspention;
	
	private Appointment appt;
	
	private DoctorsOrders orders;
	
	private TreatmentRecords record;
	
	private PatientInvoice invoice;

	/**
	 * Constructor
	 * 
	 * @param type
	 */
	public Info(int type) {
		this.name = null;
		this.userName = null;
		this.email = null;
		this.address = null;
		this.state = null;
		this.country = null;
		this.SSN = 0;
		this.birthday = 0;
		this.zip = 0;
		this.type = type;
		this.suspention = false;
		this.appt = new Appointment();
		this.orders = new DoctorsOrders();
		this.record = new TreatmentRecords();
		this.invoice = new PatientInvoice();
	}

	/**
	 * Creating user information and then storing them in the class
	 * 
	 * @param name
	 * @param password
	 * @param userName
	 * @param email
	 * @param address
	 * @param state
	 * @param country
	 * @param SSN
	 * @param zip
	 * @param birthday
	 * @param type
	 * @param susp
	 */
	public Info(String name, String password, String userName, String email,
			String address, String state, String country, int SSN, int zip,
			int birthday, int type, boolean susp) {
		this.name = name;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.state = state;
		this.country = country;
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

	public String getCountry() {
		return this.country;
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

	public boolean isSusp() {
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

	public void setCountry(String country) {
		this.country = country;
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

	public void setSusp(boolean susp) {
		this.suspention = susp;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setAppt(Appointment appt) {
		this.appt = appt;
	}

	public Appointment getAppt() {
		return appt;
	}

	public void setOrders(DoctorsOrders orders) {
		this.orders = orders;
	}

	public DoctorsOrders getOrders() {
		return orders;
	}

	public void setRecord(TreatmentRecords record) {
		this.record = record;
	}

	public TreatmentRecords getRecord() {
		return record;
	}

	public void setInvoice(PatientInvoice invoice) {
		this.invoice = invoice;
	}

	public PatientInvoice getInvoice() {
		return invoice;
	}
}
