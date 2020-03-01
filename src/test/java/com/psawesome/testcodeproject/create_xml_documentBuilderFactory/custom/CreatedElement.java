package com.psawesome.testcodeproject.create_xml_documentBuilderFactory.custom;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
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
        elementsIds.forEach(id -> _elMap.put(id, this.d.createElement(id)));
        this._elementsMap = _elMap;
    }

    public Element get_rootElement() {
        return _rootElement;
    }

    public CreatedElement set_rootElement(Element _rootElement) {
        this._rootElement = _rootElement;
        return this;
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
        return this.set_rootElement(this.d.createElement(elementId));
    }

    public CreatedElement setRootElement(Element element) {
        this.stepEnd();
        this._rootElement = Objects.requireNonNull(element);
        return this;
    }

    @Override
    public CreatedElement nonCDATAChild(String elementId, String textContent) {
        Element element = Objects.requireNonNull(this.get_rootElement());
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
        assert !elementId.isBlank();
        Element obj = this._elementsMap.get(elementId);
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
        assert !removeElementId.isBlank();
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

    @Override
    public String getResultXml(Node rootNode) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = null;
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        assert t != null;

        t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "yes");

        String ret = "";
        try(StringWriter sw = new StringWriter()){
            t.transform(new DOMSource(rootNode), new StreamResult(sw));
            sw.flush();
            ret = sw.toString();
        } catch (IOException | TransformerException e) {
            ret = e.getMessage();
        }

        return ret;
    }
}
