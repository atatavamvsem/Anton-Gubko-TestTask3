package org.examples;

import org.examples.webDrivers.ChromeDriverSet;
import org.examples.webDrivers.FirefoxDriverSet;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private ChromeDriverSet chromeDriverSet = new ChromeDriverSet();
    private FirefoxDriverSet firefoxDriverSet = new FirefoxDriverSet();
    private WebDriver driver;
    private static WebDriverManager instance;

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    private WebDriver choseBrowser(String browser) {
        switch (browser){
            case ("chrome"): {
                driver = chromeDriverSet.setUp();
                return driver;
            }

            case("firefox"):{
                driver = firefoxDriverSet.setUp();
                return driver;
            }

            default:{
                driver = firefoxDriverSet.setUp();
                return driver;
            }
        }
    }

    public WebDriver getDriver(){
        if (driver != null) {
            return driver;
        }else {
            return choseBrowser(ResourcesProperties.getConfProperty("browser"));
        }
    }
}
