package com.training.day5;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class MuseumApi {
    public static void main(String[] args) throws IOException, InterruptedException {

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10; i++){
            String url="https://collectionapi.metmuseum.org/public/collection/v1/objects/"+i;

            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            sb.append(response.body()).append(",");
            //System.out.println(sb);
        }

        System.out.println(sb);


        try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/museum.json")) {
            fw.write("["+sb+"]");
            System.out.println("data is filled into the file museum.json");
        } catch (Exception e) {
            System.out.println("an error occurred while creating or writing to the file");
        }


        InputStream is = new FileInputStream("/Users/azuga/Desktop/museum.json");
        JSONTokener tokener = new JSONTokener(is);
        System.out.println(is);
        //break a string into tokens
        JSONArray jsonArray = new JSONArray(tokener);
//        System.out.println(jso);
        // convert that to jsonArray
        StringBuilder csv = new StringBuilder();
        csv.append(CDL.toString(jsonArray));


        try {
            // Convert JSONArray into csv and save the file
            Files.write(Path.of("/Users/azuga/Desktop/museum1.csv"), csv.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("completed");

    }
}