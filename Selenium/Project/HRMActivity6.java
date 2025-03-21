package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMActivity6 {
	WebDriver driver;
	
	
	@BeforeClass // Setup Function
	public void setUp() {
		// Driver Installation
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	}

	@Test (priority=1)
	public void loginPage() {
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		String message = driver.getTitle();
		System.out.println( "We logged in successfully to Home Page: " + message);
        
	}
	
	@Test (priority=2)
	public void directoryPage() {
			
		 WebElement dire = driver.findElement(By.id("menu_directory_viewDirectory"));
		dire.click();
		System.out.println("Directory Option is visible and clickable once logged in" );
		//WebElement searchDirect = driver.findElement(By.xpath("//input[contains@id,'searchDirectory']"));
	    String heading=driver.findElement(By.tagName("h1")).getText();
		System.out.println("Heading of the Page is: " + heading);			 
}
	@AfterClass

	public void tearDown() {

		// Close the browser
		driver.quit();

}

}