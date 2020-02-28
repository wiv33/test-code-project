package com.psawesome.testcodeproject.create_xml_documentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

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

public class CreatedXmlRunner {

    @Test
    void runCreatedXML() {


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert db != null;

        Document d = db.newDocument();
        Element rss = d.createElement("RSS");


        Element collection = d.createElement("Collection");

        Element morphemeAnalysis = d.createElement("MorphemeAnalysis");
        Element morphemeField = d.createElement("Field");
        CDATASection art_title = d.createCDATASection("ART_TITLE");
        art_title.setTextContent("my TITLE");

        morphemeField
                .appendChild(art_title)
                .appendChild(setCDATA_content(d, "MOB_TITLE", "MOB TITLE"))
                .appendChild(setCDATA_content(d, "ART_KWD", "ART KWD"))
                .appendChild(setCDATA_content(d, "ART_REPORTER", "ART REPORTER"))
                .appendChild(setCDATA_content(d, "ART_SUBTITLE", "ART SUB TITLE"))
        ;
        morphemeAnalysis.appendChild(morphemeField);

        Element documentSet = d.createElement("DocumentSet");
        Element document = d.createElement("Document");
        Element docField = d.createElement("Field");

        CDATASection docid = setCDATA_content(d,"DOCID", "2732145");
        d.createCDATASection("DOCID");
        d.createCDATASection("TOTAL_ID");
        d.createCDATASection("ARTICLE_ID");
        d.createCDATASection("SOURCE_CODE");
        d.createCDATASection("VIEW_FLAG");
        d.createCDATASection("ART_TYPE");
        d.createCDATASection("SERVICE_DAY");
        d.createCDATASection("SERVICE_TIME");
        d.createCDATASection("CONTENT_TYPE");
        d.createCDATASection("PRESSDATE");
        d.createCDATASection("PRESSCATEGORY");
        d.createCDATASection("PRESSMYUN");
        d.createCDATASection("ART_CRE_TIME");
        d.createCDATASection("ART_UPD_TIME");
        d.createCDATASection("SOURCE_NAME");
        d.createCDATASection("SEARCH_CODE");
        d.createCDATASection("PORTAL_CODE");
        d.createCDATASection("MEDIA_CODE");
        d.createCDATASection("MASTER_CODE_LIST");
        d.createCDATASection("SERVICE_CODE");
        d.createCDATASection("SECTION_NAME");
        d.createCDATASection("SERVICE_CODE_LIST");
        d.createCDATASection("SECTION_NAME_LIST");
        d.createCDATASection("ART_THUMB");
        d.createCDATASection("ART_TITLE");
        d.createCDATASection("MOB_TITLE");
        d.createCDATASection("ART_REPORTER");
        d.createCDATASection("ART_SUBTITLE");
        d.createCDATASection("ART_KWD");
        d.createCDATASection("SERVICE_FULLCODE");
        d.createCDATASection("ART_CONTENT");
        d.createCDATASection("REPORTER_GROUP");
        d.createCDATASection("SRC_GRP_CD");
        d.createCDATASection("ART_REP_NO");
        d.createCDATASection("DATE");
        d.createCDATASection("JOONGANG_USE");
        d.createCDATASection("ILGAN_USE");
        d.createCDATASection("NEWSALIAS");

        document.appendChild(d.createElement("Uid"))
        .appendChild(d.createElement("Rank"))

        .appendChild(d.createElement("Weight"))
        .appendChild(d.createElement("SearcherId"))
        .appendChild(d.createElement("CollectionId"))
        .appendChild(d.createElement("DuplicateDocumentCount"))
        .appendChild(docField)
        ;


        documentSet.appendChild(d.createElement("Count"))
                .appendChild(d.createElement("TotalCount"))
                ;



        collection.appendChild(d.createElement("Id"))
                .appendChild(d.createElement("original"))

                ;


        rss.appendChild(d.createElement("Version"))
            .appendChild(d.createElement("SuggestedQuery"))
            .appendChild(collection)
        ;
        d.appendChild(rss);

        TransformerFactory tf = TransformerFactory.newInstance( );
	        Transformer t = null;
	        try
	        {
	            t = tf.newTransformer( );
	        }
	        catch ( TransformerConfigurationException e )
	        {
	            e.printStackTrace( );
	        }
	        assert t != null;

	        t.setOutputProperty( OutputKeys.ENCODING , "utf-8" );
	        t.setOutputProperty( OutputKeys.METHOD , "xml" );
	        t.setOutputProperty( OutputKeys.INDENT , "yes" );
	        t.setOutputProperty( OutputKeys.CDATA_SECTION_ELEMENTS , "yes" );

	        StringWriter sw = new StringWriter( );
	        try
	        {
	            t.transform( new DOMSource( d ) , new StreamResult( sw ) );
	        }
	        catch ( TransformerException e )
	        {
	            e.printStackTrace( );
	        }
	        System.out.println( sw.toString( ) );

    }

    private CDATASection setCDATA_content(Document d, String elementId, String textContent) {
        CDATASection cdataSection = d.createCDATASection(elementId);
        cdataSection.setTextContent(textContent);
        return cdataSection;
    }


}
