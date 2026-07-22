package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected WebDriverWait wait;
    protected static final long DURATION = 10;

    // Setter
    public void setDriver(WebDriver driver){
        DRIVER.set(driver);
    }

    protected WebDriver getDriver(){
        return DRIVER.get();
    }

    // Call from @AfterClass once the driver has been quit, to avoid leaking
    // stale references into threads reused by later test classes.
    public static void removeDriver(){
        DRIVER.remove();
    }

    // Convenience
    public WebElement find(By locator){
        waitForElement(locator);
        return getDriver().findElement(locator);
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
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getAttribute(By locator, String attribute){
        waitForElement(locator);
        return find(locator).getAttribute(attribute);
    }

}
