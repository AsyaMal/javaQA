package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.it_academy.onliner.framework.AbstractPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;


public class ComputersAndNetsItem extends AbstractPage {
    // показывает элементы, если кликнуть на "Компьютеры и сети" 9
    private static final String COMPUTER_AND_SET_ITEMS =
            "//*[@class='catalog-navigation-list__category' and @data-id='2']"
                    + "//*[@class='catalog-navigation-list__aside-item']";
    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')]";
    private static final String ACCESSORIES_ITEMS =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')"
                    + " and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]";

    public ComputersAndNetsItem selectCategory() {
        $x(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN)
                .shouldBe(Condition.visible, ofSeconds(60))
                .click();
        return new ComputersAndNetsItem();
    }

    public List<String> getItemsInsideAccessoriesItem() {
        return $$x(ACCESSORIES_ITEMS).shouldBe(CollectionCondition.sizeGreaterThan(1), ofSeconds(60)).texts();
    }

    public List<String> getItemsInsideComputersAndNetsItem() {
        return $$x(COMPUTER_AND_SET_ITEMS).shouldBe(CollectionCondition.sizeGreaterThan(1), ofSeconds(60)).texts();
    }
}
