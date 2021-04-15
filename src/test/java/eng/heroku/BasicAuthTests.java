package eng.heroku;

import domains.forms.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.examples.RandomGenerator.valueForCompare;
import static org.examples.ResourcesProperties.*;


public class BasicAuthTests extends BaseTest {


    //private SearchPage searchPage = new SearchPage();

    @Test
    public void firstTest() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();

        basicAuthPage.openStartPage(getConfProperty("BasicAuthPageURL"));
        basicAuthPage.passingAuthorizationByAddressBar();
        Assert.assertEquals("it's not main page", basicAuthPage.labelIsDisplayed(), getDataProperty("labelBasicAuthPage"));
    }



    @Test
    public void thTest() {
        HorizontalSlider horizontalSliderPage = new HorizontalSlider();

        horizontalSliderPage.openStartPage(getConfProperty("HrzntlSliderPageURL"));
        Assert.assertTrue("it's wrong page", horizontalSliderPage.pageIsOpened(getDataProperty("HrzntlSliderTitle")));
        horizontalSliderPage.moveSlider();
        Assert.assertEquals("wrong value", Double.toString(horizontalSliderPage.getSliderValue()), Double.toString(valueForCompare));
    }

    @Test
    public void forTest() {
        HoversPage hoversPage = new HoversPage();

        hoversPage.openStartPage(getConfProperty("HoversPageURL"));
        hoversPage.findUsers();

        System.out.println("d");
    }

    @Test
    public void fifthTest() {
        WindowsPage windowsPage = new WindowsPage("main");
        NewWindow newWindow1 = new NewWindow("second");
        NewWindow newWindow2 = new NewWindow("third");

        windowsPage.openStartPage(getConfProperty("WindowsPageURL"));
        windowsPage.putWindowHandle();
        windowsPage.clickNewWindow();
        windowsPage.switchToNewWindow();
        Assert.assertTrue("it's wrong page", newWindow1.pageIsOpened(getDataProperty("NewWindowTitle")));

        newWindow1.putWindowHandle();
        windowsPage.switchToWindow();
        windowsPage.clickNewWindow();
        windowsPage.switchToNewWindow();
        Assert.assertTrue("it's wrong page", newWindow1.pageIsOpened(getDataProperty("NewWindowTitle")));

        newWindow2.putWindowHandle();
        newWindow1.switchToWindow();
        newWindow2.closeWindow("second");

        windowsPage.switchToWindow();
        windowsPage.closeWindow("second");

        newWindow2.switchToWindow();
        System.out.println("d");
    }


}
