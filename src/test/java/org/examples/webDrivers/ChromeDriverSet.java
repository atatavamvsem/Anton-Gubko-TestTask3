package org.examples.webDrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSet {
    public WebDriver setUp(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

