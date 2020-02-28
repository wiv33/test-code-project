package com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * package: com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom
 * author: PS
 * DATE: 2020-02-28 금요일 22:15
 */
public class MyElement implements MyElementInterface {
    private Element _element;
    private Map<String, Element> _elementsMap;
    private Document d;

    public MyElement() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert db != null;

        this.d = db.newDocument();
    }

    public MyElement(List<String> elementsIds) {
        this();
        assert elementsIds.size() > 0;
        Map<String, Element> _elMap = new ConcurrentHashMap<>();
        elementsIds.forEach(id -> _elMap.put(id, this.d.createElement(id)));
        this._elementsMap = _elMap;
    }

    public MyElement appendChild(String elementId, String textContent) {
        Objects.requireNonNull(this._element)
                .appendChild(this.setCDATA_content(elementId, textContent));
        return this;
    }

    @Override
    public MyElement createDomTree(Element root, Element... elements) {
        for (Element element : elements) {
            root.appendChild(element);
        }
        return this;
    }

    @Override
    public MyElement setElement(String elementId) {
        this._element = this.d.createElement(elementId);
        return this;
    }

    @Override
    public MyElement nonCDATAChild(String elementId, String textContent) {
        Element element = Objects.requireNonNull(this._element);
        Element child = this.d.createElement(elementId);
        child.setTextContent(textContent);
        element.appendChild(child);
        return this;
    }

    private Element setCDATA_content(String elementId, String textContent) {
        CDATASection cdataSection = d.createCDATASection(elementId);
        cdataSection.setTextContent(textContent);
        Element newElement = d.createElement(elementId);
        newElement.appendChild(cdataSection);
        return newElement;
    }
}
