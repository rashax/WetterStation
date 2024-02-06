package Wetterstation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {

        System.out.println("Loading driver ...");

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Use com.mysql.jdbc.Driver if you're not on MySQL 8+ yet.
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//        }

        String url = "jdbc:mysql://localhost:3306/weather_station";
        String username = "java";
        String password = "password";

        System.out.println("Connecting database ...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            this.connection = connection;
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {

        Connection connection = new DatabaseConnection().getConnection();
        if (connection == null) {
            System.out.println("connection is null");
        }
    }

}
