package tests.mobile;

import mobile.ProductsScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseMobileAppTest;

public class AndroidProductScreenTests extends BaseMobileAppTest {

        ProductsScreen productsScreen;

        @Test
        public void Android_ProductScreenIsLoaded() throws Exception{
            Android_setUp();
            productsScreen = new ProductsScreen(driver);
            Assert.assertTrue(productsScreen.isAppHeaderPresent());
        }
}

