package framework.domain.forms;

import framework.examples.RandomGenerator;
import framework.examples.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Alerts {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private static Alert alert;

    public static void switchToAlert() {
        alert = driver.switchTo().alert();
    }

    public static void clickAlertOK() {
        alert.accept();
    }

    public static void sendTextToAlert() {
        alert.sendKeys(RandomGenerator.getRandomString());
    }

    public static String getAlertText() {
        return alert.getText();
    }
}
