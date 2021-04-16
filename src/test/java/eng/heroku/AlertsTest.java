package eng.heroku;

import domains.forms.JSAlertsPage;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.examples.ResourcesProperties.getConfProperty;
import static org.examples.ResourcesProperties.getDataProperty;

public class AlertsTest {

    @Test
    @Parameters("URL")
    public void alertsTest(String url) {
        JSAlertsPage javaScriptsAlertsPage = new JSAlertsPage();

        javaScriptsAlertsPage.openStartPage(url);
        Assert.assertTrue("it's wrong page", javaScriptsAlertsPage.pageIsOpened(getDataProperty("JSAlertsPageTitle")));

        javaScriptsAlertsPage.clickJSAlert();
        javaScriptsAlertsPage.switchToAlert();
        Assert.assertEquals("it's wrong alert", javaScriptsAlertsPage.getAlertText(), getDataProperty("JSAlertMess"));
        javaScriptsAlertsPage.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), getDataProperty("JSAlertSuccessMess"));

        javaScriptsAlertsPage.clickJSConfirm();
        javaScriptsAlertsPage.switchToAlert();
        Assert.assertEquals("it's wrong alert", javaScriptsAlertsPage.getAlertText(), getDataProperty("JSConfirmMess"));
        javaScriptsAlertsPage.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), getDataProperty("JSConfirmSuccessMess"));

        javaScriptsAlertsPage.clickJSPrompt();
        javaScriptsAlertsPage.switchToAlert();
        Assert.assertEquals("it's wrong alert", javaScriptsAlertsPage.getAlertText(), getDataProperty("JSPromptMess"));
        javaScriptsAlertsPage.sendTextToAlert();
        javaScriptsAlertsPage.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), javaScriptsAlertsPage.getMessToCompare());
    }
}
