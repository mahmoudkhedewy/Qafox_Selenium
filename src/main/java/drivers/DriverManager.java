package drivers;

import org.openqa.selenium.WebDriver;
import utils.LogsManager;

public class DriverManager {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private DriverManager(){

    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }

    public static void createdDriverInstance(String browserName){
        WebDriver driver = BrowserFactory.getBrowserDriver(browserName);
        LogsManager.info(browserName+" is created ");
        setDriver(driver);
    }

    public static WebDriver getDriver(){
        if (threadLocal.get() == null){
            LogsManager.error("Webdriver instance is not set for this thread");
        }
        return threadLocal.get();
    }

    public static void unload(){
        threadLocal.remove();
    }
}
