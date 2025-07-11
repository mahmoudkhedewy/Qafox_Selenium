package tests;

import data.ReadData;
import drivers.DriverManager;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import utils.Validations;

import java.io.IOException;


public class RegisterTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){

        homePage = new HomePage(DriverManager.getDriver());
        homePage.NavigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        ReadData data = new ReadData();
        data.testData();
        registerPage = new RegisterPage(DriverManager.getDriver());
        registerPage.enterLoginRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com", data.telephone);
        registerPage.enterPassword(data.password);
        registerPage.clickOnRegister();
        Validations.assertTrue(registerPage.getAssertionMessage().contains("Your Account Has Been Created"));
    }
}
