package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class offerpage_delivery extends PageBase {
    public offerpage_delivery(WebDriver driver){
        this.driver=driver;
    }

    private final By pspDropdown = By.xpath("//a[.//span[normalize-space(text())='PSP']]");
    private final By medicationRequests = By.xpath("//a[normalize-space(text())='Medication Requests']");
    private final By homeDelivery = By.xpath("//a[normalize-space(text())='Home Delivery']");

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

public void deliverypage() throws Exception {

   clickPSPdrobdown();
   clickMedicationRequests();
   clickOnHomeDelivery();




}
}
