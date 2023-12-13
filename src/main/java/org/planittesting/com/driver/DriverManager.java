package org.planittesting.com.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static synchronized void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static synchronized WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static synchronized void unloadDriver() {
        threadLocalDriver.remove();
    }
}
