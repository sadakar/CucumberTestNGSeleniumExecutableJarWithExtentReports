package com.sadakar.stepdefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.sadakar.common.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then; 
public class HRMLoginPage extends BasePage {

	
	@Given("User login to HRM application with UserName and Password")
	public void loginToHRMApp(io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> cells = dataTable.cells();
		driver.findElement(By.xpath("BAD//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(cells.get(0).get(0));
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys(cells.get(0).get(1));
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).submit();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Then("User navigates to Employee list page")
	public void navigateToDashboardTab() {
	   
		// login navigation url verification
		String actualNavigation = driver.getCurrentUrl();
		String expectedNavigation = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		Assert.assertEquals(actualNavigation,expectedNavigation);	
		
		// Add button presense and enable status validation 
		WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		addButton.isDisplayed();
		addButton.isEnabled();
	}
}