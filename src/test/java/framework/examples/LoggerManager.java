package framework.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerManager.class);

    public void getLoggerMessage(String name, String s) {
        LOGGER.info("Info : {},{}", name, s);
    }

    public void getLoggerMessage(String name) {
        LOGGER.info("Info : {}", name);
    }

    public void getWarningMessage(String name, String s) {
        LOGGER.warn("Warning : {},{}", name, s);
    }

    public void getWarningMessage(String name) {
        LOGGER.warn("Warning ", name);
    }
}
