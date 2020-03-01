package com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * package: com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom
 * author: PS
 * DATE: 2020-02-28 금요일 22:15
 */
public class CreatedElement implements CreatedElementInterface {
    private Element _rootElement;
    private String recentElementId;
    private Map<String, Element> _elementsMap;
    private Document d;

    public CreatedElement() {
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

    public CreatedElement(List<String> elementsIds) {
        this();
        assert elementsIds.size() > 0;
        Map<String, Element> _elMap = new HashMap<>();
        elementsIds.forEach(id -> {
            Element element = this.d.createElement(id);
            _elMap.put(id, element);
        });
        this._elementsMap = _elMap;
    }

    public Element get_rootElement() {
        return _rootElement;
    }

    public CreatedElement appendChild(String elementId, String textContent) {
        Objects.requireNonNull(this.get_rootElement())
                .appendChild(this.setCDATA_content(elementId, textContent));
        return this;
    }
    public CreatedElement appendChild(Element element) {
        Objects.requireNonNull(this.get_rootElement())
                .appendChild(element);
        return this;
    }

    @Override
    public CreatedElement createDomTree(Element... elements) {
        for (Element element : elements) {
            this.get_rootElement().appendChild(element);
        }
        return this;
    }

    @Override
    public CreatedElement setRootElement(String elementId) {
        this._rootElement = this.d.createElement(elementId);
        return this;
    }

    public CreatedElement setRootElement(Element element) {
        this.stepEnd();
        this._rootElement = Objects.requireNonNull(element);
        return this;
    }

    @Override
    public CreatedElement nonCDATAChild(String elementId, String textContent) {
        Element element = Objects.requireNonNull(this._rootElement);
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

    public Element getElement(String elementId) {
        assert !elementId.isEmpty();
        Element obj = _elementsMap.get(elementId);
        return Objects.isNull(obj) ? d.createElement(elementId) : obj;
    }

    public Element putAndGetElement(String elementId) {
        if (Objects.isNull(this._elementsMap.get(elementId))) {
            Element element = d.createElement(elementId);
            recentElementId = elementId;
            this._elementsMap.put(elementId, element);
        }
        return this._elementsMap.get(elementId);
    }

    public CreatedElement stepEnd() {
        this._rootElement = null;
        return this;
    }
    public CreatedElement stepRemoveEnd(String removeElementId) {
        assert removeElementId != null;
        this._elementsMap.remove(removeElementId);
        return this;
    }

    public CreatedElement stepRemoveRecentElementEnd() {
        if (Objects.nonNull(this._elementsMap.get(recentElementId))) {
            this._elementsMap.remove(recentElementId);
        }
        return this;
    }

    public CreatedElement stepEnd(BiConsumer<CreatedElement, Map<String, String>> c, Map<String, String> param) {
        c.accept(this, param);
        this.stepEnd();
        return this;
    }

}
