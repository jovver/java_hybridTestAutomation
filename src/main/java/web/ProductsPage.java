package web;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private final By productPageHeader = By.className("title");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logOutButton = By.linkText("Logout");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");

    public boolean isProductPageHeaderPresent(){
        return find(productPageHeader).isDisplayed();
    }

    public void clickMenuButton(){
        click(menuButton);
    }

    public LoginPage clickLogOutButton(){
        click(logOutButton);
        return new LoginPage();
    }

    public void clickShoppingCartLink(){
        click(shoppingCartLink);
    }

    public int getShoppingCartCount(){
        return Integer.parseInt(getElementText(shoppingCartBadge));
    }

}
