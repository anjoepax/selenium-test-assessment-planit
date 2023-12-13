package org.planittesting.com.driver.driverimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.planittesting.com.driver.IBrowserDriver;

public class FirefoxDriverLocalImpl implements IBrowserDriver {
    @Override
    public WebDriver initializeDriver() {
        return new FirefoxDriver();
    }
}
