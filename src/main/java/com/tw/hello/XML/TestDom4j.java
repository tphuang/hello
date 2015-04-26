package com.tw.hello.XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * Created by tphuang on 4/26/15.
 */
public class TestDom4j {

    public static void main(String[] args) {
        String xmlString = "<root><people>Robin</people></root>";
        try {
            Document document = DocumentHelper.parseText(xmlString);
            System.out.println(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
