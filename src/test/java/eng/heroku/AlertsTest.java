package eng.heroku;

import framework.domain.forms.Alerts;
import domains.forms.JSAlertsPage;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static framework.examples.ResourcesProperties.getDataProperty;

public class AlertsTest {

    @Test
    @Parameters("URL")
    public void alertsTest(String url) {
        JSAlertsPage javaScriptsAlertsPage = new JSAlertsPage();

        javaScriptsAlertsPage.openStartPage(url);
        Assert.assertTrue("it's wrong page", javaScriptsAlertsPage.pageIsOpened(getDataProperty("JSAlertsPageTitle")));

        javaScriptsAlertsPage.clickJSAlert();
        checkAssertAlerts(getDataProperty("JSAlertMess"));
        Alerts.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), getDataProperty("JSAlertSuccessMess"));

        javaScriptsAlertsPage.clickJSConfirm();
        checkAssertAlerts(getDataProperty("JSConfirmMess"));
        Alerts.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), getDataProperty("JSConfirmSuccessMess"));

        javaScriptsAlertsPage.clickJSPrompt();
        checkAssertAlerts(getDataProperty("JSPromptMess"));
        Alerts.sendTextToAlert();
        Alerts.clickAlertOK();
        Assert.assertEquals("it's wrong message", javaScriptsAlertsPage.labelIsDisplayed(), javaScriptsAlertsPage.getMessToCompare());
    }

    private void checkAssertAlerts(String mess) {
        Alerts.switchToAlert();
        Assert.assertEquals("it's wrong alert", Alerts.getAlertText(), mess);
    }
}
