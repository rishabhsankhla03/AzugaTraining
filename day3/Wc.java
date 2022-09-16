/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;


/**
 * it fetches each word from the file and store that in a string
 */

public class Wc {
	/**
	 * it takes the word line by line
	 * @param path: it take the path of the file
	 */
	public static void wc_all(String path) {
		try {
			int cnt = 0;
			int lc = 0;
			FileReader f = new FileReader(path);
			BufferedReader bf = new BufferedReader(f);
			String line;
			while ((line = bf.readLine()) != null) {
				lc++;
				String w[] = line.split(" ");
				cnt += w.length;
			}
			System.out.print(lc == 1 ? "0 " : lc+" ");
			System.out.print(cnt+" ");
			bf.close();
			System.out.print(Files.size(Path.of(path))+" ");
			System.out.println(Path.of(path).getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * it will count the character of the string taken
	 * @param path: it  will take the path of the file and it will fetch the character of that file
	 */
	public static void wc_cm(String path) {

		try {
			System.out.print(Files.size(Path.of(path))+" ");
			System.out.println(Path.of(path).getFileName());
		} catch (IOException e) {
			System.out.println("AN ERROR OCCURRED");
			e.printStackTrace();
		}
	}

	/**
	 * this will count the number of line in the file
	 * @param path: it will take the path of the file whose line we want to count
	 */
	public static void wc_l(String path) {

		int lc = 0;
		BufferedReader bf;
		try {
			FileReader f = new FileReader(path);
			bf= new BufferedReader(f);
			while ( bf.readLine() != null) {
				lc++;
			}
			System.out.print(lc == 1 ? "0 " : lc+" ");
			System.out.println(Path.of(path).getFileName());
		} catch (IOException e) {
			System.out.println("AN ERROR OCCURRED");
			e.printStackTrace();
		}
	}

	/**
	 * this will count the number of words in the file
	 * @param path: it will take the path of the file whose words we want to count
	 */
	public static void wc_w(String path) {
		try {
			int cnt = 0;
			FileReader f = new FileReader(path);
			BufferedReader bf = new BufferedReader(f);
			String line;
			while ((line = bf.readLine()) != null) {
				String w[] = line.split(" ");
				cnt += w.length;
			}

			System.out.print(cnt+" ");
			bf.close();
			System.out.println(Path.of(path).getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * execution starts here
	 * @param args takes input from user as command line arguement
	 */
	public static void main(String[] args) {

		if(args.length>1) {
			switch(args[0]) {
				case ".":
					wc_all(args[1]);
					break;
				case "-c":
					wc_cm(args[1]);
					break;
				case "-m":
					wc_cm(args[1]);
					break;
				case "-l":
					wc_l(args[1]);
					break;
				case "-w":
					wc_w(args[1]);
					break;
				default:
					System.out.println("option does not match");
			}
		}
		else
			System.err.println("file name cannot be empty");

	}

}

