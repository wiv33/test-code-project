package com.psawesome.testcodeproject.jaxb_marshal.dto.threeDepth;

import com.psawesome.testcodeproject.jaxb_marshal.dto.fourDepth.DocumentField;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

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

public class ArtDocument {

    private String Uid;
    private String Rank;
    private String Date;
    private String Weight;
    private String SearcherId;
    private String CollectionId;
    private String DuplicateDocumentCount;

    @XmlElement(name = "Field")
    private DocumentField field;
}
