package demoBlaze.tasks.purchaseDoneModal;

import demoBlaze.actions.Click;
import demoBlaze.ui.PurchaseDoneUI;
import org.openqa.selenium.WebDriver;

public class AcceptPurchase {
    public static void done(WebDriver driver){
        Click.on(driver, PurchaseDoneUI.acceptButton);
    }
}
