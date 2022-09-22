/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */

package com.training.day1;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger log= LogManager.getLogger(ApiW.class);

    public static void main(String[] args) throws IOException, InterruptedException {
    log.info("fetching data from weather api");
        /*
         * accessing response body and storing the response body into string "sb".
         */

        String[] city = {"tokyo","sydney","delhi","dubai","milan","madrid","berlin","amsterdam","washington","vancouver","Chicago","rome","lyon","turin"};

        log.info("fetching details of each city from weather api url");

        String sb3;
        StringBuilder sting = new StringBuilder();
        sting.append("[");

        log.warn("the api url can fail, check the key");

        for(int i=0;i< city.length;i++) {
            log.debug("taking data of "+city[i]+ " from weather api url");

            //"city" string array that will take all the given city names

            var url = "http://api.weatherapi.com/v1/current.json?key=2d14c37a9ef84ef6ab980624221809&q=" + city[i] + "&aqi=yes";
//            var url = "http://api.weatherapi.com/v1/current.json?key=bd4fc916e20c46f886b05941221309&q=" + city[i] + "&aqi=yes";

            /*
             * sending request to server
             * based on request web browser responding to the client
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
        log.info("json file fetched and now converting to csv file ");
        sting.append("]");
        try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/weather.json")) {
            fw.write(sting.toString());
            System.out.println("data is filled into the file whether.json");
        } catch (Exception e) {
            System.out.println("an error occurred while creating file");
        }
        log.info("Got response from the server-URL");

        // making tokens of the json Array
        //JSONTokener takes a source string and extracts character from it


        InputStream is = new FileInputStream("/Users/azuga/Desktop/weather.json");
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        StringBuilder csv = new StringBuilder();
        csv.append(CDL.toString(jsonArray));

        log.info("printing csv file from the data of json");

        //fetching data of json file to csv file and printing the same

        try {
            // Convert JSONArray into csv and save to file
            Files.write(Path.of("/Users/azuga/Desktop/weather1.csv"), csv.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task completed");
        log.info("task completed");
//        log.warn("check for the data connection if failed");
    }
}