package domains.forms;

import framework.domain.elements.Label;
import framework.domain.elements.TextField;
import framework.domain.forms.BaseForm;
import framework.examples.RandomGenerator;
import org.openqa.selenium.By;


public class Iframe extends BaseForm {
    private static TextField labelPage = new TextField(By.xpath("//body[@id='tinymce']//p"), "textFild");
    private static Label iframe = new Label(By.xpath("//iframe"), "iFrame");

    public void cleareText() {
        labelPage.click();
        iframe.actionCntrlA();
        iframe.actionBackspace();
        labelPage.sendText("");
    }

    public void switchToIframe() {
        iframe.switchToIframe();
    }

    public void sendRandomText() {
        labelPage.sendText(RandomGenerator.getRandomString());
    }

    public void hightlightText() {
        iframe.actionCntrlA();
    }
}
