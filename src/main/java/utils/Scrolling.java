package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {
    // this util help to scroll to an element

    private Scrolling(){

    }

    @Step("scrolling to an element")
    public static void scrollToElement(WebDriver driver, By locator){
        LogsManager.info("scrolling to an element", locator.toString());
        // use JS to scroll

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
                ,ElementActions.findElement(driver,locator));

    }

    // create two methods to scroll up and down
    public static void scrollUp(WebDriver driver, int pixel){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, "+pixel+");");
    }
    public static void scrollDown(WebDriver driver, int pixel){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-"+pixel+");");
    }
}
