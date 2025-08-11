package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class psp_patients_pickup extends PageBase {

    private final By pspDropdown = By.xpath("//a[.//span[normalize-space(text())='PSP']]");
    private final By pspPatient = By.xpath("//a[normalize-space(text())='PSP Patients']"); // tab in side bar
    private final By  assPspPg = By.xpath("//h3[normalize-space(text())='PSP Patients']"); // hadline to assert it's navigate successfully
    private final By searcBar = By.xpath("//input[@id=\"src_txt\"]"); // search patient
    private  final By searchButton = By.xpath("//button[@class=\"btn btn-psp-primary btn-search btn-block\"]");
    private final By  selectUser = By.xpath("//span[@title=\"MOUNJARO 5MG/0.5ML\"]"); // select user who subscribed in mounjaro prog
    private final  By psptab = By.xpath("//span[normalize-space(text( ))='PSPs']");
    private  final By selectProgram = By.xpath("(//i[contains(@class, 'icon-show-more')])[1]");
    private final By reqPickup = By.xpath("//li[normalize-space(text())='Request Pick up']");
    private  final By verifyReqPickupPage = By.xpath("//h2[normalize-space(text())='Request Pickup']");
    private final  By selectCity =By.xpath("//select[@id=\"city\"]");
    private  final By selectArea = By.xpath("//select[@id=\"area\"]");
    private final By nxtStpsBtn =By.xpath("//button[normalize-space(text())='Next Step']");
    private final  By rdioBtn = By.xpath("//input[@id=\"pharmacy-checked0\"]");
    private final  By nxtStpsBtn2 = By.xpath("//button[normalize-space(text())='Next Step']");
    private final By discToggl = By.xpath("//span[@class=\"custom-toggle-slider rounded-circle\"]");
    private final By prcntgField = By.xpath("//input[@name=\"discountPercentage\"]");
    private final By sbmtBtn = By.xpath("//button[normalize-space(text())='Submit Request']");

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
        waitAndClickOnWebElement(reqPickup);
    }

    public void verifyPickuppage () throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(findElement(verifyReqPickupPage).isDisplayed());
    }

    public void selectcity(){
        WebElement el = driver.findElement(selectCity);
        Select select = new Select(el);
        select.selectByValue("20");
    }
public void selectarea(){
    WebElement el = driver.findElement(selectArea);
    Select select = new Select(el);
    select.selectByValue("275");
}

public void nextstepBtn1() throws Exception {
        waitAndClickOnWebElement(nxtStpsBtn);
}
public void selectpharmacy() throws Exception {

        waitAndClickOnWebElement(rdioBtn);
}
public void nextstepBtn2() throws Exception {
        waitAndClickOnWebElement(nxtStpsBtn2);
}
public void enablediscount() throws Exception {
        waitAndClickOnWebElement(discToggl);
}
    public void enterDiscPercent(String percentage){
        findElement(prcntgField).sendKeys(percentage);
    }
public void submbitReq() throws Exception {
        waitAndClickOnWebElement(sbmtBtn);
}
public void completePickupReq(String number,String percentage) throws Exception {

    clickPSPdrobdown();
    clickPspPatient();
    psppatientPage();
    searchByNum(number);
    selectUser();
    navtoPsps();
    choseProg();
    verifyPickuppage();
    selectcity();
    selectarea();
    nextstepBtn1();
    selectpharmacy();
    nextstepBtn2();
    enablediscount();
    enterDiscPercent(percentage);
    submbitReq();



}

}
