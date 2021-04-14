package domains.forms;

import domains.elements.Label;
import org.openqa.selenium.By;

public class BasicAuthPage extends BaseHerokuPage{
    private static Label labelBasicAuthPage = new Label(By.xpath("//div[@id='content']//p"), "idSearchPage");

    public BasicAuthPage() {
        super();
    }

    public String labelIsDisplayed(){
        return labelBasicAuthPage.labelIsDisplayed();
    }

}
