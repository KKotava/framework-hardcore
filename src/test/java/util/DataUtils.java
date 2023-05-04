package util;

import service.TestDataReader;

public class DataUtils {
    public static final String ESTIMATED_REGION = "estimated.region";
    public static final String PROVISIONING_MODEL = "provisioning.model";
    public static final String INSTANCE_TYPE = "instance.type";
    public static final String LOCAL_SSD = "local.ssd";
    public static final String COMMITMENT_TERM = "commitment.term";
    public static final String TOTAL_PRICE = "total.price";

    public static String getEstimatedRegion() {
        return TestDataReader.getTestData(ESTIMATED_REGION);
    }

    public static String getProvisioningModel() {
        return TestDataReader.getTestData(PROVISIONING_MODEL);
    }

    public static String getInstanceType() {
        return TestDataReader.getTestData(INSTANCE_TYPE);
    }

    public static String getLocalSsd() {
        return TestDataReader.getTestData(LOCAL_SSD);
    }

    public static String getCommitmentTerm() {
        return TestDataReader.getTestData(COMMITMENT_TERM);
    }

    public static String getTotalPrice() {
        return TestDataReader.getTestData(TOTAL_PRICE);
    }
}
