package com.it_academy.onliner.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    private static final String BROWSER = "chrome";

    @Override
    public RemoteWebDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BROWSER);
        capabilities.setPlatform(Platform.WIN10);
        return new RemoteWebDriver(getGridUrl(), capabilities);
    }

    private URL getGridUrl() {

        try {
            return new URL(System.getProperty("webdriver.remote.driver"));
        } catch (MalformedURLException e) {
            System.out.println("URL doesn't create");
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
