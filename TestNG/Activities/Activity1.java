package activities;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity1 {
// Declare class objects
	WebDriver driver;
	
	@BeforeClass //Setup Function
	public void setUp() {
		// Driver Installation
		driver = new FirefoxDriver();
		//Open Browser
		driver.get("https://training-support.net/");
	}
	
	
	@Test (priority = 1)
		public void pageTitleTest()
	{
	    //verifing page title
		assertEquals(driver.getTitle(),"Training Support");
		
	}
	
	
	@Test (priority = 2)
	public void aboutLinkTest()
		{
	// Find the about page link and click it
		driver.findElement(By.linkText("About Us")).click();
		
		// Verify page redirect
		assertEquals(driver.getTitle(),"About Training Support");
		}
	
	//TearDownfuntion
	@AfterClass
	public void tearDown() {
		//close the browser
	driver.quit();
	}
}

