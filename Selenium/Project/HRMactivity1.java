package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMactivity1 {
	WebDriver driver;
	@BeforeClass // Setup Function
	public void setUp() {
		// Driver Installation

		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");

	}

	@Test
	public void pageTitleTest() {
		String titlen = driver.getTitle();
		System.out.println("Page title is:" + titlen);

		// verifing page title
		Assert.assertEquals(titlen, "OrangeHRM");

	}

	@AfterClass
            	
                public void tearDown() {
            	
                    // Close the browser
            	
                    driver.quit();
                 
                 }
}