package tests;

import drivers.DriverManager;
import io.qameta.allure.Step;
import listeners.TestNGListeners;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AllureUtils;
import utils.LogsManager;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(value = TestNGListeners.class)
public class TestBase {
    Properties properties;


    @BeforeClass
    @Step("creating the base of test")

    public void setDriver() throws IOException {
        LogsManager.info("STARTING BROWSER SETUP");
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
        properties.load(fis);
        LogsManager.info("Loaded properties: " + properties);
        DriverManager.createdDriverInstance(properties.getProperty("chromeBrowser"));
        DriverManager.getDriver().get(properties.getProperty("baseURL"));
        LogsManager.info("Navigated to base URL.");
        System.out.println("Log4j2 configuration location: " + System.getProperty("log4j.configurationFile"));
    }

    @AfterClass
    public void closeDriver(){
        DriverManager.getDriver().close();
        DriverManager.unload();
    }
  }
