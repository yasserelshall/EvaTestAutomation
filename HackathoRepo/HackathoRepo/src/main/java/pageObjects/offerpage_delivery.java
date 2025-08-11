package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class offerpage_delivery extends PageBase {
    public offerpage_delivery(WebDriver driver){
        this.driver=driver;
    }

    private final By pspDropdown = By.xpath("//a[.//span[normalize-space(text())='PSP']]");
    private final By medicationRequests = By.xpath("//a[normalize-space(text())='Medication Requests']");
    private final By homeDelivery = By.xpath("//a[normalize-space(text())='Home Delivery']");
    private final By latestOffLogo = By.xpath("//h1[normalize-space()='Latest Offers']");
   // @FindBy(xpath = "//h1[normalize-space()='Latest Offers']")
 //   WebElement latestOffLogo;
    public void clickPSPdrobdown () throws Exception {
        Thread.sleep(3000);
        waitUntilWebElementBrClickable(pspDropdown);
        waitAndClickOnWebElement(pspDropdown);    }

    public void clickMedicationRequests() throws Exception {
        waitUntilWebElementBrClickable(medicationRequests);
        waitAndClickOnWebElement(medicationRequests);
    }
    public void clickOnHomeDelivery() throws Exception {
        waitAndClickOnWebElement(homeDelivery);
    }
    public void isloggedIn() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(findElement(latestOffLogo).isDisplayed());

    }
public void deliverypage() throws Exception {
  // isloggedIn();
   //clickPSPdrobdown();
   clickMedicationRequests();
   clickOnHomeDelivery();

}


}
