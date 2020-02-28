package com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-02-26
 */

public class MorphemeAnalysis {

    @XmlElement(name = "Field")
    private AnalysisField field;

    public MorphemeAnalysis setField(AnalysisField field) {
        this.field = field;
        return this;
    }
}
