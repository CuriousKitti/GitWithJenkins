package serialization_deserialization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingPOJO {

	@Test
	public void test1() {
		String jsonObj ="{\n"
				+ "  \"id\": 0,\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 0,\n"
				+ "    \"name\": \"string\"\n"
				+ "  },\n"
				+ "  \"name\": \"doggie\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 0,\n"
				+ "      \"name\": \"string\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"available\"\n"
				+ "}";
		
			Response res =given().baseUri("https://petstore.swagger.io/")
			.basePath("/v2/pet")
			.contentType("application/json")
			.body(jsonObj)
			.post();
			
			
			System.out.println(res.asPrettyString());
	}
	
}
