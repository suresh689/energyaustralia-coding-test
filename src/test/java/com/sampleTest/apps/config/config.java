package com.sampleTest.apps.config;

public class config {
	private static String automationName;
	private static String platform;
	private static String app;
	private static String concept;
	private static String country;
	private static String language;
	private static int port;
	private static String appiumPath;
	private static String appiumlogfilepath;
	private static String androidDeviceName;
	private static String iphoneDeviceName;
	private static String takescreenshot;
	private static String implictwaittime;
	private static String nodePath;

	private static String mobileVersion;
	private static String appFilePath;
	private static String buildVersion;
	private static String executionType;
	private static String cloudExecution;
	private static String appPackage;
	private static String bundileID;
	private static String deviceUDID;
	private static String appVersion;
	private static String appId;
	private static boolean sIsAppiumRunning = false;

	public static String getExecutionType() {
		return executionType;
	}

	public static void setExecutionType(String executionType) {
		config.executionType = executionType;
	}

	public static void setCloudExecution(String cloudExecution) {
		config.cloudExecution = cloudExecution;
	}

	public static String getCloudExecution() {
		return cloudExecution;
	}

	public static String getBuildVersion() {
		return buildVersion;
	}
	public static String getAppversion() {
		return appVersion;
	}
	public static void setBuildVersion(String buildVersion) {
		config.buildVersion = buildVersion;
	}

	public static String getAppFilePath() {
		return appFilePath;
	}

	public static void setAppVersion(String appVersion) {
		config.appVersion = appVersion;
	}
	public static void setAppFilePath(String appFilePath) {
		config.appFilePath = appFilePath;
	}

	public static String getNodePath() {
		return nodePath;
	}

	public static void setNodePath(String nodePath) {
		config.nodePath = nodePath;
	}

	public static String getAutomationName() {
		return automationName;
	}

	public static void setAutomationName(String automationName) {
		config.automationName = automationName;
	}

	public static String getPlatform() {
		return platform;
	}

	public static void setPlatform(String platform) {
		config.platform = platform;
	}

	public static String getApp() {
		return app;
	}

	public void setApp(String app) {
		config.app = app;
	}

	public static String getConcept() {
		return concept;
	}

	public static void setConcept(String concept) {
		config.concept = concept;
	}

	public static String getCountry() {
		return country;
	}

	public static void setCountry(String country) {
		config.country = country;
	}

	public static String getLanguage() {
		return language;
	}

	public static void setLanguage(String language) {
		config.language = language;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		config.port = port;
	}

	public static String getAppiumPath() {
		return appiumPath;
	}

	public static void setAppiumPath(String appiumPath) {
		config.appiumPath = appiumPath;
	}

	public static String getAppiumlogfilepath() {
		return appiumlogfilepath;
	}

	public static void setAppiumlogfilepath(String appiumlogfilepath) {
		config.appiumlogfilepath = appiumlogfilepath;
	}

	public static String getAndroidDeviceName() {
		return androidDeviceName;
	}

	public static void setAndroidDeviceName(String androidDeviceName) {
		config.androidDeviceName = androidDeviceName;
	}

	public static String getIphoneDeviceName() {
		return iphoneDeviceName;
	}

	public static void setIphoneDeviceName(String iphoneDeviceName) {
		config.iphoneDeviceName = iphoneDeviceName;
	}

	public static String getTakescreenshot() {
		return takescreenshot;
	}

	public static void setTakescreenshot(String takescreenshot) {
		config.takescreenshot = takescreenshot;
	}

	public static String getImplictwaittime() {
		return implictwaittime;
	}

	public static void setImplictwaittime(String implictwaittime) {
		config.implictwaittime = implictwaittime;
	}

	public static String getAppPackage() {
		return appPackage;
	}

	public static void setAppPackage(String appPackage) {
		config.appPackage = appPackage;
	}

	public static String getBundleID() {
		return bundileID;
	}

	public static void setgetBundleID(String bundileID) {
		config.bundileID = bundileID;
	}

	public static boolean getIsAppiumRunning() {
		return sIsAppiumRunning;
	}

	public static String getDeviceUDID() {
		return deviceUDID;
	}

	public static void setdDeviceUDID(String deviceUDID) {
		config.deviceUDID = deviceUDID;
	}

	public static String getMobileVersion() {
		return mobileVersion;
	}

	public static void setMobileVersion(String buildVersion) {
		config.buildVersion = mobileVersion;
	}



	public static String getAppId() { return appId; }

	public static void setAppId(String appId) {
		config.appId = appId;
	}


}
