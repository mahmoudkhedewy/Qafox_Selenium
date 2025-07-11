package utils;

import io.qameta.allure.Allure;
import java.io.FileInputStream;

public class AllureUtils {
    // declare where to store allure-results stored
    private AllureUtils(){
        super();
    }

    private static String ALLURE_PATH = "test-outputs/logs";
public static void attachScreenshotFromFile(String screenshotPath, String attachmentName) {
    try (FileInputStream inputStream = new FileInputStream(screenshotPath)) {
        Allure.addAttachment(attachmentName, inputStream);
    } catch (Exception e) {
        LogsManager.error("Failed to attach screenshot to Allure: " + e.getMessage());
    }
}
    public static void attachLogFile(String logFilePath, String attachmentName) {
        try (FileInputStream inputStream = new FileInputStream(logFilePath)) {
            Allure.addAttachment(attachmentName, "text/plain", inputStream, ".log");
        } catch (Exception e) {
            LogsManager.error("Failed to attach log file to Allure: " + e.getMessage());
        }
    }

}
