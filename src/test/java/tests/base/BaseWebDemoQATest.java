package tests.base;

import drivers.config.ConfigReader;
import drivers.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.BasePage;

public class BaseWebDemoQATest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected String url = "https://demoqa.com/";

    @BeforeClass
    public void setUp(){
        driver = new WebDriverFactory().createInstance(ConfigReader.getProperty("web.browser"));
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
        BasePage.removeDriver();
    }
}
