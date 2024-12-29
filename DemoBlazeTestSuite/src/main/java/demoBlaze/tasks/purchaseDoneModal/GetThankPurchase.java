package demoBlaze.tasks.purchaseDoneModal;

import demoBlaze.actions.Label;
import demoBlaze.ui.PurchaseDoneUI;
import org.openqa.selenium.WebDriver;

public class GetThankPurchase {
    public static String text(WebDriver driver){
        return Label.getText(driver, PurchaseDoneUI.thankLabel);
    }
}
