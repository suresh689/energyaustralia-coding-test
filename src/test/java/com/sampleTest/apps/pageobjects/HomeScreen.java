package com.sampleTest.apps.pageobjects;

import com.sampleTest.apps.config.config;
import com.sampleTest.apps.utilities.BaseDeviceView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Properties;

public class HomeScreen extends BaseDeviceView {

    public static Properties configProperties;

    AppiumDriver<MobileElement> driver;
    private HomeScreen Home;

    private static String platform = config.getPlatform();
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    @iOSXCUITFindBy()
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private MobileElement Home_CountryName;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//div[@class='_highlighter-box_86d92']")
    List<MobileElement> Home_CountryNameValues;

    @iOSXCUITFindBy()
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private MobileElement enterYourName;

    @iOSXCUITFindBy()
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private MobileElement letsShopButton;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "android.widget.Toast[1]")
    private MobileElement toastMessageText;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    private MobileElement addToBasket;


    /*
    * This method is used for select country in Home page
    * */

    public void selectCountry(String countryName) {
        Home_CountryName.click();
        int k=Home_CountryNameValues.size();
        String preFix="com.androidsample.generalstore[@text='";
        String postFix="']";
        for(int i=0;i<k;i++) {
            driver.findElements(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().resourceIdMatches(" + countryName + ").instance(0))"));
        }
    }

    /*
     * This method is used for Enter User Name in Home page
     * */

    public void enterUserNmae(String userName) {
        enterYourName.sendKeys(userName);

    }

    /*
     * This method is used for Select Gender in Home page
     * */

    public void selectGender(String gender) {
        driver.findElement(By.xpath("*//[@text="+gender+"]")).click();
    }


    /*
     * This method is used for click lets shop buttong in Home page
     * */
    public void clickOnLetsShopButton() {
        letsShopButton.click();
    }

    /*
     * This method is used for verifying toast message in Home page
     * */
    public void validateToastMessage() {
        String toastMessage=toastMessageText.getAttribute("name");
        SoftAssert sa=new SoftAssert();
        sa.assertEquals(toastMessage,configProperties.getProperty("Please.enter.your.name.Text"));
        sa.assertAll();
    }

    /*
     * This method is used for clicks on add to basket on Product list page
     * */

    public void clickOnAddToBasket() {
        addToBasket.click();
    }
}
