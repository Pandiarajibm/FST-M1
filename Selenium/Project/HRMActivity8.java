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
			WebElement sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
			sales.click();

			// clicking Accounts
			wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Accounts"))).click();

			// Table element
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'list view table')]")));

			List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'list view tab')]/tbody/tr"));
			
			for (int i = 0; i<=9; i++) 
			{
				if (i%2 == 0)
				{ 
					System.out.println(rows.get(i).getText());
				
				}	
				
			}
		}

		@AfterClass(alwaysRun = true)
		public void closeure() {
			driver.close();
		}

	}
