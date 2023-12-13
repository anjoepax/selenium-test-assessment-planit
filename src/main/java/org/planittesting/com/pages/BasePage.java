package org.planittesting.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.planittesting.com.driver.DriverManager;
import org.planittesting.com.pages.component.GlobalHeader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebElement findElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return DriverManager.getDriver().findElements(locator);
    }

    protected void waitForElementToDisplay(By locator) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForElementToDisplay(By locator, long timeout) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected GlobalHeader navigateTo(String relativeUrl) {
        DriverManager.getDriver().get("https://jupiter.cloud.planittesting.com/#" + relativeUrl);
        DriverManager.getDriver().manage().window().maximize();
        return new GlobalHeader();
    }

    protected void clickElement(By locator) {
        waitForElementToDisplay(locator);
        findElement(locator).click();
    }

    protected void enterText(String text, By locator) {
        waitForElementToDisplay(locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    protected String getElementText(By locator) {
        waitForElementToDisplay(locator);
        return findElement(locator).getText();
    }

    protected String getElementText(By locator, long waitTimeout) {
        waitForElementToDisplay(locator, waitTimeout);
        return findElement(locator).getText();
    }
}
