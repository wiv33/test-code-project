package com.psawesome.testcodeproject.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author pilseong.ko
 */
class HarshadNumber {

    @ParameterizedTest
    @MethodSource(value = "getNumber")
    void testRun(int x, boolean answer) {
        System.out.println(x + " , " + answer);
        int sum = getSum(x);
        if (x % sum == 0) {
            Assertions.assertTrue(answer);
        }
        System.out.println("sum = " + sum);
    }

    private int getSum(int x) {
        var sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    static Stream<Arguments> getNumber() {
        return Stream.of(Arguments.of(10, true),
                         Arguments.of(11, false),
                         Arguments.of(18, true),
                         Arguments.of(13, false),
                         Arguments.of(20, true));
    }
}
