package com.psawesome.testcodeproject.pagination;

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

    public String doEndTag() {
        StringBuilder sb = new StringBuilder();
//        try {
        if (pageTotalCount < 1) {
            return "";
        }
        sb.append("<nav aria-label=\"Page navigation example\">");
        sb.append("<ul class=\"pagination justify-content-center\">");

        sb.append(this.getPaginationHtml(maximumPageCount, startPage, pageTotalCount));

        sb.append("</ul>");
        sb.append("</nav>");

//            out.write(sb.toString());
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return sb.toString();
    }

    private String getPaginationHtml(int maximumPageCount, int startPage, int pageTotalCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("<li class=\"page-item\">");
        sb.append("<a class=\"page-link\" href=\"#\" tabindex=\"-1\"><img src=\"/resources/images/common/prev-arrow.png\" title=\"prev\"/></a>");
        sb.append("</li>");

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

        sb.append("<li class=\"page-item\">");
        sb.append("<a class=\"page-link\" href=\"#\"><img src=\"/resources/images/common/next-arrow.png\" title=\"next\"/></a>");
        sb.append("</li>");
        return sb.toString();
    }

    private void appendEllipsisHtmlLiTag(StringBuilder sb) {
        sb.append("<li class=\"page-item\"><a class=\"page-link ellipsis\" href=\"javascript:void(0)\">...</a></li>");
    }

    private void appendPageNumberLiHtmlTag(StringBuilder sb, String baseUrl, int startPage, int i) {
        boolean bool = startPage == i;
        String tempUrl = String.format("%s?startItem=%d", baseUrl, i * this.itemCountInPage);
        sb.append(
                String.format("<li class=\"page-item\"><a class=\"page-link %s\" href=\"%s\">%d</a></li>",
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