package CustomerModule.Steps;

import CustomerModule.Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.delivery_checkU;
import pageObjects.login;
import pageObjects.offerpage_delivery;





public class deliverySteps {
 WebDriver driver = Hooks.driver;


 @Given("User opened admin portal successfully")
    public void User_opened_admin_portal_successfully(){

  login loginObj= new login(driver);
  loginObj.setup("NadeenAdmin.test@yahoo.com","123456");

 Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Latest Offers']")).isDisplayed());

 }

 @When("User navigate to home delivery page")
    public void User_navigate_to_home_delivery_page() throws Exception {
  offerpage_delivery offDelvObj = new offerpage_delivery(driver);
  offDelvObj.deliverypage();
 }


 @Then("User should be able to check his home delivery requests")
    public void User_should_able_to_check_his_home_delivery_requests() throws Exception {
     Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Home Delivery']")).isDisplayed()); //check there is at home delivery page

     delivery_checkU delvObj = new delivery_checkU(driver);
     delvObj.checkUser_delivery();

}
}
