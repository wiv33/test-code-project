package com.psawesome.testcodeproject.controller.myMockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * package: com.psawesome.testcodeproject.controller.myMockito
 * author: PS
 * DATE: 2020-03-24 화요일 22:35
 */

@DisplayName("My special Test")
class MyMockitoControllerTest {

    @Test
    @DisplayName("first annotation displayName")
    void displayNameFirstTest() {

    }

//    @Test
    @DisplayName("Annotation으로 args 넘기기")
    @ParameterizedTest(name = "세 번의 호출이 될 것이다.")
    @ValueSource(strings = {"myMono", "Flux", "Stream"})
    void parameterizedAnnotationTest(String param) {
        var expected = Pattern.compile("myMono|Flux|Stream");
        assertTrue(expected.matcher(param).find());
    }
}