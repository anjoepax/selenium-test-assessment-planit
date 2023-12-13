package org.planittesting.com.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.planittesting.com.pages.component.GlobalHeader;

import java.time.Duration;

public class HomePage extends BasePage {

    public GlobalHeader goTo() {
        navigateTo("/home");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return new GlobalHeader();
    }
}
