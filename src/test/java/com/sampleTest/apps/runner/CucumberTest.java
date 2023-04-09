package com.sampleTest.apps.runner;



import org.testng.annotations.*;

import com.cucumber.listener.Reporter;

import com.sampleTest.apps.launcher.TestHarness;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = { "src/test/Resources/Feature" },

		glue = { "com.sampleTest.apps.stepdefinition" },
		plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json", "ru.yandex.qatools.allure.cucumberjvm.AllureReporter", "rerun:target/cucumber-reports/rerun.txt",
				"json:target/cucumber.json"},
		monochrome = true,
		dryRun = false ,
		tags = {"@Sample"}
)

public class CucumberTest extends TestHarness {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}


	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}
}
