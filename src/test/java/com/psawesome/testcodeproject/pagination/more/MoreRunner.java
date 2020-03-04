package com.psawesome.testcodeproject.pagination.more;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
    void page_start() {
        total_index = 32514;
        list_count = 10;

        MorePagination more = new MorePagination();
        more.setStart(start_index)
                .setTotalIndex(total_index)
                .setCount(list_count);

        Map<String, Integer> map = more.getPage();
        Assertions.assertEquals(list_count, map.get("next_index"));
        Assertions.assertEquals(0, map.get("prev_index"));
        Assertions.assertEquals(0, map.get("current_index"));
        Assertions.assertEquals(0, map.get("isEnd"));
    }
}
