package restAssuredAuthentication;

import org.testng.annotations.Test;
import io.restassured.RestAssured;


public class AuthUsingBaseClass extends BaseClass{

	@Test
	public void test1() {
		int code = RestAssured
				.given()
				.when()
					.get("https://postman-echo.com/basic-auth")
					.statusCode();
			
			System.out.println("Status code is "+code);
	}	
	

}
