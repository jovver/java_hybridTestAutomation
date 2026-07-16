package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected static AppiumDriver driver;
    protected static final long DURATION = 10;

    public BaseScreen(AppiumDriver appiumDriver){
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    // Convenience
    public void tapInto(WebElement element, String text){
        waitToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void tap(WebElement element){
        waitToBeVisible(element);
        element.click();
    }

    public void waitToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getAttribute(WebElement element, String attribute){
        waitToBeVisible(element);
        return element.getAttribute(attribute);
    }

}
