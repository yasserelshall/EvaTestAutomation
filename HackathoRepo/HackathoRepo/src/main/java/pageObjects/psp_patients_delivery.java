package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class psp_patients_delivery extends PageBase {

    public psp_patients_delivery(WebDriver driver){
        this.driver=driver;
    }
    private final By pspDropdown = By.xpath("//a[.//span[normalize-space(text())='PSP']]");

    private final By pspPatient = By.xpath("//a[normalize-space(text())='PSP Patients']"); // tab in side bar
    private final By  assPspPg = By.xpath("//h3[normalize-space(text())='PSP Patients']"); // hadline to assert it's navigate successfully
    private final By searcBar = By.xpath("//input[@id=\"src_txt\"]"); // search patient
    private  final By searchButton = By.xpath("//button[@class=\"btn btn-psp-primary btn-search btn-block\"]");
    private final By  selectUser = By.xpath("//span[@title=\"MOUNJARO 5MG/0.5ML\"]"); // select user who subscribed in mounjaro prog
    private final  By psptab = By.xpath("//span[normalize-space(text( ))='PSPs']");
    private  final By selectProgram = By.xpath("(//i[contains(@class, 'icon-show-more')])[1]");
    private final  By reqHomeDelivery = By.xpath("//li[normalize-space(text())='Request Home Delivery']");
    private final By verifyReqHomePage = By.xpath("//h1[normalize-space(text())='Request Home Delivery']"); //assert if it's in request home delivery page
    private  final  By radioBtn = By.xpath("//input[@id='address-checked0']"); // check nasr city button
    private  final By nextStepBtn = By.xpath("(//button[@type=\"submit\"])[2]");
    private final By togglediscount = By.xpath("//span[@class=\"custom-toggle-slider rounded-circle\"]");
    private final By discPercent = By.xpath("//input[@name=\"discountPercentage\"]"); // discount percentage field
    private final  By submitBtn = By.xpath("//button[normalize-space(text( ))='Submit Request']");

    public void clickPSPdrobdown () throws Exception {
        Thread.sleep(3000);
        waitUntilWebElementBrClickable(pspDropdown);
        waitAndClickOnWebElement(pspDropdown);    }
    public void clickPspPatient () throws Exception {
        Thread.sleep(2000);
        waitAndClickOnWebElement(pspPatient);
    }
    public void psppatientPage () throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(findElement(assPspPg).isDisplayed());

    }
    public void searchByNum ( String number) throws Exception {
        findElement(searcBar).sendKeys(number);
        Thread.sleep(3000);
        waitAndClickOnWebElement(searchButton);
    }
public void selectUser() throws Exception {
        waitAndClickOnWebElement(selectUser);
}
public void navtoPsps() throws Exception {
        waitAndClickOnWebElement(psptab);
}
public void choseProg() throws Exception {
        waitAndClickOnWebElement(selectProgram);
        waitAndClickOnWebElement(reqHomeDelivery);
}
public void verifyreqhomepage () throws InterruptedException {
    Thread.sleep(2000);
    Assert.assertTrue(findElement(verifyReqHomePage).isDisplayed());
}
public void checkradiobtn() throws Exception {
        waitAndClickOnWebElement(radioBtn);
}
public void nextstep() throws Exception {
        waitAndClickOnWebElement(nextStepBtn);
}
public void enableDiscount() throws Exception {

        waitAndClickOnWebElement(togglediscount);
}
public void enterDiscPercent(String percentage){
        findElement(discPercent).sendKeys(percentage);
}
public void submitrequest () throws Exception {
        waitAndClickOnWebElement(submitBtn);
}
public void completeHomeDeliveryReq( String number , String percentage) throws Exception {
    clickPSPdrobdown();
    clickPspPatient();
    psppatientPage();
    searchByNum(number);
    selectUser();
    navtoPsps();
    choseProg();
    verifyreqhomepage();
    checkradiobtn();
    nextstep();
    enableDiscount();
    enterDiscPercent(percentage);
    submitrequest();
Thread.sleep(3000);


}



}
