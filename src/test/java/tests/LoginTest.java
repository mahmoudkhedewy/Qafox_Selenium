package tests;

import data.ReadData;
import drivers.DriverManager;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Validations;

import java.io.IOException;

public class LoginTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    ReadData data;

    @Test
    @Step("navigate to login page")
    public void navigateToLoginPage(){
        homePage = new HomePage(DriverManager.getDriver());
        homePage.navigateToLoginPage();
    }
    @Test(priority = 1)
    public void login() throws IOException, ParseException {
        data = new ReadData();
        data.testData();
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.enterLoginData(data.emailLogin, data.passwordLogin);
        Validations.assertTrue(loginPage.getLoginAssertionMessage().contains("My Account"));
    }
}
