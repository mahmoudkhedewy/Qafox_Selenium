package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.Waits;

public class HomePage {
    private final WebDriver driver;
    private final By accountManager = By.xpath("//span[text()='My Account']");
    private final By registerButton = By.xpath("//a[text()='Register']");
    private final By loginButton = By.xpath("//a[text()='Login']");

    public HomePage(WebDriver driver){
        this.driver= driver;
    }



    public void NavigateToRegisterPage(){
        ElementActions.clickElement(driver,accountManager);
        Waits.waitElementToBeClickable(driver,registerButton);
        ElementActions.clickElement(driver,registerButton);
    }

    public void navigateToLoginPage(){
        ElementActions.clickElement(driver,accountManager);
        Waits.waitElementToBeClickable(driver,loginButton);
        ElementActions.clickElement(driver,loginButton);
    }
}
