package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class pendingPage extends PageBase {

    private final By pendingTab = By.xpath("//span[normalize-space(text())='Pending Prescriptions']");
    private final By firstRowNumbr = By.xpath("(//tbody[@class='p-element p-datatable-tbody']//tr[1]/td[2])");
    private final  By editBtn = By.xpath("(//button[normalize-space(text())='Edit Prescription'])[1]");
   private final By medicationList = By.xpath("//h3[normalize-space()='Medications:']/following-sibling::ul/li");

    public void navigateToPendingPage () throws Exception {
        Thread.sleep(2000);
        waitAndClickOnWebElementUsingJavaScript(pendingTab);
    }

    public void checkPrescriptionApeear(String expectedPhone){
        String actualPhone = findElement(firstRowNumbr).getText().trim();
        Assert.assertEquals(actualPhone,expectedPhone);

        System.out.println("prescription existed in pending prescription table");

    }

    public void EditBtn() throws Exception {
        waitUntilWebElementBrClickable(editBtn);
        waitAndClickOnWebElement(editBtn);
    }

public void checkEditedMedicine(List<String> expectedMedicines){
    List<WebElement> medsElements = findElements(medicationList);

    List<String> actualMedicines = medsElements.stream()
            .map(el -> el.getText().trim())
            .toList();
    for(String expected : expectedMedicines){
        Assert.assertTrue(actualMedicines.contains(expected),
                "Edited medicine not found in actual list. Expected: " + expected + " | Actual: " + actualMedicines);
    }
    System.out.println("Edited medicines exist in the list. Actual medicines: " + actualMedicines);

}

    public void checkPendingPage(String expectedPhone) throws Exception {

        navigateToPendingPage();
        checkPrescriptionApeear(expectedPhone);

    }
}
