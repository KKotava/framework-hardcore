package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CloudSearchResultsPage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();
    private final String terms;

    public CloudSearchResultsPage(WebDriver driver, String terms) {
        super(driver);
        this.terms = terms;
        PageFactory.initElements(driver, this);
    }

    public CloudCalculatorPage clickMatchingResult() {
        logger.info("Results page opened");
        String defaultLocatorPattern = "//a/b[contains(text(), '%s')]";
        String locatorForSearch = String.format(defaultLocatorPattern, terms);
        waitTillElementIsPresent(By.xpath(locatorForSearch));
        WebElement matchingResult = driver.findElement(By.xpath(locatorForSearch));
        logger.info("Matching result found");
        matchingResult.click();
        return new CloudCalculatorPage(driver);
    }

}
