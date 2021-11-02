package com.qa.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/pankaj.kumar/workspace/FreeCRMTest"
		+ "/src/main/java/com/qa/features/FreeCRM.feature",
		glue = { "com/qa/stepDefinitions" },
		
		monochrome = true, stepNotifications = true,
	
		
		plugin = { "pretty", "junit:target/JSONUnitReports/report.xml",
				"html:target/cucumber-reports/htmlReports/index.html",
				"json:target/JSONReports/report.json" },
		
		strict = true, 
		
		dryRun = false)

public class TestRunner {

}
