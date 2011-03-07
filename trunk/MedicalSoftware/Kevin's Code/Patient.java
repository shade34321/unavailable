package MedicalSoftware;
import java.util.ArrayList;

public class Patient 
{
	private AVL<String, Info> information;
	private AVL<String, Patient> patient;
	private AVL<String, PatientInformation> patientInfo;
	
	public Patient(String user)
	{
		this.patient = new AVL<String, Patient>();
	}
	
	public appointment requestAppt(int date, int time, String doctor, String reason)
	{
		appointment appt = new appointment(date, time, doctor, reason);
	}
	
	public String viewHistory()
	{
		return this.patientInfo.getHistory();
	}
}
