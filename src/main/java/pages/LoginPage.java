package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.Waits;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("input-email");
    private final By passwordTxt = By.id("input-password");
    private final By loginButton = By.cssSelector("input[value='Login']");
    private final By AssertionMessage = By.xpath("//h2[text()='My Account']");


    public void enterLoginData(String email, String password){
        Waits.waitELementToBeVisible(driver,emailTxt);
        ElementActions.sendData(driver,emailTxt,email);
        ElementActions.sendData(driver,passwordTxt,password);
        ElementActions.clickElement(driver,loginButton);
    }

    public String getLoginAssertionMessage(){
        Waits.waitELementToBeVisible(driver,AssertionMessage);
        return ElementActions.getText(driver,AssertionMessage);
    }
}
