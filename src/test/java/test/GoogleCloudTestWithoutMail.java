package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.DataUtils;

public class GoogleCloudTestWithoutMail extends CommonConditions{

    @Test(description = "Hurt Me Plenty")
    public void isRegionRight() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkRegion(), DataUtils.getEstimatedRegion(),"Region is wrong");
    }

    @Test
    public void isProvisioningModelRight() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkProvisioningModel(), DataUtils.getProvisioningModel(), "Provisioning model is wrong");
    }

    @Test
    public void isInstanceTypeRight() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkInstanceType(), DataUtils.getInstanceType(), "Instance type is wrong");
    }

    @Test
    public void isLocalSsdRight() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkLocalSsd(), DataUtils.getLocalSsd(), "Local SSD is wrong");
    }

    @Test
    public void isCommitmentTermRight() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkCommitmentTerm(), DataUtils.getCommitmentTerm(), "Commitment term is wrong");
    }

    @Test
    public void isTotalPriceMatchingManualTestingPrice() {
        makeCalculatorPage();
        Assert.assertEquals(calculatorPage.checkTotalPrice(), DataUtils.getTotalPrice(), "Total price is not matching with manual testing price");
    }
}
