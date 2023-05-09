package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class TestDataReader {
    private final static Logger logger = LogManager.getRootLogger();
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("browser"));

    public static String getTestData(String key){
        logger.info(resourceBundle.getKeys());
        return resourceBundle.getString(key);
    }
}
