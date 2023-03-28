package testLocalJsonServer;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class testJsonServer {

	public static void main(String[] args) {

		String body =" {\"id\": 5,\n"
				+ "        \"title\": \"json-server5\",\n"
				+ "        \"author\": \"typicode5\"}";
		ValidatableResponse res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.post("http://localhost:3000/posts")
				.then().statusCode(201)
				.log().body();
		
		res.statusCode(200);
		
		
		
		
	}

}
