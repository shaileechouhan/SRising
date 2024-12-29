package demoBlaze.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {
    public static Boolean isPresent(WebDriver driver){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static void accept(WebDriver driver){
        driver.switchTo().alert().accept();
    }
}
