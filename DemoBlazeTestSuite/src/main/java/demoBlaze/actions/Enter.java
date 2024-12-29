package demoBlaze.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter {
    public static void text(WebDriver driver, By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
}
