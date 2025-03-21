package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMActivity4 {
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
		
		public void pimPage() {
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			//driver.findElement(By.id("menu_pim_addEmployee")).click();
			//driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
			WebElement firstName=driver.findElement(By.id("firstName"));
			WebElement lastName=driver.findElement(By.id("lastName"));
			//addButton.click();
			firstName.sendKeys("RAMRAM3");
			lastName.sendKeys("RAM3");
	        
	        // Find and click the submit button
			driver.findElement(By.id("btnSave")).click();
	        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	        WebElement empName=driver.findElement(By.id("empsearch_employee_name_empName"));
	        empName.sendKeys("RAMRAM");
	        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	        System.out.println("Employee is Successfully Added");
		
		}
		@AfterClass

		public void tearDown() {

			// Close the browser

			driver.quit();

}
}