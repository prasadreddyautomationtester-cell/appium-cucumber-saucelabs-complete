package stepdefinitions;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverFactory;

public class ApiDemoSteps {
    @Given("user launches ApiDemo application")
    public void user_launch() {
        HomePage home = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(home.isAccessibilityDisplayed());
    }
}