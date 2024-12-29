package demoBlaze.tasks.navBar;

import demoBlaze.actions.Click;
import demoBlaze.ui.NavUI;
import org.openqa.selenium.WebDriver;

public class SelectNav {
    public static void cart(WebDriver driver){
        Click.on(driver, NavUI.cartButton);
    }
    public static void login(WebDriver driver){
        Click.on(driver, NavUI.loginButton);
    }
}
