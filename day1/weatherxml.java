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

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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



            FileWriter file = new FileWriter("/Users/azuga/Desktop/weatherxml.txt");
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
            System.out.println("Your XML data is successfully written into XMLData.txt");
            // close FileWriter
            file.close();


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    // create convertToXML() method for converting JSOn data into XML
    public static String convertToXML(String jsonString, String root) throws JSONException, FileNotFoundException {    // handle JSONException
//            InputStream is = new FileInputStream("/Users/azuga/Desktop/weather.json");
//            JSONTokener tokener = new JSONTokener(is);
//            JSONArray jsonArray = new JSONArray(tokener);
//            StringBuilder csv = new StringBuilder();
//            csv.append(CDL.toString(jsonArray));
        JSONObject jsonObject =new JSONObject(jsonString);
        // pass the XML data to the main() method
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">" + XML.toString(jsonObject) + "</"+root+">";

    }
}
