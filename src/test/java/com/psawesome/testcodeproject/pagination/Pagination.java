package com.psawesome.testcodeproject.pagination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * package: com.psawesome.testcodeproject.pagination
 * author: PS
 * DATE: 2020-02-23 일요일 21:17
 */
public class Pagination {
    private int startPage; //현재 active page 번호
    private int maximumPageCount; // 페이지네이션 개수 / 현재는 5개
    private int itemCountInPage; //한 페이지의 기사 개수
    private int pageTotalCount; // 총 페이지 개수
    private int itemTotalCount; // 총 아이템(기사) 개수

    private String baseUrl;

    @BeforeEach
    void setUp() {
        startPage = 1;
        maximumPageCount = 7;
        itemCountInPage = 10;
        pageTotalCount = 32532;

        baseUrl = "testUrl";
    }

    @Test
    public void makePaginationHtmlTest() throws Exception {
        StringBuilder sb = new StringBuilder();
        if (pageTotalCount < 1) {
            throw new Exception("페이징할 리스트가 없습니다.");
        }
        sb.append("<nav>");
        sb.append("<ul>");

        sb.append(this.getPaginationHtml(maximumPageCount, startPage, pageTotalCount));

        sb.append("</ul>");
        sb.append("</nav>");

        System.out.println(sb.toString());
    }

    private String getPaginationHtml(int maximumPageCount, int startPage, int pageTotalCount) {
        StringBuilder sb = new StringBuilder();

        if (startPage < maximumPageCount) {
            maximumPageCount = Math.min(pageTotalCount, maximumPageCount);

            for (int i = 0; i < maximumPageCount; i++)
                this.appendPageNumberLiHtmlTag(sb, this.baseUrl, startPage, i + 1);

            this.appendEllipsisHtmlLiTag(sb);
            this.appendPageNumberLiHtmlTag(sb, baseUrl, -1, pageTotalCount);

        } else if (pageTotalCount < (startPage + maximumPageCount)) {
            int lastPage = pageTotalCount - maximumPageCount;
            this.appendPageNumberLiHtmlTag(sb, baseUrl, -1, 1);
            this.appendEllipsisHtmlLiTag(sb);

            for (int i = lastPage; i <= pageTotalCount; i++)
                this.appendPageNumberLiHtmlTag(sb, baseUrl, startPage, i);

        } else {

            this.appendPageNumberLiHtmlTag(sb, baseUrl, -1, 1);
            this.appendEllipsisHtmlLiTag(sb);

            this.appendPageNumberLiHtmlTag(sb, baseUrl, startPage, startPage - 1);
            this.appendPageNumberLiHtmlTag(sb, baseUrl, startPage, startPage);
            this.appendPageNumberLiHtmlTag(sb, baseUrl, startPage, startPage + 1);

            this.appendEllipsisHtmlLiTag(sb);
            this.appendPageNumberLiHtmlTag(sb, baseUrl, -1, pageTotalCount);
        }

        return sb.toString();
    }

    private void appendEllipsisHtmlLiTag(StringBuilder sb) {
        sb.append("<li><a href=\"javascript:void(0)\">...</a></li>");
    }

    private void appendPageNumberLiHtmlTag(StringBuilder sb, String baseUrl, int startPage, int i) {
        boolean bool = startPage == i;
        /*
            i * this.itemCountInPage
            OR
            i

            item 개수 기준으로 리스트 출력 parameter를 보낼 것인지,
            page 기준으로 리스트 출력 parameter를 보낼 것인지에 따라 다르다.
        */
        String tempUrl = String.format("%s?startItem=%d", baseUrl, i * this.itemCountInPage);
        sb.append(
                String.format("<li><a class=\"%s\" href=\"%s\">%d</a></li>",
                        bool ? "active" : "",
                        bool ? "javascript:void(0)" : tempUrl,
                        i
                ));
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setMaximumPageCount(int maximumPageCount) {
        this.maximumPageCount = maximumPageCount;
    }

    /**
     * @param pageTotalCount
     *         기사의 총 개수를 받아서 총 페이지 개수로 변환한다.
     */
    public void setPageTotalCount(int pageTotalCount) {
        this.itemTotalCount = pageTotalCount;
        this.pageTotalCount = (int) Math.ceil((double) pageTotalCount / this.itemCountInPage);
    }

    public void setItemCountInPage(int itemCountInPage) {
        this.itemCountInPage = itemCountInPage;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}