package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import model.BrowserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import service.TestDataReader;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            BrowserModel browserModel = BrowserModel.createBrowserModel();
            WebDriverManager.getInstance(DriverManagerType.valueOf(browserModel.getBrowserName())).setup();
            switch (browserModel.getBrowserName()){
                case "FIREFOX": {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments(browserModel.getBrowserOptions());
                    driver = WebDriverManager.firefoxdriver().capabilities(options).create();
                    break;
                }
                case "CHROME": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(browserModel.getBrowserOptions());
                    driver = WebDriverManager.chromedriver().capabilities(options).create();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Browser name is not recognized: " + browserModel.getBrowserName());
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
