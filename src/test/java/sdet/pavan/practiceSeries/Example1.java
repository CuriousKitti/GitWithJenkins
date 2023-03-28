package sdet.pavan.practiceSeries;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class Example1 {

	@Test
	public void test1() {
	
			given()
				.pathParam("path", "users")
				.queryParam("id", 2)
			.when()
				.get("https://reqres.in/api/{path}")
			.then()
				.statusCode(200)
				.body("data.first_name",equalTo("Janet"));
				
		
	}
	
	
}
