package com.psawesome.testcodeproject.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author pilseong.ko
 */
class ExtractTwoNumberAdd {

    private int[] sort(int[] a) {
        int size = a.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                int low = a[j];
                int high = a[j + 1];
                if (low < high) {
                    continue;
                }
                a[j] = high;
                a[j + 1] = low;
            }
        }

        return a;
    }

    public int[] solution(int[] numbers) {
        int[] answer = {};
        var list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i ++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int _sum = numbers[i] + numbers[j];
                if (list.contains(_sum)) {
                    continue;
                }
                list.add(_sum);
            }
        }
        answer = sort(list.stream().mapToInt(Integer::intValue).toArray());

        return answer;
    }

    @Test
    void testSolution() {
        var actual = solution(new int[]{2,1,3,4,1});
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, actual);
    }
}
