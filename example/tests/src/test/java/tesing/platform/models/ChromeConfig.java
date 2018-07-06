package testing.platform.models;

public class ChromeConfig {
    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String BROWSER = "chrome";
    public static String START_PAGE = "https://google.com";
    public static String WEBDRIVER_BIN = null;
    public static String BROWSER_BIN = null;
    public static Boolean HEADLESS = false;

    static {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String startPage = System.getProperty("clienthost");
        String headless = System.getProperty("headless");

        ChromeConfig.WEBDRIVER_BIN = isWindows ? "bin\\chromedriver.exe" : "bin/chromedriver";
        ChromeConfig.BROWSER_BIN = System.getProperty("binpath");
        ChromeConfig.HEADLESS = headless != null && headless.equals("1");

        if (startPage != null) {
            ChromeConfig.START_PAGE = startPage;
        }
    }
}