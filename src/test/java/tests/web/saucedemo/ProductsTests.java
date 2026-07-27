package tests.web.saucedemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseWebSauceDemoTest;
import tests.data.saucedemo.LoginDataProvider;

public class ProductsTests extends BaseWebSauceDemoTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "Standard User")
    public void loginToProductsTest(String username, String password) {
        // Arrange

        // Act
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        var productPage = loginPage.clickLoginButton();

        // Assert
        Assert.assertTrue(productPage.isProductPageHeaderPresent());
    }

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "Standard User")
    public void logOutOfApplicationTest(String username, String password) {
        // Arrange

        // Act
        var productPage = loginPage.logIntoProductsPage(username, password);
        productPage.clickMenuButton();
        var loginPage = productPage.clickLogOutButton();

        // Assert
        Assert.assertTrue(loginPage.isLoginLogoDisplayed());
    }
}
