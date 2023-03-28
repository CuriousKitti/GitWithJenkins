package sdet.pavan;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {

	int id;
	
	@Test(priority = 1)
	void getUser() 
	{
		given()//Here we did static import for RestAssured, hence can use given() directly
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
		
	}
	
	@Test(priority = 2)
	void createUser() 
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name","sneha");
		hm.put("job", "student");
		
		id = given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
	}
	
	@Test(priority=3, dependsOnMethods = "createUser")
	void updateUser() {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "sneha");
		hm.put("job", "Analyst");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.put("https://reqres.in/api/users/"+id)//Concatenate id to URL
		.then()
			.body("name", equalTo("sneha"));
		
	}
	
	@Test(priority = 4)
	void deleteUser() 
	{
		
		given()
		.when()
			.delete("https://reqres.in/api/users/{id}", id)//pass id as parameter with URL, ID is used from createUser method
		.then()
			.log().all();
	}
	
}
