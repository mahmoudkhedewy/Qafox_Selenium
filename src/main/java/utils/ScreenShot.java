package utils;

import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.bidi.log.Log;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenShot {

    public static String PIC_PATH = "test-outputs/screenshots/";
    private ScreenShot(){
        super();
    }

    @Step("Take screenshot: {screenShotName}")
    public static void takeScreenShot(String screenShotName) {
        try {
            // Take screenshot as a temp file
            File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

            // Build destination file path
            Path destPath = Path.of(PIC_PATH, screenShotName + ".png");
            Files.createDirectories(destPath.getParent()); // Ensure directory exists
            Files.copy(srcFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

            LogsManager.info("Screenshot saved: " + destPath);

            // Attach to Allure
            AllureUtils.attachScreenshotFromFile(destPath.toString(), screenShotName);
            AllureUtils.attachLogFile(LogsManager.LOGS_PATH);

        } catch (Exception e) {
            LogsManager.error("Failed to take screenshot: " + e.getMessage());
        }


    }


}
