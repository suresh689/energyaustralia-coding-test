
package com.sampleTest.apps.launcher;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sampleTest.apps.config.config;
import com.sampleTest.apps.helper.CreateReportLink;
import com.sampleTest.apps.helper.LoggerHelper;
import com.sampleTest.apps.utilities.BaseDeviceView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class TestHarness {



	DeviceWrapper deviceSetup;

	public static AppiumDriver<MobileElement> testdriver;
	public static IOSDriver<MobileElement> iOSdriver;
	LoadConfigurations load;
	String name;
	public Logger log = LoggerHelper.getLogger(TestHarness.class);

	@BeforeSuite
	public AppiumDriver<MobileElement> setupDriver() throws IOException, InterruptedException {
		loadconfigurations("AppsConfig.properties");
		deleteScreenshots("Screenshots");
		deleteScreenshots("screenshotsFailedTests");

		if (config.getPlatform().equalsIgnoreCase("android")) {
			BaseDeviceView.getAttributeType = "name";
			testdriver = DeviceWrapper.StartAndroidDriver();
			log.info("Setup of Android Test Environment is started");
		} else if (config.getPlatform().equalsIgnoreCase("iOS")) {

			testdriver = DeviceWrapper.StartiOSDriver();
			log.info("Setup of iOS Test Environment is started");
			if (isElementDisplayed(BaseDeviceView.getAttributeType = "value")) {
				BaseDeviceView.getAttributeType = "value";
			} else {
				BaseDeviceView.getAttributeType = "label";
			}
		} else if (config.getPlatform().equalsIgnoreCase("MobileChrome")) {
            testdriver = DeviceWrapper.StartMobileChromeDriver();

		} else if (config.getPlatform().equalsIgnoreCase("MobileSafari")) {
			testdriver = DeviceWrapper.StartMobileSafariDriver();
		}

		log.info("The driver instance is " + testdriver.toString());
		return testdriver;

	}


	private void loadconfigurations(String configFileName) {

		log.info("Method called for loading config file.");
		load = new LoadConfigurations();
		load.LoadConfigurationsProperties(configFileName);

	}

	@AfterSuite
	public void stopTest(ITestContext context) throws InterruptedException {
		String reportPath = System.getProperty("user.dir") + "/TestResults/cucumber-reports/" + "TestAutomation.html";
		log.info("Report Path Location:  " + reportPath);


		if (config.getCloudExecution().equalsIgnoreCase("true")) {
			String purl = new CreateReportLink().generatePresignedURL(name.replace(".html", ".tar.gz")).toString();
			log.info("The generated presigned URL is: " + purl);
			System.out.println(("The generated presigned URL is: " + purl));
			String cmd1 = "tar -cvzf TestResults.tar.gz TestResults";
			String cmd2 = "curl -T TestResults.tar.gz " + purl;
			try {
				Process p1 = Runtime.getRuntime().exec(cmd1);
				p1.waitFor();
				Process p2 = Runtime.getRuntime().exec(cmd2);
				p2.waitFor();
				log.info("The test report file has been successfully uploaded to S3 bucket");
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		testdriver.quit();

	}

	public void openApp() throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String bundileID = config.getBundleID();
			testdriver.activateApp(bundileID);
			log.info("Launching iOS App");
			Thread.sleep(25);

		} else {
			String apppackage = config.getAppPackage();

			testdriver.activateApp(apppackage);
			log.info("Launching Android App");
			Thread.sleep(80000);

		}
	}


	private boolean isElementDisplayed(String string) {
		return false;
	}

	public void deleteScreenshots(String fileName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/" + fileName + "/");
		String[] myFiles;
		if (file.isDirectory()) {
			myFiles = file.list();
			for (int i = 0; i < myFiles.length; i++) {
				File myFile = new File(file, myFiles[i]);
				myFile.delete();
			}

		}

	}

}
