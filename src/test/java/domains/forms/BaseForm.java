package domains.forms;

import domains.elements.BaseElement;
import org.examples.RandomGenerator;
import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.examples.ResourcesProperties.getConfProperty;

public abstract class BaseForm {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private BaseElement element;
    private String name;
    private static Alert alert;

    public BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
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
}