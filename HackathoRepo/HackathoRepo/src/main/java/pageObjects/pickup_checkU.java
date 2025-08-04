package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class pickup_checkU  extends PageBase {

    public pickup_checkU (WebDriver driver){
        this.driver=driver;
    }

    private final By pageThree =By.xpath("//ul[@class='pager']//li[@aria-label='page 3']");
    private final By checkUser = By.xpath("//datatable-body-cell[.//span[text()='Sara Waleed Salim']]");
    private final WebElement nationalID_element = driver.findElement(By.xpath("//div[h6[text()='National ID / Passport ID']]/h4"));
    private final WebElement MobileNUM_element = driver.findElement(By.xpath("//div[h6[text()='Mobile Number']]/h4"));

    public void openpage3 () throws Exception {
        waitAndClickOnWebElement(pageThree);
    }
    public void clickOnUser () throws Exception {
        waitAndClickOnWebElement(checkUser);
    }

    public void extractNationalID (){
        String nationalID=nationalID_element.getText();
        System.out.println("National ID: " + nationalID);
    }

    public void  extractMobNum (){
        String mobileNumber =MobileNUM_element.getText();
        System.out.println("Mobile number: " + mobileNumber);
    }
    public void checkUser_pickup() throws Exception {

        Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Sara Waleed Salim']")).isDisplayed());
        openpage3();
        clickOnUser();
        extractNationalID();
        extractMobNum();


    }
}
