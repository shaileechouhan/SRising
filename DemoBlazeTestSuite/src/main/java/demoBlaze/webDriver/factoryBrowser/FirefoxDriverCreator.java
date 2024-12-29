package demoBlaze.webDriver.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements IBrowser{
    @Override
    public WebDriver CreateWebDriver() {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        return new FirefoxDriver();
    }
}
