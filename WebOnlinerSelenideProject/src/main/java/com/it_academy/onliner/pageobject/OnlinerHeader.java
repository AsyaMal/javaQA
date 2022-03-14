package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.Condition;
import com.it_academy.onliner.framework.AbstractPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class OnlinerHeader extends AbstractPage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), 'Каталог')]";

    public void clickOnMainNavigationLink() {
        $x(MAIN_NAVIGATION_LINK_XPATH_PATTERN)
                .shouldBe(Condition.visible, ofSeconds(60))
                .click();
    }
}