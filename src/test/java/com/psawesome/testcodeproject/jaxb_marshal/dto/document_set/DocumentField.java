package com.psawesome.testcodeproject.jaxb_marshal.dto.document_set;

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

public class DocumentField {
    private String DOCID;
    private String TOTAL_ID;
    private String ARTICLE_ID;
    private String SOURCE_CODE;
    private String VIEW_FLAG;
    private String ART_TYPE;
    private String SERVICE_DAY;
    private String SERVICE_TIME;
    private String CONTENT_TYPE;
    private String PRESSDATE;
    private String PRESSCATEGORY;
    private String PRESSMYUN;
    private String ART_CRE_TIME;
    private String ART_UPD_TIME;
    private String SOURCE_NAME;
    private String SEARCH_CODE;
    private String PORTAL_CODE;
    private String MEDIA_CODE;
    private String MASTER_CODE_LIST;
    private String SERVICE_CODE;
    private String SECTION_NAME;
    private String SERVICE_CODE_LIST;
    private String SECTION_NAME_LIST;
    private String ART_THUMB;
    private String ART_TITLE;
    private String MOB_TITLE;
    private String ART_REPORTER;
    private String ART_SUBTITLE;
    private String ART_KWD;
    private String SERVICE_FULLCODE;
    private String ART_CONTENT;
    private String REPORTER_GROUP;
    private String SRC_GRP_CD;
    private String ART_REP_NO;
    private String Date;
    private String JOONGANG_USE;
    private String ILGAN_USE;
    private String NEWSALIAS;
    private String DUP_TITLE;

    public DocumentField setDOCID(String DOCID) {
        this.DOCID = DOCID;
        return this;
    }

    public DocumentField setTOTAL_ID(String TOTAL_ID) {
        this.TOTAL_ID = TOTAL_ID;
        return this;
    }

    public DocumentField setARTICLE_ID(String ARTICLE_ID) {
        this.ARTICLE_ID = ARTICLE_ID;
        return this;
    }

    public DocumentField setSOURCE_CODE(String SOURCE_CODE) {
        this.SOURCE_CODE = SOURCE_CODE;
        return this;
    }

    public DocumentField setVIEW_FLAG(String VIEW_FLAG) {
        this.VIEW_FLAG = VIEW_FLAG;
        return this;
    }

    public DocumentField setART_TYPE(String ART_TYPE) {
        this.ART_TYPE = ART_TYPE;
        return this;
    }

    public DocumentField setSERVICE_DAY(String SERVICE_DAY) {
        this.SERVICE_DAY = SERVICE_DAY;
        return this;
    }

    public DocumentField setSERVICE_TIME(String SERVICE_TIME) {
        this.SERVICE_TIME = SERVICE_TIME;
        return this;
    }

    public DocumentField setCONTENT_TYPE(String CONTENT_TYPE) {
        this.CONTENT_TYPE = CONTENT_TYPE;
        return this;
    }

    public DocumentField setPRESSDATE(String PRESSDATE) {
        this.PRESSDATE = PRESSDATE;
        return this;
    }

    public DocumentField setPRESSCATEGORY(String PRESSCATEGORY) {
        this.PRESSCATEGORY = PRESSCATEGORY;
        return this;
    }

    public DocumentField setPRESSMYUN(String PRESSMYUN) {
        this.PRESSMYUN = PRESSMYUN;
        return this;
    }

    public DocumentField setART_CRE_TIME(String ART_CRE_TIME) {
        this.ART_CRE_TIME = ART_CRE_TIME;
        return this;
    }

    public DocumentField setART_UPD_TIME(String ART_UPD_TIME) {
        this.ART_UPD_TIME = ART_UPD_TIME;
        return this;
    }

    public DocumentField setSOURCE_NAME(String SOURCE_NAME) {
        this.SOURCE_NAME = SOURCE_NAME;
        return this;
    }
}
