package domains.forms;

import framework.domain.elements.Button;
import framework.domain.elements.Label;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class WindowsPage extends BaseForm {
    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Button newWindow = new Button(By.xpath("//div[@class = 'example']//a"), "newWindow");
    private String handle;

    public void clickNewWindow() {
        newWindow.click();
    }

    public WindowsPage(String handle) {
        super(labelPage, "idPage", handle);
    }
}
