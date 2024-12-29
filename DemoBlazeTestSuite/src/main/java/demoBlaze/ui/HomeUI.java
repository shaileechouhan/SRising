package demoBlaze.ui;

import org.openqa.selenium.By;

public class HomeUI {
    public static By categoryLabel = By.xpath("//a[@id='cat']");
    public static By categoryItem(String categoryName){
        return By.xpath("//a[text()='"+categoryName+"']");
    }
    public static By productName(String productName){
        return By.xpath("//a[text()='"+productName+"']");
    }
    public static By productPrice(String productName){
        return By.xpath("//a[text()='"+productName+"']//parent::h4//following-sibling::h5");
    }

    public static By loggedUserLabel = By.id("nameofuser");
}
