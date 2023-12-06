package Scrutineer.Participants;
import Scrutineer.Utils.Measurable;


public class Dancer extends Person implements Measurable{
    private int dancerId;
    private int age;
    private String danceLevel;


    // Constructors
    public Dancer() {
    }

    public Dancer(String fName, String lName, int age, String danceLevel) {
        super(fName, lName);
        this.age = age;
        this.danceLevel = danceLevel;
    }
    
    public int getAge() {
        return age;
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
        return "Age: " + this.getAge() + " Name: " + this.getfName() + " " + this.getlName() + " Dance level: " + this.getDanceLevel();
    }

	@Override
	public int getMeasure() {
		return this.age;
	}


    public void setDancerId(int dancerId) {
        this.dancerId = dancerId;

    }

}
