package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.Waits;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver= driver;
    }

    private final By firstNameTxt = By.id("input-firstname");
    private final By lastNameTxt  = By.id("input-lastname");
    private final By emailTxt = By.id("input-email");
    private final By telephoneTxt = By.id("input-telephone");
    private final By passwordTxt = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");
    private final By acceptTerms = By.xpath("//input[@type='checkbox']");
    private final By registerButton = By.cssSelector("input.btn.btn-primary");
    private final By assertionMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");


    public void enterLoginRegisterData(String firstName, String lastName, String email, String telephone){
        ElementActions.sendData(driver,firstNameTxt,firstName);
        ElementActions.sendData(driver,lastNameTxt,lastName);
        ElementActions.sendData(driver,emailTxt,email);
        ElementActions.sendData(driver,telephoneTxt,telephone);
    }

    public void enterPassword(String password){
        ElementActions.sendData(driver,passwordTxt,password);
        ElementActions.sendData(driver,confirmPassword,password);
        ElementActions.clickElement(driver,acceptTerms);
    }

    public void clickOnRegister(){
        Waits.waitElementToBeClickable(driver,registerButton);
        ElementActions.clickElement(driver,registerButton);

    }

    public String getAssertionMessage(){
        Waits.waitELementToBeVisible(driver,assertionMessage);
        return ElementActions.getText(driver,assertionMessage);
    }
}
