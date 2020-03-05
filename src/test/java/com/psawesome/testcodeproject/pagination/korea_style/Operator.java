package com.psawesome.testcodeproject.pagination.korea_style;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-03-05
 */

public class Operator {
    int start_index = 0, list_count = 10, maximum_page = 10;

    int current_page; // 클릭한 상태에서 현재 페이지
    int start_page; // 클릭한 상태에서 페이징 시작할 번호
    int end_page; //클릭한 상태에서 페이징 끝나는 번호

}
