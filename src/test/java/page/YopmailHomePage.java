package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class YopmailHomePage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();
    private final static String HOMEPAGE_URL = "https://yopmail.com/";
    private final static String GENERATED_EMAIL_ADDRESS_ID = "geny";
    private final static String MAIL_ID = "message";
    private ArrayList<String> tabs;

    @FindBy(id = "accept")
    private WebElement acceptCookies;

    @FindBy(xpath = "//a[@href='email-generator']//div[@class='txtlien']")
    private WebElement chooseRandomEmailGenerator;

    @FindBy(id = GENERATED_EMAIL_ADDRESS_ID)
    private WebElement generatedEmailAddress;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkInboxButton;

    @FindBy(id = MAIL_ID)
    private WebElement mail;

    @FindBy(xpath = "//h2")
    private WebElement totalCostFromEmail;

    @FindBy(id = "refresh")
    private WebElement refreshMailButton;

    public YopmailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YopmailHomePage openYopmailInNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        logger.info("New tab opened");
        driver.get(HOMEPAGE_URL);
        clickThis(acceptCookies);
        logger.info("cookies accepted");
        tabs = new ArrayList<>(driver.getWindowHandles());
        logger.info("YopMail page opened");
        return this;
    }

    public String generateRandomEmailAddress() {
        clickThis(chooseRandomEmailGenerator);
        waitTillElementIsPresent(By.id(GENERATED_EMAIL_ADDRESS_ID));
        logger.info("Random email address generated");
        return generatedEmailAddress.getText();
    }

    public String receiveEstimatedInfoFromGeneratedEmail() {
        clickThis(checkInboxButton);
        logger.info("Inbox opened");
        return getMailContent();
    }

    public YopmailHomePage switchToYopmailPage() {
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().defaultContent();
        logger.info("Switched to YopMail page successfully");
        return this;
    }

    private String getMailContent() {
        waitTillElementIsPresent(By.id(MAIL_ID));
        while (mail.getText().equals("This inbox is empty")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickThis(refreshMailButton);
            waitTillElementIsPresent(By.id(MAIL_ID));
        }
        driver.switchTo().frame("ifmail");
        return totalCostFromEmail.getText();
    }
}
