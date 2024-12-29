package demoBlaze.tasks.purchaseDoneModal;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.IsDisplayed;
import demoBlaze.actions.WaitUntilElement;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.ui.PurchaseDoneUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class IsPurchaseDoneDisplayed {
    public static Boolean inView(WebDriver driver) throws IOException {
        return WaitUntilElement.isVisible(driver, PurchaseDoneUI.acceptButton);
    }
}
