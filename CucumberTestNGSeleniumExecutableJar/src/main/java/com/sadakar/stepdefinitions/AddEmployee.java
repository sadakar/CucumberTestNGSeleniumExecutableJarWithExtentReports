package com.sadakar.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.sadakar.common.BasePage;
import io.cucumber.java.en.Then; 

public class AddEmployee extends BasePage{
	
	@Then("User navigates to Add Employee page")
	public void directoryPage() {

		// Add Employee menu button
		WebElement addEmployeeMenuElement = driver.findElement(By.xpath("//a[contains(text(),'Add Employee')]"));
		addEmployeeMenuElement.click();
		
		// Navigation to Add Employee page validation
		String expectedAddEmployeeNavigationURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
		String actualAddEmployeeNavigationURL = driver.getCurrentUrl();
		Assert.assertEquals(actualAddEmployeeNavigationURL, expectedAddEmployeeNavigationURL);
		
		// Add Employee page form title label validation
		WebElement addEmployeeLabelElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6"));
		String expectedAddEmployeeLabelText = addEmployeeLabelElement.getText();
		String actualAddEmployeeLabelText = "Add Employee";
		Assert.assertEquals(actualAddEmployeeLabelText, expectedAddEmployeeLabelText);
	}



}
