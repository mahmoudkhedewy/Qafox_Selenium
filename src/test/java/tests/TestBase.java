package tests;

import drivers.DriverManager;
import io.qameta.allure.Step;
import listeners.TestNGListeners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(value = TestNGListeners.class)
public class TestBase {
    Properties properties;


    @BeforeClass
    @Step("creating the base of test")

    public void setDriver() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/config.properties");
        properties.load(fis);
        DriverManager.createdDriverInstance(properties.getProperty("chromeBrowser"));
        DriverManager.getDriver().get(properties.getProperty("baseURL"));
    }

    @AfterClass
    public void closeDriver(){
        DriverManager.getDriver().close();
        DriverManager.unload();
    }
}
