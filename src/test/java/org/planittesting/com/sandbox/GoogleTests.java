package org.planittesting.com.sandbox;

import org.planittesting.com.BaseTest;
import org.planittesting.com.driver.DriverManager;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTests extends BaseTest {

    @Test
    public void testCase1() {
        DriverManager.getDriver().get("https://google.com");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
