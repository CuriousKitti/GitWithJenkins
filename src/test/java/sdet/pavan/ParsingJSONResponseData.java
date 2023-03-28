package sdet.pavan;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;



public class ParsingJSONResponseData {

	//@Test
	void testJsonResponse() 
	{
		
		//Approach 1
		/*
		given()
			.contentType("ContentType.JSON")
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[0].first_name", equalTo("Michael"));
		*/
		
		//Approach 2
		
		Response res = given()
						.contentType("application/JSON")
						.when()
						.get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.getStatusCode(),200); //Assert status code
		Assert.assertEquals(res.body().jsonPath().get("data[0].first_name").toString(),"Michael");//Assert name
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");//Assert header
		
	}
	
	@Test
	void testJsonResponseBodyData() //Parsing entire JSON response
	{
		
		Response res = given()
				.contentType("ContentType.JSON")
				.when()
				.get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status = false;
		
		for(int i=0; i<jo.getJSONArray("data").length();i++) 
		{
			String name =jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			//System.out.println(name);
			if(name.equals("Byron")) 
			{
				status=true;
				break;
			}
			
		}
		Assert.assertTrue(status);
	}

}
