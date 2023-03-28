package practice;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class GenerateFakeDataUsingJavaFaker {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Faker faker = new Faker();
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		int price = faker.number().randomDigit();
		boolean deposit =faker.random().nextBoolean();
		String checkin = sdf.format(faker.date().birthday());
		String checkout = sdf.format(faker.date().birthday());
		String need="Bfast";
		
		JSONObject bdate = new JSONObject();
		bdate.put("checkin", checkin);
		bdate.put("checkout", checkout);
		
		JSONObject data = new JSONObject();
		data.put("firstname", fname);
		data.put("lastname", lname);
		data.put("totalprice",price );
		data.put("depositpaid",deposit);
		data.put("bookingdates", bdate);
		data.put("additionalneeds", need);
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.when()
		.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.log().body().statusCode(200);
		
	}

}
