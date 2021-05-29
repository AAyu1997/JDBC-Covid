package com.mindtree.dto;

public class Corona {

	private String date;
	private String state;
	private String city;
	private int numberOfTestingDone;
	private int numberOfPositivePatient;
	private int numberOfDiedPatient;
	
	public Corona() {
		super();
	}

	public Corona(String date, String state, String city, int numberOfTestingDone, int numberOfPositivePatient,
			int numberOfDiedPatient) {
		super();
		this.date = date;
		this.state = state;
		this.city = city;
		this.numberOfTestingDone = numberOfTestingDone;
		this.numberOfPositivePatient = numberOfPositivePatient;
		this.numberOfDiedPatient = numberOfDiedPatient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumberOfTestingDone() {
		return numberOfTestingDone;
	}

	public void setNumberOfTestingDone(int numberOfTestingDone) {
		this.numberOfTestingDone = numberOfTestingDone;
	}

	public int getNumberOfPositivePatient() {
		return numberOfPositivePatient;
	}

	public void setNumberOfPositivePatient(int numberOfPositivePatient) {
		this.numberOfPositivePatient = numberOfPositivePatient;
	}

	public int getNumberOfDiedPatient() {
		return numberOfDiedPatient;
	}

	public void setNumberOfDiedPatient(int numberOfDiedPatient) {
		this.numberOfDiedPatient = numberOfDiedPatient;
	}
	
		
}



