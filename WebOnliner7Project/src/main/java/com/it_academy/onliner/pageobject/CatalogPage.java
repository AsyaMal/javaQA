package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.AbstractPage;
import org.openqa.selenium.By;

import java.util.List;

public class CatalogPage extends AbstractPage {

    // находит 10 items Каталога
    private static final String CATALOG_NAVIGATION_CLASSIFIER_ITEM = "//li[@class = 'catalog-navigation-classifier__item ']";
    // кнопка "Копьютеры и сети"
    private static final String CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS = "//span[contains(text(),'Компьютеры и')]";

    // получить коллекцию из 10 items в Каталоге
    public List<String> getItemsInsideCatalog() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(CATALOG_NAVIGATION_CLASSIFIER_ITEM)));
    }

    // нажать на "Компьютеры и сети"
    public ComputersAndNetsItem clickOnCatalogClassifierComputersAndNets() {
        waitForElementVisible(By.xpath(String.format(CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS)))
                .click();
        return new ComputersAndNetsItem();
    }
}