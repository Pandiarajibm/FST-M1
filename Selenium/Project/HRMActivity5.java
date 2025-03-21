package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRMActivity5 {

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
	
	public void editPage() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	WebElement editButton=	driver.findElement(By.xpath("//input[contains(@value,'Edit')]"));
		
		//driver.findElement(By.xpath("//input[@='btnSave'][@value='Edit']"));
		//driver.findElement(By.id("btnSave")).click();
		WebElement firstName=driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
		WebElement maleGender=driver.findElement(By.id("personal_optGender_1"));
		WebElement birthDate=driver.findElement(By.id("personal_DOB"));
		
		editButton.click();
		firstName.clear();
		lastName.clear();
		firstName.sendKeys("RAMRAM2");
		lastName.sendKeys("RAM2");
		maleGender.click();
		birthDate.sendKeys("2000-03-16");
		
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		//driver.findElement(By.xpath("//input[@id='btnSave'][@value='Save']"));
		// Find and click the submit button
        System.out.println("Employee details Added");
	                     
	}

	@AfterClass

	public void tearDown() {

		// Close the browser
		driver.quit();

}
}
	

