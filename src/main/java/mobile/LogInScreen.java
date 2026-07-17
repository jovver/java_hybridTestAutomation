package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LogInScreen extends BaseScreen{

    public LogInScreen(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "nameET")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    WebElement usernameField;

    @AndroidFindBy(id = "passwordET")
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    WebElement passwordField;

    @AndroidFindBy(id = "loginBtn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    WebElement loginButton;

    @AndroidFindBy(id = "loginTV")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Login\"`][1]")
    WebElement loginScreenHeader;

    public void typeUsername(String username){
        typeInto(usernameField,username);
    }

    public void typePassword(String password){
        typeInto(passwordField,password);
    }

    public void tapLoginButton(){
        tap(loginButton);
    }

    public boolean isLoginScreenHeaderVisible(){
        waitToBeVisible(loginScreenHeader);
        return loginScreenHeader.isDisplayed();
    }
}
