
public class appointment {
	private int date;
	private int time;
	private String doctor;
	private String reason;
	private Info information;
	
	appointment(){
		this(0,0,null, null);
	}
	
	appointment(int date, int time, String doctor, String reason){
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.reason = reason;
		information = new info();
	}
	
	public void create(){
		update();
	}
	
	public void cancel(){
		//update calendar
	}
	private void update(){
		//update calendar
	}
	
	private void view(){
		
	}
	
}
