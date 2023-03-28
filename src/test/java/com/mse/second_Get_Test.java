package com.mse;

import io.restassured.RestAssured;

//here used 2 pathParam methods to pass two parameters
public class second_Get_Test {

	public static void main(String[] args) {
		
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/{resource}/{id}")
				.log()
				.all()
				.pathParam("resource", "booking")
				.pathParam("id", 2)
			.when()
				.get()
			.then()
				.statusCode(200)
				.log()
				.all();

				
	}

}
