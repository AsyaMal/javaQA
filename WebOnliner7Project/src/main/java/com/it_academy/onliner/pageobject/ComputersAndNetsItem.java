package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.AbstractPage;
import org.openqa.selenium.By;

import java.util.List;

public class ComputersAndNetsItem extends AbstractPage {
    // показывает элементы, если кликнуть на "Компьютеры и сети" 206
    private static final String COMPUTER_AND_SET_ITEMS = "//div[@class='catalog-navigation-list__dropdown-list']";
    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private static final String ACCESSORIES_ITEMS =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')"
                    + " and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]";

    public void selectCategory(String category) {
        waitForElementVisible(By.xpath(String.format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category)))
                .click();
    }

    public ComputersAndNetsItem selectAccessoriesInComputerAndNetItem() {
        selectCategory("Комплектующие");
        return new ComputersAndNetsItem();
    }

    public List<String> getItemsInsideAccessoriesItem() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(ACCESSORIES_ITEMS)));
    }

    public List<String> getItemsInsideComputersAndNetsItem() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(COMPUTER_AND_SET_ITEMS)));
    }
}
