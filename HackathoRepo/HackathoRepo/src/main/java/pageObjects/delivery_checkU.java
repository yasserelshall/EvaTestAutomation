package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class delivery_checkU extends PageBase {
    public delivery_checkU(WebDriver driver){
        this.driver=driver;
    }
//    @FindBy (xpath = "//datatable-body-cell[.//span[text()='yasser samir']]")
//    WebElement checkUser;
     private final By checkuser = By.xpath("//datatable-body-cell[.//span[text()='yasser samir']]");
    private final By nationalID_element = By.xpath("//div[h6[text()='National ID / Passport ID']]/h4");
     private final By MobileNUM_element = By.xpath("//div[h6[text()='Mobile Number']]/h4");
     private final By homedeliverylogo = By.xpath("//h1[normalize-space()='Home Delivery']");
    private  final By userIsDisplayed = By.xpath("//span[normalize-space()='yasser samir']");


    public void clickOnUser () {
        try {
            System.out.println("Trying to click on user element");
            waitAndClickOnWebElement(checkuser);
            System.out.println("Clicked on user successfully");
        } catch (Exception e) {
            System.out.println("Failed to click on user: " + e.getMessage());
        }
    }

    public void extractNationalID (){
        WebElement el = driver.findElement(nationalID_element);
        String nationalID=el.getText();
        System.out.println("National ID: " + nationalID);
    }

    public void  extractMobNum (){
        WebElement el =driver.findElement(MobileNUM_element);
        String mobileNumber =el.getText();
        System.out.println("Mobile number: " + mobileNumber);
    }

    public void HomedeliveryLogo() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(findElement(homedeliverylogo).isDisplayed());
    }

    public void userIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(findElement(userIsDisplayed).isDisplayed());
    }

    public void checkUser_delivery() throws Exception {
        System.out.println("Step 1: Checking logo");
        HomedeliveryLogo();
        System.out.println("Step 2: Checking user display");
        userIsDisplayed();
        System.out.println("Step 3: Clicking on user");
        clickOnUser();
        System.out.println("Step 4: Extracting ID");
        extractNationalID();
        extractMobNum();
    }

}
