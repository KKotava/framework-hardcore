package model;

import service.TestDataReader;

public class BrowserModel {
    public static final String BROWSER_OPTIONS = "options";
    public static final String SEPARATOR = "options.separator";

    private String browserName;

    private String[] browserOptions;
    private BrowserModel(String browserName, String[] browserOptions) {
        this.browserName = browserName;
        this.browserOptions = browserOptions;
    }

    public static BrowserModel createBrowserModel() {
        String browserName = TestDataReader.getTestData("name");
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
