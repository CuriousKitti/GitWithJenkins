package restAssuredAuthentication;

import static io.restassured.RestAssured.*;

public class OauthGitHubApi {

	public static void main(String[] args) {

		String apiToken ="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";
		String url ="https://api.github.com/user/repos";
		
		given()
		.auth()
		.oauth2(apiToken)
		.get(url)
		.then()
		.log()
		.body();
	}

}
