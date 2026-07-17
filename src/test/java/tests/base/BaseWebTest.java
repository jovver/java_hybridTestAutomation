package tests.base;

import drivers.config.ConfigReader;
import drivers.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.BasePage;
import web.LoginPage;

import java.io.ObjectInputFilter;

public class BaseWebTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = new WebDriverFactory().createInstance(ConfigReader.getProperty("web.browser"));
        driver.get(ConfigReader.getProperty("web.baseUrl"));
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
