package framework.tests;

import framework.examples.LoggerManager;
import framework.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private static LoggerManager logger = new LoggerManager();
    private WebDriverManager instance = WebDriverManager.getInstance();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        logger.getLoggerMessage(this.getClass().toString(), "Start");
        driver = instance.getDriver();
    }

    @AfterSuite
    public void closeUp() {
        driver.close();
        driver.quit();
    }

    public void closeWindow() {
        driver.close();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void switchToDefaultContext() {
        driver.switchTo().defaultContent();
    }


}
