/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */

package com.training.day1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    private static final Logger log= LogManager.getLogger(ConverterTest.class);
//


    /**
     * running test case to check the generation of HTML file from CSV file.
     *testing if the generated HTML is same as that of online converted file.
     */


    @Test
    void CheckingHTML() throws IOException {

        log.info("testing for the generation of HTML file from CSV file");
        log.info("testing if the generated HTML file is same as converted HTML file");

        CSVtoHTML obj1 = new CSVtoHTML();
        obj1.csvtohtml();
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weather1.csv")).exists());
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weather.html")).exists());

        byte[] file1Bytes=Files.readAllBytes(Paths.get("/Users/azuga/Desktop/truth/WeatherAPI.html"));
        byte[] file2Bytes=Files.readAllBytes(Paths.get("/Users/azuga/Desktop/weather.html"));
        String actual =new String(file1Bytes);
        String expected=new String(file1Bytes);
        assertEquals(actual,expected);

    }

    /**
     * running test case to check the generation of PDF file from CSV file.
     * testing if the generated PDF is same as that of online converted file.
     */

    @Test
    void PDF_Testing() {
         log.info("testing for the generation of PDF file from CSV file");
         log.info("testing if the generated PDF file is same as converted PDF file");
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weather1.csv")).exists());
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weather.pdf")).exists());

        try {
            byte[] file1Bytes = Files.readAllBytes(Paths.get("/Users/azuga/Desktop/weather.pdf"));
            byte[] file2Bytes = Files.readAllBytes(Paths.get("/Users/azuga/Desktop/truth/WeatherAPI.pdf"));
            String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
            String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

            Assertions.assertEquals(file1, file2);
        } catch (IOException e) {
            log.error("file not found");
            System.out.println("File not fount" + e);
        }
    }

    /**
     * running test case to check the generation of XML file from JSON file.
     * testing if the generated XML is same as that of online converted file.
     */


    @Test
    void XMLFileChecking () {
         log.info("testing for the generation of JSON file from XML file");
         log.info("testing if the generated XML file is same as converted XML file");
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weather.json")).exists());
        Assertions.assertEquals(true , (new File("/Users/azuga/Desktop/weatherxml1.xml")).exists());
        JSONtoXML obj3 = new JSONtoXML();
        obj3.jsontoxml();

        String expected = null;
        try {
            expected = Files.readString(Path.of("/Users/azuga/Desktop/weatherxml1.xml"));
        } catch (IOException e) {
            log.error("file not found");
            throw new RuntimeException(e);
        }
        String actual = null;
        try {
            actual = Files.readString(Path.of("/Users/azuga/Desktop/truth/WeatherAPI.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(expected, actual);
    }


}