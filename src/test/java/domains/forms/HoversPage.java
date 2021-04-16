package domains.forms;

import framework.domain.elements.Button;
import framework.domain.elements.Label;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class HoversPage extends BaseForm {

    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Button button;
    private static Label label;
    private static Label img;
    public static String buttonAttribute;

/*
Да, не очень хорошее решение этой задачи, но это лучшее, что я смог придумать)
 */
    public HoversPage(String user1) {
        super(labelPage, "idPage");
        label = new Label(By.xpath("//*[contains(text(),'" + user1 + "')]"), "listLinks");
        img = new Label(By.xpath("//*[contains(text(),'" + user1 + "')]//preceding::img[1]"), "listLinks");
        button = new Button(By.xpath("//*[contains(text(),'" + user1 + "')]//following::a[1]"), "listUsers");
    }

    public void clickButton() {
        buttonAttribute = getLinkAttribute("href");
        button.click();
    }

    public void moveTo() {
        img.moveTo();
    }

    public boolean labelIsDisplayed() {
        return label.isDisplayed();
    }

    public boolean buttonIsDisplayed() {
        return button.isDisplayed();
    }

    public String getLinkAttribute(String href) {
        return button.getAttribute(href);
    }
}
