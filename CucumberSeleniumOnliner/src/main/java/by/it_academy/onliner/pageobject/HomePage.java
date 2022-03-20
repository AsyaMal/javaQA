package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.driver.DriverManager;

public class HomePage extends BasePage {
    private static final String ONLINER_URL = "https://www.onliner.by/";

    public void openOnlinerWebsite() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

}