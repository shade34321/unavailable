import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Appointment {

	private Info information;
	private ArrayList<Appt> App;
	private Comparator compare;
	
	Appointment(){
		App = new ArrayList<Appt>();
	}
	public void create(int date, int time, String name, String doctor, String reason){
		Appt a = new Appt(date, time, name, doctor, reason);
		App.add(a);
		
	}
	
	public void cancel(int date, int time, String name, String doctor, String reason){
		int size = App.size();
		for(int i = 0;i<size;i++){
			if(App.get(i).getName() == name){
				if(App.get(i).getDate() == date){
					if(App.get(i).getTime() == time){
						if(App.get(i).getDoctor() == doctor){
							App.remove(i);
						}
					}
				}
			}
			
		}
	}
	private void update(){
		//update calendar
	}
	
	private void view(){
		//update GUI
	}
	
}
