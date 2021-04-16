package eng.heroku;

import domains.forms.Iframe;
import domains.forms.IframePage;
import framework.tests.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

import static framework.examples.ResourcesProperties.getConfProperty;
import static framework.examples.ResourcesProperties.getDataProperty;

public class IframeTest extends BaseTest {

    @Test
    public void iframeTest() {
        IframePage iframePage = new IframePage();
        Iframe iframe = new Iframe();


        iframePage.openStartPage(getConfProperty("IframePageURL"));
        Assert.assertTrue("it's wrong page", iframePage.pageIsOpened(getDataProperty("IframeTitle")));
        iframe.switchToIframe();
        iframe.cleareText();
        iframe.sendRandomText();
        iframe.hightlightText();
        switchToDefaultContext();
        iframePage.clickBoldButton();

    }
}
