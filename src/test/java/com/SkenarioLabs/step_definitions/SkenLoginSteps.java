package com.SkenarioLabs.step_definitions;

import com.SkenarioLabs.pages.LoginPage;
import com.SkenarioLabs.utilities.BrowserUtils;
import com.SkenarioLabs.utilities.ConfigurationReader;
import com.SkenarioLabs.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SkenLoginSteps {
    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
    }

    @When("User enter the valid credentials")
    public void user_enter_the_valid_credentials() {
        String username = ConfigurationReader.get("test_engineer_username");
        String password = ConfigurationReader.get("test_engineer_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("User should be to login")
    public void user_should_be_to_login() {

        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Portfolio Overview";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Given("User navigates to the login page at staging")
    public void user_navigates_to_the_login_page_at_staging() {
        String url = ConfigurationReader.get("staging_url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
    }

    @When("User enter the valid credentials for staging")
    public void user_enter_the_valid_credentials_for_staging() {
        String username = ConfigurationReader.get("staging_engineer_username");
        String password = ConfigurationReader.get("staging_engineer_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("User should be to login to staging")
    public void user_should_be_to_login_staging() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Portfolio Overview";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}