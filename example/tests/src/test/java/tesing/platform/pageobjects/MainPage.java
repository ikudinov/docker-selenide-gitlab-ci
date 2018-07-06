package testing.platform.pageobjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement queryInput = $("input#lst-ib");
    public static SelenideElement submitButton = $("input[name=btnK]");
    public static SelenideElement resultStats = $("div#resultStats");
}
