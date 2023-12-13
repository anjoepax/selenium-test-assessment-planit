package org.planittesting.com;

import org.planittesting.com.driver.DriverFactory;
import org.planittesting.com.enums.BrowserType;
import org.planittesting.com.enums.RunModeType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters({"browser", "runMode"})
    @BeforeMethod
    public void setUp(@Optional String browser, @Optional String runMode) {
        browser = System.getProperty("browser", browser);
        runMode = System.getProperty("runMode", runMode);
        DriverFactory.openBrowser(BrowserType.valueOf(browser), RunModeType.valueOf(runMode));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}
