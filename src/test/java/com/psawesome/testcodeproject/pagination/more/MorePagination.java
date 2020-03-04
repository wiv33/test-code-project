package com.psawesome.testcodeproject.pagination.more;

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
    public MorePagination setStart(int start_index) {
        return this;
    }

    public MorePagination setTotalIndex(int total_index) {
        return this;
    }

    public MorePagination setCount(int list_count) {
        return this;
    }

    public Map<String, Integer> getPage() {
        return null;
    }
}
