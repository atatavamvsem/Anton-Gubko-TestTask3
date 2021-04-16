package eng.heroku;

import domains.forms.IframePage;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.examples.ResourcesProperties.getConfProperty;
import static org.examples.ResourcesProperties.getDataProperty;

public class IframeTest extends BaseTest{

    @Test
    public void iframeTest() {
        IframePage iframePage = new IframePage();


        iframePage.openStartPage(getConfProperty("IframePageURL"));
        Assert.assertTrue("it's wrong page", iframePage.pageIsOpened(getDataProperty("IframeTitle")));
        iframePage.switchIframe();
        System.out.println("d");

    }
}
