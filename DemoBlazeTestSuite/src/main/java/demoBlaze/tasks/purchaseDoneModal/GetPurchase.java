package demoBlaze.tasks.purchaseDoneModal;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.Label;
import demoBlaze.helpers.mathsHelper.NumberExtractor;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.models.PurchaseData;
import demoBlaze.ui.PurchaseDoneUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GetPurchase {
    public static PurchaseData info(WebDriver driver) throws IOException {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Purchase Completed Modal");
        String t = Label.getText(driver, PurchaseDoneUI.purchaseInfoLabel);
        String[] lines = t.split( "\n");

        long id = NumberExtractor.extractLong(lines[0]);
        int amount = NumberExtractor.extractInt(lines[1]);
        long card = NumberExtractor.extractLong(lines[2]);
        String name = lines[3].split(":")[1].trim();
        String date = lines[4].split(":")[1].trim();

        return new PurchaseData(id, amount, card, name, date);
    }
}
