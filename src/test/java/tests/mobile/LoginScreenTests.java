package tests.mobile;

import mobile.CatalogScreen;
import mobile.LogInScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseMobileAppTest;
import web.LoginPage;

public class LoginScreenTests extends BaseMobileAppTest {

    @Test
    public void navigateToLoginScreenTest(){
        // Arrange
        catalogScreen = new CatalogScreen(driver);
        loginScreen = new LogInScreen(driver);

        // Act
        catalogScreen.tapMenu();
        loginScreen = catalogScreen.tapLogInOutBtn();

        // Assert
        Assert.assertTrue(loginScreen.isLoginScreenHeaderVisible());
    }
}
