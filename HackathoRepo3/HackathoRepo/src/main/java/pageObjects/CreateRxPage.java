package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateRxPage extends PageBase {

private final By CreateRxTitle = By.xpath("(//h1[@class=\"card-title mb-3\"])[1]");
private final By SearchMedicationField = By.xpath("(//div[@class='search ng-star-inserted']/input)[3]");
private final By selectmedicinefromlist = By.xpath("//div[normalize-space(text())='Lamivudine, 60 tablets, 150 mg']");
private final By createPrescBtn = By.xpath("//button[normalize-space()='Create E-Prescription']");
private final By selectmdicineTwo = By.xpath("//div[normalize-space(text())='Abacavir (Abacavir sulfate), 60 tablets, 600 mg']");
private final By UpdateBtn = By.xpath("//button[normalize-space(text())='Update']");
    public void CreateRxPage_opened() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(findElement(CreateRxTitle).isDisplayed());
    }

    public void selectmedicine () throws Exception {
        safeSendKeysWithEnter(SearchMedicationField,"Lamivudine");
        safeClick(SearchMedicationField);
        waitUntilWebElementIsPresent(SearchMedicationField);
        Thread.sleep(2000);
        safeClick(selectmedicinefromlist);
        safeClick(createPrescBtn);

    }
public void editprescription() throws Exception {
    safeSendKeysWithEnter(SearchMedicationField,"Abacavir");
    safeClick(SearchMedicationField);
    waitUntilWebElementIsPresent(SearchMedicationField);
    Thread.sleep(2000);
    safeClick(selectmdicineTwo);
    safeClick(UpdateBtn);
}

    public void createRx () throws Exception {
      //  CreateRxPage_opened();
        selectmedicine();
    }
}
