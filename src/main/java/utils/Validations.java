package utils;

import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class Validations {
    private Validations(){

    }

    @Step("validate true ")
    public static void assertTrue(boolean condition){
        Assert.assertTrue(condition);
    }
    @Step("validate false ")
    public static void assertFalse(boolean condition ){
        Assert.assertFalse(condition);
    }

    @Step("validate that actual results equal to expected results ")
    public static void assertEqual(String expected , String Actual){
        Assert.assertEquals(Actual,expected);
    }

    @Step("Validate Page URL")
    public static void validatePageURl(WebDriver driver,String URL,String message){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),URL,message);
    }

}
