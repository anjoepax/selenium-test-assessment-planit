package org.planittesting.com.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.time.Duration;

public class ContactPage extends BasePage {

    private final By foreNameField = By.id("forename");
    private final By surNameField = By.id("surname");
    private final By emailField = By.id("email");
    private final By telephoneField = By.id("telephone");
    private final By messageField = By.id("message");
    private final By submitButton = By.cssSelector("a[class='btn-contact btn btn-primary']");
    private final By errorMessage = By.cssSelector("div[class='alert alert-error ng-scope']");
    private final By infoMessage = By.cssSelector("div[class='alert alert-info ng-scope']");
    private final By submitSuccessMessage = By.cssSelector("div[class='alert alert-success']");

    public ContactPage goTo() {
        navigateTo("/contact");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }

    public ContactPage clickSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    public ContactPage enterForeName(String name) {
        enterText(name, foreNameField);
        return this;
    }

    public ContactPage enterSurname(String surName) {
        enterText(surName, surNameField);
        return this;
    }

    public ContactPage enterTelephoneNumber(String telNumber) {
        enterText(telNumber, telephoneField);
        return this;
    }

    public ContactPage enterEmail(String email) {
        enterText(email, emailField);
        return this;
    }

    public ContactPage enterMessage(String message) {
        enterText(message, messageField);
        return this;
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

    public String getInfoMessage() {
        return getElementText(infoMessage);
    }

    public String getSuccessMessage() {
        return getElementText(submitSuccessMessage, 60);
    }
}
