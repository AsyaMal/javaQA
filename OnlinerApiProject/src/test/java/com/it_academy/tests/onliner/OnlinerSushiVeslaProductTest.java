package com.it_academy.tests.onliner;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerSushiVeslaProductTest extends BaseTest {

    @Test(description = "Check that each SushiVesla product has name")
    public void testEachSushiVeslaProductHasName() {
        sushiVeslaProducts = sushiVeslaService.getSushiVeslaProducts();
        assertThat(sushiVeslaProducts)
                .as("Some SushiVesla product has no name")
                .allMatch(product -> product.getName() != null);
    }

    @Test(description = "Check that SushiVesla products filtered by certain filter")
    public void testSushiVeslaProductsFilteredByCertainFilter() {
        sushiVeslaProducts = sushiVeslaService.getSushiVeslaProductsFilter();
        assertThat(sushiVeslaProducts)
                .as("Some SushiVesla product has been filtered by another filter")
                .allMatch(product -> product.getName_prefix().equals("Роллы"));
    }
}