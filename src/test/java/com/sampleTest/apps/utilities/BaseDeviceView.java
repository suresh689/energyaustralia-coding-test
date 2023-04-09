package com.sampleTest.apps.utilities;

import com.sampleTest.apps.config.config;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class BaseDeviceView extends BaseDeviceElement {

	public static String getAttributeType = null;
	protected Wait<WebDriver> wait;
	protected MobileElement element = null;
	AppiumDriver<MobileElement> driver;

	public BaseDeviceView() {

	}

	/**
	 * This method will wait for Webelement to appear
	 * 
	 * @param element
	 * @param timeout
	 */
	// Wait for element present for Mobile element
	public void waitForWebElementPresent(MobileElement element, int timeout) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method will wait for a Mobile element present
	 */

	// Wait for element present for lists MobileElement

	public void waitForListOfWebElementsPresent(List<WebElement> elements, int timeout) {
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void fluentWait(WebDriver driver, long withTimeoutDuration) {

		wait = new FluentWait<WebDriver>(driver).withTimeout(withTimeoutDuration, TimeUnit.SECONDS).pollingEvery(3,
				TimeUnit.SECONDS);

	}

	public boolean isAlertPresent(MobileElement element, long withTimeoutDuration) {
		fluentWait(testdriver, withTimeoutDuration);
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			log.info("Alert not present");
			return false;
		} else
			log.info("Alert not present");
		return true;
	}

	public void visibilityOf(MobileElement element, long withTimeoutDuration) {
		fluentWait(testdriver, withTimeoutDuration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean textToBePresentInElementAttributeValue(MobileElement element, String attributeValue) {
		fluentWait(testdriver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, attributeValue));

	}

	public boolean titleContains(String title) {
		fluentWait(testdriver, 10);
		return wait.until(ExpectedConditions.titleContains(title));

	}

	public void waitForElementToBeClickable(MobileElement element, long withTimeoutDuration) {
		fluentWait(testdriver, withTimeoutDuration);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public boolean isElementDisplayed(MobileElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}
	
	public boolean isElementDisplayed(MobileElement element,
			long withTimeoutDuration) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	// Wait
	public void waitForElementPresent(int Seconds) {
		int miliseconds;
		try {
			miliseconds = Seconds * 1000;
			Thread.sleep(miliseconds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseHover(MobileElement element) {
		Actions action = new Actions(testdriver);
		action.moveToElement(element).build().perform();
	}

	public void elementMouseClick(MobileElement element) {
		Actions action = new Actions(testdriver);
		action.moveToElement(element).click().build().perform();
	}

	public void acceptAlerts() {
		try {
			Thread.sleep(2);
			testdriver.switchTo().alert().accept();
			log.info("Alerts Presented and tap Accept");
		} catch (Exception ex) {
			log.info("Alerts not Presented");
		}
	}

	public void dismissAlerts() {
		try {
			Thread.sleep(2);
			testdriver.switchTo().alert().dismiss();
			log.info("Alerts Presented and tap Dismiss");
		} catch (Exception ex) {
			log.info("Alerts not Presented");
		}
	}

	public void captureAlerts() {
		try {
			Thread.sleep(2);
			testdriver.switchTo().alert().getText();

		} catch (Exception ex) {
			log.info("Alerts not Presented");
		}
	}

	public boolean backButton() {
		boolean flag = true;
		try {
			//Androiddriver.pressKeyCode(AndroidKeyCode.BACK);
			((AndroidDriver) testdriver).pressKey(new KeyEvent(AndroidKey.BACK));

		} catch (Exception ex) {
			log.error("Unable to click Android Device back button");
			flag = false;
		}
		return flag;
	}
	public boolean navigateBack() {
		testdriver.navigate().back();
		return true;
	}

	public boolean enterButton(MobileElement element) {
		boolean flag = true;
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			element.sendKeys(Keys.ENTER);
		} else {
			((AndroidDriver) testdriver).pressKey(new KeyEvent(AndroidKey.ENTER));
//			((PressesKeyCode) testdriver).pressKeyCode(AndroidKeyCode.ENTER);

		}
		return flag;
	}

	/**
	 * Swipes down from the top of the screen
	 * @throws InterruptedException 
	 * 
	 */

	public void swipeUp() throws InterruptedException {
		Thread.sleep(2);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.90); //0.70
		int endY = (int) (size.height * 0.30);
		int startX = size.width / 2;

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.50);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(6, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}

	public void swipeUp_PDP() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.40);
		int endY = (int) (size.height * 0.10);
		int startX = size.width / 2;


	/*	Dimension dimension = driver.manage().window().getSize();
		int s_x= (int) (dimension.width *0.5);
		int s_y=(int) (dimension.height *0.8);
		int e_x= (int) (dimension.width * 0.2);
		int e_y= (int) (dimension. height *0.2);*/


		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.20);

		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(15, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}

		/*tAction.press(PointOption.point(s_x, s_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
								.moveTo(PointOption.point(e_x,e_y)).release().perform();*/
		log.info("Swipe Up completed");
	}
	public void swipeUp_PDP3() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.60);
		int endY = (int) (size.height * 0.20);
		int startX = size.width / 2;

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.50);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(15, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}

	public void swipeUp_PDPgdms() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.60);
		int endY = (int) (size.height * 0.20);
		int startX = size.width/10; //  swipe left side of the screen

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.20);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(15, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}
	
	public void swipeUp_PDPgdms1() throws InterruptedException {
	//	((JavascriptExecutor) driver) .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject); */
		

	}
	public void swipeUp_PDP2() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		System.out.println(size);
		int startY = (int) (size.height * 0.80);//0.80
		int endY = (int) (size.height * 0.50); //0.50
		int startX = size.width / 2;

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.20);
		System.out.println(startX+","+iosEndY);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(15, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}
	
	public void swipeUp_PDP1() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.20);
		int endY = (int) (size.height * 0.10);
		int startX = size.width / 2;

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.20);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(15, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}

	public void swipeLefttoRightOnElement(int yAxis) throws InterruptedException {
		Thread.sleep(1);
		log.info("About to swipe from Right to Left");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 15);
		int startY = (int) yAxis;

		int endX = (int) (size.width / 1008.0);
		int endY = (int) yAxis;

		TouchAction tAction = new TouchAction(testdriver);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(endX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(-size.width / 2, 0)).release()
					.perform();
		} else {
			tAction.press(PointOption.point(endX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, startY)).release().perform();
		}
		log.info("Swipe from Right to Left completed");
	}

	public void swipeDown() {
		Duration smallWait = Duration.ofMillis(1000);
		log.info("About to do swipe");
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) size.width / 2;
		int startY = (int) size.height / 4;
		int endX = (int) size.width / 2;
		int endY = (int) (size.height / 2);

		TouchAction tAction = new TouchAction(testdriver);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(6, endY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(endX, endY)).release().perform();
		}
		log.info("Swipe  Down completed");
	}

	public void swipeRightToLeftOnElement(int yAxis) {
		log.info("About to swipe from Right to Left");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 15);
		int startY = (int) yAxis;

		int endX = (int) (size.width / 1008.0);
		int endY = (int) yAxis;

		TouchAction tAction = new TouchAction(testdriver);
		tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(endX, endY)).release().perform();
		log.info("Swipe from Right to Left completed");
	}

	public void swipeLeftToRightOnElement(int yAxis) {
		log.info("About to swipe from Right to Left");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 15);
		int startY = (int) yAxis;

		int endX = (int) (size.width / 1008.0);
		int endY = (int) yAxis;

		TouchAction tAction = new TouchAction(testdriver);
		tAction.press(PointOption.point(endX, endY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, startY)).release().perform();
		log.info("Swipe from Right to Left completed");
	}

	public void swipeRightToLeft() {
		log.info("About to swipe from Right to Left");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 5);
		int startY = (int) (size.height / 2);

		int endX = (int) (size.width / 5);
		int endY = (int) (size.height / 2);
		TouchAction tAction = new TouchAction(testdriver);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(-size.width / 4, 0)).release()
					.perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(endX, endY)).release().perform();
		}

		log.info("Swipe RightToLeft completed");
		// We may have to refresh the page on android
		if (!config.getPlatform().equalsIgnoreCase("iOS")) {
			log.info("Refreshing the page");
			testdriver.getPageSource();
		}
	}

	public void swipeLeftToRight() {
		log.info("About to swipe from Left to Right");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 5);
		int startY = (int) (size.height / 2);

		int endX = (int) (size.width / 5);
		int endY = (int) (size.height / 2);
		TouchAction tAction = new TouchAction(testdriver);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(endX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(-size.width / 4, 0)).release()
					.perform();
		} else {
			tAction.press(PointOption.point(endX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, startY)).release().perform();
		}

		log.info("Swipe Left To Right completed");
		// We may have to refresh the page on android
		if (!config.getPlatform().equalsIgnoreCase("iOS")) {
			log.info("Refreshing the page");
			testdriver.getPageSource();
		}
	}

	/**
	 * @return
	 * @return the x coordinate of the current center of the element
	 */
	public int getCenterX() {
		return this.getLocation().getX() + (this.getDimension().getWidth() / 2);
	}

	/**
	 * @return the y coordinate of the current center of the element
	 */
	public int getCenterY() {
		return this.getLocation().getY() + (this.getDimension().getHeight() / 2);
	}

	/**
	 * Tap Center of Element
	 */
	public void tapCenterOfElement() {
		Duration smallWait = Duration.ofMillis(1000);

		if (config.getPlatform().equalsIgnoreCase("iOS") && !element.isDisplayed()) {
			Dimension size = testdriver.manage().window().getSize();
			int startY = (int) (size.height * 0.80);
			int startX = (int) (size.width / 3) * 2;
			TouchAction tAction = new TouchAction(testdriver);
			int iosEndY = (int) (size.height * 0.60);
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(0, -iosEndY)).release().perform();
		}
		log.info(String.format("Tapping center of element (%d,%d)", getCenterX(), getCenterY()));
		TouchAction touchAction = new TouchAction(testdriver).tap(PointOption.point(getCenterX(), getCenterY())).release();
		touchAction.perform();
	}

	public String UiScrollable(MobileElement mobileElement) {
		return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mobileElement
				+ ".instance(0));";

	}

	/**
	 * @return Dimension of the element
	 */
	public Dimension getDimension() {
		return element.getSize();
	}

	/**
	 * @return Point location of element
	 */
	public Point getLocation() {
		return element.getLocation();
	}

	public void doubleTap(MobileElement element) {
		Actions action = new Actions(testdriver);
		action.doubleClick(element);
		action.perform();
	}

	public void longPress(MobileElement element) {
		TouchAction a = new TouchAction(testdriver);
		a.longPress(LongPressOptions.longPressOptions()
				.withElement (ElementOption.element (element)));
		a.perform();
	}

	public void product_Random_Click(List<MobileElement> element) {

		List<MobileElement> links = element;
		links.get(new Random().nextInt(links.size())).click();

	}

	public void appInBackground() {

		testdriver.runAppInBackground(Duration.ofSeconds(5));
		// put app in background for 5 seconds
		testdriver.launchApp();// launch the app again
		// currentActivity();
	}

	public void app_WebView() {

		Set<String> contextNames = testdriver.getContextHandles();

		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like
												// NATIVE_APP \n WEBVIEW_1
			if (contextName.contains("WebView")) {
				testdriver.context((String) contextNames.toArray()[0]);
			}
		}


		testdriver.context("NATIVE_APP");
		// do more native testing if we want

	}

	public void clearTextBox() {
		log.info(String.format("Clearing textbox with selector [%s].", this.elementSelector.toString()));
		TouchAction tAction = new TouchAction(testdriver);
		if (config.getPlatform().equals("iOS")) {
			element.clear();
		} else {
			// clear it, Hard way in android
			element.click();
			testdriver.performTouchAction(tAction.longPress(LongPressOptions.longPressOptions()
					.withElement (ElementOption.element (element))));
//			((AndroidDriver) testdriver).pressKeyCode(AndroidKeyCode.DEL);
			((AndroidDriver) testdriver).pressKey(new KeyEvent(AndroidKey.DEL));
		}
	}

	public void scrollToClick(String menuText) {

		testdriver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + menuText + "\"));"))
				.click();

	}

	public void javaScriptExecute(MobileElement element) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void hidekeyboard() {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {

			//TouchAction tap = new TouchAction(testdriver);
			//tap.tap(PointOption.point(1280, 1013)).perform();
			((HidesKeyboard) testdriver).hideKeyboard();
		} else {

			((HidesKeyboard) testdriver).hideKeyboard();
		}
	}

	public void hideKeyBoard_UsingElement(MobileElement element) {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			// testdriver.getKeyboard().sendKeys(Keys.RETURN);
			/*
			 * TouchAction tap = new TouchAction(testdriver);
			 * tap.tap(PointOption.point(1280, 1013)).perform();
			 */
			element.click();
		} else {

			((HidesKeyboard) testdriver).hideKeyboard();
		}
	}

	public void scroll(String down) {

		JavascriptExecutor js = (JavascriptExecutor) testdriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", down);
		js.executeScript("mobile: scroll", scrollObject);

	}
	
	public void scrollup(String up) {

		JavascriptExecutor js = (JavascriptExecutor) testdriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", up);
		js.executeScript("mobile: scroll", scrollObject);

	}

	public void scrollToElement(MobileElement element) {
		Duration smallWait = Duration.ofMillis(1000);

		do {
			Dimension size = testdriver.manage().window().getSize();
			int startY = (int) (size.height * 0.80);
			int startX = size.width / 3 * 2;
			TouchAction tAction = new TouchAction(testdriver);
			int iosEndY = (int) (size.height * 0.60);
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(0, -iosEndY)).release().perform();

		} while (config.getPlatform().equalsIgnoreCase("iOS") && !element.isDisplayed());

	}
	
	
	public boolean seekBarSlider_Left(MobileElement element) throws InterruptedException {

		MobileElement seek_bar = element;
		int startX=seek_bar.getLocation().getX();
		int startY = seek_bar.getLocation().getY();
		int end = (int) (startX+((seek_bar.getSize().getWidth()) *0.80));//1008.0
		TouchAction action = new TouchAction(testdriver);
		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(end,startY)).release().perform();
	    return true;

	}
	public boolean seekBarSlider_Right(MobileElement element) throws InterruptedException {

		MobileElement seek_bar = element;
		int startX=seek_bar.getLocation().getX();
		int startY = seek_bar.getLocation().getY();
		int end = (int) (startX+((seek_bar.getSize().getWidth()) *0.200));//1008.0
		TouchAction action = new TouchAction(testdriver);
		//action.longPress(startX, startY).moveTo(end,startX).release().perform();
		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(end,startX)).release().longPress(LongPressOptions.longPressOptions()
				.withElement (ElementOption.element (seek_bar))).perform();
		
	    return true;

	}
	
	public boolean seekBarSlider(MobileElement element) throws InterruptedException {

		MobileElement seek_bar = element;
		int start=seek_bar.getLocation().getX();
		int y=seek_bar.getLocation().getY();
		int end=seek_bar.getSize().getWidth();
		TouchAction action = new TouchAction(testdriver);
        int moveTo=(int)(end*0.4);
		action.press(PointOption.point(start,y)).moveTo(PointOption.point(moveTo,y)).release().perform();
	    return true;

	}
	public void scrollUsingTouchActionsByElements(MobileElement startElement) throws InterruptedException {
		while(!verify_element_Present(startElement)){
			if(config.getPlatform().equalsIgnoreCase("iOS")) {
				swipeUp_PDP2();
			}else {
				swipeUpToElement();
			}
		}
	}

	public void swipeUpToElement() throws InterruptedException {
		Thread.sleep(2);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startY = (int) (size.height * 0.50);
		int endY = (int) (size.height * 0.10);
		int startX = size.width / 2;

		TouchAction tAction = new TouchAction(testdriver);
		int iosEndY = (int) (size.height * 0.50);
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(6, -iosEndY)).release().perform();
		} else {
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait)).moveTo(PointOption.point(startX, endY)).release().perform();
		}
		log.info("Swipe Up completed");
	}

	public void click_Mid_Upper() throws InterruptedException {
		Thread.sleep(1);
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int x = (int) (size.width / 2);
		int y = (int) (size.height * 0.25);

		TouchAction tAction = new TouchAction(testdriver);
		tAction.tap(PointOption.point(x,y)).perform();

		log.info("click completed");
	}

}