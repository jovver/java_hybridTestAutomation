package drivers.factory;

import drivers.factory.manager.ChromeDriverManager;
import drivers.factory.manager.FireFoxDriverManager;
import drivers.factory.manager.EdgeDriverManager;
import drivers.factory.manager.SafariDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    protected WebDriver driver;

    public WebDriver createInstance(String browser){
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        driver = switch (browserType) {
            case CHROME -> new ChromeDriverManager().createDriver();
            case FIREFOX -> new FireFoxDriverManager().createDriver();
            case EDGE -> new EdgeDriverManager().createDriver();
            case SAFARI -> new SafariDriverManager().createDriver();
        };

        driver.manage().window().maximize();

        return driver;
    }
}
