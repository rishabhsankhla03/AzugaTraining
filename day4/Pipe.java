/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh.
 */

import java.io.*;
import java.nio.file.*;

public class Pipe{
	//It prints present file's data on console.
	//@param path -It takes the input file path and return file as string.
		
		public static String cat(String path) {
			try {
				String line = Files.readString(Path.of(path));
				return line;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

	/**
	 * method taking string as input and executing task of word, line, character count
	 * @param str taking string as input
	 */
		public static void wc(String str) {
			String[] lines = str.split("\r\n|\r|\n");
			System.out.print(lines.length+"     ");
			lines = str.split(" ");
			System.out.print(lines.length+"     ");
			int i=0;
			for(char c:str.toCharArray()) {
				i++;
			}
			System.out.println(i+"     ");
			
		}

	// Execution of programs starts from here
	// it will take input from the user as command line argument
	
		public static void main(String[] args) {
			if((args[1].equals("|"))&&(args[2].equals("wc"))) {
				wc(cat(args[0]));
			}
			else {
				System.out.println("wrong syntax");
			}
			}
}