package practice;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;

import io.restassured.http.ContentType;

public class PostRequestBodyUsingJSONObject {

	public static void main(String[] args) {

		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		
		JSONObject data = new JSONObject();
		
		data.put("firstname", "sneha");
		data.put("lastname", "dhande");
		data.put("totalprice", "111");
		data.put("depositpaid", "25");
		data.put("bookingdates", bookingdates);
		data.put("additionalneeds", "breakfast");
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.when()
		.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.log().body().statusCode(200);
		
		
	}
	
}
