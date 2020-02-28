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

    public ArtDocument setUid(String uid) {
        Uid = uid;
        return this;
    }

    public ArtDocument setRank(String rank) {
        Rank = rank;
        return this;
    }

    public ArtDocument setDate(String date) {
        Date = date;
        return this;
    }

    public ArtDocument setWeight(String weight) {
        Weight = weight;
        return this;
    }

    public ArtDocument setSearcherId(String searcherId) {
        SearcherId = searcherId;
        return this;
    }

    public ArtDocument setCollectionId(String collectionId) {
        CollectionId = collectionId;
        return this;
    }

    public ArtDocument setDuplicateDocumentCount(String duplicateDocumentCount) {
        DuplicateDocumentCount = duplicateDocumentCount;
        return this;
    }

    public ArtDocument setField(DocumentField field) {
        this.field = field;
        return this;
    }
}
