package testing.platform.tests;

import testing.platform.common.Browser;
import testing.platform.pageobjects.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;

public class SearchWithGoogle {
    private WebDriver browser;

    public void open() {
        browser = Browser.runChrome();
    }

    @Test
    public void addContactsInMultipleBrowsers() {
        open();

        MainPage.queryInput.setValue("Selenide");
        MainPage.queryInput.sendKeys(Keys.ESCAPE);
        MainPage.submitButton.click();
        MainPage.resultStats.waitUntil(visible, 3000);

        Browser.quitChrome(browser);
    }
}
