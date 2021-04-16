package framework.domain.forms;

import framework.domain.elements.BaseElement;
import framework.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static framework.examples.ResourcesProperties.getConfProperty;

public abstract class BaseForm {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private BaseElement element;
    private String name;
    private static Map<String, String> pullHadle = new HashMap<>();
    private String handle;


    public BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public BaseForm(BaseElement element, String name, String handle) {
        this.element = element;
        this.name = name;
        this.handle = handle;
    }

    public BaseForm() {
    }

    public void openStartPage(String loginPage) {
        driver.get(loginPage);
    }

    public boolean pageIsOpened(String titleJavaScriptAlertsPage) {
        return element.labelIsDisplayed().equals(titleJavaScriptAlertsPage);
    }

    public void waitBeforeCheck() {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getConfProperty("waitLoadingPageSeconds")));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void putWindowHandle() {
        pullHadle.put(this.handle, driver.getWindowHandle());
    }

    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!pullHadle.containsValue(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToWindow() {
        driver.switchTo().window(pullHadle.get(this.handle));
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

}