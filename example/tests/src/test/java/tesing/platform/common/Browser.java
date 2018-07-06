package testing.platform.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import testing.platform.models.ChromeConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Browser {
    public static void run(String webdriver, String webdriverLink, String browser, String startPage, String binaryPath, Boolean headless) {
        System.setProperty(webdriver, webdriverLink);
        Configuration.browser = browser;

        if (browser == "chrome") {
            // Allow getUserMedia
            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-ui-for-media-stream");
            options.addArguments("use-fake-device-for-media-stream");
            options.addArguments("start-maximized");

            if (headless) {
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
            }

            if (binaryPath != null) {
                options.setBinary(binaryPath);
            }

            ChromeDriver driver = new ChromeDriver(options);
            WebDriverRunner.setWebDriver(driver);
        }

        open(startPage);
    }

    public static WebDriver runChrome() {
        Browser.run(
            ChromeConfig.WEBDRIVER,
            ChromeConfig.WEBDRIVER_BIN,
            ChromeConfig.BROWSER,
            ChromeConfig.START_PAGE,
            ChromeConfig.BROWSER_BIN,
            ChromeConfig.HEADLESS
        );
        return WebDriverRunner.getWebDriver();
    }

    public static void quitChrome() {
        getWebDriver().close();
        WebDriverRunner.closeWebDriver();
    }

    public static void quitChrome(WebDriver driver) {
        WebDriverRunner.setWebDriver(driver);
        driver.close();
        WebDriverRunner.closeWebDriver();
    }

    public static void switchBrowser(WebDriver driver) {
        WebDriverRunner.setWebDriver(driver);
    }
}