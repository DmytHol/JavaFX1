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
            d.setFName(rs.getString("fname"));
            d.setLName(rs.getString("lname"));
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

    public boolean delete(Dancer dancer){
        boolean res = false;
        if(dancer.getFName() != ""){
            try {
                String sql = "DELETE FROM Dancer WHERE dancer_id="+dancer.getDancerId();
                Connection connection = DbConnection.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
                res = true;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
    public boolean add(Dancer dancer){
        boolean res = false;
        if(dancer.getFName() != ""){
            try {
                String sql = "INSERT INTO Dancer (fname, lname, birthdate, dance_level) VALUES (?,?,?,?)";
                Connection connection = DbConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, dancer.getFName());
                stmt.setString(2, dancer.getLName());
                //stmt.setDate(3, new java.sql.Date(dancer.getBirthDate().getTime()));
                stmt.setString(4, dancer.getDanceLevel());
                stmt.executeUpdate();
                res = true;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public boolean update(Dancer dancer){
        boolean res = false;
        if(dancer.getFName() != ""){
            try {
                String sql = "UPDATE Dancer SET fname=?, lname=?, birthdate=?, dance_level=? WHERE dancer_id=?";
                Connection connection = DbConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, dancer.getFName());
                stmt.setString(2, dancer.getLName());
                //stmt.setDate(3, new java.sql.Date(dancer.getBirthDate().getTime()));
                stmt.setString(4, dancer.getDanceLevel());
                stmt.setInt(5, dancer.getDancerId());
                stmt.executeUpdate();
                res = true;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public Dancer find(int id) {
        try {
            Dancer dancer = null;
            PreparedStatement ps = DbConnection.getConnection().prepareStatement("SELECT * FROM Dancer WHERE dancer_id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dancer = createDancer(rs);
            }
            return dancer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
