package com.it_academy.onliner.rest_api.service;


import com.it_academy.onliner.rest_api.model.SushiVeslaProduct;
import com.it_academy.onliner.rest_api.utils.GetRequestUtils;
import com.it_academy.onliner.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.List;

public class SushiVeslaService {
    public List<SushiVeslaProduct> getSushiVeslaProducts() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
                SushiVeslaProduct.class);
    }
    public List<SushiVeslaProduct> getSushiVeslaProductsFilter() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla?sushi_typ[0]" +
                "=roll&sushi_typ[operation]=union";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
                SushiVeslaProduct.class);
    }
}