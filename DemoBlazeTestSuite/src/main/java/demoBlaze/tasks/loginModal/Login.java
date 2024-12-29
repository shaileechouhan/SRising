package demoBlaze.tasks.loginModal;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.Click;
import demoBlaze.actions.Enter;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.ui.LoginModalUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login {
    public static void withValidCredentials(WebDriver driver, String username, String password) throws IOException {
        Enter.text(driver, LoginModalUI.usernameInput, username);
        Enter.text(driver, LoginModalUI.passwordInput, password);
        Click.on(driver, LoginModalUI.loginButton);
    }
}
