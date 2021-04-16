package domains.forms;

import framework.domain.elements.Button;
import framework.domain.elements.Label;
import framework.domain.elements.TextField;
import framework.domain.forms.BaseForm;
import org.openqa.selenium.By;

public class HorizontalSlider extends BaseForm {

    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");

    private static TextField sliderValue = new TextField(By.xpath("//div[@class = 'sliderContainer']//span"), "sliderValue");

    private static Button hrzntlSlider = new Button(By.xpath("//div[@class = 'sliderContainer']//input"), "hrzntlSlider");

    public HorizontalSlider() {
        super(labelPage, "idPage");
    }

    public void moveSlider() {
        hrzntlSlider.moveSlider();
    }

    public double getSliderValue() {
        return Double.valueOf(sliderValue.findElement().getText());
    }
}
