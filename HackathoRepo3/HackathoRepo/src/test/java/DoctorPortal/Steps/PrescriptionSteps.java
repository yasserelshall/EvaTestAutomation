package DoctorPortal.Steps;

import DoctorPortal.Hooks.Hooks;
import base.PageBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateRxPage;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.pendingPage;

import java.util.List;

public class PrescriptionSteps  extends PageBase {
    WebDriver driver = Hooks.driver;


    @Given("User opened Doctor portal successfully")
    public void User_opened_Doctor_portal_successfully() throws Exception {
        loginPage loginObj = new loginPage();
        loginObj.login("hiv@doctor1.com", "123456");
        System.out.println("Doctor portal opened successfully");
    }

    @When("Doctor Create prescription to patient")
    public void Doctor_Create_prescription_to_patient() throws Exception {
        Thread.sleep(2000);
        homePage homeObj = new homePage();
        homeObj.navigateToRxPage("01021901196");
        String expectedPhone = homeObj.getEnteredPhoneNumber();
        System.out.println("Rx page opened with patient phone: " + expectedPhone);

        CreateRxPage RxObj = new CreateRxPage();
        RxObj.createRx();

        Hooks.scenarioContext.setContext("ExpectedPhone", expectedPhone);
    }

    @Then("prescription should appear in pending prescription")
    public void prescription_should_appear_in_pending_preascription() throws Exception {
        String expectedPhone = (String) Hooks.scenarioContext.getContext("ExpectedPhone");

        pendingPage pendObj = new pendingPage();
        pendObj.checkPendingPage(expectedPhone);


    }

    @And("Doctor can edit the prescription")
    public void Doctor_can_edit_the_prescription() throws Exception {
        pendingPage pendObjj = new pendingPage();
        pendObjj.EditBtn();

        CreateRxPage edtObj= new CreateRxPage();
        List<String> expectedMedicines = edtObj.editprescription();
        Hooks.scenarioContext.setContext("ExpectedMedicines", expectedMedicines);

        pendingPage pnd=new pendingPage();
        pnd.checkEditedMedicine(expectedMedicines);
    }



}
