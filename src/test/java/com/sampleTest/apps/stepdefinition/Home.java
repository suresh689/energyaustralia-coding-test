package com.sampleTest.apps.stepdefinition;

import com.sampleTest.apps.config.config;
import com.sampleTest.apps.helper.LoggerHelper;
import com.sampleTest.apps.launcher.TestHarness;
import com.sampleTest.apps.pageobjects.HomeScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home extends TestHarness {
    private HomeScreen Home;
    protected static org.apache.log4j.Logger log = LoggerHelper.getLogger(Home.class);


    @Given("^User Opens App$")
    public void openapp() throws Throwable {
        Home = new  HomeScreen(testdriver);
        openApp();
        if(config.getPlatform().equalsIgnoreCase("iOS")) {
        }else
        {

        }
    }

    @When("^User Select Country \"([^\"]*)\"$")
    public void userSelectCountry(String countryName){
        Home = new HomeScreen(testdriver);
        Home.selectCountry(countryName);
    }

    @When("^User Enters Name \"([^\"]*)\" Click on Search Input Box$")
    public void userEntersNameClickOnSearchInputBox(String userName){
        Home = new HomeScreen(testdriver);
        Home.enterUserNmae(userName);
    }

    @Then("^User Choose Gender as \"([^\"]*)\"$")
    public void userChooseGenderAs(String gender) {
        Home = new HomeScreen(testdriver);
        Home.selectGender(gender);
    }

    @And("^User clicks on Lets Shop Button$")
    public void userClicksOnLetsShopButton() {
        Home = new HomeScreen(testdriver);
        Home.clickOnLetsShopButton();
    }

    @Then("^Verify toast message$")
    public void verifyToastMessage() {
        Home = new HomeScreen(testdriver);
        Home.validateToastMessage();
    }

    @And("^User clicks on Add to basket$")
    public void userClicksOnAddToBasket() {
        Home = new HomeScreen(testdriver);
        Home.clickOnAddToBasket();
    }
}
