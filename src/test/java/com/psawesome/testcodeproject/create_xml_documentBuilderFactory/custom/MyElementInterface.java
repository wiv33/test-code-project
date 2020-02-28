package com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom;

import org.w3c.dom.Element;

/**
 * package: com.psawesome.testcodeproject.create_xml_documentBuilderFactory
 * author: PS
 * DATE: 2020-02-28 금요일 22:14
 */
interface MyElementInterface {
    MyElementInterface setElement(String elementId);

    MyElementInterface appendChild(String elementId, String textContent);

    MyElementInterface nonCDATAChild(String elementId, String textContent);

    MyElementInterface createDomTree(Element root, Element... elements);
}
