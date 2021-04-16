package eng.heroku;

import domains.forms.BasicAuthPage;
import framework.tests.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

import static framework.examples.ResourcesProperties.getConfProperty;
import static framework.examples.ResourcesProperties.getDataProperty;


public class BasicAuthTest extends BaseTest {

    @Test
    public void authorizationTest() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();

        basicAuthPage.openStartPage(basicAuthPage.parsingURL(getConfProperty("BasicAuthPageURL"), getDataProperty("user"), getDataProperty("password")));
        Assert.assertEquals("it's not main page", basicAuthPage.labelIsDisplayed(), getDataProperty("labelBasicAuthPage"));
    }

}
