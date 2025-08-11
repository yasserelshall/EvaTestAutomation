package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class check_pickup_req extends PageBase {

    public check_pickup_req(WebDriver driver){
        this.driver=driver;
    }

    private final By checkuser = By.xpath("(//datatable-body-cell[.//span[text()='yasser samir']])[1]");
    private final By assertstatus = By.xpath("(//span[text()='yasser samir']/ancestor::datatable-row-wrapper//datatable-body-cell[18]//span)[1]");

public void userisexist(){
    WebElement el =driver.findElement(checkuser);
    String username =el.getText();
    System.out.println("patient name :" + username);
    Assert.assertEquals(username,"yasser samir");
}

    public void printStatusAfter(){
//        driver.navigate().back();
        WebElement el = driver.findElement(assertstatus);
        String statusText = el.getText();
        System.out.println("Status : " + statusText);
        Assert.assertEquals(statusText,"Confirmed");
    }
public void completeCheck() throws InterruptedException {
    Thread.sleep(2000);
    userisexist();
    printStatusAfter();
}
}
