package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.BasePage;
import web.LoginPage;

public class BaseWebTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    // TODO: Move this to a different class
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    //TODO: Make this setUp accept a string to change the driver
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
