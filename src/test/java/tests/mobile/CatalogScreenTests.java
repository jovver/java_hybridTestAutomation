package tests.mobile;

import mobile.CatalogScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseMobileAppTest;

public class CatalogScreenTests extends BaseMobileAppTest {

        @Test
        public void CatalogScreenIsLoaded() throws Exception{
            catalogScreen = new CatalogScreen(driver);
            Assert.assertTrue(catalogScreen.isAppHeaderPresent());
        }
}

