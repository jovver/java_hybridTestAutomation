package web;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private By productPageHeader = By.className("title");

    public boolean isProductPageHeaderPresent(){
        return find(productPageHeader).isDisplayed();
    }
}
