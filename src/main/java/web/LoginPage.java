package web;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    final String loginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    final String lockedOutErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
    final By usernameField = By.id("user-name");
    final By passwordField = By.id("password");
    final By loginButton= By.id("login-button");
    final By loginErrorHeader = By.className("error-message-container");

    // Base Methods
    public String getLoginErrorMessage(){
        return loginErrorMessage;
    }

    public String getLockedOutErrorMessage(){
        return lockedOutErrorMessage;
    }

    public void setUsernameField(String username){
        typeInto(usernameField,username);
    }

    public void setPasswordField(String password){
        typeInto(passwordField,password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage();
    }

    public boolean isLoginErrorDisplayed(){
        return find(loginErrorHeader).isDisplayed();
    }

    public String getLoginErrorText(){
        return find(loginErrorHeader).getText();
    }

    // Convenience Methods
    public ProductsPage logIntoProductsPage(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        return clickLoginButton();
    }

}
