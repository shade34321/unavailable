package MedicalSoftware;

public class Invoice {
	private String name, doctor;
	private int dueDate, total;
	private Boolean paid;
	
	// Basic constructor
	Invoice() {
		this.name = "N/A";
		this.doctor = "N/A";
		this.dueDate = 0;
		this.total = 0;
		this.paid = false;
	}
	
	// Advanced constructor for accepting variables
	Invoice(String name, String doc, int total, int due, Boolean paid) {
		this.name = name;
		this.doctor = doc;
		this.total = total;
		this.dueDate = due;
		this.paid = paid;
	}
	
	// Getters and setters
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocotr() {
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
	
	public Boolean getPaid() {
		return this.paid;
	}
	
	public void setPaid(Boolean pay) {
		this.paid = pay;
	}
}