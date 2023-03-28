package practice;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequestBodyUsingHashMap {

	public static void main(String[] args) {

		HashMap<String,String> bdates = new HashMap<String, String>();
		bdates.put("checkin", "2018-01-01");
		bdates.put("checkout", "2019-01-01");
		
		Map<String,Object> hm = new HashMap<String, Object>();
		hm.put("firstname", "swapnil");
		hm.put("lastname", "pat");
		hm.put("totalprice", "111");
		hm.put("depositpaid", "25");
		hm.put("bookingdates", bdates);
		hm.put("additionalneeds", "breakfast");
		
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.log().body().statusCode(200);
	
		
	}

}
