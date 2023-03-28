package sdet.pavan;

import static io.restassured.RestAssured.*;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class CookiesDemo {

	
	@Test
	void testCookies() 
	{
		Response res =given()
					  .when()
					  .get("https://www.google.com");
		
		// Get single cookie value
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie AEC======>"+cookie_value);
		
		// Get all cookies
		Map<String, String> cookies_all =res.getCookies();
		
		for(String cookie:cookies_all.keySet()) {
			
			System.out.println(cookie +"    "+res.getCookie(cookie));
			
		}
		
	}
	
}
