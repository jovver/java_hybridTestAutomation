package tests.base;

import drivers.config.ConfigReader;
import drivers.factory.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import mobile.CatalogScreen;
import mobile.LogInScreen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseMobileAppTest {

    protected AppiumDriver driver;
    protected CatalogScreen catalogScreen;
    protected LogInScreen loginScreen;

    @BeforeClass
    public void setUp(){
        driver = new AppiumDriverFactory().createInstance(ConfigReader.getProperty("mobile.platform"));
    }

    @AfterClass
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
