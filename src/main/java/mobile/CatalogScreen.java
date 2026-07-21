package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CatalogScreen extends BaseScreen{

    public CatalogScreen(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(accessibility = "App logo and name")
    @iOSXCUITFindBy(accessibility = "AppTitle Icons")
    WebElement appHeader;

    @AndroidFindBy(accessibility = "View menu")
    @iOSXCUITFindBy(accessibility = "More-tab-item")
    WebElement menu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement logInOutBtn;

    public boolean isAppHeaderPresent(){
        waitToBeVisible(appHeader);
        return appHeader.isDisplayed();
    }

    public void tapMenu(){
        waitToBeVisible(menu);
        tap(menu);
    }

    public LogInScreen tapLogInOutBtn(){
        waitToBeVisible(logInOutBtn);
        tap(logInOutBtn);

        return new LogInScreen(driver);
    }
}
