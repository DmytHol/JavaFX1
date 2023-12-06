package Scrutineer.Utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static int calculateAge(Date birthDate) {
        // Convert java.sql.Date to java.time.LocalDate
        LocalDate birthLocalDate = birthDate.toLocalDate();
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Calculate age
        Period period = Period.between(birthLocalDate, currentDate);
        return period.getYears();
    }
}
