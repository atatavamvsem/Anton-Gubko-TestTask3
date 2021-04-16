package eng.heroku;

import org.examples.LoggerManager;
import org.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private static LoggerManager logger = new LoggerManager();
    private WebDriverManager instance = WebDriverManager.getInstance();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        //LOGGER.debug("Start testing");
        logger.getLoggerMessage(this.getClass().toString(), "Start");
        driver = instance.getDriver();
    }

    @AfterSuite
    public void closeUp() {
        driver.close();
        driver.quit();
        //LOGGER.debug("The close_up process is completed");
    }

    public void closeWindow(){
        driver.close();
    }

    public void navigateBack(){
        driver.navigate().back();
    }



}
