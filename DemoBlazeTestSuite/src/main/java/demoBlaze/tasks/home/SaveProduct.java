package demoBlaze.tasks.home;

import demoBlaze.actions.Label;
import demoBlaze.helpers.mathsHelper.NumberExtractor;
import demoBlaze.ui.HomeUI;
import org.openqa.selenium.WebDriver;

public class SaveProduct {
    public static int price(WebDriver driver, String name){
        return NumberExtractor.extractInt(Label.getText(driver, HomeUI.productPrice(name)));
    }
}
