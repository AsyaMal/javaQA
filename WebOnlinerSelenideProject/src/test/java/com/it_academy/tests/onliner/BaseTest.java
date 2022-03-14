package com.it_academy.tests.onliner;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected OnlinerHeader onlinerHeader = new OnlinerHeader();
    protected CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        onlinerHeader.clickOnMainNavigationLink();
    }
}
