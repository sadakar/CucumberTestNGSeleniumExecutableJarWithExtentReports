package com.sadakar.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		//tags = "@HRMLogin and not @AddEmployee",

		features = "classpath:features", glue = { "com.sadakar.common", "com.sadakar.stepdefinitions",
				"com.sadakar.testng.runner" },

		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumberreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

		monochrome = true)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}