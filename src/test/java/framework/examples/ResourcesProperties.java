package framework.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesProperties {
    private static LoggerManager logger = new LoggerManager();
    private static FileInputStream fileConfigInputStream;
    private static FileInputStream fileTestDataInputStream;
    private static Properties CONF_PROPERTIES;
    private static Properties DATA_PROPERTIES;

    static {
        try {
            logger.getLoggerMessage("Reading files");
            fileConfigInputStream = new FileInputStream("src/test/resources/conf.properties");
            fileTestDataInputStream = new FileInputStream("src/test/resources/testData.properties");
            CONF_PROPERTIES = new Properties();
            DATA_PROPERTIES = new Properties();
            CONF_PROPERTIES.load(fileConfigInputStream);
            DATA_PROPERTIES.load(fileTestDataInputStream);
        } catch (IOException e) {
            logger.getWarningMessage("Error reading");
            throw new UnsupportedOperationException(e);
        } finally {
            if (fileConfigInputStream != null && fileTestDataInputStream != null)
                try {
                    fileConfigInputStream.close();
                    fileTestDataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getConfProperty(String key) {
        return CONF_PROPERTIES.getProperty(key);
    }

    public static String getDataProperty(String key) {
        return DATA_PROPERTIES.getProperty(key);
    }
}
