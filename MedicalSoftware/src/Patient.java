package MedicalSoftware;
import java.util.ArrayList;

public class Patient 
{
	private Info info;
	private AVL<String, Patient> patient;
	private AVL<String, Doctor> doctor;
	private Appointment appt;
	
	public Patient(String user)
	{
		this.info = (Info) ((Patient) Search(user, 3)).getInfo();
		this.patient = new AVL<String, Patient>();
		this.doctor = new AVL<String, Doctor>();
		appt = new Appointment();
	}
	
	public Patient(String user, AVL<String, Patient> p, AVL<String, doctor> d)
	{
		this.patient = p;
		this.doctor = d;
		appt = new Appointment();
		this.info = (Info) ((Patient) Search(user, 3)).getInfo();
	}
	
	public void requestAppt(int date, int time, String doctor, String reason)
	{
		appt = new Appointment(date, time, doctor, reason);
	}
	
	public Appointment getRequestedAppt()
	{
		return appt;
	}
	
	public String viewHistory()
	{
		return this.patientInfo.getHistory();
	}
	
	public Object Search(String user, int type)
	{
		Object ret;
		if(type == 1)
		{
			ret = doctor.find(user);
		}
		else if(type == 3)
		{
			ret = patient.find(user);
		}
		return ret;
		}
	}
}
