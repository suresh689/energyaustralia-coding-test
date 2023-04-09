package com.sampleTest.apps.stepdefinition;

import com.sampleTest.apps.helper.LoggerHelper;
import com.sampleTest.apps.launcher.TestHarness;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestHarness {
    Logger log = LoggerHelper.getLogger(Hooks.class);

@After
public void endTest(Scenario scenario) {
    if (scenario.isFailed()) {

        try {
            log.info(scenario.getName() + " is Failed");
            final byte[] screenshot = ((TakesScreenshot)testdriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        try {
            log.info(scenario.getName() + " is pass");
            scenario.embed(((TakesScreenshot) testdriver).getScreenshotAs(OutputType.BYTES), "image/png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
}
