package com.sampleTest.apps.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.concurrent.TimeUnit;

public class EmailReporter {
	static WebDriver driver = null;

	public static void Reportgeneration(String reportPath) {

		WebElement elementCategory;

		String destinationPath = System.getProperty("user.dir");
		String phantomJSExePath = System.getProperty("user.dir") + "/phantomjs";
		try {

			try {
				if (!new File(reportPath).exists()) {
					throw new Exception("Report not found at " + reportPath);
				}
				if (!new File(destinationPath).exists()) {
					throw new Exception("Destination folder not found at "
							+ destinationPath);
				}

				if (!new File(phantomJSExePath).exists()) {
					throw new Exception(
							"PhantomJS Exe not found on the given path - "
									+ phantomJSExePath);
				}

				System.out.println("Report Path - " + reportPath);
				System.out.println("Destination Folder - " + destinationPath);
				System.out.println("PhantomJS Path - " + phantomJSExePath);

				System.setProperty("phantomjs.binary.path", phantomJSExePath);

				System.out.println("Creating Phantom Instance...");
				driver = new PhantomJSDriver();

				driver.get("file:///" + reportPath); // append htmlfilelocation
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				System.out.println("Navigating to Dashboard...");

				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element1 = driver.findElement(By
						.xpath("//a[@view='dashboard-view']//i")); // clicking
																	// on
																	// dashboard
																	// of html
																	// page
				js.executeScript("arguments[0].click();", element1);
				System.out.println("Getting snapshot of Report sections...");
				TimeUnit.SECONDS.sleep(5);
				driver.findElement(By.xpath("//*[@id=\"theme-selector\"]"))
						.click();
				TimeUnit.SECONDS.sleep(5);
				elementCategory = driver.findElement(By
						.xpath("//*[@id=\"charts-row\"]"));

				takeSnapShot(destinationPath + "/categoryimage.png",
						elementCategory);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			System.out.println("Creating HTML file...");
			File resultFile = new File(destinationPath + "/emailreport.html");
			PrintWriter writer = new PrintWriter(resultFile);
			writer.write("<html>\n");
			writer.append("<body>\n");
			writer.append("<p><img src=\"categoryimage.png\"/></p>\n");
			writer.append("<br/>\n");

			writer.append("</html>\n");
			writer.close();
			System.out.println("Email Report Generation Complete!");
		} catch (NoSuchElementException e) {
			System.out
					.println("Error with XPath. Please check the XPath values");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error Message = " + e.getMessage());
			e.printStackTrace();
		} finally {
			// driver.close();
		}
	}

	public static void takeSnapShot(String destinationPath,
			WebElement webElement) throws IOException {

		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE); // storing
																		// screenshot
																		// in
																		// srcfile
			BufferedImage fullImg = ImageIO.read(srcFile);

			Point point = webElement.getLocation(); // getting upper left corner
													// of particular section
			int width = webElement.getSize().getWidth(); // find width from that
															// corner
			int height = webElement.getSize().getHeight(); // find height from
															// that corner
			BufferedImage ElementScreenshot = fullImg.getSubimage(point.getX(),
					point.getY(), width, height);// getting subimage from
													// complete webpage
			ImageIO.write(ElementScreenshot, "png", srcFile);
			File DestFile = new File(destinationPath); // create the png file in
														// particular folder
			FileUtils.copyFile(srcFile, DestFile);
		} catch (WebDriverException e) {
			System.out.println("webdriver Exception");
		} catch (IOException e) {
			System.out.println("InputOutput Exception");
		}
	}
}
