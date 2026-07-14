package web;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private String loginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton= By.id("login-button");
    private By loginErrorHeader = By.className("error-message-container");

    // Base Methods
    public String getLoginErrorMessage(){
        return loginErrorMessage;
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
