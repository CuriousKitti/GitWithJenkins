package practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.RestAssured;


public class PostRequestBodyUsingExternalJsonFile {

	public static void main(String[] args) throws IOException {

		
		File file = new File("./src/test/java/practice/body.json");
		FileReader fr= new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jb = new JSONObject(jt);
		
		RestAssured.given().body(jb)
		.when().post("https://restful-booker.herokuapp.com/booking")
		.then().log().body().statusCode(200);
		
		
		
	}

}
