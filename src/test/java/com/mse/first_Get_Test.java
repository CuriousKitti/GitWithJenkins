package com.mse;

import  io.restassured.RestAssured;

public class first_Get_Test {
//Rest assured is a java library used to automate restful api
//Here we used pathParam method for passing id value
	public static void main(String[] args) {

		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking/{id}")
				.pathParam("id", 1)
				.log()
				.all()
			.when()
				.get()
			.then()
				.log()
				.all()
				.statusCode(200);
	}

}
