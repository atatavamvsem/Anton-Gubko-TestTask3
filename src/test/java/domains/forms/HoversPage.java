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
    private static Label listLinks = new Label(By.xpath("//div[@class = 'figure']//a"), "listLinks");
    private static List<Label> listLabel = new ArrayList<>();
    private static  List<Button> listButton;


    public HoversPage() {
        super(labelPage,"idPage");
    }


    public void findUsers() {
        for(WebElement element :listUsers.findElements()){
            BaseForm.moveTo(element);
        }
    }

    private List<Label> convertToListLabel(List<WebElement> elements) {
        List<Label> listLabel = new ArrayList<>();
        for (WebElement user : elements){
        user.isDisplayed();
            listLabel.add((Label) user);
        }
        return listLabel;
    }

    private List<Button> convertToListButton(List<WebElement> elements) {
        List<Button> listButton = new ArrayList<>();
        for (WebElement user : elements){
            listButton.add((Button) user);
        }
        return listButton;
    }

   /* public void moveTo() {
        listLabel.get(0).moveTo();
    }*/
}
