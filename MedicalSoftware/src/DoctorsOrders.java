

public class DoctorsOrders 
{
	private int date, time;
	private String prescription;
	private String labWork;
	private String followUpIns;
	private String otherIns;
	
	public DoctorsOrders(int date, int time, String prescrip, String labW, String followUp,
						 String other)
	{
		this.date = date;
		this.time = time;
		this.prescription = prescrip;
		this.labWork = labW;
		this.followUpIns = followUp;
		this.otherIns = other;
	}
	
	public String getPrescription()
	{
		return prescription;
	}
	
	public void setPrescription(String presc)
	{
		prescription = presc;
	}
	
	public String getLabWork()
	{
		return labWork;
	}
	
	public void setLabWork(String lw)
	{
		labWork = lw;
	}
	
	public String getFollowUpIns()
	{
		return followUpIns;
	}
	
	public void setFollowUpIns(String followup)
	{
		followUpIns = followup;
	}
	
	public String getOtherIns()
	{
		return otherIns;
	}
	
	public void setOtherIns(String other)
	{
		otherIns = other;
	}

}
