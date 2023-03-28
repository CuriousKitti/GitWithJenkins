package practice;

import io.restassured.RestAssured;

public class GetBookingIds {

	public static void main(String[] args) {

		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/booking")
			.when()
				.get()
			.then()
				.log().all()
				.assertThat()
				.statusCode(200);
			
	}

}
