package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.TestDataReader;

public class BrowserModel {
    private final static Logger logger = LogManager.getRootLogger();
    public static final String BROWSER_OPTIONS = "options";
    public static final String SEPARATOR = "options.separator";

    private String browserName;

    private String[] browserOptions;
    private BrowserModel(String browserName, String[] browserOptions) {
        this.browserName = browserName;
        this.browserOptions = browserOptions;
    }

    public static BrowserModel createBrowserModel() {
        logger.info("test property " + System.getProperty("surefire.suiteXmlFiles"));
        logger.info("before " + System.getProperty("browser"));
        String browserName = TestDataReader.getTestData("name");
        logger.info("after "+ System.getProperty("browser"));
        String[] browserOptions = TestDataReader.getTestData(BROWSER_OPTIONS).
                split(TestDataReader.getTestData(SEPARATOR));
        return new BrowserModel(browserName, browserOptions);
    }

    public String getBrowserName() {
        return browserName;
    }

    public String[] getBrowserOptions() {
        return browserOptions;
    }
}
