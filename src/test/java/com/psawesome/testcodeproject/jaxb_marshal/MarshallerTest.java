package com.psawesome.testcodeproject.jaxb_marshal;

import com.psawesome.testcodeproject.jaxb_marshal.dto.*;
import com.psawesome.testcodeproject.jaxb_marshal.dto.document_set.ArtDocument;
import com.psawesome.testcodeproject.jaxb_marshal.dto.document_set.DocumentField;
import com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis.MorphemeField;
import com.psawesome.testcodeproject.jaxb_marshal.dto.document_set.DocumentSet;
import com.psawesome.testcodeproject.jaxb_marshal.dto.morpheme_analysis.MorphemeAnalysis;
import com.psawesome.testcodeproject.jaxb_marshal.dto.multi_group.MultiField;
import com.psawesome.testcodeproject.jaxb_marshal.dto.multi_group.MultiGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.time.LocalDateTime;

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
        rcm.setMorphemeAnalysis(ma);

        MorphemeField af = new MorphemeField();
        af.setArt_title("hello_title");
        af.setArt_kwd("Key Word");
        af.setArt_reporter("Reporter value");

        ma.setField(af);
/* DocSet */
        DocumentSet ds = new DocumentSet();

        ArtDocument ad = new ArtDocument();
        ad.setDate(LocalDateTime.now().toString())
                .setUid("0")
                .setWeight("0")
                .setRank("0")
                .setCollectionId("news")
        ;

        DocumentField df = new DocumentField();
        df.setTotal_id("기사번호")
                .setDocid("기사번호")
                .setArticle_id("기사번호")
                .setArt_title("기사 제목")
                .setArt_content("기사 본문 - 간략")
        ;
        ad.setField(df);

        ds.setArtDocument(ad);
        rcm.setDocumentSet(ds);

/* MultiGroup */
        MultiGroup mg = new MultiGroup();
        MultiField mf = new MultiField();
        mf.setService_code("vf")
                .setReporter_group("te")
                .setSrc_grp_cd("er")
        ;
        mg.setMultiField(mf);

        rcm.setMultiGroup(mg);

        rm.setRelationCollectionModel(rcm);
    }

    @Test
    void marshalRunTest() {
        Marshaller marshaller = null;

        try {
            JAXBContext context = JAXBContext.newInstance(RootModel.class);
            marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MarshallAdapter marshallAdapter = new MarshallAdapter();
            marshaller.setAdapter(marshallAdapter);
            File file = new File("C:\\private\\projects\\test-code-project\\src\\test\\java\\com\\psawesome\\testcodeproject\\",
                    "test.xml");
            marshaller.marshal(rm, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
