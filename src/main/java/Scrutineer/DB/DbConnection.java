package Scrutineer.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static boolean VerifyDBClassLoaded() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    public static Connection getConnection() {
        try {
            if (!VerifyDBClassLoaded()) {
                throw new RuntimeException("MySQL JDBC driver not found. Add external library to your build path.");
            }
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/scrutener", "root", "Hermione160!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect", e);
        }
    }
}
