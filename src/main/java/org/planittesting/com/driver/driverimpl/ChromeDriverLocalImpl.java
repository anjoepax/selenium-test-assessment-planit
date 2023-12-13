package org.planittesting.com.driver.driverimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.planittesting.com.driver.IBrowserDriver;

public class ChromeDriverLocalImpl implements IBrowserDriver {
    @Override
    public WebDriver initializeDriver() {
        return new ChromeDriver();
    }
}
