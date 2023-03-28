package sdet.pavan;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeadersDemo {

	
	//@Test
	void testHeaders() 
	{
		given()
		.when()
			.get("https://www.google.com")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
		
	}
	
	@Test
	void getHeaderInfo() 
	{
		Response res = given()
						.when()
						.get("https://www.google.com");
		
		
		// Get single header info
		System.out.println(res.getHeader("Content-Type"));
		
		//Get all headers
		Headers h = res.getHeaders();
	
		for(Header x:h) {
			
			System.out.println(x.getName()+"  "+x.getValue());
			System.out.println();
		
		}
		
	}
	
	
}
