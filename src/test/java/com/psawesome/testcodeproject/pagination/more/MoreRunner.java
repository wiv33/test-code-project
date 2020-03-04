package com.psawesome.testcodeproject.pagination.more;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-03-04
 */

public class MoreRunner {

    int start_index = 0, total_index = 0, list_count = 0;

    @Test
    void testRandomValue() {
        int x = this.randomTotalIndex();
        Assertions.assertTrue(x > 0 && x < 100000);
        System.out.println(x);
    }

    @Test
    void index_zero_start() {
        total_index = 32514;
        list_count = 10;

        MorePagination more = new MorePagination();
        more.setStart(start_index)
                .setTotalIndex(total_index)
                .setCount(list_count);

        Map<String, Integer> map = more.build();
        Assertions.assertEquals(list_count * 2, map.get("next_index"));
        Assertions.assertEquals(0, map.get("prev_index"));
        Assertions.assertEquals(10, map.get("current_index"));
        Assertions.assertEquals(0, map.get("isEnd"));
    }

    @Test
    void index_one_start() {
        total_index = 32514;
        list_count = 10;
        start_index = 1;

        MorePagination more = new MorePagination();
        more.setStart(start_index)
                .setTotalIndex(total_index)
                .setCount(list_count);

        Map<String, Integer> map = more.build();
        Assertions.assertEquals(list_count * 2 + 1, map.get("next_index"));
        Assertions.assertEquals(1, map.get("prev_index"));
        Assertions.assertEquals(11, map.get("current_index"));
        Assertions.assertEquals(0, map.get("isEnd"));
    }

    @Test
    @Description("total_index 가 끝났을 때")
    void index_zero_start_and_maximum_total_index() {
        total_index = 9;
        list_count = 10;

        MorePagination more = new MorePagination();
        more.setStart(start_index)
                .setTotalIndex(total_index)
                .setCount(list_count);

        Map<String, Integer> map = more.build();
        Assertions.assertEquals(0, map.get("next_index"));
        Assertions.assertEquals(0, map.get("prev_index"));
        Assertions.assertEquals(9, map.get("current_index"));
        Assertions.assertEquals(1, map.get("isEnd"));
    }

    @Test
    void n_more() {

    }

    private int randomTotalIndex() {
        return ThreadLocalRandom.current()
                .nextInt(0, 100000);
    }
}
