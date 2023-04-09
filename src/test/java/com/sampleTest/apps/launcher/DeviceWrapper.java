
package com.sampleTest.apps.launcher;

import com.google.common.collect.ImmutableMap;
import com.sampleTest.apps.config.config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DeviceWrapper {

	static AppiumDriverLocalService service;

	private static AndroidDriver<MobileElement> androidDriver;
	private static IOSDriver<MobileElement> iOSDriver;
	protected static Logger log = LogManager.getLogger(Logger.class.getName());

	public static AppiumDriver<MobileElement> StartAndroidDriver() throws MalformedURLException, InterruptedException {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		capability.setCapability(MobileCapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getAutomationName());
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, config.getAndroidDeviceName());
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getMobileVersion());
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, config.getImplictwaittime());
		capability.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		capability.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability("autoWebView", "true");
		capability.setCapability("INSTALL_GRANT_RUNTIME_PERMISSIONS", "true");
		capability.setCapability(MobileCapabilityType.APP, config.getAppFilePath());
		capability.setCapability("webContentsDebuggingEnabled", "true");
		capability.setCapability("ensureWebviewsHavePages", "true");
		capability.setCapability(MobileCapabilityType.UDID, config.getDeviceUDID());

		/*
		 * New Splash Page Arrived in React app so added appactivity. It is same
		 * for all apps in React.
		 */


			capability.setCapability(MobileCapabilityType.APP,
					System.getProperty("user.dir") + "/apps/android/GCC/" + config.getAppFilePath());
		androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + config.getPort() + "/wd/hub"),
				capability);
		androidDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		boolean deviceLocked = androidDriver.isDeviceLocked();
		if (deviceLocked == true) {
			androidDriver.unlockDevice();
		}
		return androidDriver;

	}

	public static AppiumDriver<MobileElement> StartiOSDriver() throws MalformedURLException, InterruptedException {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(config.getNodePath()))
						.withAppiumJS(new File(config.getAppiumPath())).withIPAddress("0.0.0.0")
						.usingPort(config.getPort()).withLogFile(new File(config.getAppiumlogfilepath())));
		service.start();
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getAutomationName());
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIphoneDeviceName());
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, config.getImplictwaittime());
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
		capability.setCapability("autoDismissAlerts", "");
		capability.setCapability(MobileCapabilityType.APP,
					System.getProperty("user.dir") + "/apps/IOS/" + config.getAppFilePath());
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		capability.setCapability(MobileCapabilityType.UDID, config.getDeviceUDID());
		capability.setCapability("showXcodeLog", "true");
		capability.setCapability("useNewWDA", "true");
		capability.setCapability("autoWebView", "true");
		capability.setCapability("realDeviceLogger", "/usr/local/bin/idevicesyslog");
		capability.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		Thread.sleep(2000);
		iOSDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:" + config.getPort() + "/wd/hub"),
				capability);
		iOSDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return iOSDriver;
	}

	public static AppiumDriver<MobileElement> StartMobileChromeDriver() throws MalformedURLException, InterruptedException {
		log.info("Before start appium server");
		log.info("Launching mobile device browser - Chrome for test execution");
		service.start();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 40);
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capability.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + config.getPort() + "/wd/hub"),
				capability);
		return androidDriver;
	}

	public static AppiumDriver<MobileElement> StartMobileSafariDriver() throws MalformedURLException, InterruptedException {
		log.info("Before start appium server");
		log.info("Launching mobile device browser - Safari for test execution");
		service.start();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIphoneDeviceName());
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getAutomationName());
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 150);
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capability.setCapability(MobileCapabilityType.FULL_RESET, "True");
		capability.setCapability(MobileCapabilityType.UDID, config.getDeviceUDID());
		iOSDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:" + config.getPort() + "/wd/hub"),
				capability);
		return iOSDriver;
	}

	public AndroidDriver<MobileElement> startADFAndroidAppiumService()
			throws IOException, MalformedURLException, InterruptedException {

		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		URL url = new URL(URL_STRING);

		// Use a empty DesiredCapabilities object
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, new DesiredCapabilities());

		return driver;
	}

	public static void stopAppiumServer() throws InterruptedException {

		log.info("Stoping appium server");
		String stopCommand = "-i:" + config.getPort();
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(new String[] { "lsof", "-t", stopCommand });
			BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			String pid = "";
			while ((line = r.readLine()) != null) {
				Process killProcess = runtime.exec(new String[] { "ps", "-p", line, "-o", "comm=" });
				BufferedReader br = new BufferedReader(new InputStreamReader(killProcess.getInputStream()));
				pid = br.readLine();
				if (pid.equals("/usr/local/bin/node")) {
					runtime.exec(new String[] { "kill", line });
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Appium server not found");
		}
	}

	public void stopAndroidService() throws IOException, InterruptedException {
		service.stop();
		Thread.sleep(2000);
	}

	public void stopIOSService() throws InterruptedException {
		service.stop();
		Thread.sleep(2000);
	}

}
