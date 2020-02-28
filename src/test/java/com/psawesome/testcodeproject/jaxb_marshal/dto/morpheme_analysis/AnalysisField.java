package com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-02-27
 */

public class AnalysisField {

    private String art_title;
    private String mob_title;
    private String art_kwd;
    private String art_reporter;
    private String art_subtitle;

    public String getArt_title() {
        return art_title;
    }

    public AnalysisField setArt_title(String art_title) {
        this.art_title = art_title;
        return this;
    }

    public String getMob_title() {
        return mob_title;
    }

    public AnalysisField setMob_title(String mob_title) {
        this.mob_title = mob_title;
        return this;
    }

    public String getArt_kwd() {
        return art_kwd;
    }

    public AnalysisField setArt_kwd(String art_kwd) {
        this.art_kwd = art_kwd;
        return this;
    }

    public String getArt_reporter() {
        return art_reporter;
    }

    public AnalysisField setArt_reporter(String art_reporter) {
        this.art_reporter = art_reporter;
        return this;
    }

    public String getArt_subtitle() {
        return art_subtitle;
    }

    public AnalysisField setArt_subtitle(String art_subtitle) {
        this.art_subtitle = art_subtitle;
        return this;
    }

}
