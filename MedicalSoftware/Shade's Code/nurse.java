package MedicalSoftware;

import java.util.ArrayList;


public class nurse{
	private AVL<String, Info> information;
	private AVL<String, Report> report;
	private AVL<String, Patient> patient;
	private AVL<String, Nurse> nurse;
	private AVL<String, Record> record;
	private info information;	
	private Boolean suspended;
	private String input;
	
	
	public nurse(String user){
		this.information = new AVL<String, Info>();
		this.report = new AVL<String, Report>();
		this.patient = new AVL<String, Patient>();
		this.nurse = new AVL<String, Nurse>();
		this.record = new AVL<String, Record>();
		this.info = (Info) ((nurse) Search(user, 2)).getInfo();		
	}
	
	private Record viewRecords(String name){
		return this.record.find(name).getRecord();
		//update GUI
	}
	
	private Report viewReports(String name){
		return this.report.find(name).getReport();
		//update GUI
	}
	
	private String viewAppt(int date, String name){
		return this.patient.find(name).getAppt(); 
		//update GUI
	}

	@Override
	public Boolean getSusp(String name) {
		// TODO Auto-generated method stub
		return suspended;
	}

	@Override
	public void setSusp(String name, Boolean susp) {
		suspended = susp;
	}

	private info getInfo(String name){
		
	}
	
	private void createAppt(int date, int time, String doc, String reason){
		appointment appt = new appointment(date, time, doc, reason);
		appt.create();
	}
	
	private void cancelAppt(int date, int time, String doc, String reason){
		appointment appt = new appointment(date, time, doc, reason)
		appt.cancel();
	}
}
