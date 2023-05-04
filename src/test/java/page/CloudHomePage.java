package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CloudHomePage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//devsite-snackbar//button")
    private WebElement acceptCookies;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement searchBox;

    public CloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Cloud home page opened");
        //clickThis(acceptCookies);
        return this;
    }

    public CloudSearchResultsPage searchForTerms(String terms) {
        clickThis(searchButton);
        clickThis(searchBox);
        searchBox.sendKeys(terms);
        searchBox.sendKeys(Keys.ENTER);
        logger.info("Terms input successful");
        return new CloudSearchResultsPage(driver, terms);
    }
}
