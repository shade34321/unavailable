package MedicalSoftware;

/**
* This class creates a new Treatment Record.
* A new Treatment Record needs to be created for each Doctors Orders.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

import java.util.ArrayList;

public class TreatmentRecords {

	private ArrayList<TRecords> records;

	TreatmentRecords() {
		records = new ArrayList<TRecords>();
	}

	public void create(String name, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight) {
		TRecords tr = new TRecords(name, date, time, symptoms, bloodPressure, pulse, temp, height, weight);
		records.add(tr);

	}
	
	public TRecords find(int date, int time) {
		int size = records.size();
		for (int i = 0; i < size; i++) {
				if (records.get(i).getDate() == date) {
					if (records.get(i).getTime() == time) {
							return records.get(i);
				}
			}
		}
	return null;
}

	public void cancel(int date, int time) {
		int size = records.size();
		for (int i = 0; i < size; i++) {
				if (records.get(i).getDate() == date) {
					if (records.get(i).getTime() == time) {
							records.remove(i);
				}
			}
		}
	}
}
