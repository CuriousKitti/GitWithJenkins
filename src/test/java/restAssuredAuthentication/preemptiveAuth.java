package restAssuredAuthentication;

import io.restassured.RestAssured;

//import static io.restassured.RestAssured.*; Static import so we can use given method directly

public class preemptiveAuth {

	public static void main(String[] args) {

		int code = RestAssured
			.given()
				.auth()
				.preemptive()
				.basic("postman", "password")
			.when()
				.get("https://postman-echo.com/basic-auth")
				.statusCode();
		
		System.out.println("Status code is "+code);
	
	}

}
