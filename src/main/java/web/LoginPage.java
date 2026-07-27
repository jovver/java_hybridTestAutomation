package web;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton= By.id("login-button");
    private final By loginErrorHeader = By.className("error-message-container");
    private final By loginLogo = By.className("login_logo");


    // Base Methods
    public String getLoginErrorMessage(){
        return "Epic sadface: Username and password do not match any user in this service";
    }

    public String getLockedOutErrorMessage(){
        return "Epic sadface: Sorry, this user has been locked out.";
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

    public boolean isLoginLogoDisplayed(){
        return find(loginLogo).isDisplayed();
    }

    // Convenience Methods
    public ProductsPage logIntoProductsPage(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        return clickLoginButton();
    }

}
