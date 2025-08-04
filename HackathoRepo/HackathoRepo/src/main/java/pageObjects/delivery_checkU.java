package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class delivery_checkU extends PageBase {
    public delivery_checkU(WebDriver driver){
        this.driver=driver;
    }
     private final By checkuser = By.xpath("//datatable-body-cell[.//span[text()='yasser samir']]\n");
     private final WebElement nationalID_element = driver.findElement(By.xpath("//div[h6[text()='National ID / Passport ID']]/h4"));
    private final WebElement MobileNUM_element = driver.findElement(By.xpath("//div[h6[text()='Mobile Number']]/h4"));

    public void clickOnUser (){
        waitUntilWebElementBeClickableThenClick(checkuser);
    }

    public void extractNationalID (){
        String nationalID=nationalID_element.getText();
        System.out.println("National ID: " + nationalID);
    }

    public void  extractMobNum (){
        String mobileNumber =MobileNUM_element.getText();
        System.out.println("Mobile number: " + mobileNumber);
    }

    public void checkUser_delivery() throws Exception {
        Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='yasser samir']")).isDisplayed());
        clickOnUser();
        extractNationalID();
        extractMobNum();
    }

}
