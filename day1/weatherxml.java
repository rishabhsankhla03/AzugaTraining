/*
 * Copyright (c) 2022.  - All Rights Reserved
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -rishabh (rishabh sankhla)
 */

package com.training.day1;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class weatherxml {
    public static void main(String[] args) throws JSONException {
        String result;
        try {
            result = new String(Files.readAllBytes(Paths.get("/Users/azuga/Desktop/weather.json")));
            System.out.println(result);
            String a = result.replace("[","");
            String b = a.replace("//","");
//            System.out.println(a);


            String[] arr = b.split("},\\{");

//            System.out.println();



//            System.out.println(arr[1]);



            FileWriter file = new FileWriter("/Users/azuga/Desktop/weatherxml1.xml");
            file.write("");
            for(int i=0;i< arr.length;i++) {
                if(i==0) {
                    file.append(convertToXML(arr[i] + "}", "root"));// This method converts json object to xml string
                    System.out.println("hello");
                }
                else if (i==arr.length-1) {
                    System.out.println(arr[i].charAt(arr[i].length()-1));
                    result="{"+arr[i];
                    file.append(convertToXML(result, "root"));//file.append(convertToXML(arr[i], "root"));
                    System.out.println("hey!!!");
                }
                else{
                    System.out.println(i);
                    result="{"+arr[i]+"}";
                    file.append(convertToXML(result, "root"));

//
                }
            }
            System.out.println("Your XML data is successfully written into XMLData.xml");
            // close FileWriter
            file.close();


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public static String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith("<?xml");

            //May need this: System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");


            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.

            return writer.writeToString(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method for converting JSOn data into XML
     * @param jsonString-json string as input
     * @param root -root element for xml
     * @return - returns xml as a string
     * @throws JSONException - to handle syntax error of json string
     */
    public static String convertToXML(String jsonString, String root) throws JSONException {    // handle JSONException
        JSONObject jsonObject =new JSONObject(jsonString);
        String unformattedXml =  "<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
        return format(unformattedXml);
    }
}