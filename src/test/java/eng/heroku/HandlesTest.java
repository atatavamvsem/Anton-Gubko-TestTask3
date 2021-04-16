package eng.heroku;

import domains.forms.NewWindow;
import domains.forms.WindowsPage;
import framework.tests.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

import static framework.examples.ResourcesProperties.getConfProperty;
import static framework.examples.ResourcesProperties.getDataProperty;

public class HandlesTest extends BaseTest {

    @Test
    public void handlesTest() {
        WindowsPage windowsPage = new WindowsPage("main");
        NewWindow newWindow1 = new NewWindow("second");
        NewWindow newWindow2 = new NewWindow("third");

        windowsPage.openStartPage(getConfProperty("WindowsPageURL"));
        Assert.assertTrue("it's wrong page", windowsPage.pageIsOpened(getDataProperty("HandlesTitle")));
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
        closeWindow();

        windowsPage.switchToWindow();
        closeWindow();

        newWindow2.switchToWindow();
    }
}
