package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login extends PageBase {
    public login(WebDriver driver){
        this.driver=driver;

    }
    private final By usernameField = By.xpath("//input[@name='mail']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By submitButton = By.xpath("//button[@type='submit']");

    public void enterUsername(String username) {
        findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitButton).click();
    }
public void  setup(String username , String password){
  //  driver=new ChromeDriver();
    //driver.manage().window().maximize();
  //  driver.get("https://limitlesscaredashboard-staging.azurewebsites.net/");
    enterUsername(username);
    enterPassword(password);
    clickSubmit();


}





}




