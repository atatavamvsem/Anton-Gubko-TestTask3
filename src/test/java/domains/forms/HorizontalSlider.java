package domains.forms;

import domains.elements.BaseElement;
import domains.elements.Button;
import org.openqa.selenium.By;

public class HorizontalSlider extends BaseHerokuPage {
    private static Button hrzntlSlider = new Button(By.xpath("//div[@class = 'sliderContainer']//input"), "hrzntlSlider");

    public HorizontalSlider() {
        super();
    }

    public void clickSlider() {
        hrzntlSlider.clickSlider();
    }
}
