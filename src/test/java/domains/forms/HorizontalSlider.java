package domains.forms;

import domains.elements.Button;
import domains.elements.Label;
import domains.elements.TextField;
import org.openqa.selenium.By;

import java.time.temporal.Temporal;

public class HorizontalSlider extends BaseForm {

    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");

    private static TextField sliderValue = new TextField(By.xpath("//div[@class = 'sliderContainer']//span"), "sliderValue");

    private static Button hrzntlSlider = new Button(By.xpath("//div[@class = 'sliderContainer']//input"), "hrzntlSlider");

    public HorizontalSlider() {
        super(labelPage,"idPage");
    }

    public void moveSlider() {
        hrzntlSlider.moveSlider();
    }

    public double getSliderValue() {
        return Double.valueOf(sliderValue.findElement().getText());
    }
}
