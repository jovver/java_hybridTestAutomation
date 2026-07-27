package tests.base;

import drivers.config.ConfigReader;
import drivers.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web.BasePage;
import web.LoginPage;
import web.ProductsPage;

public class BaseWebSauceDemoTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        driver = new WebDriverFactory().createInstance(browser);
        driver.get(ConfigReader.getProperty("web.baseUrl"));
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownThread(){
        BasePage.removeDriver();
    }
}
