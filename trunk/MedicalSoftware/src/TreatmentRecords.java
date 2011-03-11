package MedicalSoftware;

/**
* This class creates a new Treatment Record.
* A new Treatment Record needs to be created for each Doctors Orders.
* 
* @author Michael Sambol
* Written: 3/6/2011
*/

public class TreatmentRecords {

	private String date;
	private String time;
	private doctorsOrders orders;
	private String symptoms;
	private String bloodPressure;
	private int pulse;
	private int temperature;
	private int height;
	private int weight;
	
	public String getDate(){
		return this.date;
	}
	
	public void setString(String dte){
		this.date = dte;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setTime(String tme){
		this.time = tme;
	}
	
	public doctorsOrders getOrders(){
		return this.orders;
	}
	
	public void setOrders(doctorsOrders order){
		this.orders = order;
	}
	
	public String getSymptoms(){
		return this.symptoms;
	}
	
	public void setSymptoms(String symp){
		this.symptoms = symp;
	}
	
	public String getBloodPressure(){
		return this.bloodPressure;
	}
	
	public void setBloodPressure(String blood){
		this.bloodPressure = blood;
	}
	
	public int getPulse(){
		return pulse;
	}
	
	public void setPulse(int pse){
		this.pulse = pse;
	}
	
	public int getTemperature(){
		return temperature;
	}
	
	public void setTemperature(int temp){
		temperature = temp;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int hght){
		height = hght;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int wght){
		weight = wght;
	}
}
