package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class pendingPage extends PageBase {

    private final By pendingTab = By.xpath("//span[normalize-space(text())='Pending Prescriptions']");
    private final By firstRowNumbr = By.xpath("(//tbody[@class='p-element p-datatable-tbody']//tr[1]/td[2])");
    private final  By editBtn = By.xpath("(//button[normalize-space(text())='Edit Prescription'])[1]");

    public void navigateToPendingPage () throws Exception {
        Thread.sleep(2000);
        waitAndClickOnWebElementUsingJavaScript(pendingTab);
    }

    public void checkPrescriptionApeear(String expectedPhone){
        String actualPhone = findElement(firstRowNumbr).getText().trim();
        Assert.assertEquals(actualPhone,expectedPhone);

        System.out.println("prescription existed in pending prescription table");

    }

    public void editPrescription() throws Exception {
        waitAndClickOnWebElement(editBtn);
    }

    public void checkPendingPage(String expectedPhone) throws Exception {

        navigateToPendingPage();
        checkPrescriptionApeear(expectedPhone);
    }
}
