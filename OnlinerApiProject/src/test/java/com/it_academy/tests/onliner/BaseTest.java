package com.it_academy.tests.onliner;

import com.it_academy.onliner.rest_api.model.SushiVeslaProduct;
import com.it_academy.onliner.rest_api.service.SushiVeslaService;

import java.util.List;

public class BaseTest {
    SushiVeslaService sushiVeslaService = new SushiVeslaService();
    List<SushiVeslaProduct> sushiVeslaProducts;
}
