package demoBlaze.tasks.orderModal;

import demoBlaze.actions.Enter;
import demoBlaze.models.OrderData;
import demoBlaze.ui.OrderModalUI;
import org.openqa.selenium.WebDriver;

public class FillOrder {
    public static void withData(WebDriver driver, OrderData orderInfo){
        Enter.text(driver, OrderModalUI.nameInput, orderInfo.getName());
        Enter.text(driver, OrderModalUI.countryInput, orderInfo.getCountry());
        Enter.text(driver, OrderModalUI.cityInput, orderInfo.getCity());
        Enter.text(driver, OrderModalUI.cardInput, orderInfo.getCard());
        Enter.text(driver, OrderModalUI.monthInput, orderInfo.getMonth());
        Enter.text(driver, OrderModalUI.yearInput, orderInfo.getYear());
    }
}
