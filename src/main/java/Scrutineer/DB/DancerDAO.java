package Scrutineer.DB;

import Scrutineer.Participants.Dancer;
import Scrutineer.Utils.AgeCalculator;
import Scrutineer.Utils.DataSetGeneric;

import java.sql.*;

public class DancerDAO {

    //Create a dancer from the database
    private static Dancer createDancer(ResultSet rs){
        Dancer d = new Dancer();
        try {
            d.setDancerId(rs.getInt("dancer_id"));
            d.setfName(rs.getString("fname"));
            d.setlName(rs.getString("lname"));
            Date birthDate = rs.getDate("birthdate");
            int age = AgeCalculator.calculateAge(birthDate);
            d.setAge(age);
            d.setDanceLevel(rs.getString("dance_level"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    // Get all dancers from the database
    public DataSetGeneric<Dancer> findAll(){

        String sql = "SELECT * FROM Dancer";
        DataSetGeneric<Dancer> dancers = new DataSetGeneric<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Dancer d = createDancer(rs);
                dancers.add(d);
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return dancers;
    }
}
