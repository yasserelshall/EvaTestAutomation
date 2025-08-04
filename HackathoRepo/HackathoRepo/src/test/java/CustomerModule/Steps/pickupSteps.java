package CustomerModule.Steps;

import CustomerModule.Hooks.Hooks;
import base.PageBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.login;
import pageObjects.offerpage_delivery;
import pageObjects.offerpage_pickup;
import pageObjects.pickup_checkU;

import java.time.Duration;

public class pickupSteps extends PageBase {

    WebDriver driver = Hooks.driver;

    @When("User navigate to pickup page")
    public void User_navigate_to_pickup_page() throws Exception {
        offerpage_pickup offPickObj = new offerpage_pickup(driver);
        offPickObj.pickupPage();
    }

    @Then("User should be able to check his pick up requests")
    public void User_should_be_able_to_check_his_pick_up_requests() throws Exception {
Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Pickup']")).isDisplayed());

        pickup_checkU pickObj = new pickup_checkU(driver);
        pickObj.checkUser_pickup();


    }
}
