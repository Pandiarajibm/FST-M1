package activities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
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
				WebElement menu= driver.findElement(By.id("menu_pim_viewMyDetails"));
				menu.click();
				System.out.println("Checking My info details" );
				builder.pause(3000).scrollByAmount(0, 300).pause(500).build().perform();
				WebElement emergencyContact=driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]"));
				emergencyContact.click();
				
				
				WebElement emgcontactList = driver.findElement(By.id("emgcontact_list"));
				System.out.println(emgcontactList);
				List<WebElement> allContacts = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
				int count = 0;
				for (Iterator<WebElement> iterator = allContacts.iterator(); iterator.hasNext();) {
					if(count < 5) {
						WebElement row = (WebElement) iterator.next();
						//type = name
						WebElement nameCell = row.findElement(By.xpath(".//td[@type='name']//a"));
						//type = relate
						WebElement relationCell = row.findElement(By.xpath(".//td[@type='Relationship']//a"));
						WebElement HomeCell = row.findElement(By.xpath(".//td[@type='Home Telephone']//a"));
						WebElement mobileCell = row.findElement(By.xpath(".//td[@type='Mobile']//a"));
						WebElement workCell = row.findElement(By.xpath(".//td[@type='Work Telephone']//a"));
						Reporter.log( " Contact Name: " + nameCell.getText() + " Home Telephone: " + HomeCell.getText() + " Mobile: " + mobileCell.getText() + " Work Telephone: " + workCell.getText(), true);
					} else 
					{
						break;
					}
					count++;
				}
				
							
			}
			
			@AfterClass

			public void tearDown() {
				
				// Close the browser
				driver.quit();

		}

		}



