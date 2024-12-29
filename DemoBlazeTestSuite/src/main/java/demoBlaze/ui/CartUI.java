package demoBlaze.ui;

import org.openqa.selenium.By;

public class CartUI {
    public static By productsLabel = By.xpath("//div[@id='page-wrapper']//h2[text()='Products']");

    public static By productsList = By.xpath("//table/tbody/tr");
    public static By productNameLabel = By.xpath("//table/tbody/tr/td/following-sibling::td[1]");
    public static By productPriceLabel = By.xpath("//table/tbody/tr/td/following-sibling::td[2]");
    public static By totalPriceLabel = By.id("totalp");
    public static By placeOrderButton = By.xpath("//button[text()='Place Order']");

}

