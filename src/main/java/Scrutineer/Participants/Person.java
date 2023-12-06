package Scrutineer.Participants;

import Scrutineer.Utils.Measurable;

public abstract class Person implements Measurable {
	private String fName;
	private String lName;
		
	public String getfName() {
		return fName;		
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
    protected Person() {
    	
    }
    
    protected Person(String fName, String lName) {
    	this.fName = fName;
    	this.lName = lName;
    }
    @Override
    public String toString() {
    	return "Name: " + fName + " " + lName;
    }
}
