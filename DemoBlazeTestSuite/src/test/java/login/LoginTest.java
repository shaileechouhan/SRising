package login;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import demoBlaze.helpers.jsonDataHelper.JsonTestDataHelper;
import demoBlaze.helpers.reportHelper.ReportManager;
import demoBlaze.models.testData.LoginData;
import demoBlaze.tasks.home.GetLoggedUser;
import demoBlaze.tasks.home.IsUserLoggedDisplayed;
import demoBlaze.tasks.loginModal.Login;
import demoBlaze.tasks.navBar.SelectNav;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTest extends BaseTest {
    public static String loginTestDataPath = "resources/testdata/login/";
    @Test (description = "Login with valid credentials", dataProvider = "validLoginDP")
    public void loginWithValidCredentials(LoginData loginData) throws IOException {
        ReportManager.getInstance().getTest().log(Status.INFO, "Test data: "+ loginData.toString());
        SelectNav.login(driver);
        Login.withValidCredentials(driver, loginData.getUsername(), loginData.getPassword());

        Assert.assertTrue(IsUserLoggedDisplayed.inView(driver));
        String loggedUsername = GetLoggedUser.usernameText(driver);
        Assert.assertEquals(loggedUsername, "Welcome "+loginData.getUsername(), "Logged username not equal as expected");
    }

    @DataProvider (name="validLoginDP")
    public Object[] loginValidDP() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "validLoginData.json", LoginData.class);
    }
}
