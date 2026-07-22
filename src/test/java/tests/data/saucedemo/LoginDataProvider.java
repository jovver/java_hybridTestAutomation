package tests.data.saucedemo;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "Sauce Demo Users")
    public static Object[][] sauceDemoUsers(){
        return new Object[][]{
                {"standard_user", "error"},
                {"locked_out_user", "secret_sauce"},
                {"standard_user", "secret_sauce"}
        };
    }
}
