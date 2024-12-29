package demoBlaze.tasks.home;

import demoBlaze.actions.Click;
import demoBlaze.ui.HomeUI;
import org.openqa.selenium.WebDriver;

public class SelectProduct {
    public static void byName(WebDriver driver, String name){
        Click.on(driver, HomeUI.productName(name));
    }
}
