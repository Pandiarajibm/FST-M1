package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	//open a page
	driver.get("https://training-support.net");
	
	// Print the title of the home page
	System.out.println("Current page Title " + driver.getTitle());
	// Find the About us button and click it.
	driver.findElement(By.linkText("About Us")).click();
	
	// Print the page title of the About Us page
	System.out.println("New page title is: " + driver.getTitle());
	
	}

}
