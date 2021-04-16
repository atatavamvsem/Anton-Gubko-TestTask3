package domains.forms;

import domains.elements.Button;
import domains.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HoversPage extends BaseForm {

    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private static Label listUsers = new Label(By.xpath("//div[@class = 'figure']//img"), "listUsers");
    private static Button button;
    private static Label label;
    private static Label img;
    public static String buttonAttribute;

    public HoversPage(String user1) {
        super(labelPage,"idPage");
        label = new Label(By.xpath("//*[contains(text(),'" + user1 + "')]"), "listLinks");
        img = new Label(By.xpath("//*[contains(text(),'" + user1 + "')]//preceding::img[1]"), "listLinks");
        button = new Button(By.xpath("//*[contains(text(),'" + user1 + "')]//following::a[1]"), "listUsers");
    }

    public void clickButton(){
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
