package drivers.factory.manager;

import drivers.factory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.SAFARI;

public class SafariDriverManager implements Factory {

    @Override
    public WebDriver createDriver(){

        WebDriverManager.getInstance(SAFARI).setup();

        return new SafariDriver();
    }
}
