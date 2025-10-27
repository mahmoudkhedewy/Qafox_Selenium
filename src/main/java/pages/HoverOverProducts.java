package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementActions;
import utils.Waits;

public class HoverOverProducts {
    private final WebDriver driver;
    public HoverOverProducts(WebDriver driver){
        this.driver = driver;
    }

    private final By desktopProducts = By.xpath("//a[text()='Desktops']");
    private final By mac1Product = By.xpath("//a[text()='Mac (1)']");
    private final By assertionMessage = By.tagName("h2");

    public void hoverOverDesktopProducts(){
        WebElement desktop = driver.findElement(desktopProducts);
        ElementActions.hoverOver(desktop);
        Waits.waitELementToBeVisible(driver,mac1Product);
        ElementActions.clickElement(driver,mac1Product);
    }

    public String getAssertionMessage(){
        Waits.waitELementToBeVisible(driver,assertionMessage);
        return ElementActions.findElement(driver,assertionMessage).getText();
    }
}
