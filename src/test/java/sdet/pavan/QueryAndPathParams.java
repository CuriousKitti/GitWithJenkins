package sdet.pavan;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

/*
 Path parameters need to be specified/send with URL
 Query parameters no need to send, they will automatically go with URL
 Query parameters will go with request in the order in which they were declared
 */


public class QueryAndPathParams {

	@Test
	void testQueryAndPathParams() 
	{
		//https://reqres.in/api/users?page=2&id=11
		given()
			.pathParam("mypath", "users")
			.param("id", 11)//order of query param does not matter
			.param("page", 2)
			.log()
			.all()
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log()
			.all();
		
	}
	
}
