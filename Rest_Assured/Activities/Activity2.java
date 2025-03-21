package activities;

public class Activity2 {
	@Test(priority=1)
	public void getUserInfo()
	{
		File outputJSON = new File('src/test/java/activities/userinfo.json');
	given()
		.baseUri("https://petstore.swagger.io.v2.user") // Set Base URI
		.header("Content-Type","application/json")		// Set Header
		.body(inputJSON)	//	Send POST request
	.when
		.post
	.then
		.body("code",equalTo(200))
		.body("message",equalTo("939212"));
	inputJSON.close;
	
	}
	
	@Test(priority2)
	public void getUserInfo()
	{
		File outputJSON = new File('src/test/java/activities/userGetResponse.json');
		Response response = given()
				.baseUri("https://petstore.swagger.io.v2.user") // Set Base URI
				.header("Content-Type","application/json")		// Set Header
				.pathParam("username","justinc")
				.when.get("/{username}")
				.body(inputJSON)	//	Send POST request
			.when
				.post
			.then
				.body("code",equalTo(200))
				.body("message",equalTo("939212"));
			inputJSON.close;
	
	//Assertion
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
			response.then().body("id",equalTo("939212"));
	
	
	
	
	}
	@Test(priority=3)
	public void deleteUser throws IOException()
	{
		File outputJSON = new File('src/test/java/activities/userGetResponse.json');
	given()
		.baseUri("https://petstore.swagger.io.v2.user") // Set Base URI
		.header("Content-Type","application/json")		// Set Header
		.pathParam("username","justinc")    // Add path parameter
	.when
			.delete("/{username}")
	.then
		.body("code",equalTo(200))
		.body("message",equalTo("justinc"));
	inputJSON.close;

	}
	
}
