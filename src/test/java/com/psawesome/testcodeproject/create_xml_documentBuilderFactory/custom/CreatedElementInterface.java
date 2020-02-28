package com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom;

import org.w3c.dom.Element;

/**
 * package: com.psawesome.testcodeproject.create_xml_documentBuilderFactory
 * author: PS
 * DATE: 2020-02-28 금요일 22:14
 */
interface CreatedElementInterface {
    CreatedElementInterface setRootElement(String elementId);

    CreatedElementInterface appendChild(String elementId, String textContent);

    CreatedElementInterface nonCDATAChild(String elementId, String textContent);

    CreatedElementInterface createDomTree(Element... elements);
}
