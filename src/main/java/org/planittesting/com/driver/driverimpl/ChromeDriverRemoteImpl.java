package org.planittesting.com.driver.driverimpl;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.planittesting.com.driver.IBrowserDriver;

import java.net.URL;

public class ChromeDriverRemoteImpl implements IBrowserDriver {
    @Override
    @SneakyThrows
    public WebDriver initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
