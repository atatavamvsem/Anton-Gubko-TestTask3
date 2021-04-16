package domains.forms;

import domains.elements.BaseElement;
import domains.elements.Label;
import org.examples.RandomGenerator;
import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.examples.ResourcesProperties.getConfProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public abstract class BaseForm {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private BaseElement element;
    private String name;
    private static Alert alert;
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

    public boolean isOpened(String loginPage){
        String url = driver.getCurrentUrl();
        return url.equals(loginPage);
    }

    public void openStartPage(String loginPage){
        driver.get(loginPage);
    }



    public void passingAuthorizationByAddressBar() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public boolean pageIsOpened(String titleJavaScriptAlertsPage){
        return element.labelIsDisplayed().equals(titleJavaScriptAlertsPage);
    }

    public void waitBeforeCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getConfProperty("waitLoadingPageSeconds")));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText(){
        return alert.getText();
    }

    public void switchToAlert(){
        waitBeforeCheck();
        alert = driver.switchTo().alert();
    }


    public void clickAlertOK(){
        alert.accept();
    }

    public void sendTextToAlert() {
        alert.sendKeys(RandomGenerator.getRandomString());
    }

    public void putWindowHandle(){
        pullHadle.put(this.handle, driver.getWindowHandle());
    }


    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if(!pullHadle.containsValue(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToWindow() {
        driver.switchTo().window(pullHadle.get(this.handle));
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }


}