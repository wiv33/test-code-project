package com.psawesome.testcodeproject.testCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * package: com.psawesome.testcodeproject.testCode
 * author: PS
 * DATE: 2020-05-05 화요일 14:12
 */
public class t_2588 {
    int x;
    int y;

    @BeforeEach
    void setUp() {
        x = 472;
        y = 385;
    }

    @Test
    @DisplayName("100의 자리")
    void testMethod() {
        int resultX = this.getNum(x, 2);
        int resultY = this.getNum(y, 2);
        assertAll(
                () -> assertEquals(4, resultX),
                () -> assertEquals(3, resultY)
        );
    }

    @Test
    @DisplayName("10의 자리")
    void testDigits() {
        int resultX = this.getNum(x, 1);
        int resultY = this.getNum(y, 1);
        assertAll(
                () -> assertEquals(7, resultX),
                () -> assertEquals(8, resultY)
        );
    }

    @Test
    @DisplayName("1의 자리")
    void testDigits_1() {
        int resultX = this.getNum(x, 0);
        int resultY = this.getNum(y, 0);

        assertAll(
                () -> assertEquals(2, resultX),
                () -> assertEquals(5, resultY)
        );
    }

    private int getNum(int n, int digits) {
        double pow = Math.pow(10, digits);
        int floorDiv = Math.floorDiv(n, (int) pow);
        return floorDiv % 10;
    }

}
