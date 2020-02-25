package com.psawesome.testcodeproject.pagination;

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

    private String queryCurrPage = "currPage";

    @Test
    void doEndTag() {
        if (pageTotalCount < 1) {
            throw new RuntimeException("페이징할 페이지가 없습니다.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<nav>");
        sb.append("<ul>");

        sb.append(this.getPaginationHtml(
                this.maximumPageCount,
                this.startPage,
                this.pageTotalCount,
                this.baseUrl));

        sb.append("</ul>");
        sb.append("</nav>");


    }

    private String getPaginationHtml(int maximumPageCount, int startPage, int pageTotalCount, String baseUrl) {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>");
        String prevUrl = String.format("%s?%s=%d", baseUrl, this.queryCurrPage, startPage - 1 > 0 ? startPage - 1 : 1);
        sb.append(
                String.format("<a href=\"%s\">" +
                                "<img src=\"/resources/images/common/prev-arrow.png\" title=\"prev\"/></a>",
                        startPage > 1 ? prevUrl : "javascript:void(0)"));
        sb.append("</li>");

        if (startPage < maximumPageCount) {
            boolean isNotFullSize = pageTotalCount < maximumPageCount;
            maximumPageCount = isNotFullSize ? pageTotalCount : maximumPageCount;

            for (int i = 0; i < maximumPageCount; i++)
                this.appendPageNumberLiHtmlTag(sb, baseUrl, startPage, i + 1);

            if (!isNotFullSize) {
                this.appendEllipsisHtmlLiTag(sb);
                this.appendPageNumberLiHtmlTag(sb, baseUrl, -1, pageTotalCount);
            }

        } else if (pageTotalCount < (startPage + maximumPageCount - 1)) {
            int lastPage = pageTotalCount - maximumPageCount + 1;
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

        sb.append("<li>");
        String nextUrl = String.format("%s?%s=%d", baseUrl, queryCurrPage, Math.min(startPage + 1, pageTotalCount));
        sb.append(
                String.format("<a href=\"%s\">" +
                                "<img src=\"/resources/images/common/next-arrow.png\" title=\"next\"/></a>",
                        startPage < pageTotalCount ? nextUrl : "javascript:void(0)"
                ));
        sb.append("</li>");
        return sb.toString();
    }

    private void appendEllipsisHtmlLiTag(StringBuilder sb) {
        sb.append("<li><a href=\"javascript:void(0)\">...</a></li>");
    }

    private void appendPageNumberLiHtmlTag(StringBuilder sb, String baseUrl, int startPage, int i) {
        boolean isCurrentNum = startPage == i;
        String tempUrl = String.format("%s?%s=%d", baseUrl, queryCurrPage, i);
        sb.append(
                String.format("<li><a class=\"%s\" href=\"%s\">%d</a></li>",
                        isCurrentNum ? "active" : "",
                        isCurrentNum ? "javascript:void(0)" : tempUrl,
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