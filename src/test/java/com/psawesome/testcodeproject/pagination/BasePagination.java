package com.psawesome.testcodeproject.pagination;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.psawesome.testcodeproject.pagination
 * author: PS
 * DATE: 2020-02-23 일요일 21:19
 */
public class BasePagination {
    @Test
    void total_count_test() {
        int cnt = 32531;
        Assertions.assertEquals(3254, Math.ceil(cnt / 10.0));
    }

    int maximumPageCount = 5;
    int itemCountInPage = 10;
    int totalCount = 32536;

    @Test
    void getTotalPage() {
        // given

        //when
        int totalPage = getTotalPage(itemCountInPage, totalCount);

        //then
        Assertions.assertEquals(3254, totalPage, "총 페이지 수가 일치하지 않습니다. 32536 -> 3254");

    }

    @Test
    @Description("현재 페이지가 1부터 4까지 True")
    void getVisitPageTest() {
        //given
        int currentPage = 1; // 1부터 4까지

        //when
        int totalPage = getTotalPage(itemCountInPage, totalCount);
        List<String> visitPageList = getVisitPage(maximumPageCount, currentPage, totalPage);

        // then
        Assertions.assertTrue(visitPageList.contains("1"));
        Assertions.assertTrue(visitPageList.contains("2"));
        Assertions.assertTrue(visitPageList.contains("3"));
        Assertions.assertTrue(visitPageList.contains("4"));
        Assertions.assertTrue(visitPageList.contains("5"));
        Assertions.assertTrue(visitPageList.contains("..."));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(totalPage)));
    }

    @Test
    @Description("현재 페이지 + maximumPage 가 totalPage 보다 크면 True")
    void getVisitPageLastTest() {
        //given
        int currentPage = 3250;

        //when
        int totalPage = getTotalPage(itemCountInPage, totalCount);
        List<String> visitPageList = getVisitPage(maximumPageCount, currentPage, totalPage);

        //then
//        visitPageList.forEach(System.out::println);

        Assertions.assertTrue(visitPageList.contains("1"));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage++)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage++)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage++)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage++)));
        Assertions.assertEquals(totalPage, currentPage);
    }

    @Test
    void getVisitPageMiddleTest() {
        //given
        int currentPage = 2532;

        //when
        int totalPage = getTotalPage(itemCountInPage, totalCount);
        List<String> visitPageList = getVisitPage(maximumPageCount, currentPage, totalPage);

        Assertions.assertTrue(visitPageList.contains("1"));
        Assertions.assertTrue(visitPageList.contains("..."));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage - 1)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage)));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(currentPage + 1)));
        Assertions.assertTrue(visitPageList.contains("..."));
        Assertions.assertTrue(visitPageList.contains(String.valueOf(totalPage)));

        visitPageList.forEach(System.out::println);
    }

    private List<String> getVisitPage(int maximumPageCount, int currentPage, int totalPageCount) {
        List<String> pageList = new ArrayList<>();

        if (currentPage < maximumPageCount) {
            for (int i = 0; i < maximumPageCount; i++) pageList.add(String.valueOf(i + 1));
            pageList.add("...");
            pageList.add(String.valueOf(totalPageCount));
            return pageList;
        }

        if (totalPageCount < (currentPage + maximumPageCount)) {
            pageList.add(String.valueOf(1));
            pageList.add("...");
            for (int i = currentPage; i <= totalPageCount; i++) {
                pageList.add(String.valueOf(i));
            }
            return pageList;
        }

        pageList.add("1");
        pageList.add("...");
        pageList.add(String.valueOf(currentPage - 1));
        pageList.add(String.valueOf(currentPage));
        pageList.add(String.valueOf(currentPage + 1));
        pageList.add("...");
        pageList.add(String.valueOf(totalPageCount));
        return pageList;
    }

    private int getTotalPage(int itemCountInPage, int totalCount) {
        return (int) Math.ceil(totalCount / (double) itemCountInPage);
    }
}
