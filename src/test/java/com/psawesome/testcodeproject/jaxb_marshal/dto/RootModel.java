package com.psawesome.testcodeproject.jaxb_marshal.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

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

@XmlRootElement(name = "RSS")
public class RootModel {

    @XmlElement(name = "Version")
    private String version;

    @XmlElement(name = "Collection")
    private RelationCollectionModel relationCollectionModel;

    public RootModel setVersion(String version) {
        this.version = version;
        return this;
    }

    public RootModel setRelationCollectionModel(RelationCollectionModel relationCollectionModel) {
        this.relationCollectionModel = relationCollectionModel;
        return this;
    }
}
