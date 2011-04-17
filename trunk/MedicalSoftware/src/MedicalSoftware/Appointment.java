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
	public Appointment() {
		App = new ArrayList<Appt>();
	}

	public Appointment(int date, int time, String name, String doctor,
			String reason) {
			App = new ArrayList<Appt>();
			Appt app = new Appt(date, time, name, doctor, reason);
			App.add(app);
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
	public void create(int date, int time, String name, String doctor,
			String reason) {
		Appt app = new Appt(date, time, name, doctor, reason);
		App.add(app);

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

	public ArrayList<Appt> getAppt() {
		return this.App;
	}
	
	public ArrayList<Appt> sortedAppt() {
		ArrayList<Appt> temp = new ArrayList<Appt>();
		Appt tempTest = null;
		for (int i = App.size(); i > 0; i--){
			tempTest = App.get(i);
			for (int j = App.size(); j > 0; j--) {
				if (temp.size() == 0) {
					if (tempTest.getDate() < App.get(j).getDate()) {
						if (tempTest.getTime() < App.get(j).getTime()) {
							tempTest = App.get(j);
						}
					}
				} else {
				if (tempTest.getDate() < App.get(j).getDate() && tempTest.getDate() > temp.get(i-1).getDate()) {
						if (tempTest.getTime() < App.get(j).getTime()&& tempTest.getTime() > temp.get(i).getTime()) {
							tempTest = App.get(j);
						}
					}
				}
			}
				temp.add(tempTest);
			}
		return temp;
	}
}
