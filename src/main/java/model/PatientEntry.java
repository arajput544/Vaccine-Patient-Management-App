package model;

import java.sql.Date;

public class PatientEntry {
	static int patientidseed=1;
	private int id;
	private String name;
	private VaccinationEntry vaccine;
	private String date1;
	private String date2;
	
	public PatientEntry() {}	
	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VaccinationEntry getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccinationEntry vaccine) {
		this.vaccine = vaccine;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

}

	