package com.it_academy.tests.onliner;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public static OnlinerHeader onlinerHeader = new OnlinerHeader();
    public CatalogPage catalogPage;

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        catalogPage = onlinerHeader.clickOnCatalogNavigationLink();
    }

    @AfterAll
    public static void closeBrowser() {
        onlinerHeader.closeBrowser();
    }
}
