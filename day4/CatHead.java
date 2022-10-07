/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Rishabh (rishabh sankhla)
 */
package com.training.day4;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * This class mimics the pipe command of linux
 */
public class CatHead {


    public static String cat(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String sort(String str) {
        String[] lines = str.split("\n\r|\r|\n");
        List<String> ls = new ArrayList<>();
        Collections.addAll(ls, lines);
        Collections.sort(ls);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ls.size(); i++){
            if(i < ls.size()-1){
                sb.append(ls.get(i)).append("\n");
            }
            else{
                sb.append(ls.get(i));
            }

        }

        return sb.toString();
//        return ls.toString();
//        for (String e : ls) {
//            System.out.println(e);
//        }
    }

    public static String head(String str,int len) {
        String[] lines = str.split("\n\r|\r|\n");
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(lines));
        String ans = "";
        int j=0;
        for(int i=0; i<ar.size(); i++) {
            if (j>=len){
                break;
            }
            if(i < ar.size()-1){
                ans = ans + (ar.get(i)+"\n");
                j++;

            }
            else{
                ans = ans + ar.get(i);
            }

        }
        return ans;
    }

    public static String ptest (String str) {


        String[] s = str.split(" ");
        if (s[0].equals("cat") && s.length <= 3) {
            System.out.println(cat(s[1]));
        }
        else if (s.length >= 3) {
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("sort")) {
                return sort(cat(s[1]));
            }
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("head")) {
                return head(cat(s[1]) ,Integer.parseInt(s[4]));
            }
        }


        return "";
    }

}