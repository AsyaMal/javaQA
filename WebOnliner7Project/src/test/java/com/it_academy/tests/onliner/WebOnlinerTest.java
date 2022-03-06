package com.it_academy.tests.onliner;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WebOnlinerTest {
    private static OnlinerHeader onlinerHeader = new OnlinerHeader();
    private CatalogPage catalogPage;

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        catalogPage = onlinerHeader.clickOnCatalogNavigationLink();
    }

    @DisplayName("Check That Catalog Items Is Not Empty")
    @Test
    public void testCatalogItemsIsNotEmpty() {
        List<String> itemsOfCatalog = catalogPage
                .getItemsInsideCatalog();
        assertThat(itemsOfCatalog)
                .as("Catalog items should not be empty")
                .allMatch(i -> i != null);
    }

    @DisplayName("Check That 'Computers And Nets' Contains 'Ноутбуки, компьютеры, мониторы', 'Комплектующие',"
            + "'Хранение 'данных', 'Сетевое оборудование'")
    @Test
    public void testComputerAndNetItemsContainsCertainItems() {
        List<String> itemsOfComputersAndNets = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .getItemsInsideComputersAndNetsItem();
        assertThat(itemsOfComputersAndNets)
                .as("ComputersAndNets should contain four certain items")
                .anyMatch(i -> i.equals("Ноутбуки, компьютеры, мониторы"))
                .anyMatch(i -> i.equals("Комплектующие"))
                .anyMatch(i -> i.equals("Хранение данных"))
                .anyMatch(i -> i.equals("Сетевое оборудование"));
    }

    @DisplayName("Check That 'Accessories' Contains Information About Min Price")
    @Test
    public void testProductsAndDescriptionInAccessoriesAreNotEmpty() {
        List<String> itemsOfAccessories = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .selectAccessoriesInComputerAndNetItem()
                .getItemsInsideAccessoriesItem();
        assertThat(itemsOfAccessories)
                .as("Each accessories should contain min price")
                .allMatch(i -> i != null)
                .allMatch(i -> i.contains("от"))
                .allMatch(i -> i.contains("р."));
    }

    @AfterAll
    public static void closeBrowser() {
        onlinerHeader.closeBrowser();
    }
}