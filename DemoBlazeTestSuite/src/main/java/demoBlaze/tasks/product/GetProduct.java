package demoBlaze.tasks.product;

import com.aventstack.extentreports.Status;
import demoBlaze.actions.Label;
import demoBlaze.helpers.mathsHelper.NumberExtractor;
import demoBlaze.helpers.reportHelper.ScreenShotHelper;
import demoBlaze.models.Product;
import demoBlaze.ui.ProductUI;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GetProduct {
    public static Product info(WebDriver driver) throws IOException {
        String productName = Label.getText(driver, ProductUI.productLabel);
        int productPrice = NumberExtractor.extractInt(Label.getText(driver, ProductUI.productPriceLabel));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Selected product");
        return new Product(productName, productPrice);
    }

}
