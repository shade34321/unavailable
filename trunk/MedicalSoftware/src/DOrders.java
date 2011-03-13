package MedicalSoftware;

public class DOrders {
	private int date, time;
	private String prescription;
	private String labWork;
	private String followUpIns;
	private String otherIns;
	private String name;
	
	public DOrders(String user, int date, int time, String prescrip, String labW,
			String followUp, String other) {
		this.setName(user);
		this.setDate(date);
		this.setTime(time);
		this.prescription = prescrip;
		this.labWork = labW;
		this.followUpIns = followUp;
		this.otherIns = other;
	}

	// Getters and setters
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String presc) {
		prescription = presc;
	}

	public String getLabWork() {
		return labWork;
	}

	public void setLabWork(String lw) {
		labWork = lw;
	}

	public String getFollowUpIns() {
		return followUpIns;
	}

	public void setFollowUpIns(String followup) {
		followUpIns = followup;
	}

	public String getOtherIns() {
		return otherIns;
	}

	public void setOtherIns(String other) {
		otherIns = other;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

