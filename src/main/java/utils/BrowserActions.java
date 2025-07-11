package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }

    @Step("navigate to url")
    public static void navigateToURL(WebDriver driver, String url){
        LogsManager.info("navigate to url :"+url);
        driver.manage().window().maximize();
        driver.get("url");
    }

    @Step("Navigate forward")
    public static void navigateForward(WebDriver driver,String url){
        LogsManager.info("navigate forward"+url);
        driver.navigate().forward();
    }
    @Step("Navigate Back")
    public static void navigateBack(WebDriver driver,String url){
        LogsManager.info("navigate forward"+url);
        driver.navigate().back();
    }

    @Step("get current URL")
    public static String getCurrentURL(WebDriver driver){
        LogsManager.info("get current url "+driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }
}
