package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected static final long DURATION = 10;

    // Setter
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    // Convenience
    public WebElement find(By locator){
        waitForElement(locator);
        return driver.findElement(locator);
    }

    public void typeInto(By locator, String value){
        waitForElement(locator);
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    public void click(By locator){
        waitForElementToBeClickable(locator);
        find(locator).click();
    }

    public void waitForElement(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getAttribute(By locator, String attribute){
        waitForElement(locator);
        return find(locator).getAttribute(attribute);
    }

}
