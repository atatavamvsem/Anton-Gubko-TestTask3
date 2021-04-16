package framework.domain.elements;

import framework.examples.LoggerManager;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    private static LoggerManager logger = new LoggerManager();

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        logger.getLoggerMessage("Sending text: {}", text);
        findElement().sendKeys(text);
    }

}
