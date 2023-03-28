package practice;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class PostRequestBodyUsinhPoJo {

	public static void main(String[] args) {

			BookingDatesPoJo bdates = new BookingDatesPoJo();
			bdates.setCheckin("8/09/24");
			bdates.setCheckout("98/02/76");
			
		
			DataPojo data = new DataPojo();
		
			data.setFirstname("tesla");
			data.setLastname("musk");
			data.setAdditionalneeds("breakfast");
			data.setTotalprice(255);
			data.setDepositpaid(true);
			data.setBookingdates(bdates);
	
			given()
			.contentType(ContentType.JSON)
			.body(data)
			.when()
			.post("https://restful-booker.herokuapp.com/booking")
			.then()
			.log()
			.body()
			.statusCode(200);
		
	}

}
