package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class selectPharmacy extends PageBase {

    public selectPharmacy (WebDriver driver){
        this.driver=driver;
    }
    private final By checkuser = By.xpath("(//datatable-body-cell[.//span[text()='yasser samir']])[1]");
    private final By selectpharmacyBtn = By.xpath("//h3[normalize-space(text())='Select Pharmacy']");
    private final By choosePharmacy =By.xpath("(//div[@class=\"small-card-body p-3\"])[1]");
    private final By confirmPharmacyBtn =By.xpath("//button[normalize-space(text())='Pharmacy Confirmed Order!']");
    private final By assertstatus = By.xpath("(//span[text()='yasser samir']/ancestor::datatable-row-wrapper//datatable-body-cell[18]//span)[1]");
    //private final By pharmacyelement = By.xpath("//span[@title='69372']/ancestor::datatable-row-wrapper//datatable-body-cell[15]//span");
   public void printStatusBefore(){
       WebElement el = driver.findElement(assertstatus);
       String statusText = el.getText();
       System.out.println("Status before select pharmacy: " + statusText);
       Assert.assertEquals(statusText,"Pending");
   }
    public void printStatusAfter(){
       driver.navigate().back();
        WebElement el = driver.findElement(assertstatus);
        String statusText = el.getText();
        System.out.println("Status after select pharmacy: " + statusText);
        Assert.assertEquals(statusText,"Confirmed");
    }
    public void clickOnUser () {
        try {
            System.out.println("Trying to click on user element");
            waitAndClickOnWebElement(checkuser);
            System.out.println("Clicked on user successfully");
        } catch (Exception e) {
            System.out.println("Failed to click on user: " + e.getMessage());
        }}

    public void clickSelectPharmacyBtn () throws Exception {
        waitAndClickOnWebElement(selectpharmacyBtn);
    }

    public void choosePharmacy() throws Exception {
        waitAndClickOnWebElement(choosePharmacy);
    }
public void confirmPharmacy() throws Exception {
        waitAndClickOnWebElement(confirmPharmacyBtn);
}

//public void checkPharmacyIsAdded() throws InterruptedException {
//        driver.navigate().back();
//        Thread.sleep(2000);
//    WebElement el = driver.findElement(pharmacyelement);
//    String pharmacyText = el.getText();
//    System.out.println("Pharmacy: " + pharmacyText);
//
//}

public void completeCheck() throws Exception {
printStatusBefore();
   clickOnUser();
   clickSelectPharmacyBtn();
   choosePharmacy();
   confirmPharmacy();
    System.out.println("pharmacy selected successfully");
   Thread.sleep(2000);
   printStatusAfter();
   //checkPharmacyIsAdded();
}


}
