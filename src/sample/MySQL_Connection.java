package sample;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The class has just one  Method that  sets up the connection with the MySQL server
 */

public class MySQL_Connection {
    public Connection databaseLink;

    public Connection getConnection() {
        String dataBaseName = "WJ080Vp";
        String dataBaseUser = "U080Vp";
        String dataBasePassword = "53689191721";
        String url = "jdbc:mysql://wgudb.ucertify.com:3306/WJ080Vp";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            databaseLink = DriverManager.getConnection(url, dataBaseUser, dataBasePassword);

            if (databaseLink != null) {
                System.out.println("Successfully connected to MySQL database, retrieving data..please wait");

            }

            } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("An error occurred while connecting MySQL database");

        }
        return databaseLink;
    }
}
