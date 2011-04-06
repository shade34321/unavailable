package MedicalSoftware;

import java.util.ArrayList;

/**
 * This class creates, finds, and deletes appointments
 * 
 * @author Kevin Zhou
 *
 */
public class Appointment {

	// ArrayList for holding appointments
	private ArrayList<Appt> App;

	/**
	 * Constructor
	 */
	Appointment() {
		App = new ArrayList<Appt>();
	}

	/**
	 * Creates a new appointment and adds it to the ArrayList
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param doctor
	 * @param reason
	 */
	public void create(int date, int time, String name, String doctor, String reason) {
		Appt a = new Appt(date, time, name, doctor, reason);
		App.add(a);

	}

	/**
	 * Finds and return an appointment
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param doctor
	 * @return Appt
	 */
	public Appt find(int date, int time, String name, String doctor) {
		int size = App.size();
		for (int i = 0; i < size; i++) {
			if (App.get(i).getName() == name) {
				if (App.get(i).getDate() == date) {
					if (App.get(i).getTime() == time) {
						if (App.get(i).getDoctor() == doctor) {
							return App.get(i);
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Deletes an appointment
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param doctor
	 */
	public void cancel(int date, int time, String name, String doctor) {
		int size = App.size();
		for (int i = 0; i < size; i++) {
			if (App.get(i).getName() == name) {
				if (App.get(i).getDate() == date) {
					if (App.get(i).getTime() == time) {
						if (App.get(i).getDoctor() == doctor) {
							App.remove(i);
						}
					}
				}
			}
		}
	}
}
