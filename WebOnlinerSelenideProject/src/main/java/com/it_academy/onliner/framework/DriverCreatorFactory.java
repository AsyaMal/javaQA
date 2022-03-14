package com.it_academy.onliner.framework;

public class DriverCreatorFactory {
    private DriverCreatorFactory() {

    }

    public static WebDriverCreator getDriverCreator(String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriverCreator();
            case "edge":
                return new EdgeDriverCreator();
            case "remote":
                return new RemoteDriverCreator();
            default:
                return null;
        }
    }
}
