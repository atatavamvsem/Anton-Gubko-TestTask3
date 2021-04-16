package eng.heroku;

import domains.forms.HorizontalSlider;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.examples.RandomGenerator.valueForCompare;
import static org.examples.ResourcesProperties.getConfProperty;
import static org.examples.ResourcesProperties.getDataProperty;

public class ActionsTest extends BaseTest {

    @Test
    public void sliderTest() {
        HorizontalSlider horizontalSliderPage = new HorizontalSlider();

        horizontalSliderPage.openStartPage(getConfProperty("HrzntlSliderPageURL"));
        Assert.assertTrue("it's wrong page", horizontalSliderPage.pageIsOpened(getDataProperty("HrzntlSliderTitle")));
        horizontalSliderPage.moveSlider();
        Assert.assertEquals("wrong value", Double.toString(horizontalSliderPage.getSliderValue()), Double.toString(valueForCompare));
    }
}
