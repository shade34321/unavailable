package MedicalSoftware;

import java.util.ArrayList;

/**
 * This class creates, finds, and deletes doctors orders
 * 
 * @author Nathan Heard
 */
public class DoctorsOrders {

	// ArrayList to hold orders
	private ArrayList<DOrders> orders;

	/**
	 * Constructor
	 */
	DoctorsOrders() {
		orders = new ArrayList<DOrders>();
	}

	/**
	 * Creates a new doctors orders
	 * 
	 * @param name
	 * @param date
	 * @param time
	 * @param prescrip
	 * @param labW
	 * @param followUp
	 * @param other
	 */
	public void create(String name, int date, int time, String prescrip, String labW,
			String followUp, String other) {
		DOrders order = new DOrders(name, date, time, prescrip, labW, followUp, other);
		orders.add(order);

	}

	/**
	 * Finds a doctors order
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param prescrip
	 * @return
	 */
	public DOrders find(int date, int time, String name, String prescrip) {
		int size = orders.size();
		for (int i = 0; i < size; i++) {
			if (orders.get(i).getName() == name) {
				if (orders.get(i).getDate() == date) {
					if (orders.get(i).getTime() == time) {
						if (orders.get(i).getPrescription() == prescrip) {
							return orders.get(i);
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Deletes a doctors order
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param prescrip
	 */
	public void cancel(int date, int time, String name, String prescrip) {
		int size = orders.size();
		for (int i = 0; i < size; i++) {
			if (orders.get(i).getName() == name) {
				if (orders.get(i).getDate() == date) {
					if (orders.get(i).getTime() == time) {
						if (orders.get(i).getPrescription() == prescrip) {
							orders.remove(i);
						}
					}
				}
			}
		}
	}
	
	public ArrayList<DOrders> getOrders() {
		return this.orders;
	}
}
