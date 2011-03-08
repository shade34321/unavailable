import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Appointment {

	private Info information;
	private ArrayList<Appt> App;
	private Comparator compare;
	
	appointment(){
		App = new ArrayList<Appt>();
	}
	public void create(int date, int time, String name, String doctor, String reason){
		Appt a = new Appt(date, time, name, doctor, reason);
		app.add(a);
		
	}
	
	public void cancel(int date, int time, String name, String doctor, String reason){
		int size = app.size();
		for(int i = 0;i<size;i++){
			if(app(i).getName() == name){
				if(app(i).getDate() == date){
					if(app(i).getTime() == time){
						if(app(i).getDoctor() == doctor){
							app.remove(i);
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
