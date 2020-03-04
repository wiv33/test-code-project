package com.psawesome.testcodeproject.pagination.more;

import java.util.HashMap;
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

public class MorePagination {

    private int start_index, total_index, list_count;

    private int current_index;

    public MorePagination setStart(int start_index) {
        this.start_index = start_index;
        return this;
    }

    public MorePagination setTotalIndex(int total_index) {
        this.total_index = total_index;
        return this;
    }

    public MorePagination setCount(int list_count) {
        this.list_count = list_count;
        return this;
    }

    public Map<String, Integer> build() {
        this.init();

        HashMap<String, Integer> retMap = new HashMap<>();
        retMap.put("next_index", getNextIndex());
        retMap.put("prev_index", getPrevIndex());
        retMap.put("current_index", this.current_index);
        retMap.put("isEnd", this.isEnd());
        return retMap;
    }

    private void init() {

    }

    private Integer getPrevIndex() {
        return this.start_index;
    }

    private Integer getNextIndex() {
        return 0;
    }

    private Integer isEnd() {
        return 0;
    }
}
