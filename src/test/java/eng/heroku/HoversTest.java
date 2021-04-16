package eng.heroku;

import domains.forms.HoversPage;
import domains.forms.UserPage;
import framework.tests.BaseTest;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static framework.examples.ResourcesProperties.getConfProperty;
import static framework.examples.ResourcesProperties.getDataProperty;

public class HoversTest extends BaseTest {
    @DataProvider(name = "hoversTest")
    public static Object[] primeNumbers() {
        return new String[]{
                "user1", "user2", "user3"
        };
    }

    @Test(dataProvider = "hoversTest")
    public void hoversTest(String user) {
        HoversPage hoversPage = new HoversPage(user);
        UserPage userPage = new UserPage();

        hoversPage.openStartPage(getConfProperty("HoversPageURL"));
        Assert.assertTrue("it's wrong page", hoversPage.pageIsOpened(getDataProperty("HoversPageTitle")));
        hoversPage.moveTo();
        Assert.assertTrue("not displayed", hoversPage.labelIsDisplayed());
        Assert.assertTrue("not displayed", hoversPage.buttonIsDisplayed());
        hoversPage.clickButton();
        Assert.assertEquals("wrong link", userPage.checkOpenedUrl(), HoversPage.buttonAttribute);
        navigateBack();
        Assert.assertTrue("it's wrong page", hoversPage.pageIsOpened(getDataProperty("HoversPageTitle")));
    }
}
