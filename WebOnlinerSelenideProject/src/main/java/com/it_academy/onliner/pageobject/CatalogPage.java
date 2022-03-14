package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.it_academy.onliner.framework.AbstractPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends AbstractPage {

    // находит 10 items Каталога
    private static final String CATALOG_NAVIGATION_CLASSIFIER_ITEM =
            "//li[@class = 'catalog-navigation-classifier__item ']";
    // кнопка "Копьютеры и сети"
    private static final String CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS =
            "//span[contains(text(),'Компьютеры и')]";

    // получить коллекцию из 10 items в Каталоге
    public List<String> getItemsInsideCatalog() {
        return $$x(CATALOG_NAVIGATION_CLASSIFIER_ITEM)
                .shouldBe(CollectionCondition.sizeGreaterThan(1), ofSeconds(60)).texts();
    }

    // нажать на "Компьютеры и сети"
    public ComputersAndNetsItem clickOnCatalogClassifierComputersAndNets() {
        $x(CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS).shouldBe(Condition.visible, ofSeconds(60))
                .click();
        return new ComputersAndNetsItem();
    }
}