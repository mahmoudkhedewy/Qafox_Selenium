package utils;

import io.qameta.allure.Allure;
import java.io.FileInputStream;

public class AllureUtils {
    // declare where to store allure-results stored
    private AllureUtils(){
        super();
    }

    private static String ALLURE_PATH = "test-outputs/logs/test-execution.log";
public static void attachScreenshotFromFile(String screenshotPath, String attachmentName) {
    // using file input stream to read data from external files (benefits of FileInputStream is it can read binary)
    try (FileInputStream inputStream = new FileInputStream(screenshotPath)) {
        // attach this file to allure report
        Allure.addAttachment(attachmentName, inputStream);
    } catch (Exception e) {
        LogsManager.error("Failed to attach screenshot to Allure: " + e.getMessage());
    }
}
    public static void attachLogFile( String attachmentName) {
        try (FileInputStream inputStream = new FileInputStream(ALLURE_PATH)) {
            Allure.addAttachment(attachmentName, "text/plain", inputStream, ".log");
        } catch (Exception e) {
            LogsManager.error("Failed to attach log file to Allure: " + e.getMessage());
        }
    }

}
