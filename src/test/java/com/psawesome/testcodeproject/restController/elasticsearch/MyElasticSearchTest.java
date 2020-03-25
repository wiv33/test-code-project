package com.psawesome.testcodeproject.restController.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * package: com.psawesome.testcodeproject.restController.elasticsearch
 * author: PS
 * DATE: 2020-03-24 화요일 23:48
 */
@SpringBootTest
class MyElasticSearchTest {

    @Autowired
    RestHighLevelClient client;

    @Test
    void name() {
        Assertions.assertNotNull(client);
    }


}
