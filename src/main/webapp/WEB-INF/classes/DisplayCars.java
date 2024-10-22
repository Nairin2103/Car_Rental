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
	    
	    
	    public String GetInfo() {
	    	String PrintPackages = "";
	        try {
	            // Step 1: Load Oracle JDBC Driver
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            // Step 2: Establish the connection
	            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

	            // Step 3: Create a statement
	            statement = connection.createStatement();

	            // Step 4: Execute a query
	            resultSet = statement.executeQuery("SELECT * FROM CARDETAILS"); // Replace with your table

	            // Step 5: Process the result set
	            while (resultSet.next()) {
	            	PrintPackages += 
	                        "<div class='col-lg-3 col-sm-6 py-3 grow-div'>" +
	                                "<div class=' position-relative ratio' style='--bs-aspect-ratio: 66.67%;'>" +
	                                    "<img src='images/" + resultSet.getString("IMAGE") + "' class='object-fit-cover rounded-top-3 shadow' />" +
	                                "</div>" +
	                            "<div class='package-info rounded-bottom-3 shadow'>" +
	                                "<h5 class='capitalize'>" + resultSet.getString("RENT") + "</h5>" +
	                            "</div>" +
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
	}

