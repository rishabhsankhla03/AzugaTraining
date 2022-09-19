/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */

package com.training.day1;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApiW {
    public static void main(String[] args) throws IOException, InterruptedException {

        /**
         * accessing response body and storing the response body into string "sb".
         */

        String[] city = {"tokyo","sydney","delhi","dubai","milan","madrid","berlin","amsterdam","washington","vancouver","Chicago","rome","lyon","turin"};
        String sb3 = null;
        StringBuilder sting = new StringBuilder();
        sting.append("[");
        for(int i=0;i< city.length;i++) {

            //"city" string array that will take all the given city names
            var url = "http://api.weatherapi.com/v1/current.json?key=2d14c37a9ef84ef6ab980624221809&q=" + city[i] + "&aqi=yes";
//            var url = "http://api.weatherapi.com/v1/current.json?key=bd4fc916e20c46f886b05941221309&q=" + city[i] + "&aqi=yes";

            /**
             * sending reequest to server
             * based on request web brower responding to the client
             */

            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //replacing "location" and "target" from parent file and fetching its data in a string
            // storing response body from the server in the string
            // manipulating the body to Json array.

            String sb = response.body();
            String sb1 = sb.replace("{\"location\":{", "");
            String sb2 = sb1.replace("\"current\":{", "");
            String sb4 = sb2.replace("{", "\"\",");
            sb3= sb4.replace("}", "");
            sting.append("{");
            sting.append(sb3);
//            sting.append("},");

            if (i== city.length-1) {
                sting.append("}");
            }
            else {
                sting.append("},");
            }

            // making a json file.
        }
        sting.append("]");
        try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/weather.json")) {
            fw.write(sting.toString());
            System.out.println("data is filled into the file whether.json");
        } catch (Exception e) {
            System.out.println("an error occurred while creating file");
        }

        // making tokens of the json Array
        //JSONTokener takes a source string and extracts character from it


        InputStream is = new FileInputStream("/Users/azuga/Desktop/weather.json");
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        StringBuilder csv = new StringBuilder();
        csv.append(CDL.toString(jsonArray));

        //fetching data of json file to csv file and printing the same

        try {
            // Convert JSONArray into csv and save to file
            Files.write(Path.of("/Users/azuga/Desktop/weather1.csv"), csv.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task completed");
    }
}
