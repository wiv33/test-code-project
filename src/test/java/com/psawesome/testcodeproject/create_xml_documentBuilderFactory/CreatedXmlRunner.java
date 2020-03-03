package com.psawesome.testcodeproject.create_xml_documentBuilderFactory;

import com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom.CreatedElement;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        CreatedElement ce = new CreatedElement(
                List.of("RSS", "Collection", "MorphemeAnalysis", "DocumentSet", "MultiGroup"));
        Element rss = ce.getElement("RSS");
        Element collection = ce.getElement("Collection");
        Element morphemeAnalysis = ce.getElement("MorphemeAnalysis");
        Element documentSet = ce.getElement("DocumentSet");
        Element multiGroup = ce.getElement("MultiGroup");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("TOTAL_ID", "PARAM TOTAL ID !!");
        paramMap.put("COUNT", "5");
        paramMap.put("TOTAL_COUNT", "100");
        paramMap.put("ART_TYPE", "PARAM ART TYPE!!!");
        paramMap.put("SRC_GRP_CD", "PARAM SRC_GRP_CD!!!");

        List<Map<String, Object>> listParam = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> param = new HashMap<>();
            param.put("updatetime", "20191024194947087");
            param.put("TOTAL_ID", "20193832" + i);
            param.put("ART_TYPE", "MY TYPE " + i);
            listParam.add(param);
        }
        paramMap.put("body", listParam);

        ce.setRootElement(rss)
                .nonCDATAChild("Version", "5.0.0")
                .nonCDATAChild("SuggestedQuery", "")
                .createDomTree(collection)
                .stepEnd()
            .setRootElement(collection)
                .appendChild("Id", "Collection Id")
                .appendChild("original", "Collection Original")
                .createDomTree(documentSet, morphemeAnalysis, multiGroup)
            .setRootElement(documentSet)
                .appendChild("Count", paramMap.get("COUNT").toString())
                .appendChild("TotalCount", paramMap.get("TOTAL_COUNT").toString());

        List<Map<String, Object>> body = (List<Map<String, Object>>) paramMap.get("body");

        body.forEach(m -> {
                    Element document = ce.getElement("Document");
                    ce.set_rootElement(documentSet)
                            .createDomTree(document)
                            .setRootElement(document)
                            .appendChild("Uid", "UID")
                            .appendChild("Date", getStringDate(m.get("updatetime").toString(), "yyyy/MM/dd HH:mm:ss"))
                            .appendChild("Rank", "Rank")
                            .appendChild("Weight", "Weight")
                            .appendChild("SearcherId", "SearcherId")
                            .appendChild("CollectionId", "CollectionId")
                            .appendChild("DuplicateDocumentCount", "DuplicateDocumentCount")
                            .createDomTree(ce.putAndGetElement("Field"))
                            .setRootElement(ce.getElement("Field"))
                            .stepEnd(this::makeDocumentFields, m)
                            .stepRemoveRecentElementEnd();
                }
        );

        ce.setRootElement(morphemeAnalysis)
                .createDomTree(ce.putAndGetElement("Field"))
                .setRootElement(ce.getElement("Field"))
                .stepEnd(this::makeMorphemeFields, paramMap)
                .stepRemoveRecentElementEnd()
                .setRootElement(multiGroup)
                .createDomTree(ce.putAndGetElement("Field"))
                .setRootElement(ce.getElement("Field"))
                .stepEnd((createdElement, map) -> createdElement
                        .appendChild("SRC_GRP_CD", map.get("SRC_GRP_CD").toString())
                        .appendChild("SERVICE_CODE", "")
                        .appendChild("REPORTER_GROUP", ""), paramMap)
                .stepRemoveRecentElementEnd()
        ;

        String s = ce.getResultXml(ce.getElement("RSS"));

        System.out.println(s);

    }

    private void makeDocumentFields(CreatedElement createdElement, Map<String, Object> paramMap) {
        createdElement.appendChild("DOCID", "2732145")
                .appendChild("TOTAL_ID", paramMap.get("TOTAL_ID").toString())
                .appendChild("ARTICLE_ID", "본문")
                .appendChild("SOURCE_CODE", "본문")
                .appendChild("VIEW_FLAG", "본문")
                .appendChild("ART_TYPE", paramMap.get("ART_TYPE").toString())
                .appendChild("SERVICE_DAY", "본문")
                .appendChild("SERVICE_TIME", "본문")
                .appendChild("CONTENT_TYPE", "본문")
                .appendChild("PRESSDATE", "본문")
                .appendChild("PRESSCATEGORY", "본문")
                .appendChild("PRESSMYUN", "본문")
                .appendChild("ART_CRE_TIME", "본문")
                .appendChild("ART_UPD_TIME", "본문")
                .appendChild("SOURCE_NAME", "본문")
                .appendChild("SEARCH_CODE", "본문")
                .appendChild("PORTAL_CODE", "본문")
                .appendChild("MEDIA_CODE", "본문")
                .appendChild("MASTER_CODE_LIST", "본문")
                .appendChild("SERVICE_CODE", "본문")
                .appendChild("SECTION_NAME", "본문")
                .appendChild("SERVICE_CODE_LIST", "본문")
                .appendChild("SECTION_NAME_LIST", "본문")
                .appendChild("ART_THUMB", "본문")
                .appendChild("ART_TITLE", "본문")
                .appendChild("MOB_TITLE", "본문")
                .appendChild("ART_REPORTER", "본문")
        ;
    }

    private void makeMorphemeFields(CreatedElement createdElement, Map<String, Object> paramMap) {
        createdElement
                .appendChild("ART_TITLE", "my Title!!")
                .appendChild("MOB_TITLE", "MOB TITLE")
                .appendChild("ART_KWD", "ART KWD")
                .appendChild("ART_REPORTER", "ART REPORTER")
                .appendChild("ART_SUBTITLE", "ART SUB TITLE");
    }

    private void makeMultiGroupFields(CreatedElement createdElement, Map<String, Object> paramMap) {
        createdElement
                .appendChild("SRC_GRP_CD", "")
                .appendChild("SERVICE_CODE", "")
                .appendChild("REPORTER_GROUP", "")
                ;
    }

    private String getStringDate(String date, String format) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.parse(date.substring(0, 14), f);
        return ldt.format(DateTimeFormatter.ofPattern(format));
    }
}
