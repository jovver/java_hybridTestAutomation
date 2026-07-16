package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    // Setter
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    // Convenience
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void typeInto(By locator, String value){
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    public void click(By locator){
        find(locator).click();
    }

    // TODO: Create a base wait method

}
