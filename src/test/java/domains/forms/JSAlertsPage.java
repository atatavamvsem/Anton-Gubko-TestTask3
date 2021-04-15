package domains.forms;

import domains.elements.Button;
import domains.elements.Label;
import org.examples.RandomGenerator;
import org.openqa.selenium.By;

import static org.examples.ResourcesProperties.getDataProperty;

public class JSAlertsPage extends BaseForm {
    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Label successMess = new Label(By.xpath("//p[@id = 'result']"), "idSearchPage");
    private static Button jsAlert = new Button(By.xpath("//button[contains(text(),'Alert')]"), "jsAlert");
    private static Button jsConfirm = new Button(By.xpath("//button[contains(text(),'Confirm')]"), "jsConfirm");
    private static Button jsPrompt = new Button(By.xpath("//button[contains(text(),'Prompt')]"), "jsPrompt");


    public JSAlertsPage() {
        super(labelPage,"idPage");
    }

    public void clickJSAlert() {
        jsAlert.click();
    }

    public void clickJSConfirm() {
        jsConfirm.click();
    }

    public String labelIsDisplayed(){
        return successMess.labelIsDisplayed();
    }


    public void clickJSPrompt() {
        jsPrompt.click();
    }

    public String getMessToCompare(){
        return getDataProperty("JSPromptSuccessMess")+" "+ RandomGenerator.randomString;
    }
}
