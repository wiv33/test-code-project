package com.psawesome.testcodeproject.baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class T_1110_더하기_사이클 {


    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest(name = "주어진 수가 10보다 작다면 0을 뒤에 붙인다")
    @MethodSource("paramList")
    void testOne(String arg, String expect) {
        var actual = Integer.parseInt(arg);
        actual = actual < 10 ? actual * 10 : actual;
        Assertions.assertEquals(expect, String.valueOf(actual));
    }


    @Test
    @DisplayName("")
    void testTwo() {

    }

    private static Stream<Arguments> paramList() {
        return Stream.of(
                Arguments.of("26", "26"),
                Arguments.arguments("1", "10"),
                Arguments.arguments("6", "60"),
                Arguments.of("10", "10")
        );
    }

}
