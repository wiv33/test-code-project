package com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-02-28
 */

public class MultiField {

    private String SRC_GRP_CD;
    private String SERVICE_CODE;
    private String REPORTER_GROUP;

    public MultiField setSRC_GRP_CD(String SRC_GRP_CD) {
        this.SRC_GRP_CD = SRC_GRP_CD;
        return this;
    }

    public MultiField setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
        return this;
    }

    public MultiField setREPORTER_GROUP(String REPORTER_GROUP) {
        this.REPORTER_GROUP = REPORTER_GROUP;
        return this;
    }
}
