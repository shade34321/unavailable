package MedicalSoftware;
/**
 * Represents an appointment
 * 
 * @author Nathan Heard
 *
 */
public class Appt implements Comparable<Appt> {
	private int date;
	private int time;
	private String doctor;
	private String reason;
	private String name;

	/**
	 * Constructor
	 * 
	 * @param date
	 * @param time
	 * @param name
	 * @param doctor
	 * @param reason
	 */
	public Appt(int date, int time, String name, String doctor, String reason) {
		this.date = date;
		this.time = time;
		this.name = name;
		this.doctor = doctor;
		this.reason = reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public int compareTo(Appt other) {
		// TODO Auto-generated method stub
		return name.compareToIgnoreCase(other.name);
	}
}
