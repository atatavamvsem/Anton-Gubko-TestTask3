package eng.heroku;

import domains.forms.*;
import org.junit.Assert;
import org.testng.annotations.Test;
import static org.examples.ResourcesProperties.*;


public class BasicAuthTest extends BaseTest {

    @Test
    public void authorizationTest() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();

        basicAuthPage.openStartPage(basicAuthPage.parsingURL(getConfProperty("BasicAuthPageURL"),getDataProperty("user"), getDataProperty("password")));
        basicAuthPage.passingAuthorizationByAddressBar();
        Assert.assertEquals("it's not main page", basicAuthPage.labelIsDisplayed(), getDataProperty("labelBasicAuthPage"));
    }

}
