package Scrutineer.Participants;
import Scrutineer.Utils.Measurable;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;


public class Dancer implements Measurable {
    private int dancerId;
    private String fName;
    private String lName;
    private String danceLevel;

    private Date dateOfBirth;


    // Constructors
    public Dancer() {
        this.dateOfBirth = new Date(); // or provide a default value
    }

    public Dancer(String fName, String lName, Date dateOfBirth, String danceLevel) {
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.danceLevel = danceLevel;
    }

    public int getAge() {
        return getAge((java.sql.Date) this.dateOfBirth);
    }

    public String getFName() {
        return fName;
    }


    public String getLName() {
        return lName;
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
        return getAge((java.sql.Date) this.dateOfBirth);
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

    public static int getAge(java.sql.Date birthDate) {
        if (birthDate == null) {
            return 0; // or handle as appropriate
        }
        // Convert java.sql.Date to java.time.LocalDate
        LocalDate birthLocalDate = birthDate.toLocalDate();
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Calculate age
        Period period = Period.between(birthLocalDate, currentDate);
        return period.getYears();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
