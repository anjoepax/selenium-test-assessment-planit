package org.planittesting.com.driver;

import org.planittesting.com.driver.driverimpl.ChromeDriverLocalImpl;
import org.planittesting.com.driver.driverimpl.ChromeDriverRemoteImpl;
import org.planittesting.com.driver.driverimpl.FirefoxDriverLocalImpl;
import org.planittesting.com.driver.driverimpl.FirefoxDriverRemoteImpl;
import org.planittesting.com.enums.BrowserType;
import org.planittesting.com.enums.RunModeType;

import java.util.Objects;

public class DriverFactory {

    public static void openBrowser(BrowserType browserType, RunModeType runModeType) {
        if (Objects.isNull(DriverManager.getDriver())) {
            switch (runModeType) {
                case LOCAL -> {
                    switch (browserType) {
                        case CHROME -> DriverManager.setDriver(new ChromeDriverLocalImpl().initializeDriver());
                        case FIREFOX -> DriverManager.setDriver(new FirefoxDriverLocalImpl().initializeDriver());
                        default -> throw new RuntimeException("Invalid browser value/or not supported...");
                    }
                }
                case REMOTE -> {
                    switch (browserType) {
                        case CHROME -> DriverManager.setDriver(new ChromeDriverRemoteImpl().initializeDriver());
                        case FIREFOX -> DriverManager.setDriver(new FirefoxDriverRemoteImpl().initializeDriver());
                        default -> throw new RuntimeException("Invalid browser value/or not supported...");
                    }
                }
                default -> throw new RuntimeException("Run mode type is not yet supported...");
            }
        }
    }

    public static void closeBrowser() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
