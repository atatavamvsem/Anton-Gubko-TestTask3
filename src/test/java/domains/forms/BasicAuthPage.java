package domains.forms;

import framework.domain.elements.Label;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class BasicAuthPage extends BaseForm {
    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Label messPage = new Label(By.xpath("//div[@id='content']//p"), "messPage");


    public BasicAuthPage() {
        super(labelPage, "idPage");
    }

    public String labelIsDisplayed() {
        return messPage.labelIsDisplayed();
    }

    public String parsingURL(String basicAuthPageURL, String user, String password) {
        String URL = "http://" + user + ":" + password + "@" + basicAuthPageURL.substring(7);
        return URL;
    }

}
