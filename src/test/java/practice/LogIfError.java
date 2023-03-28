package practice;

import io.restassured.RestAssured;

public class LogIfError {

	public static void main(String[] args) {

		RestAssured
			.given()
				.baseUri("https://reqres.in/api/users")
				.body("\"name\": \"snhea\",\n"
						+ "    \"job\": \"test\"")
			.when()
				.post()
			.then()
				.log().ifError()//it will only log if there is an error
				.statusCode(200);
				
				
			
		
		
	}

}
