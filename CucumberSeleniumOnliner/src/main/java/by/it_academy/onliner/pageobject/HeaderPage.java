package by.it_academy.onliner.pageobject;

import org.openqa.selenium.By;

public class HeaderPage extends BasePage {
    private static final By AVTOBARAHOLKA_SUBCATEGORIES =
            By.xpath("//*[contains(@class, 'main-navigation__dropdown-column_75')]//div[@class='b-main-navigation__" +
                    "dropdown-column']//*[contains(@class, 'main-navigation__dropdown-advert-sign')]");
    private static final By HOUSES_AND_APARTMENTS_SUBCATEGORIES =
            By.xpath("//*[contains(@class, 'main-navigation__dropdown-column_50')]" +
                    "//div[@class='b-main-navigation__dropdown-column']" +
                    "//*[contains(@class, 'main-navigation__dropdown-advert-sign')]");

    public By getAvtobaraholkaSubcategories() {
        return AVTOBARAHOLKA_SUBCATEGORIES;
    }

    public By getHousesAndApartmentsSubcategories() {
        return HOUSES_AND_APARTMENTS_SUBCATEGORIES;
    }
}