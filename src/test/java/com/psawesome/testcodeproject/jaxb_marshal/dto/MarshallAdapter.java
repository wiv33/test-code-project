package com.psawesome.testcodeproject.jaxb_marshal.dto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

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

public class MarshallAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }

    @Override
    public String marshal(String v) throws Exception {
        return v;
    }
}
