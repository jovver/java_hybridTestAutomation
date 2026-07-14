package tests.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseWebTest;

public class ProductsTests extends BaseWebTest {

    // TODO: Put this in a different class or file
    private String password = "secret_sauce";
    private String standard_user = "standard_user";

    @Test
    public void loginToProductsTest(){
        loginPage.setUsernameField(standard_user);
        loginPage.setPasswordField(password);
        var productPage = loginPage.clickLoginButton();

        Assert.assertTrue(productPage.isProductPageHeaderPresent());
    }
}
