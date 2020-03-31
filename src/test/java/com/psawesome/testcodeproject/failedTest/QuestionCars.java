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
    @ValueSource(strings = {"abcdefXghi", "Xabcdefghi", "abcdefghiX"})
    void name(String road) {
//        문제 정의와 해결책을 먼저 생각

        StringBuilder sb = new StringBuilder();
        char[] chars = road.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X') {

            }
        }

            Assertions.assertEquals("abBcBdEBeEBfEBX", sb.toString());

    }
}
