package utils;

import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class ElementActions {
    static Actions actions;
    Select select;
    private ElementActions(){

    }

    // create methode to find elements

    public static WebElement findElement(WebDriver driver, By locator){
        LogsManager.info("finding an element", locator.toString());
        return driver.findElement(locator);

    }
    public static List<WebElement> findElements(WebDriver driver, By locator){
        LogsManager.info("finding an element", locator.toString());
        return driver.findElements(locator);

    }

    @Step("click an element")
    public static void clickElement(WebDriver driver, By locator){
//        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).click();
    }

    @Step("Send data to element")
    public static void sendData(WebDriver driver,By locator,String data){
        Scrolling.scrollToElement(driver,locator);

        // clear existing data
//        findElement(driver,locator).sendKeys(Keys.CONTROL,"a");
        findElement(driver,locator).sendKeys(Keys.DELETE);
        findElement(driver,locator).sendKeys(data);
        // log data sent

        LogsManager.info("data sent to "+locator+ "with data"+data);
    }

    @Step("get text of an element")
    public static String getText(WebDriver driver,By locator){
        Scrolling.scrollToElement(driver,locator);
        // log data return from that locator
        LogsManager.info("getting text of "+locator+"with data"+findElement(driver,locator).getText());
        return findElement(driver,locator).getText();
    }

    @Step("clear data")
    public static void clearData(WebDriver driver, By locator){
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).clear();
        LogsManager.info("clearing data from : "+locator);
    }

    @Step("hoverOverElements")
    public static void hoverOver(WebElement locator){
        actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(locator).build().perform();
    }

    public void selectByVisableText(String text, WebElement locator){
        select = new Select(locator);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(int index, WebElement locator){
        select = new Select(locator);
        select.selectByIndex(index);
    }



}
