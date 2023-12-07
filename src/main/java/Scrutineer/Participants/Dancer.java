package Scrutineer.Participants;
import Scrutineer.Utils.Measurable;


public class Dancer implements Measurable {
    private int dancerId;
    private int age;
    private String fName;
    private String lName;
    private String danceLevel;


    // Constructors
    public Dancer() {
    }

    public Dancer(String fName, String lName, int age, String danceLevel) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.danceLevel = danceLevel;
    }
    
    public int getAge() {
        return age;
    }

    public String getFName() {
        return fName;
    }


    public String getLName() {
        return lName;
    }

    public void setAge(int age) {
		this.age = age;
	}

    public int getDancerId() {
        return dancerId;
    }
    
    public String getDanceLevel() {
        return danceLevel;
    }

    public void setDanceLevel(String danceLevel) {
        this.danceLevel = danceLevel;
    }

    @Override
    public String toString(){
        return "Age: " + this.getAge() + " Name: " + this.getFName() + " " + this.getLName() + " Dance level: " + this.getDanceLevel();
    }

	@Override
	public int getMeasure() {
		return this.age;
	}


    public void setDancerId(int dancerId) {
        this.dancerId = dancerId;

    }

    public void setFName(String fname) {
        this.fName = fname;
    }

    public void setLName(String lname) {
        this.lName = lname;
    }


}
