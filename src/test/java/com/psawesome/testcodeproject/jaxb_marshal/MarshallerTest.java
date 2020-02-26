package com.psawesome.testcodeproject.jaxb_marshal;

import com.psawesome.testcodeproject.jaxb_marshal.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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

public class MarshallerTest {
    @BeforeEach
    void setUp() {
        RootModel rm = new RootModel();
        rm.setVersion("5.0.0");

        RelationCollectionModel rcm = new RelationCollectionModel();
        rcm.setId("hello")
                .setOriginal("World");

        MorphemeAnalysis ma = new MorphemeAnalysis();
        DocumentSet ds = new DocumentSet();
        MultiGroup mg = new MultiGroup();




        rm.setRelationCollectionModel(rcm);
    }

    @Test
    void marshalRunTest() {
        Marshaller marshaller = null;



        try {
            JAXBContext context = JAXBContext.newInstance(RootModel.class);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
