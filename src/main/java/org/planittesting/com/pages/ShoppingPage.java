package org.planittesting.com.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.time.Duration;

public class ShoppingPage extends BasePage {

    private String productPriceXpath = "//h4[text()='%s']/parent::div/p/span";

    public ShoppingPage goTo() {
        navigateTo("/shop");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }

    public ShoppingPage buyProduct(String productName, int quantity) {
        String addToCartButtonXpath = "//h4[text()='%s']/parent::div/p/a";
        String buyBtnStringXpath = String.format(addToCartButtonXpath, productName);
        By buyBtnXpath = By.xpath(buyBtnStringXpath);
        for (int i = 1; i <= quantity; i++) {
            clickElement(buyBtnXpath);
            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        }
        return this;
    }
}
