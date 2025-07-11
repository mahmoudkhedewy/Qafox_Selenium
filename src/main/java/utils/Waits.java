package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits(){

    }

    // check element is present
    @Step("wait until element is present ")
    public static WebElement waitElementToBePresent(WebDriver driver, By locator){
        LogsManager.info("wait element to be present"+ locator.toString());

        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(_ -> driver.findElement(locator));
    }

    // after checking element is visible

    @Step("wait untl element to be visible")
    public static WebElement waitELementToBeVisible(WebDriver driver,By locator){
        LogsManager.info("wait element to be visible"+locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                _ -> {
                    WebElement element = waitElementToBePresent(driver,locator);
                    // this line of code equal to iif else statement
                    return element.isDisplayed() ? element :null;
//                    if (element.isDisplayed()){
//                        return element;
//                    }else {
//                        return null;
//                    }
                });
    }

    public static WebElement waitElementToBeLocated(WebDriver driver, By locator){
        LogsManager.info("wait element to be located "+locator.toString());

        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(_ -> driver.findElement(locator));
    }

    public static WebElement waitElementToBeClickable(WebDriver driver, By locator){
        LogsManager.info("wait element to be clickable "+ locator.toString());

        return new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                _ -> {
                    WebElement element =  waitELementToBeVisible(driver,locator);
                    return element.isEnabled() ? element : null;
                }
        );
    }

}
