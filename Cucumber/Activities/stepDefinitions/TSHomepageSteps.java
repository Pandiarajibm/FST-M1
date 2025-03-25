package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TSHomepageSteps extends BaseClass {
	@Given("the user is on the TS homepage")
		public void openTSHomepage() throws Throwable {
		// Open the browser
		driver.get("https://training-support.net");
		String titleHeading= driver.getTitle();
		System.out.println(titleHeading);
		//Assertion to check if are in the correct page
		assertEquals(driver.getTitle(), "Training Support");
		
	}

	@When("the user clicks on the About Us link")
		public void clickButton() throws Throwable {
	    //find and click About Us button
		driver.findElement(By.linkText("About Us")).click();
	}

	@Then("the user is redirected to the About page")
	public void aboutUsPage() throws Throwable {
		//wait.until(ExpectedConditions.titleIs("About Training Support"));
		assertEquals(driver.getTitle(), "About Training Support");
		String pageHeading = driver.findElement(By.cssSelector("h1.text-center")).getText();

		System.out.println("New page title is: " + pageHeading);
		assertEquals(pageHeading, "About Us");
	}
}