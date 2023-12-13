package org.planittesting.com.pages.component;

import org.openqa.selenium.By;
import org.planittesting.com.pages.*;

public class GlobalHeader extends BasePage {

    private final By homeLink = By.id("nav-home");
    private final By shopLink = By.id("nav-shop");
    private final By contactLink = By.id("nav-contact");
    private final By cartLink = By.id("nav-cart");

    public GlobalHeader goTo(String relPath) {
        navigateTo(relPath);
        return this;
    }

    public HomePage goToHomePage() {
        clickElement(homeLink);
        return new HomePage();
    }

    public ShoppingPage goToShoppingPage() {
        clickElement(shopLink);
        return new ShoppingPage();
    }

    public CartPage goToCartPage() {
        clickElement(cartLink);
        return new CartPage();
    }

    public ContactPage goToContactPage() {
        clickElement(contactLink);
        return new ContactPage();
    }
}
