package com.mse;

import io.restassured.RestAssured;

public class third_Get_Test {

	public static void main(String[] args) 
	{
//Here we used overloaded get method and passed parameter
		String body = RestAssured
						.given()
						.log()
						.all()
						.get("https://reqres.in/api/users/{id}",2)//overloaded get method
						.then()
						.log()
						.all()
						.extract()
						.asPrettyString();
						
	boolean firstname =	body.contains("Janet");
	System.out.println(firstname);
		
	}

}
