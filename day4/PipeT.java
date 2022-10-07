/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Rishabh (rishabh sankhla).
 */
package com.training.day1;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PipeT{



//    private static final Logger logger = LogManager.getLogger(pipe1.class);
    public String res = null;

    public boolean CheckFile(String s){
        File file = new File(s);
        return file.exists();
    }



    //    @Override
    public String cat(String pathFileName) {
        File f  = new File(pathFileName);
        if(!CheckFile(pathFileName)){
            return "File Not Exist For the Given Path";
        }
        String data;
        try {
            if (pathFileName != null) {
                data = Files.readString(Path.of(pathFileName));
//                logger.info("Cat file path " + pathFileName);
                return data;
            }
        } catch (IOException e) {
//            logger.error("Given Cat Input " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    //    @Override
    public String ls() {
        StringBuilder data = new StringBuilder();
        String path = System.getProperty("user.dir");
        if (path != null) {
            File f = new File(path);
            String[] arr = f.list();
            for (String i : arr) {
                if (i.charAt(0) != '.') {
                    data.append(i).append("\n");
                }
//                logger.debug("list of files" + i);
            }
            return data.toString();
        }
        return null;
    }

    //    @Override
    public String head(String value, int n) {
        if (value.equals("") || n == 0) {
            return null;
        }
        StringBuilder data = new StringBuilder();
        String[] arr = value.split("\n\r|\n|\r");
        int count = 0;
        for (String i: arr) {
            if(!i.isEmpty() && count != n) {
                data.append(i).append("\n");
                count++;
            }
        }
        return data.toString();
    }

    //    @Override
    public String tail(String value, int n) {
        if (value.equals("") || n == 0){
            return null;
        }
        StringBuilder data = new StringBuilder();
        String[] reverse = value.split("\n\r|\n|\r");
        for (int i = (reverse.length - n); i < reverse.length; i++) {

            data.append(reverse[i]).append("\n");

        }
        return data.toString();
    }

    //    @Override
    public String uniq(String value) {
        if (value.equals("")) {
            return null;
        }
        StringBuilder data = new StringBuilder();
        String[] arr = value.split("\n\r|\n|\r");
//        Arrays.sort(arr);
        data.append(arr[0]).append("\n");
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i].equals(arr[i - 1]))
                continue;
            else
                data.append(arr[i]).append("\n");
//            logger.debug("uniq object " + arr[i]);
        }
        return data.toString();
    }

    //    @Override
    public String wc(String value) {
        if (value.equals("")) {
            return null;
        }
        long wordCount, lineCount;
        String[] arr = value.split("\n\r|\n|\r");
        lineCount = arr.length;

        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(value);
        ArrayList<String> array = new ArrayList<>();
        while (m.find()) {
            array.add(m.group());
        }
        wordCount = array.size();
        String data = (lineCount == 0 ? 1 : lineCount) + "\t" + wordCount + "\t" + value.length();
        return data;
    }

    //    @Override
    public String sort(String value) {
        if (value.equals("")) {
            return null;
        }
        StringBuilder data = new StringBuilder();
        String[] arr = value.split("\n\r|\n|\r");
        Arrays.sort(arr, Comparator.comparingInt(str -> str.charAt(0)));
        for (String s : arr) {
            data.append(s).append("\n");
        }
//        logger.info("sort executed");
        return data.toString();
    }

    private String select(String str) throws Exception {
        String[] myList = str.split("\\s");
        switch (myList[0]) {
            case "cat": {
//                logger.info("cat method invoked");
                res = cat(myList[1]);
//                logger.debug("cat: \n"+ res);
            }
            break;
            case "head": {
//                logger.info("head method invoked");
                String value = res;
                int n = Character.getNumericValue(myList[1].charAt(1));
                res = head(value, n);
//                logger.debug("head: \n"+res);
            }
            break;
            case "tail": {
//                logger.info("tail method invoked");
                String value = res;
                int n = Character.getNumericValue(myList[1].charAt(1));
                res = tail(value, n);
//                logger.debug("tail: \n"+res);
            }
            break;
            case "ls": {
//                logger.info("ls method invoked");
                res = ls();
//                logger.debug("ls: \n" + res);
            }
            break;
            case "wc": {
//                logger.info("wc method invoked");
                String value = res;
                res = wc(value);
//                logger.debug("wc: \n" + res);
            }
            break;
            case "sort": {
//                logger.info("sort method invoked");
                String value = res;
                res = sort(value);
//                logger.debug("sort: \n" +res);
            }
            break;
            case "uniq": {
//                logger.info("uniq method invoked");
                String value = res;
                res = uniq(value);
//                logger.debug("uniq: \n" +res);
            }
            break;
            default:
                res= "Invalid Command";
//                logger.error("command not matched");
        }
        return res;
    }

    public String PipeT(String args) {
        String result = null;
        PipeT pipes = new PipeT();
        try {
//            logger.info("Pipe program invoked");
            String[] command = args.split("\\|");
            ArrayList<String> myList = new ArrayList<>();
//            logger.info("CLI input string manipulation");
            for (String s : command) {
                //Removing all the left spaces.
                String leftTrim = s.replaceAll("^\\s+", "");
                //Removing all the right spaces.
                String rightTrim = leftTrim.replaceAll("\\s+$", "");
                //Removing all the center spaces.
                String center = rightTrim.replaceAll("\\s+", " ");
                myList.add(center);
            }
            int i = 0;
            while (i < myList.size()) {
                result = pipes.select(myList.get(i));
                i++;
            }
        } catch (Exception e) {
//            logger.error("Input error " + e.getMessage());
        }
        return result;
    }
}