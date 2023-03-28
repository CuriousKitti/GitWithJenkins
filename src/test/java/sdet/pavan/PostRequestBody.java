package sdet.pavan;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import practice.DataPojo;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;

public class PostRequestBody {

/*
 1. Using HashMap
 2. Using org.json library
 3. Using POJO class
 4. Using external JSON file
 */
	
	
	//@Test
	void testBookingUsingHashMap() 
	{
		HashMap<String, String> bdates = new HashMap<String, String>();
		bdates.put("checkin","2013-02-23");
		bdates.put("checkout","2014-10-23");
		
		
		HashMap<String, Serializable> hm = new HashMap<String, Serializable>();
		hm.put("firstname", "shikha");
		hm.put("lastname", "gupta");
		hm.put("totalprice", 100);
		hm.put("depositpaid", true);
		hm.put("bookingdates", bdates);
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
	void testBookingUsingOrgJsonLibrary() 
	{
		
		JSONObject bdates = new JSONObject();
		bdates.put("checkin","2013-02-23");
		bdates.put("checkout","2014-10-23");
		
		JSONObject data = new JSONObject();
		data.put("firstname", "shikha");
		data.put("lastname", "gupta");
		data.put("totalprice", 100);
		data.put("depositpaid", true);
		data.put("bookingdates", bdates);
		data.put("additionalneeds", "breakfast");
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	void testBookingUsingPojoClass() throws JsonProcessingException 
	{
		
		Pojo_Bookingdates bdates = new Pojo_Bookingdates();
		bdates.setCheckin("2018-01-01");
		bdates.setCheckout("2019-01-01");
		
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setFirstname("Tom");
		data.setLastname("Murphy");
		data.setTotalprice(200);
		data.setDepositpaid(true);
		data.setBookingdates(bdates);
		data.setAdditionalneeds("bfast");
		
		
		//Serialization : POJO/JavaObject ----> JSON/ByteStream
		ObjectMapper obj = new ObjectMapper();
		//System.out.println(obj.writeValueAsString(data));
		System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(data));
		
		
		/*given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();*/
		
		//DeSerialization : JSON/ByteStream-----> POJO/JavaObject
		
		String t ="{\n"
				+ "  \"firstname\" : \"Tom\",\n"
				+ "  \"lastname\" : \"Murphy\",\n"
				+ "  \"totalprice\" : 200,\n"
				+ "  \"depositpaid\" : true,\n"
				+ "  \"bookingdates\" : {\n"
				+ "    \"checkin\" : \"2018-01-01\",\n"
				+ "    \"checkout\" : \"2019-01-01\"\n"
				+ "  },\n"
				+ "  \"additionalneeds\" : \"bfast\"\n"
				+ "}";
		
		DataPojo test =obj.readValue(t, DataPojo.class);
		System.out.println(test.getFirstname());
		
	}
	
	//@Test
	void testBookingUsingExternalJsonFile() throws FileNotFoundException 
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
