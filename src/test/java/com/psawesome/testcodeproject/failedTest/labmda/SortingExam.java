package com.psawesome.testcodeproject.failedTest.labmda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-04-01
 */

class SortingExam {
    List<String> arr = Arrays.asList("peter", "anna", "mike", "milk");

    @Test
    @DisplayName("오름차순 정렬 테스트")
    void testSortASCAnonymous() {

        List<String> expected = Arrays.asList("anna", "mike", "milk", "peter");

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Assertions.assertArrayEquals(expected.toArray(), arr.toArray());

    }

    @Test
    void testSortDESCLambda() {
        List<String> expected = Arrays.asList("peter", "milk", "mike", "anna");

        Assertions.assertArrayEquals(expected.toArray(), arr.toArray());
    }
}
