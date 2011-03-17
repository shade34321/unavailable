package MedicalSoftware;

public class TRecords {

	private String name;
	private int date;
	private int time;
	private String symptoms;
	private int bloodPressure;
	private int pulse;
	private int temperature;
	private int height;
	private int weight;
	
	TRecords(String name, int date, int time, String symptoms, int bloodPressure, int pulse, int temp, int height, int weight) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.symptoms = symptoms;
		this.bloodPressure = bloodPressure;
		this.pulse = pulse;
		this.temperature = temp;
		this.height = height;
		this.weight = weight;
	}
	
	
	// Getters and setters
	public int getDate(){
		return this.date;
	}
	
	public void setString(int dte){
		this.date = dte;
	}
	
	public int getTime(){
		return this.time;
	}
	
	public void setTime(int tme){
		this.time = tme;
	}
	
	public String getSymptoms(){
		return this.symptoms;
	}
	
	public void setSymptoms(String symp){
		this.symptoms = symp;
	}
	
	public int getBloodPressure(){
		return this.bloodPressure;
	}
	
	public void setBloodPressure(int blood){
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


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
}
