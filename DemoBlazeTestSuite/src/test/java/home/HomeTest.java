package home;

import conf.BaseTest;
import demoBlaze.tasks.home.IsHomePageDisplayed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(description = "Verify home page opened")
    public void verifyHomePage(){
        Assert.assertTrue(IsHomePageDisplayed.list(driver));
    }
}
