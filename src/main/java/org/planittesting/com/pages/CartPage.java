package org.planittesting.com.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage goTo() {
        navigateTo("/cart");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }

    public List<String> getTableValue(String columnName) {
        Map<String, By> byTargetLocator = new HashMap<>();
        byTargetLocator.put("PRICES", By.xpath("//tr[@ng-repeat='item in cart.items()']/td[2]"));
        byTargetLocator.put("SUBTOTAL", By.xpath("//tr[@ng-repeat='item in cart.items()']/td[4]"));
        return findElements(byTargetLocator.get(columnName.toUpperCase()))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getTotalValue() {
        By totalAmountXpath = By.xpath("//tfoot/tr/td/strong");
        String trimAmountText = getElementText(totalAmountXpath);
        return trimAmountText.replace("Total: ", "");
    }
}
