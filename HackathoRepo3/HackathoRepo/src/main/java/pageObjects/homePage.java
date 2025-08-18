package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends PageBase {
    private  final By phoneNumField = By.xpath("//input[@id=\"phone-number\"]");
    private final By createReqBtn = By.xpath("//button[normalize-space(text())='Create Request']");



    public  void enterphoneNumber (String number) throws Exception {
        waitAndEnterTextInWebElement(number,phoneNumField);
    }

    public void clickCreateReq () throws Exception {

    waitAndClickOnWebElement(createReqBtn);
    }

    public void navigateToRxPage (String number) throws Exception {
        enterphoneNumber(number);
        clickCreateReq();

    }

    public String getEnteredPhoneNumber() {
        return driver.findElement(phoneNumField).getAttribute("value");
    }


}
