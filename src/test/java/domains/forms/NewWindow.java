package domains.forms;

import framework.domain.elements.Label;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class NewWindow extends BaseForm {
    private static Label pageTitle = new Label(By.xpath("//div[@class='example']"), "idPage");
    private String handle;

    public NewWindow(String handle) {
        super(pageTitle, "pageTitle", handle);
    }
}
