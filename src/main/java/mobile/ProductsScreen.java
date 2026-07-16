package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsScreen extends BaseScreen{

    public ProductsScreen(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(accessibility = "App logo and name")
    @iOSXCUITFindBy(accessibility = "AppTitle Icons")
    WebElement appHeader;

    public boolean isAppHeaderPresent(){
        waitToBeVisible(appHeader);
        return appHeader.isDisplayed();
    }
}
