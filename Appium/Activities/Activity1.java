package activities;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class Activity1 {
	    // Driver Declaration
		AppiumDriver driver;
	
		// Set up method
		@BeforeClass
	    public void androidSetUP() throws MalformedURLException, URISyntaxException{
		// Set Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options().
	        setPlatformName("android").
	        setAutomationName("UiAutomator2").
	        setAppPackage("com.google.android.calculator").
	        setAppActivity("com.android.calculator2.Calculator").
//          setApp("path/to/apk").   <- Path to apk file calculator app 
	        noReset();

	        // Server Address
	        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

	        // Driver Initialization
	        driver = new AndroidDriver(serverURL, options);
	    }

	    // Test method
	    @Test
	    public void variousLocators() {
	        //using accesibilty id,
			driver.findElement(AppiumBy.accessibilityId("clear")).click();
	    	
	    	driver.findElement(AppiumBy.id("digit_5")).click();
	    
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			
			driver.findElement(AppiumBy.id("digit_8")).click();
	        
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
	        // Find the result using xpath
	        String result = driver.findElement(AppiumBy.xpath("//android.widget.ViewText[@resource-id='result_final']")).getText();

	        // Assertion
	        Assert.assertEquals(result, "40");
	    }

	    // Tear down method
	    @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	    }
	}