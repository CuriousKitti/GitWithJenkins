package practice;

import static org.hamcrest.CoreMatchers.equalTo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import io.restassured.RestAssured;

public class test {


		    // Declaration of the variables
		    
		    private final String url = "jdbc:mysql://localhost:3306/mydb";
		    private final String user = "root";
		    private final String password = "Summer@2020$";
		    public static String fname = null;

		    // Method to initalize connection to the database and execute query
		    
		    public void connect() {

		        try {
		            Connection conn = DriverManager.getConnection(url, user, password);
		            {
		                if (conn != null) {

		                    PreparedStatement pst = conn.prepareStatement("select stu_name from Student where id = 1");
		                    ResultSet rs = pst.executeQuery();
		                    {
		                        while (rs.next()) {

		                            fname = rs.getString("stu_name");
		                            System.out.println("The value from the table is : "+fname);
		                        }
		                    }

		                } else
		                    System.out.println("Failed to connect");
		            }

		        } 
		        catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }  

		    // Main method and Rest Assured Code
		    
		    public static void main(String[] args) {
		        test app = new test();
		        app.connect(); 
		        RestAssured.given().when().get("https://reqres.in/api/users/2").then().body("data.first_name", equalTo(fname));
		       // RestAssured.given().when().get("https://reqres.in/api/users/2").then().body("data.first_name", equalToIgnoringCase(fname));
		        System.out.println("Execution Successful");
		    }

		
}
