package activities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import groovy.util.logging.Log;

public class Activity1 {

	@Test(priority=1)
	public void addNewPet() {
	
		Map<String, Object> = new HashMap<>();
		reqBody.put("id",48496)
		reqBody.put("name", "Giley")
		reqBody.put("status", "alive")
	
		//Send request, get response , assert response
		given().baseURI("https://petstore.swagger.io/v2/pet")
				.header("Content-Type","application/json")
				.body(reqBody)
				.log().all()
		.when
				.post()
		.then()
				.statusCode(200)
				.body("name",equalTo("Giley"))
				.body("status",equalTo("alive"));
	}
	@Test(priority=2)
	public void getPetInfo() {
		
	given().
		baseURI("https://petstore.swagger.io/v2/pet/")
		.header("Content-Type","application/json")
		.pathParam("petId",48496)
		.log().all()
	.when
		.get("/{petId}")
	.then()
		.log().all()
		.statusCode(200)
		.body("name",equalTo("Giley"))
		.body("status",equalTo("alive"))
		
		
		
	}
		
	}
	@Test(priority=3)
	public void deletePet() {
	given().baseURI("https://petstore.swagger.io/v2/pet")
		.header("Content-Type","application/json")
		.pathParam("petId",48496)
		.log().all()
		
	.when
		.delete("/{petId}")
	.then().
		.log().all()
		.statusCode(200)
		.body("message",equalTo("48496"))
		
}

}