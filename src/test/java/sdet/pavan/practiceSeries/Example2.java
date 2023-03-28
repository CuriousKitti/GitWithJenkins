package sdet.pavan.practiceSeries;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class Example2 {
	
	int id;

	@Test(priority = 1)
	public void createUserTest1() {
		//Pass body as hashmap
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name","sneha");
		hm.put("job", "student");
		
		id = given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/userss")
			.jsonPath().getInt("id");
	}
	
}
