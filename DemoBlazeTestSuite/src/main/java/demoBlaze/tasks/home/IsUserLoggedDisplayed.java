package demoBlaze.tasks.home;
import demoBlaze.actions.WaitUntilElement;
import demoBlaze.ui.HomeUI;
import org.openqa.selenium.WebDriver;

public class IsUserLoggedDisplayed {
    public static Boolean inView(WebDriver driver){
        return WaitUntilElement.isVisible(driver, HomeUI.loggedUserLabel);
    }
}
