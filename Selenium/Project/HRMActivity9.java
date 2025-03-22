package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.*;

		public class HRMActivity9 {
		
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
			public void infoPage() {
				 
				Actions builder = new Actions(driver);
				WebElement menu= driver.findElement(By.id("menu_admin_viewAdminModule"));
				menu.click();
				System.out.println("Updating My info details" );
				builder.pause(3000).scrollByAmount(0, 300).pause(500).build().perform();
				WebElement qual=driver.findElement(By.xpath("//a[contains(text(),'Qualification')]"));
				//a.pause(1000).scrollToElement(qual).pause(1000).click().build().perform();
				qual.click();
				System.out.println("Adding my qualification details" );
				WebElement addWork=driver.findElement(By.xpath("//input[@id='addWorkExperience']"));
				addWork.click();
				System.out.println("Adding my experience details" );
				WebElement companyName=driver.findElement(By.id("experience_employer"));
				WebElement companyJob=driver.findElement(By.id("experience_jobtitle"));
				WebElement companyFrom=driver.findElement(By.id("experience_from_date"));
				WebElement companyTo=driver.findElement(By.id("experience_to_date"));
				
				companyName.clear();
				companyJob.clear();
				companyFrom.clear();
				companyTo.clear();
				companyName.sendKeys("IBM");
				companyJob.sendKeys("CEO");
				companyFrom.sendKeys("2020-03-16");
				companyTo.sendKeys("2020-03-16");

				driver.findElement(By.id("btnWorkExpSave")).click();
						
				
				//a.scrollToElement(qual).pause(1000).click().pause(1000).perform();
				//WebElement qual=driver.findElement(By.linkText("Qualification"));
				//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				
				
				
			}
			private String windowscscrollBy(int i, int j) {
				// TODO Auto-generated method stub
				return null;
			}

			@AfterClass

			public void tearDown() {
				
				// Close the browser
				driver.quit();

		}

		}



