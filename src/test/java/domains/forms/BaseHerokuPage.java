package domains.forms;

import domains.elements.BaseElement;
import domains.elements.Label;
import org.openqa.selenium.By;

public class BaseHerokuPage extends BaseForm {

    private static Label pageTitle = new Label(By.xpath("//div[@id='content']//h3"), "idPage");

    public BaseHerokuPage() {
        super(pageTitle, "pageTitle");
    }
}
