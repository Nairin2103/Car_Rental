package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DisplayCars {
    // JDBC URL, username, and password of Oracle database
    private static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Example URL
    private static final String JDBC_USER = "admin"; // Replace with your username
    private static final String JDBC_PASSWORD = "admin"; // Replace with your password

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    
    
    public static String GetInfo() {
    	String PrintPackages = "";
        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query
            resultSet = statement.executeQuery("SELECT * FROM CARDETAILS WHERE ISRENTED=0"); // Replace with your table

            // Step 5: Process the result set
            while (resultSet.next()) {
            	PrintPackages += 
                        "<div class='col-lg-3 col-sm-6 py-3 grow-div'>" +
                            "<a href='Booking.jsp?id="+ resultSet.getString("ID") +"'>" +
                    		"<div class=' position-relative ratio' style='--bs-aspect-ratio: 66.67%;'>" +
                                "<img src='images/" + resultSet.getString("IMAGE") + "' class='object-fit-cover rounded-top-3 shadow' />" +
                            "</div>" +
                            "<div class='package-info rounded-bottom-3 shadow'>" +
                                "<h5 class='capitalize'>" + resultSet.getString("NAME") + "</h5>" +
                                "<h6>₹" + resultSet.getString("RENT") + " / Day</h6>" +
                                "<h6>" + resultSet.getString("MILEAGE") +" km/l</h6>" +
                            "</div>" +
                            "</a>" +
                        "</div>";
            }
            return PrintPackages;

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Add the driver jar in the project build path.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
		return PrintPackages;
    }
    
    
    public static String Image = "";
    public static String Name = "";
    public static String Rent = "";
    public static String Mileage = "";
    public static void BigPic(String ID) {
    	String PrintBigPic = "";
        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query
            resultSet = statement.executeQuery("SELECT * FROM CARDETAILS WHERE ID="+ID); // Replace with your table

            // Step 5: Process the result set
            if (resultSet.next()) {
            	Image = resultSet.getString("IMAGE");
            	Name = resultSet.getString("NAME");
            	Rent = resultSet.getString("RENT");
            	Mileage = resultSet.getString("MILEAGE");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Add the driver jar in the project build path.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }
}

