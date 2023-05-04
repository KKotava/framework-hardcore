package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.CloudCalculatorPage;
import page.CloudHomePage;
import page.YopmailHomePage;
import util.StringUtils;

public class GoogleCloudTestWithMail extends CommonConditions {

    @Test(description = "Framework Hardcore")
    public void isTotalPriceMatchingManualTestingPrice() {
        makeCalculatorPage();

        String priceMessageFromCalculatorPage = calculatorPage.getEstimatedPrice();

        YopmailHomePage yopmailHomePage = new YopmailHomePage(driver)
                .openYopmailInNewTab();

        String emailAddress = yopmailHomePage.generateRandomEmailAddress();

        calculatorPage.switchToCalculatorPage()
                .sendCalculatedInfoToEmail(emailAddress);

        yopmailHomePage.switchToYopmailPage();

        String priceMessageFromEmail = yopmailHomePage.receiveEstimatedInfoFromGeneratedEmail();

        Assert.assertEquals(StringUtils.getPrice(priceMessageFromCalculatorPage), StringUtils.getPrice(priceMessageFromEmail));
    }

}
