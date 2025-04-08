package examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FirstTest {

	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
	@Test
	public void getPetQueryParam() {
		Response response =

				given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type", "application/json")
						.queryParam("status", "alive").when().get("/findByStatus");

		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders().asList());
		System.out.println(response.getBody().asPrettyString());
		String petStatus = response.then().extract().path("[0]['status']");
		assertEquals(petStatus, "alive");
		response.then().statusCode(200).body("[0]['status']", equalTo("alive"));

	}

	// GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getPetWithPathParam() {
		given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type", "application/json")
				.pathParam("petId", 66362).when().get("/{petId}").then().statusCode(200)
				.body("status", equalTo("alive"));

	}

}
