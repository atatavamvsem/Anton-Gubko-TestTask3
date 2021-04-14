package eng.heroku;

import domains.forms.BasicAuthPage;
import domains.forms.HorizontalSlider;
import domains.forms.JSAlertsPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.examples.ResourcesProperties.*;


public class BasicAuthTests extends BaseTest {


    //private SearchPage searchPage = new SearchPage();

    @Test
    public void firstTest() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();

        basicAuthPage.openStartPage(getConfProperty("BasicAuthPageURL"));
        basicAuthPage.passingAuthorizationByAddressBar();
        Assert.assertEquals("it's not main page", basicAuthPage.labelIsDisplayed(), getDataProperty("labelBasicAuthPage"));

       /* mainPage.inputTextSearch();
        mainPage.clickSearchBtn();

        Assert.assertTrue("it's not search page", searchPage.isDisplayed());
        Assert.assertTrue(searchPage.checkResultSearch());

        searchPage.viewSortType();
        searchPage.sortByPriceAsc();

        Assert.assertTrue("wrong sorting", searchPage.checkSortPriceAsc());*/
    }

    @Test
    public void secTest() {
        JSAlertsPage javaScriptsAlertsPage = new JSAlertsPage();

        javaScriptsAlertsPage.openStartPage(getConfProperty("JSAlertsPageURL"));
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

    @Test
    public void thTest() {
        HorizontalSlider horizontalSliderPage = new HorizontalSlider();

        horizontalSliderPage.openStartPage(getConfProperty("HrzntlSliderPageURL"));
        Assert.assertTrue("it's wrong page", horizontalSliderPage.pageIsOpened(getDataProperty("HrzntlSliderTitle")));
        horizontalSliderPage.clickSlider();
    }


}
