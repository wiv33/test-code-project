package com.psawesome.testcodeproject.jaxb_marshal.dto;

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

public class RelationCollectionModel {

    @XmlElement(name = "Id")
    private String id;

    @XmlElement(name = "original")
    private String original;


    @XmlElement(name = "MorphemeAnalysis")
    private MorphemeAnalysis morphemeAnalysis;

    @XmlElement(name = "DocumentSet")
    private DocumentSet documentSet;

    @XmlElement(name = "MultiGroup")
    private MultiGroup multiGroup;


    public RelationCollectionModel setId(String id) {
        this.id = id;
        return this;
    }

    public RelationCollectionModel setOriginal(String original) {
        this.original = original;
        return this;
    }

    public RelationCollectionModel setMorphemeAnalysis(MorphemeAnalysis morphemeAnalysis) {
        this.morphemeAnalysis = morphemeAnalysis;
        return this;
    }

    public RelationCollectionModel setDocumentSet(DocumentSet documentSet) {
        this.documentSet = documentSet;
        return this;
    }

    public RelationCollectionModel setMultiGroup(MultiGroup multiGroup) {
        this.multiGroup = multiGroup;
        return this;
    }
}
