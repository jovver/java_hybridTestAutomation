package tests.web.saucedemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseWebSauceDemoTest;
import tests.data.saucedemo.LoginDataProvider;
import web.ProductsPage;

public class LoginTests extends BaseWebSauceDemoTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "Error User")
    public void loginTestErrorMessage(String username, String password) {
        // Arrange

        // Act
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
        String expectedErrorMessage = loginPage.getLoginErrorMessage();
        String actualErrorMessage = loginPage.getLoginErrorText();

        // Assert
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "Locked Out User")
    public void lockedOutTestErrorMessage(String username, String password){
        // Arrange

        // Act
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
        String expectedErrorMessage = loginPage.getLockedOutErrorMessage();
        String actualErrorMessage = loginPage.getLoginErrorText();

        // Assert
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "Standard User")
    public void successfulLoginTest(String username, String password){
        // Arrange
        productsPage = new ProductsPage();

        // Act
        productsPage = loginPage.logIntoProductsPage(username, password);

        // Assert
        Assert.assertTrue(productsPage.isProductPageHeaderPresent());

    }
}
