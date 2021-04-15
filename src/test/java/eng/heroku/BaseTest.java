package eng.heroku;

import org.examples.LoggerManager;
import org.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private static LoggerManager logger = new LoggerManager();
    private WebDriverManager instance = WebDriverManager.getInstance();
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        //LOGGER.debug("Start testing");
        logger.getLoggerMessage(this.getClass().toString(), "Start");
        driver = instance.getDriver();
        //instance.getDriver().get(ResourcesProperties.getConfProperty("loginPage"));
    }

    @AfterSuite
    public void closeUp() {
        driver.close();
        driver.quit();
        //LOGGER.debug("The close_up process is completed");
    }



}
