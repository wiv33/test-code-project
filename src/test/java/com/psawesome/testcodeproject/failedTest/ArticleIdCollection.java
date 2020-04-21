package com.psawesome.testcodeproject.failedTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    private String articleIdList(List<Map<String, Object>> list) {
        return list.stream()
                .map(m -> m.get("articleId"))
                .reduce((a, b) -> a + "," + b)
                .orElse("").toString();
    }
}
/*
Tree
Chart
JSON Input
[
{
"articleId": 3072396,
"pv": 26,
"title": "[이미지, 비디오] Exclusive Fragrance",
},
{
"articleId": 3072388,
"pv": 18,
"title": "비디오, 이미지 포함 기사",
},
{
"articleId": 3072389,
"pv": 17,
"title": "비디오하고 오디오",
},
{
"articleId": 3072251,
"pv": 16,
"title": "Bundang JS Hotel is now Somerset Bundang",
},
{
"articleId": 3072395,
"pv": 11,
"title": "[이미지만] Michelle Lynn Monaghan",
},
{
"articleId": 2871675,
"pv": 7,
"title": "North aide sings praises of cooperative Americans",
},
{
"articleId": 3072157,
"pv": 7,
"title": "Korea’s go-to guy for football going to Indonesia",
},
{
"articleId": 3072283,
"pv": 7,
"title": "모든 파티클 추가 작업",
},
{
"articleId": 3072365,
"pv": 7,
"title": "파티클 Test - 커버형 기사 / 슬라이드",
},
{
"articleId": 3072370,
"pv": 7,
"title": "mmo rre test",
}
]
 */