package CustomerModule.Steps;

import CustomerModule.Hooks.Hooks;
import base.PageBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class RequestSteps extends PageBase {

    WebDriver driver = Hooks.driver;

    @Given("User opened admin portal successfully")
    public void userOpenedAdminPortalSuccessfully() {
        login loginObj = new login(driver);
        loginObj.setup("NadeenAdmin.test@yahoo.com", "123456");
        System.out.println("Admin portal opened successfully.");
    }

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String requestType) throws Exception {
        switch (requestType.toLowerCase()) {
            case "delivery":
                new psp_patients_delivery(driver).completeHomeDeliveryReq("01091711145", "25");
                break;
            case "pickup":
                new psp_patients_pickup().completePickupReq("01091711145", "25");
                break;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }
    }

    @Then("User should be able to check their {string} requests")
    public void userShouldBeAbleToCheckTheirRequests(String requestType) throws Exception {
        switch (requestType.toLowerCase()) {
            case "delivery":
                new offerpage_delivery(driver).deliverypage();
                new selectPharmacy(driver).completeCheck();
                break;
            case "pickup":
                new offerpage_pickup(driver).pickupPage();
                new check_pickup_req(driver).completeCheck();
                break;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }
    }
}