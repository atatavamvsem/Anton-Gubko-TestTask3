package domains.forms;

import domains.elements.BaseElement;
import domains.elements.Label;
import org.openqa.selenium.By;

public class NewWindow extends BaseForm {
    private static Label pageTitle = new Label(By.xpath("//div[@class='example']"), "idPage");
    private String handle;

    public NewWindow(String handle) {
        super(pageTitle, "pageTitle", handle);
    }
}
