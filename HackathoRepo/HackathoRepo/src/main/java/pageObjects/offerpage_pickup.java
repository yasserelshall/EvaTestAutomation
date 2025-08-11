package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


//import static pageObjects.login.driver;

public class offerpage_pickup extends PageBase {
    public offerpage_pickup(WebDriver driver){
        this.driver=driver;
    }

    private final By pspDropdown = By.xpath("//a[.//span[normalize-space(text())='PSP']]");
    private final By medicationRequests = By.xpath("//a[normalize-space(text())='Medication Requests']");
    private final By pickup = By.xpath("//a[normalize-space(text())='Pickup']");

    @FindBy(xpath = "//h1[normalize-space()='Latest Offers']")
    WebElement latestOffLogo;

    public void clickPSPdrobdown () throws Exception {
        Thread.sleep(3000);
        waitUntilWebElementBrClickable(pspDropdown);
        waitAndClickOnWebElement(pspDropdown);    }

    public void clickMedicationRequests() throws Exception {
        waitUntilWebElementBrClickable(medicationRequests);
        waitAndClickOnWebElement(medicationRequests);
    }
    public void clickPickup() throws Exception {
        waitAndClickOnWebElement(pickup);
    }
    public void isloggedIn() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(latestOffLogo.isDisplayed());

    }
    public void pickupPage() throws Exception {
        //isloggedIn();
        //clickPSPdrobdown();
        clickMedicationRequests();
        clickPickup();

    }



}
