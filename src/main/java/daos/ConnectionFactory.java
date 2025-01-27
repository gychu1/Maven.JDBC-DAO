package daos;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/Phones";
    public static final String USER = "new_user";
    public static final String PASS = "password";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
