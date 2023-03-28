package testLocalJsonServer;

import static io.restassured.RestAssured.*;

public class GetPosts {

	public static void main(String[] args) {

		given()
		.when()
		.get("http://localhost:3000/posts")
		.then().log().body();
		
	}

}
