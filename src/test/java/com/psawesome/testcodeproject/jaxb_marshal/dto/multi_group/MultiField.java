package com.psawesome.testcodeproject.jaxb_marshal.dto.multi_group;

import javax.xml.bind.annotation.XmlElement;

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

    @XmlElement(name = "SRC_GRP_CD")
    private String src_grp_cd;
    @XmlElement(name = "SERVICE_CODE")
    private String service_code;
    @XmlElement(name = "REPORTER_GROUP")
    private String reporter_group;

    public MultiField setSrc_grp_cd(String src_grp_cd) {
        this.src_grp_cd = src_grp_cd;
        return this;
    }

    public MultiField setService_code(String service_code) {
        this.service_code = service_code;
        return this;
    }

    public MultiField setReporter_group(String reporter_group) {
        this.reporter_group = reporter_group;
        return this;
    }
}
