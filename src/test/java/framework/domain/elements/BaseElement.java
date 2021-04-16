package framework.domain.elements;

import framework.examples.LoggerManager;
import framework.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static framework.examples.RandomGenerator.getRandomInt;

public class BaseElement {
    private static LoggerManager logger = new LoggerManager();
    private WebDriverManager instance = WebDriverManager.getInstance();
    public By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        logger.getLoggerMessage(this.getClass().toString(), this.name);
        findElement().click();
    }

    public void moveSlider() {
        logger.getLoggerMessage(this.getClass().toString(), this.name);
        int randomInt = getRandomInt();
        for (int i = 1; i <= randomInt; i++) {
            findElement().sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public List<WebElement> findElements() {
        logger.getLoggerMessage("Finding elements: {}", this.name);
        return instance.getDriver().findElements(this.locator);
    }

    public WebElement findElement() {
        logger.getLoggerMessage("Finding elements: {}", this.name);
        return instance.getDriver().findElement(this.locator);
    }

    public String labelIsDisplayed() {
        logger.getLoggerMessage("Check is element displayed: {}", this.name);
        return findElement().getText();
    }

    public void moveTo() {
        new Actions(instance.getDriver()).moveToElement(findElement()).build().perform();
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public String getAttribute(String href) {
        return findElement().getAttribute(href);
    }

    public void switchToIframe() {
        instance.getDriver().switchTo().frame(findElement());
    }

    public void actionCntrlA() {
        new Actions(instance.getDriver()).keyDown(Keys.CONTROL).sendKeys("a").build().perform();
    }

    public void actionBackspace() {
        new Actions(instance.getDriver()).sendKeys(Keys.BACK_SPACE).build().perform();
    }
}
