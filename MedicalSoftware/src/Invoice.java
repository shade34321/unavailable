package MedicalSoftware;

/**
 * Stores the information for an invoice
 * 
 * @author Nathan Heard
 *
 */
public class Invoice {
	private String name, doctor;
	private int dueDate, total;
	private boolean paid;
	
	
	/**
	 * Basic constructor
	 */
	Invoice() {
		this.name = "N/A";
		this.doctor = "N/A";
		this.dueDate = 0;
		this.total = 0;
		this.paid = false;
	}
	
	/**
	 * Advanced constructor for accepting variables
	 * 
	 * @param name
	 * @param doc
	 * @param total
	 * @param due
	 * @param paid
	 */
	Invoice(String name, String doc, int total, int due, boolean paid) {
		this.name = name;
		this.doctor = doc;
		this.total = total;
		this.dueDate = due;
		this.paid = paid;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDoctor() {
		return this.doctor;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public int getDueDate() {
		return this.dueDate;
	}
	
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public boolean getPaid() {
		return this.paid;
	}
	
	public void setPaid(boolean pay) {
		this.paid = pay;
	}
}
