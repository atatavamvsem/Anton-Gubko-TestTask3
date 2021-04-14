package org.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerManager.class);

    public void getLoggerMessage(String name, String s){
        LOGGER.info("Click button : {},{}", name, s);
    }
}
