package demoBlaze.tasks.home;

import demoBlaze.actions.IsDisplayed;
import demoBlaze.ui.HomeUI;
import org.openqa.selenium.WebDriver;

public class IsHomePageDisplayed {
    public static Boolean list(WebDriver driver){
        return IsDisplayed.element(driver, HomeUI.categoryLabel);
    }
}
