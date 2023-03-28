package sdet.pavan;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	
	//@Test
	void testXMLResponse() 
	{
		//Approach 1
		/*
		 given()
			.pathParam("endpoint", "Traveler")
			.queryParam("page", 2)
			.log().all()
		.when()
			.get("http://restapi.adequateshop.com/api/{endpoint}")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("2"));
		*/
		
		//Approach 2
		
		Response res = given()
							.pathParam("endpoint", "Traveler")
							.queryParam("page", 2)
						.when()
							.get("http://restapi.adequateshop.com/api/{endpoint}");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		
		//res.body().xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "ASCAS");
		
	}
	
	@Test
	void testXMLResponseBody() 
	{
		Response res = given()
				.pathParam("endpoint", "Traveler")
				.queryParam("page", 2)
			.when()
				.get("http://restapi.adequateshop.com/api/{endpoint}");
		
	
	//	String x = res.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation").toString();
	//  List<Object> mylist = res.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		
		   
	// Verify number of travelers and name of traveler
		
		XmlPath xmlobj = new XmlPath(res.asString());
	    List<String> travelers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	    List<String> traveler_name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
	    Assert.assertEquals(travelers.size(), 10);
	    Assert.assertTrue(traveler_name.contains("jkhaumann"));
		
		
		
		
		

	}
	
	
}
