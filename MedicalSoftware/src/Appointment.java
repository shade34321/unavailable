package MedicalSoftware;

import java.util.ArrayList;

public class Appointment {

	private ArrayList<Appt> App;

	Appointment() {
		App = new ArrayList<Appt>();
	}

	public void create(int date, int time, String name, String doctor, String reason) {
		Appt a = new Appt(date, time, name, doctor, reason);
		App.add(a);

	}

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
