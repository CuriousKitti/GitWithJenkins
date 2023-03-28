 package sdet.pavan;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;


/*Different ways to create Post body
 1. using HashMap
 2. using org.json library
 3. using POJO class(plain old java object)
 4. using external JSON file data
 */


public class DiffWaystoCreatePostRequestBody {

	//@Test
	void createBookingUsingHashMap() {
		
		
		HashMap<String, String> bd = new HashMap<String, String>();
		bd.put("checkin","2018-01-01");
		bd.put("checkout","2019-01-01");
		
		HashMap<String, Serializable> hm = new HashMap<String, Serializable>();//this is through automatic options
		hm.put("firstname", "swapnil");
		hm.put("lastname", "kumar");
		hm.put("totalprice", 500);
		hm.put("depositpaid", true);
		hm.put("bookingdates",bd);
		hm.put("additionalneeds", "breakfast");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	//@Test
	void createBookingUsingOrgJsonLibrary() 
	{
		// For this add org.json dependency in pom.xml
		// Instead of HashMap create object of JSONObject class
		
		
		JSONObject subData = new JSONObject();
		subData.put("checkin","2018-01-01");
		subData.put("checkout","2019-01-01");
		
		
		JSONObject data = new JSONObject();
		data.put("firstname", "swapnil");
		data.put("lastname", "kumar");
		data.put("totalprice", 500);
		data.put("depositpaid", true);
		data.put("bookingdates",subData);
		data.put("additionalneeds", "breakfast");
		
		given()
			.contentType("application/json")
			.body(data.toString())//here need to convert JSON object to string
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.statusCode(200)
			.log().all();
			
	}
	
	//@Test
	void createBookingUsingPOJOClass() 
	{
		
		
		Pojo_Bookingdates subData = new Pojo_Bookingdates();
		subData.setCheckin("2018-01-01");
		subData.setCheckout("2019-01-01");
		
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setFirstname("sravan");
		data.setLastname("rajanala");
		data.setTotalprice(111);
		data.setDepositpaid(true);
		data.setBookingdates(subData);
		data.setAdditionalneeds("bfast");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.statusCode(200)
			.log().all();
			
	}
	
	@Test
	void createBookingUsingExternalJsonFile() throws FileNotFoundException 
	{
		
		File f= new File(".//src/test/java/sdet/pavan/body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.statusCode(200)
			.log().all();
			
	}
	
	
}
