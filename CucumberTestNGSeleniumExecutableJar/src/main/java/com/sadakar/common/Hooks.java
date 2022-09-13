package com.sadakar.common;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {

	@Before //Cucumber hook - runs for each scenario
	public static void setupDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@After(order=1) //Cucumber hook - runs for each scenario
	public static void quitDriver() throws Exception {
		driver.quit();
	}
	@After(order = 2) // Cucumber After Hook with order 1
	public void takeScreenShotOnFailedScenario(Scenario scenario) {

		System.out.println("Taking screenshot from Cucumber After hook with order=2 if the scenario fails");
		if ((scenario.isFailed())) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
