package com.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features//",
dryRun = false,
glue = {"StepDefenitions"},
plugin = {"pretty" , "html:target/cucumber-reports" ,
		"json:target/cucumber-reports/cucumber.json" ,
		"com.syf.utilities.CucumberEventListener"} ,
monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests{
	@BeforeClass
	public static void preSetup() {
		BaseClass.preSetup();
	}

}
