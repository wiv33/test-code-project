package com.psawesome.testcodeproject.failedTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * package: com.psawesome.testcodeproject.failedTest
 * author: PS
 * DATE: 2020-03-31 화요일 00:31
 */

public class QuestionCars {

    String[] inputStreets = {"", "", "CCCCC", "DDDDDDD", "", "", ""};
    String[] inputStreets2 = {"", "BBBBBB", "", "", "EEEEEE", "", ""};

    @ParameterizedTest(name = "input load")
    @ValueSource(strings = {"abcdefXghi", "Xabcdefghi"})
    void name(String road) {
        StringBuilder sb = new StringBuilder();
        Assertions.assertEquals("abBcBdEBeEBfEBXEBgE", sb.toString());
    }
}
