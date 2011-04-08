package MedicalSoftware;

import java.util.ArrayList;

/**
 * This class creates a new Treatment Record. A new Treatment Record needs to be
 * created for each Doctors Orders.
 * 
 * @author Michael Sambol Written: 3/6/2011
 */

public class TreatmentRecords {

	private ArrayList<TRecords> records;

	/**
	 * Constructor
	 */
	public TreatmentRecords() {
		records = new ArrayList<TRecords>();
	}

	/**
	 * Creates a new record
	 * 
	 * @param name
	 * @param date
	 * @param time
	 * @param symptoms
	 * @param bloodPressure
	 * @param pulse
	 * @param temp
	 * @param height
	 * @param weight
	 */
	public void create(String name, String doctor, int date, int time,
			String symptoms, int bloodPressure, int pulse, int temp,
			int height, int weight) {
		TRecords tr = new TRecords(name, doctor, date, time, symptoms,
				bloodPressure, pulse, temp, height, weight);
		records.add(tr);

	}

	/**
	 * Finds a record
	 * 
	 * @param date
	 * @param time
	 * @return TRecords
	 */
	public TRecords find(String name, int date, int time) {
		int size = records.size();
		for (int i = 0; i < size; i++) {
			if (records.get(i).getName().equals(name)) {
				if (records.get(i).getDate() == date) {
					if (records.get(i).getTime() == time) {
						return records.get(i);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Deletes a record
	 * 
	 * @param date
	 * @param time
	 */
	public void cancel(String name, int date, int time) {
		int size = records.size();
		for (int i = 0; i < size; i++) {
			if (records.get(i).getName().equals(name)) {
				if (records.get(i).getDate() == date) {
					if (records.get(i).getTime() == time) {
						records.remove(i);
					}
				}
			}
		}
	}

	public ArrayList<TRecords> getRecords() {
		return this.records;
	}
}
