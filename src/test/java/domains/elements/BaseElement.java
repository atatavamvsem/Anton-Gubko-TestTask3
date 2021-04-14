package domains.elements;

import org.examples.LoggerManager;
import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
    private static LoggerManager logger = new LoggerManager();
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    public By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }


    public void click(){
        logger.getLoggerMessage(this.getClass().toString(), this.name);
        findElement().click();
    }

    public void clickSlider(){
        logger.getLoggerMessage(this.getClass().toString(), this.name);
        findElement().sendKeys(Keys.ARROW_RIGHT);
    }

    public List<WebElement> findElements(){
        //LOGGER.debug("Finding elements: {}", this.name);
        return driver.findElements(this.locator);
    }

    public WebElement findElement(){
        //LOGGER.debug("Finding element: {}", element.name);
        return driver.findElement(this.locator);
    }

    public String labelIsDisplayed(){
        //LOGGER.debug("Check is element displayed: {}", this.name);
        return findElement().getText();
    }

}
