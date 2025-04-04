package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
		//AndroidDriver driver;
	    // Set up method
	    @BeforeClass
	    //public void setUp() throws MalformedURLException, URISyntaxException {
	    
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
		
		@BeforeClass
		//for Apple IOS devices 
//		public void iosSetUP() throws MalformedURLException, URISyntaxException {
			// Set Desired Capabilities
//			XCUITestOptions options = new XCUITestOptions().
//				setPlatformName("ios").
//				setAutomationName("XCUITest").
//				setApp("path/to/file.ipa").
			//		noReset();
			// Server Address
	    //    URL serverURL = new URI("http://127.0.0.1:4723").toURL();
			
	     // Driver Initialization
	  //      driver = new IosDriver(serverURL, options);
	//	}
		

	    // Test method
	    @Test
	    public void multiplyTest() {
	        // clear existing values
			//driver.findElement(AppiumBy.id("clr")).click();
			// Perform the calculation
			//in appium inspector/ appium emulator tap digit 5, get the id value 
			driver.findElement(AppiumBy.id("digit_5")).click();
	        //find and tap the multiply symbol
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			//in appium inspector tap digit 5, get the id value 
	        driver.findElement(AppiumBy.id("digit_8")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();

	        // Find the result
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();

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

