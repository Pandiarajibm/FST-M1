package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableExampleSteps extends BaseClass {

	@Given("User user is on the To-Do list page")
	public void completeRequirement() {
        driver.get("https://training-support.net/webelements/todo-list");
		System.out.println("Given completed");
		assertEquals.(driver.getTitle(), "Selenium: To-Do List")
	}

	@When("user adds the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException {
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);

		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);
		}
	}

	@Then("they can see the tasks added to the list")
	public void verifyResults() {
		System.out.println("All tasks present");
	}
}