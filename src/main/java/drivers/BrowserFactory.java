package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BrowserFactory {

    public static WebDriver getBrowserDriver(String browserName){
        if (Objects.isNull(browserName) || browserName.isEmpty()){
            throw new  IllegalArgumentException("Browser Can not be empty");
        }
        return switch (browserName.toUpperCase()){
            case "CHROME" ->{
                ChromeOptions chromeOptions = getChromeOptions();
                yield new ChromeDriver(chromeOptions);
            }
            case "FIREFOX" ->{
                FirefoxOptions firefoxOptions = getFireFoxOptions();
                yield new FirefoxDriver(firefoxOptions);
            }
            default -> {
                EdgeOptions edgeOptions = getedgeOptions();
                yield new EdgeDriver(edgeOptions);
            }

        };
    }



    private static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(getCommonArguments());
        chromeOptions.setExperimentalOption("prefs",getCommonPrefs());
        return chromeOptions;
    }
    private static FirefoxOptions getFireFoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(getCommonArguments());
        return firefoxOptions;
    }
    private static EdgeOptions getedgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(getCommonArguments());
        edgeOptions.setExperimentalOption("prefs",getCommonPrefs());
        return edgeOptions;
    }

    private static List<String> getCommonArguments(){
        return List.of(
                "start-maximized",
                "--disable-notifications",
                "--disable-popup-blocking",
                "--disable-infobars",
                "--disable-dev-shm-usage",
                "--disable-extensions"
        );
    }

    private static Map<String, Object> getCommonPrefs(){
        return Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credential_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile.enable", false
        );
    }
}
