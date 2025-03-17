package activities;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize driver
        driver = new FirefoxDriver();
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/login-form");
        System.out.println("Home page title: " + driver.getTitle());

    }

    @DataProvider(name = "BadCredentials")
    public  Object[][] creds() {
        Object[][]  Credentials={ 
            { "adminy", "passwordy", "Invalid credentials" },
            { "damin", "password", "Invalid credentials" },
            { "wrongmin", "wrongPassword", "Invalid credentials" }
        };
        return Credentials;
    }

    @Test(dataProvider = "BadCredentials", priority=1)
    public void loginTest(String username, String password, String expectedMessage) {
        // Find the input fields and the login button
    	//driver.navigate.refresh();
    	WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        //wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        // Enter the credentials and click Log in
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Assert login message
        String loginMessage = driver.findElement(By.id("subheading")).getText();
        assertEquals(loginMessage, expectedMessage);
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}