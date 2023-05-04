package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.CloudCalculatorPage;
import page.CloudHomePage;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected static CloudCalculatorPage calculatorPage;

    protected WebDriver driver;
    protected static final String TERMS = "Google Cloud Pricing Calculator";


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    public void makeCalculatorPage() {
        this.calculatorPage = new CloudHomePage(driver)
                .openPage()
                .searchForTerms(TERMS)
                .clickMatchingResult()
                .chooseSection()
                .fillForms()
                .addGpu()
                .calculate();
    }
}
