package tests.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseWebTest;

public class LoginTests extends BaseWebTest {

    // TODO: Move the user names into a different class or file
    private String password = "secret_sauce";
    private String standard_user = "standard_user";
    private String locked_out_user = "locked_out_user";

    @Test
    public void loginTestErrorMessage() {
        loginPage.setUsernameField(standard_user);
        loginPage.setPasswordField("error");
        loginPage.clickLoginButton();
        String expectedErrorMessage = loginPage.getLoginErrorMessage();
        String actualErrorMessage = loginPage.getLoginErrorText();
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void lockedOutTestErrorMessage(){
        loginPage.setUsernameField(locked_out_user);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
        String expectedErrorMessage = loginPage.getLockedOutErrorMessage();
        String actualErrorMessage = loginPage.getLoginErrorText();
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }
}
