package demoBlaze.ui;

import org.openqa.selenium.By;

public class LoginModalUI {
    public static By loginModal = By.id("logInModal");
    public static By usernameInput = By.id("loginusername");
    public static By passwordInput = By.id("loginpassword");
    public static By loginButton = By.xpath("//div[@id='logInModal']//button[text()='Log in']");
}
