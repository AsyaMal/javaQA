package com.it_academy.tests.onliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SelenideOnlinerTest extends BaseTest {

    @DisplayName("Check That Catalog Items Is Not Empty")
    @Test
    public void testCatalogItemsIsNotEmpty() {

        assertThat(catalogPage.getItemsInsideCatalog())
                .as("Catalog items are empty")
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
                .as("ComputersAndNets doesn't contain four certain items")
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
                .selectCategory()
                .getItemsInsideAccessoriesItem();
        assertThat(itemsOfAccessories)
                .as("Accessories doesn't contain min price")
                .allMatch(i -> i != null)
                .allMatch(i -> i.contains("от"))
                .allMatch(i -> i.contains("р."));
    }
}
