package Scrutineer.Participants;

import Scrutineer.Utils.Measurable;

public class Coach extends Person implements Measurable {
	private int coachId; // Add coachId field
	private String studio;
	private String city;
	private int numberOfStudents;

	public Coach(String coachFirstName, String coachLastName, String studio, String city) {
		super();
	}

	// constructor to accept coachId
	public Coach(int coachId, String fName, String lName, String studio, String city) {
		super(fName, lName);
		this.coachId = coachId;
		this.studio = studio;
		this.city = city;
		this.numberOfStudents = 0;
	}

	// Add getter and setter for coachId
	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public void incrementNumberOfStudents() {
		this.numberOfStudents++;
	}

	public void decrementNumberOfStudents() {
		this.numberOfStudents--;
	}

	@Override
	public int getMeasure() {
		return numberOfStudents;
	}

	@Override
	public String toString() {
		return  " Coach: " + this.getfName() + " " + this.getlName() +
				" Studio name: " + this.getStudio() + " City: " + this.getCity();
	}
}
