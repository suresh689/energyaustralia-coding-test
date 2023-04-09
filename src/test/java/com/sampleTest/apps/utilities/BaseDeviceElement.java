package com.sampleTest.apps.utilities;

import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;

import com.sampleTest.apps.config.config;
import com.sampleTest.apps.helper.LoggerHelper;
import com.sampleTest.apps.launcher.TestHarness;

import io.appium.java_client.MobileElement;

public abstract class BaseDeviceElement extends TestHarness {
	protected Object elementSelector;
	protected static Logger log = LoggerHelper.getLogger(BaseDeviceElement.class);

	/**
	 * Returns the current date in the jvm's timezone
	 *
	 * @param
	 * @param
	 * @return Date object
	 */
	public static long getCurrentDate() {

		Calendar cal = Calendar.getInstance();
		return cal.getTime().getTime();
	}

	public static int getRandomNumber() {

		Random rnd = new Random();
		int id = rnd.nextInt(5000);
		return id;

	}

	public String verify_text(MobileElement element) throws InterruptedException {
		String text = element.getAttribute(BaseDeviceView.getAttributeType).replaceAll("\\r|\\n", "");
		// replaceAll("\\s", "");
		log.info("User found text in screen is available : " + text);
		return text;
	}

	public String verify_text_trim(MobileElement element) throws InterruptedException {
		String text = element.getAttribute(BaseDeviceView.getAttributeType).trim();
		log.info("User found text in screen is available : " + text);
		return text;
	}

	public boolean verify_element_Enabled(MobileElement element) {
		boolean res = element.isEnabled();
		log.info("User found  element in screen is available : " + res);
		return res;
	}

	public boolean verify_element_Display(MobileElement element) {
		boolean res = element.isDisplayed();
		log.info("User found  element is Displayed in screen is available : " + res);
		return res;
	}

	public boolean verify_element_Present(MobileElement element) {
		boolean res = false;

		try{
			res = element.isDisplayed();
			log.info("User found  element is present : " + res);
			return res;
		}
		catch (Exception e)
		{
			log.info("User found  element is present : " + res);
			return res;
		}
	}

	public void tap(MobileElement element) {
		element.click();
		log.info("User Tap MobileElement is  : " + element);

		// tap(sizeList.get(i));
	}

	public void clearTextBoxWithTip(MobileElement element) {
		element.clear();
		log.info("User Clear Text Box With Tip is  : " + element);
	}

	public String verify_text_value(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("value").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("name").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}
	}

	public String verify_text_label(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("label").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("name").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}

	}

	public String verify_text_text(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("value").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("text").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}
	}

	public void type(MobileElement element, String text){
		element.clear();
		element.sendKeys(text);
		log.info("User type in MobileElement : " + text);
	}

}
