package MedicalSoftware;

import java.util.ArrayList;

/**
 * PatientInvoice class designed to create a bill for patients
 * 
 * @author Nathan Heard
 * 
 */
public class PatientInvoice {

	private ArrayList<Invoice> invoice;

	/**
	 * Constructor
	 */
	public PatientInvoice() {
		invoice = new ArrayList<Invoice>();
	}

	/**
	 * Creates a new invoice
	 * 
	 * @param name
	 * @param doc
	 * @param total
	 * @param due
	 * @param paid
	 */
	public void create(String name, String doc, int total, int due, Boolean paid) {
		Invoice in = new Invoice(name, doc, total, due, paid);
		invoice.add(in);
	}

	/**
	 * Search by name and due date
	 * 
	 * @param due
	 * @param name
	 * @return Invoice
	 */
	public Invoice find(int due, String name) {
		int size = invoice.size();
		for (int i = 0; i < size; i++) {
			if (invoice.get(i).getName() == name) {
				if (invoice.get(i).getDueDate() == due) {
					return invoice.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Search by name and due date
	 * 
	 * @param due
	 * @param name
	 */
	public void cancel(int due, String name) {
		int size = invoice.size();
		for (int i = 0; i < size; i++) {
			if (invoice.get(i).getName() == name) {
				if (invoice.get(i).getDueDate() == due) {
					invoice.remove(i);
				}
			}
		}
	}

	public ArrayList<Invoice> getInvoice() {
		return this.invoice;
	}
}
