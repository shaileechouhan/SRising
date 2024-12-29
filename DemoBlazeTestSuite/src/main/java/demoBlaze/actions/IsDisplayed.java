package demoBlaze.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsDisplayed {
    public static Boolean element(WebDriver driver, By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
