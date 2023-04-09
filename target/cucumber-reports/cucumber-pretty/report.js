$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Home.feature");
formatter.feature({
  "line": 3,
  "name": "E2E Checkout flow",
  "description": "As a user should be able to proceed with E2E checkout flow",
  "id": "e2e-checkout-flow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Sample"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Verify Home Page while click on Let\u0027s Shop Tab",
  "description": "",
  "id": "e2e-checkout-flow;verify-home-page-while-click-on-let\u0027s-shop-tab",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "User Select Country \"Algeria\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User Enters Name \"\u003centerYourName\u003e\" Click on Search Input Box",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User Choose Gender as \"Male\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User clicks on Lets Shop Button",
  "keyword": "And "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "e2e-checkout-flow;verify-home-page-while-click-on-let\u0027s-shop-tab;",
  "rows": [
    {
      "cells": [
        "enterYourName"
      ],
      "line": 14,
      "id": "e2e-checkout-flow;verify-home-page-while-click-on-let\u0027s-shop-tab;;1"
    },
    {
      "cells": [
        "test user"
      ],
      "line": 15,
      "id": "e2e-checkout-flow;verify-home-page-while-click-on-let\u0027s-shop-tab;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "Verify Home Page while click on Let\u0027s Shop Tab",
  "description": "",
  "id": "e2e-checkout-flow;verify-home-page-while-click-on-let\u0027s-shop-tab;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Sample"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User Select Country \"Algeria\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User Enters Name \"test user\" Click on Search Input Box",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User Choose Gender as \"Male\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User clicks on Lets Shop Button",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Algeria",
      "offset": 21
    }
  ],
  "location": "Home.userSelectCountry(String)"
});
formatter.result({
  "duration": 28455125250,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test user",
      "offset": 18
    }
  ],
  "location": "Home.userEntersNameClickOnSearchInputBox(String)"
});
formatter.result({
  "duration": 25610400458,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: By.chained({By.id: com.androidsample.generalstore:id/nameField})\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:126)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.sendKeys(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.enterUserNmae(HomeScreen.java:69)\n\tat com.sampleTest.apps.stepdefinition.Home.userEntersNameClickOnSearchInputBox(Home.java:37)\n\tat ✽.Then User Enters Name \"test user\" Click on Search Input Box(Home.feature:8)\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@6fd77352 (tried for 1 second(s) with 500 milliseconds interval)\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:304)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:99)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:119)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.sendKeys(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.enterUserNmae(HomeScreen.java:69)\n\tat com.sampleTest.apps.stepdefinition.Home.userEntersNameClickOnSearchInputBox(Home.java:37)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat com.sampleTest.apps.runner.CucumberTest.feature(CucumberTest.java:39)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:80)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:714)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:767)\n\tat org.testng.TestRunner.run(TestRunner.java:617)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:334)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:240)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1198)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1123)\n\tat org.testng.TestNG.run(TestNG.java:1031)\n\tat com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)\n\tat com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.id: com.androidsample.generalstore:id/nameField})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Venkata-Suresh.local\u0027, ip: \u0027fe80:0:0:0:492:3a1f:d5f0:734f%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002712.3\u0027, java.version: \u00271.8.0_351\u0027\nDriver info: driver.version: AndroidDriver\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:74)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:50)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:120)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:172)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\t... 46 more\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Male",
      "offset": 23
    }
  ],
  "location": "Home.userChooseGenderAs(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Home.userClicksOnLetsShopButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1615267375,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify Toast message Error validation",
  "description": "",
  "id": "e2e-checkout-flow;verify-toast-message-error-validation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "User clicks on Lets Shop Button",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Verify toast message",
  "keyword": "Then "
});
formatter.match({
  "location": "Home.userClicksOnLetsShopButton()"
});
formatter.result({
  "duration": 25184630666,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: By.chained({By.id: com.androidsample.generalstore:id/btnLetsShop})\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:126)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.click(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.clickOnLetsShopButton(HomeScreen.java:79)\n\tat com.sampleTest.apps.stepdefinition.Home.userClicksOnLetsShopButton(Home.java:49)\n\tat ✽.And User clicks on Lets Shop Button(Home.feature:18)\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@7b4acdc2 (tried for 1 second(s) with 500 milliseconds interval)\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:304)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:99)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:119)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.click(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.clickOnLetsShopButton(HomeScreen.java:79)\n\tat com.sampleTest.apps.stepdefinition.Home.userClicksOnLetsShopButton(Home.java:49)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat com.sampleTest.apps.runner.CucumberTest.feature(CucumberTest.java:39)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:80)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:714)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:767)\n\tat org.testng.TestRunner.run(TestRunner.java:617)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:334)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:240)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1198)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1123)\n\tat org.testng.TestNG.run(TestNG.java:1031)\n\tat com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)\n\tat com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.id: com.androidsample.generalstore:id/btnLetsShop})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Venkata-Suresh.local\u0027, ip: \u0027fe80:0:0:0:492:3a1f:d5f0:734f%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002712.3\u0027, java.version: \u00271.8.0_351\u0027\nDriver info: driver.version: AndroidDriver\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:74)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:50)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:120)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:172)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\t... 45 more\n",
  "status": "failed"
});
formatter.match({
  "location": "Home.verifyToastMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1004482041,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify User able to add product to basket",
  "description": "",
  "id": "e2e-checkout-flow;verify-user-able-to-add-product-to-basket",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "User Select Country \"Algeria\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User Enters Name \"\u003centerYourName\u003e\" Click on Search Input Box",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User Choose Gender as \"Male\"",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "User clicks on Add to basket",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Algeria",
      "offset": 21
    }
  ],
  "location": "Home.userSelectCountry(String)"
});
formatter.result({
  "duration": 25553418625,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: By.chained({By.id: com.androidsample.generalstore:id/spinnerCountry})\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:126)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.click(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.selectCountry(HomeScreen.java:57)\n\tat com.sampleTest.apps.stepdefinition.Home.userSelectCountry(Home.java:31)\n\tat ✽.When User Select Country \"Algeria\"(Home.feature:22)\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@de77232 (tried for 1 second(s) with 500 milliseconds interval)\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:304)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:99)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:119)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.click(\u003cgenerated\u003e)\n\tat com.sampleTest.apps.pageobjects.HomeScreen.selectCountry(HomeScreen.java:57)\n\tat com.sampleTest.apps.stepdefinition.Home.userSelectCountry(Home.java:31)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat com.sampleTest.apps.runner.CucumberTest.feature(CucumberTest.java:39)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:80)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:714)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:767)\n\tat org.testng.TestRunner.run(TestRunner.java:617)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:334)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:240)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1198)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1123)\n\tat org.testng.TestNG.run(TestNG.java:1031)\n\tat com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)\n\tat com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.id: com.androidsample.generalstore:id/spinnerCountry})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Venkata-Suresh.local\u0027, ip: \u0027fe80:0:0:0:492:3a1f:d5f0:734f%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002712.3\u0027, java.version: \u00271.8.0_351\u0027\nDriver info: driver.version: AndroidDriver\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:74)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:50)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:120)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:172)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\t... 45 more\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003centerYourName\u003e",
      "offset": 18
    }
  ],
  "location": "Home.userEntersNameClickOnSearchInputBox(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Male",
      "offset": 23
    }
  ],
  "location": "Home.userChooseGenderAs(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Home.userClicksOnAddToBasket()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "duration": 578143541,
  "status": "passed"
});
});