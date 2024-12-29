package demoBlaze.tasks.cart;

import demoBlaze.actions.Click;
import demoBlaze.ui.CartUI;
import org.openqa.selenium.WebDriver;

public class Order {
    public static void place(WebDriver driver){
        Click.on(driver, CartUI.placeOrderButton);
    }
}
