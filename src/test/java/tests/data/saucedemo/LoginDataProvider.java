package tests.data.saucedemo;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "Standard User")
    public static Object[][] standardUser(){
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name="Locked Out User")
    public static Object[][] lockedOutUser(){
        return new Object[][]{
                {"locked_out_user", "secret_sauce"}
        };
    }

    @DataProvider(name="Error User")
    public static Object[][] errorUser(){
        return new Object[][]{
                {"standard_user", "error"}
        };
    }
}
