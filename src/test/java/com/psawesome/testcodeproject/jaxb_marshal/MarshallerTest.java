package com.psawesome.testcodeproject.jaxb_marshal;

import com.psawesome.testcodeproject.jaxb_marshal.dto.*;
import com.psawesome.testcodeproject.jaxb_marshal.dto.threeDepth.AnalysisField;
import com.psawesome.testcodeproject.jaxb_marshal.dto.twoDepth.DocumentSet;
import com.psawesome.testcodeproject.jaxb_marshal.dto.twoDepth.MorphemeAnalysis;
import com.psawesome.testcodeproject.jaxb_marshal.dto.twoDepth.MultiGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

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
    private RootModel rm = new RootModel();

    @BeforeEach
    void setUp() {

        rm.setVersion("5.0.0");

        RelationCollectionModel rcm = new RelationCollectionModel();
        rcm.setId("hello")
                .setOriginal("World");

        MorphemeAnalysis ma = new MorphemeAnalysis();
        AnalysisField af = new AnalysisField();
        af.setArt_title("hello_title");
        af.setArt_kwd("Key Word");
        af.setArt_reporter("Reporter value");

        ma.setField(af);

        DocumentSet ds = new DocumentSet();
        MultiGroup mg = new MultiGroup();
        rcm.setDocumentSet(ds);
        rcm.setMorphemeAnalysis(ma);
        rcm.setMultiGroup(mg);


        rm.setRelationCollectionModel(rcm);
    }

    @Test
    void marshalRunTest() {
        Marshaller marshaller = null;

        try {
            JAXBContext context = JAXBContext.newInstance(RootModel.class);
            marshaller = context.createMarshaller();
            File file = new File("C:\\private\\projects\\test-code-project\\src\\test\\java\\com\\psawesome\\testcodeproject\\",
                    "test.xml");
            marshaller.marshal(rm,file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
