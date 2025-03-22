package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest {
    // SSH Key to test with
    String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQC3e+M7ZWv6gFk65kE2CDdMn87VwyL0NJTHd2ud/xVV836N2GlvMl49S93LGozXt1CJOo0S3R0UIvzCze9C4x8M92DaXokF2W/xLXQ0obvmr920cbDHvS2cb3kpzw7mDBqlhkoDp8GOVHtoFFLDqK0Hwzy3EecziI471wrgWE2f+w==";
    int sshKeyId;

    // Request specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();

    // Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        // Path: https://api.github.com/user/keys
        // Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        // Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        // Extract the id and save it
        sshKeyId = response.then().extract().path("id");

        // Assertions
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().get("/{keyId}").
        then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().delete("/{keyId}").
        then().statusCode(204).time(lessThan(3000L));
    }

}









