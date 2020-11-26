package com.psawesome.testcodeproject.xml;

import java.util.*;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.junit.jupiter.api.Test;

public class XStreamTest {

  @Test
  void testMyXStream() {

  }

  @Test
  void testFirstXStream() {
    XStream x = new XStream();
    x.aliasAttribute("name", "value access");
  }

  @Test
  void testByJSONObject() {
    final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    map.put("myName", "is good");
    map.put("firstName", "study");
    map.put("lastName", "ing");

    XStream x = new XStream();
    x.alias("RSS", map.getClass());
    x.aliasAttribute("xu", "Success");

    final String s = x.toXML(map);
    System.out.println("s = " + s);
  }


  @Test
  void testMapToXml() {
    Map<String,Object> root = new HashMap<>();
    root.put("name","chris");
    root.put("island","faranga");
    Map<String,Object> cihld1 = new HashMap<>();
    cihld1.put("test", "테스트");
    cihld1.put("code", "1");
    root.put("tests", cihld1);
    Map<String,Object> child2 = new HashMap<>();
    child2.put("national", "korea");
    child2.put("dev", "kkk");
    cihld1.put("devList", child2);

    XStream x = new XStream();
    x.alias("root", Map.class);
    x.registerConverter(new MapEntryConverter());

    String xml = x.toXML(root);
    System.out.println(xml);
  }
}

class MapEntryConverter implements Converter {

  public boolean canConvert(Class clazz) {
    return AbstractMap.class.isAssignableFrom(clazz);
  }

  public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    AbstractMap<String, Object> map = (AbstractMap<String, Object>) value;
    final Set<Entry<String, Object>> entries = map.entrySet();
    for (Entry<String, Object> entry : entries) {
      Object entryValue = entry.getValue();

      if (entryValue instanceof Map) {
        writer.startNode(entry.getKey());
        marshal(entry.getValue(), writer, context);
        writer.endNode();
        continue;
      }

      writer.startNode(entry.getKey());
      writer.setValue(entryValue.toString());
      writer.endNode();
    }
  }

  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    Map<String, Object> map = new HashMap<>();

    while (reader.hasMoreChildren()) {
      reader.moveDown();
      if (reader.hasMoreChildren()) {
        Map<String, Object> childMap = new HashMap<>();
        map.put(reader.getNodeName(), childMap);
        unmarshalHierarchical(reader, context, childMap);
        reader.moveUp();
        continue;
      }
      map.put(reader.getNodeName(), reader.getValue());
      reader.moveUp();
    }
    return map;
  }

  private void unmarshalHierarchical(HierarchicalStreamReader reader, UnmarshallingContext context, Map<String, Object> map) {
    while (reader.hasMoreChildren()) {
      reader.moveDown();
      if (reader.hasMoreChildren()) {
        Map<String, Object> childMap = new HashMap<String, Object>();
        map.put(reader.getNodeName(), childMap);
        unmarshalHierarchical(reader, context, childMap);
        reader.moveUp();
        continue;
      }
      map.put(reader.getNodeName(), reader.getValue());
      reader.moveUp();
    }
  }
}
