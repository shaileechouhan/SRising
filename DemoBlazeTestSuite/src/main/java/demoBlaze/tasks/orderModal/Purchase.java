package demoBlaze.tasks.orderModal;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.Click;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.ui.OrderModalUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Purchase {
    public static void complete(WebDriver driver){
        Click.on(driver, OrderModalUI.purchaseButton);
    }
}
