package com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis;

import org.springframework.data.annotation.AccessType;

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

@AccessType(AccessType.Type.FIELD)
public class MorphemeField {

    private String art_title;
    private String mob_title;
    private String art_kwd;
    private String art_reporter;
    private String art_subtitle;

    public MorphemeField setArt_title(String art_title) {
        this.art_title = art_title;
        return this;
    }

    public MorphemeField setMob_title(String mob_title) {
        this.mob_title = mob_title;
        return this;
    }

    public MorphemeField setArt_kwd(String art_kwd) {
        this.art_kwd = art_kwd;
        return this;
    }

    public MorphemeField setArt_reporter(String art_reporter) {
        this.art_reporter = art_reporter;
        return this;
    }

    public MorphemeField setArt_subtitle(String art_subtitle) {
        this.art_subtitle = art_subtitle;
        return this;
    }

}
