package entToendAPITests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassResultToAnotherAPI {

	//@Test(priority = 1)
	public void addUser(ITestContext context) {
		
Response res =RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body("{\n"
						+ "    \"firstname\" : \"Jim\",\n"
						+ "    \"lastname\" : \"Brown\",\n"
						+ "    \"totalprice\" : 111,\n"
						+ "    \"depositpaid\" : true,\n"
						+ "    \"bookingdates\" : {\n"
						+ "        \"checkin\" : \"2018-01-01\",\n"
						+ "        \"checkout\" : \"2019-01-01\"\n"
						+ "    },\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\n"
						+ "}")
			.when()
				.post("https://restful-booker.herokuapp.com/booking");
				
		System.out.println(res.body().asPrettyString());
		int id =res.body().jsonPath().getInt("bookingid");
		context.setAttribute("user_id", id);
			
	}
	@Test(priority = 1)
	public void getUser(ITestContext context) {
		
		
		RestAssured
			.given()
				.baseUri("https://reqres.in/api")
				.basePath("/users/{id}")
				.pathParam("id", 1)
			.when()
				.get()
			.then()
				.log().all()
				.statusCode(200)
				.toString();
		
	}
	
}
