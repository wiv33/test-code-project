package com.psawesome.testcodeproject.failedTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArticleIdCollection {
    ArrayList<Map<String, Object>> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();

        Arrays.asList("3072396", "3072388", "3072389", "3072251", "3072395", "2871675", "3072157", "3072283", "3072365", "3072370").forEach(s -> {
            Map<String, Object> article = new HashMap<>();
            article.put("articleId", s);
            list.add(article);
        });
    }

    @Test
    void testMakeCategories() {
        makeCategories(list);
    }

    private void makeCategories(ArrayList<Map<String, Object>> list) {
        String s = articleIdList(list);
    }

}
