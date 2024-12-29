package demoBlaze.ui;

import org.openqa.selenium.By;

public class PurchaseDoneUI {
    public static By purchaseDoneModal = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
    public static By thankLabel = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/h2");
    public static By purchaseInfoLabel = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/p");
    public static By acceptButton = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//button[contains(@class,'confirm')]");
}
