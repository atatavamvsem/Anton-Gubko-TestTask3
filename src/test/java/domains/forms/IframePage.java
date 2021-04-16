package domains.forms;

import framework.domain.elements.Button;
import framework.domain.elements.Label;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class IframePage extends BaseForm {
    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Button boldButton = new Button(By.xpath("//button[@title='Bold']"), "boldButton");

    public IframePage() {
        super(labelPage, "idPage");
    }

    public void clickBoldButton() {
        boldButton.click();
    }
}
