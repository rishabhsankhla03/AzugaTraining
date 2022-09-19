/*
 * Copyright (c) 2022.  - All Rights Reserved
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -rishabh.
 */

package com.training.day1;
import java.io.FileOutputStream;
import java.io.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class CsvtoPdf {
    public static void main(String[] args) throws IOException, DocumentException {

        //taking .csv file as an input

        String inputCSVFile = "/Users/azuga/Desktop/weather1.csv";
        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));

        // Variables to loop through the CSV File

        String [] nextLine; // taking every line in the file

        int lnNum = 0; // line number

        // Initiating making the PDF documents

        Document pdfdata = new Document();
        Rectangle rc = new Rectangle(6000f,5300f);
        pdfdata.setPageSize(rc);
        PdfWriter.getInstance(pdfdata, new FileOutputStream("/Users/azuga/Desktop/weather.pdf"));

        pdfdata.open(); //method to open the file
        PdfPTable my_first_table = new PdfPTable(43); //number of columns in pdf
        PdfPCell table_cell;



        //taking entries through csv and populating it to PDF
        while ((nextLine = reader.readNext()) != null) {
            lnNum++;
            int i=0;
            while(i<=42) {
                table_cell = new PdfPCell(new Phrase(nextLine[i]));
                my_first_table.addCell(table_cell);
                i++;
            }
        }
        // Attach table to PDF and closing the document
        pdfdata.add(my_first_table);
        pdfdata.close();
    }
}