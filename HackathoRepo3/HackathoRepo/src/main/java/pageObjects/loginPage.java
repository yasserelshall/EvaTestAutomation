package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;

public class loginPage  extends PageBase {

private final By usernamefield = By.xpath("//input[@id=\"email\"]");
private final By passwordfield = By.xpath("//input[@id=\"password\"]");
private final By submitBtn = By.xpath("//button[@type=\"submit\"]");


    public void enterUsername(String username)
    {findElement(usernamefield).sendKeys(username);}

    public void enterPassword (String password)
    { findElement(passwordfield).sendKeys(password);}

    public void clickSubmit() throws Exception { waitAndClickOnWebElement(submitBtn);}

    public void login (String username , String password) throws Exception {

        enterUsername(username);
        enterPassword(password);
        Thread.sleep(2000);
        clickSubmit();
    }


}
