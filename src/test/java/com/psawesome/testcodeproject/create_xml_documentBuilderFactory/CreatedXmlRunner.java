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

        morphemeField.appendChild(art_title);
        morphemeField.appendChild(setCDATA_content(d, "MOB_TITLE", "MOB TITLE"));
        morphemeField.appendChild(setCDATA_content(d, "ART_KWD", "ART KWD"));
        morphemeField.appendChild(setCDATA_content(d, "ART_REPORTER", "ART REPORTER"));
        morphemeField.appendChild(setCDATA_content(d, "ART_SUBTITLE", "ART SUB TITLE"))
        ;
        morphemeAnalysis.appendChild(morphemeField);

        Element documentSet = d.createElement("DocumentSet");
        Element document = d.createElement("Document");
        Element docField = d.createElement("Field");

        docField.appendChild(setCDATA_content(d, "DOCID", "2732145"));
        docField.appendChild(setCDATA_content(d, "TOTAL_ID", "본문"));
        docField.appendChild(setCDATA_content(d, "ARTICLE_ID", "본문"));
        docField.appendChild(setCDATA_content(d, "SOURCE_CODE", "본문"));
        docField.appendChild(setCDATA_content(d, "VIEW_FLAG", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_TYPE", "본문"));
        docField.appendChild(setCDATA_content(d, "SERVICE_DAY", "본문"));
        docField.appendChild(setCDATA_content(d, "SERVICE_TIME", "본문"));
        docField.appendChild(setCDATA_content(d, "CONTENT_TYPE", "본문"));
        docField.appendChild(setCDATA_content(d, "PRESSDATE", "본문"));
        docField.appendChild(setCDATA_content(d, "PRESSCATEGORY", "본문"));
        docField.appendChild(setCDATA_content(d, "PRESSMYUN", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_CRE_TIME", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_UPD_TIME", "본문"));
        docField.appendChild(setCDATA_content(d, "SOURCE_NAME", "본문"));
        docField.appendChild(setCDATA_content(d, "SEARCH_CODE", "본문"));
        docField.appendChild(setCDATA_content(d, "PORTAL_CODE", "본문"));
        docField.appendChild(setCDATA_content(d, "MEDIA_CODE", "본문"));
        docField.appendChild(setCDATA_content(d, "MASTER_CODE_LIST", "본문"));
        docField.appendChild(setCDATA_content(d, "SERVICE_CODE", "본문"));
        docField.appendChild(setCDATA_content(d, "SECTION_NAME", "본문"));
        docField.appendChild(setCDATA_content(d, "SERVICE_CODE_LIST", "본문"));
        docField.appendChild(setCDATA_content(d, "SECTION_NAME_LIST", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_THUMB", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_TITLE", "본문"));
        docField.appendChild(setCDATA_content(d, "MOB_TITLE", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_REPORTER", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_SUBTITLE", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_KWD", "본문"));
        docField.appendChild(setCDATA_content(d, "SERVICE_FULLCODE", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_CONTENT", "본문"));
        docField.appendChild(setCDATA_content(d, "REPORTER_GROUP", "본문"));
        docField.appendChild(setCDATA_content(d, "SRC_GRP_CD", "본문"));
        docField.appendChild(setCDATA_content(d, "ART_REP_NO", "본문"));
        docField.appendChild(setCDATA_content(d, "DATE", "본문"));
        docField.appendChild(setCDATA_content(d, "JOONGANG_USE", "본문"));
        docField.appendChild(setCDATA_content(d, "ILGAN_USE", "본문"));
        docField.appendChild(setCDATA_content(d, "NEWSALIAS", "본문"));

        document.appendChild(d.createElement("Uid"));
        document.appendChild(d.createElement("Rank"));
        document.appendChild(d.createElement("Weight"));
        document.appendChild(d.createElement("SearcherId"));
        document.appendChild(d.createElement("CollectionId"));
        document.appendChild(d.createElement("DuplicateDocumentCount"));
        document.appendChild(docField);

        documentSet.appendChild(d.createElement("Count"));
        documentSet.appendChild(d.createElement("TotalCount"));
        documentSet.appendChild(document);

        collection.appendChild(d.createElement("Id"));
        collection.appendChild(d.createElement("original"));
        collection.appendChild(documentSet);

        rss.appendChild(d.createElement("Version"));
        rss.appendChild(d.createElement("SuggestedQuery"));
        rss.appendChild(collection);

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
	            t.transform( new DOMSource( rss ) , new StreamResult( sw ) );
	        }
	        catch ( TransformerException e )
	        {
	            e.printStackTrace( );
	        }
	        System.out.println( sw.toString( ) );

    }

    private Element setCDATA_content(Document d, String elementId, String textContent) {
        CDATASection cdataSection = d.createCDATASection(elementId);
        cdataSection.setTextContent(textContent);
        Element newElement = d.createElement(elementId);
        newElement.appendChild(cdataSection);
        return newElement;
    }


}
