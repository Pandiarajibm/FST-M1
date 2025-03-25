package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HRMActivity8 {
	
		WebDriverWait wait;
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

		@Test(priority=2)
		public void applyLeave() {
			// Navigate to Sales
			WebElement leave = driver.findElement(By.linkText("Apply Leave"));//  ("//a[@id='grouptab_0']"));
			leave.click();

			// clicking Accounts
			wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_applyLeave"))).click();
			
			WebElement employeeName=driver.findElement(By.id("applyleave_txtEmployee_empName"));
			WebElement leaveType=driver.findElement(By.id("applyleave_txtLeaveType"));
			WebElement companyFrom=driver.findElement(By.id("assignleave_txtFromDate"));
			WebElement companyTo=driver.findElement(By.id("assignleave_txtToDate"));
			
			companyName.clear();
			companyJob.clear();
			companyFrom.clear();
			companyTo.clear();
			employeeName.sendKeys("Rachana");
			leaveType.sendKeys("DayOff");
			companyFrom.sendKeys("2025-04-16");
			companyTo.sendKeys("2025-04-18");

			driver.findElement(By.id("Apply")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_viewMyLeaveList"))).click();
			
			WebElement FromDate=driver.findElement(By.id("calFromDate"));
			WebElement toDate=driver.findElement(By.id("calToDate"));
			FromDate.sendKeys("2025-04-16");
			toDate.sendKeys("2025-04-18");
			
			driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();

		}
			
		@AfterClass(alwaysRun = true)
		public void closeure() {
			driver.close();
		}

	}
