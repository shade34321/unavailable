package MedicalSoftware;

import java.util.ArrayList;

public class DoctorsOrders {

	private ArrayList<DOrders> orders;

	DoctorsOrders() {
		orders = new ArrayList<DOrders>();
	}

	public void create(String name, int date, int time, String prescrip, String labW,
			String followUp, String other) {
		DOrders order = new DOrders(name, date, time, prescrip, labW, followUp, other);
		orders.add(order);

	}

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
}
