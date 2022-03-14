package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

public class SelenideWebDriverDiscovery implements WebDriverProvider {

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        String driverType = System.getProperty("driverType");
        return DriverCreatorFactory.getDriverCreator(driverType).create();
    }
}
