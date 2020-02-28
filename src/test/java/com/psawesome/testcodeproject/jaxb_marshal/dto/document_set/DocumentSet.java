package com.psawesome.testcodeproject.jaxb_marshal.dto.document_set;

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

public class DocumentSet {

    @XmlElement(name = "Document")
    private ArtDocument artDocument;

    public DocumentSet setArtDocument(ArtDocument artDocument) {
        this.artDocument = artDocument;
        return this;
    }
}
