package org.planittesting.com.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage goTo() {
        navigateTo("/cart");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }

    public List<String> getTableValue(String columnName) {
        List<String> values;
        switch (columnName.toUpperCase()) {
            case "PRICES" -> {
                By itemPrices = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[2]");
                values = findElements(itemPrices).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
            }
            case "SUBTOTAL" -> {
                By itemSubtotal = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[4]");
                values = findElements(itemSubtotal).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
            }
            default -> throw new RuntimeException("Unknown column name in the Cart page table...");
        }
        return values;
    }

    public String getTotalValue() {
        By totalAmountXpath = By.xpath("//tfoot/tr/td/strong");
        String trimAmountText = getElementText(totalAmountXpath);
        return trimAmountText.replace("Total: ", "");
    }
}
