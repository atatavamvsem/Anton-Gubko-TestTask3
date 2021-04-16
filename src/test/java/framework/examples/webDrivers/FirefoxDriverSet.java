package framework.examples.webDrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverSet {
    public WebDriver setUp() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

