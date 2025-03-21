package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMactivity3 {
		WebDriver driver;
		
		
		@BeforeClass // Setup Function
		public void setUp() {
			// Driver Installation
			driver = new FirefoxDriver();
			driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		}

		@Test
		public void loginPage() {
			
			driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
			driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
			driver.findElement(By.xpath("//input[@name='Submit']")).click();
			
			String message = driver.getTitle();
			System.out.println( "We logged in successfully to Home Page: " + message);
	        
		}

		@AfterClass

		public void tearDown() {

			// Close the browser

			driver.quit();

}
}