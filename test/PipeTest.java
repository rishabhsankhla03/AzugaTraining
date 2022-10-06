/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */

package com.training.day1;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PipeTest {
    private static final Logger log= LogManager.getLogger(PipeTest.class);


    PipeT pipetest = new PipeT();


    /**
     * testing method Cat Head, and checking if the result is correct.
     */

    @Test
    void Test_Cat_Head(){
        log.info("testing test_cat_head for dummy.txt");
        String expected = "Mumbai\nChennai\nBanglore\nAgra\nPunjab\nHyderabad\nRajasthan\nDelhi\n";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | head -8");
        Assertions.assertEquals(expected, actual);
    }


    /**
     * testing Cat_sort_Head, and checking if the result is correct.
     */

    @Test
    void Test_Cat_Sort_Head(){
        log.info("testing cat_sort_head for dummy.txt");
        String expected = "Agra\nAssam\nAssam\nBanglore\n";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | sort | head -4");
        Assertions.assertEquals(expected,actual);
    }

    /**
     * testing Cat_sort_head_wc, and checking if the result is correct.
     */


    @Test
    void Test_Cat_Sort_Head_Wc() {
        log.info("testing cat_sort_head_wc for dummy.txt");
        String expected = "4\t4\t26";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | sort | head -4 | wc");
        Assertions.assertEquals(expected, actual);
    }

    /**
     *Test method testWrongArgument checks if we pass the wrong Argument
     */

    @Test
    void TestingArgument(){
        log.info("testing if the wrong argument is given ");
        String expected = "Invalid Command";
        String actual = pipetest.PipeT("fjsdjl");
        Assertions.assertEquals(expected , actual);
    }


    /**
     * testing Cat_Tail and checking if the result is correct.
     */


    @Test
    void Test_Cat_Tail() {
        log.info("testing cat_tail for dummy.txt");
        String expected = "Himachal\nJaipur\nPatna\nLucknow\nKolkata\nGoa\n";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | tail -6");
        Assertions.assertEquals(expected, actual);
    }

    /**
     * tesig Cat_uniq_tail and checking if the result is correct.
     */

    @Test
    void Test_Cat_Uniq_Tail(){
        log.info("testing cat_uniq_tail for dummy.txt");
        String expected = "Jaipur\nPatna\nLucknow\nKolkata\nGoa\n";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | uniq | tail -5");
        Assertions.assertEquals(expected, actual);
    }

    /**
     * testing Cat_Wc and checking if the result is correct or not.
     */

    @Test
    void Test_Cat_Wc(){
        log.info("testing cat_wc for dummy.txt");
        String expected = "20\t21\t145";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/dummy.txt | wc");

        Assertions.assertEquals(expected,actual);
    }

    /**
     * testing if the path of the file is correct or not.
     */

    @Test
    void testWrongFile(){
        log.info("Test to check what program returns when we enters the wrong File");
        String expected = "File Not Exist For the Given Path";
        String actual = pipetest.PipeT("cat /Users/azuga/Desktop/afhbdahf.txt");
        Assertions.assertEquals(expected , actual);
    }


}