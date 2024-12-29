package demoBlaze.tasks.home;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.Label;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.ui.HomeUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GetLoggedUser {
    public static String usernameText(WebDriver driver) throws IOException {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "User logged in");
        return Label.getText(driver, HomeUI.loggedUserLabel);
    }
}
