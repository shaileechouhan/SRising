package demoBlaze.tasks.orderModal;

import demoBlaze.actions.IsDisplayed;
import demoBlaze.actions.WaitUntilElement;
import demoBlaze.ui.OrderModalUI;
import org.openqa.selenium.WebDriver;

public class IsOrderModalDisplayed {
    public static Boolean inView(WebDriver driver){
        return WaitUntilElement.isVisible(driver, OrderModalUI.ordermodal);
    }
}
