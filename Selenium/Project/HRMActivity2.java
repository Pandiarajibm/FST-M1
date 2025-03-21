package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMActivity2 {
	WebDriver driver;

	@BeforeClass // Setup Function
	public void setUp() {
		// Driver Installation
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/orangehrm");

	}

	@Test
	public void headurl() {
		//WebElement image = driver.findElement(By.xpath("//img[contains(@id,'src')]"));)
		WebElement image = driver.findElement(By.tagName("img"));
     //  WebElement image = driver.findElement(By.id("src")); 
		System.out.println("URL of Header image is:-" + image.getAttribute("src") );
        // System.out.println(image);
	}

	@AfterClass

	public void tearDown() {

		// Close the browser

		driver.quit();

	}

}
