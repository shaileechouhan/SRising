package demoBlaze.webDriver.factoryBrowser;

import org.openqa.selenium.WebDriver;

public class FactoryBrowser {
    public static WebDriver getDriver(String browserName) throws Exception {
        WebDriver browser = null;
        switch (browserName.toLowerCase()){
            case "chrome":
                browser = new ChromeDriverCreator().CreateWebDriver();
                break;
            case "firefox":
                browser = new FirefoxDriverCreator().CreateWebDriver();
                break;
            default:
                throw new Exception("Browser "+browserName+": not supported yet");
        }
        return browser;
    }

}
