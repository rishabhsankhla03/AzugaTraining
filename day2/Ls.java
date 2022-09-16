/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -rishabh (rishabh sankhla)
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * it will list out the files in current directory.
 */
public class Ls {
	

public static void ls_1(String path) {      // take the list of file in string
	System.out.println(path);               // print each file on new line
	File f = new File(!path.equalsIgnoreCase("hi")?path:System.getProperty("user.dir"));  // this will trace the path of the directory
	
String arr[] = f.list();
for (String s : arr)
	System.out.println(s);                 //this will print the file
}


	/**
	 * ls_a will print the hidden files as well.
	 * @param path this will take the path of the directory.
	 */
	public static void ls_a(String path) {       // this will print hidden files as well
File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));

for (File f1 : f.listFiles()) {
	if (f1.isHidden())
		System.out.println(f1);  // will print all files including hidden files.
}
}

	/**
	 * this will sort and print file as per the last modification.
	 * @param path will take the path of the directory
	 */
	public static void ls_t(String path) {
File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
Map<Long, String> mp = new TreeMap<>(); //sorting using treemap (key)
for (File obj : f.listFiles()) {
	mp.put(obj.lastModified(), obj.getName());
}
    SimpleDateFormat pdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  //sorting using time and date
    mp.entrySet().forEach(entry -> {
	System.out.println(pdf.format(entry.getKey()) + " " + entry.getValue()); // printing sorted value
});
}

	/**
	 * this will sort the file as per their size and print it
	 * @param path this will take the path of the directory
	 */
	public static void ls_lS(String path) {
	File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
	Map<Long, File> mp = new TreeMap<>(Collections.reverseOrder());
    for (File obj : f.listFiles()) {
	mp.put(obj.length(), obj);
}

	SimpleDateFormat pdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	mp.entrySet().forEach(entry -> {
		
		try {         //this will try the current block and look for the error
			if(!entry.getValue().isHidden()) {
			Path p = Path.of(entry.getValue().getPath());
			PosixFileAttributes ats= Files.readAttributes(p, PosixFileAttributes.class);
			System.out.print(PosixFilePermissions.toString(ats.permissions()) + " ");
			System.out.print(entry.getValue().isFile()?1:(entry.getValue().list().length)+" ");
			System.out.print(ats.owner().getName() + " ");
			System.out.print(ats.group().getName() + " ");
			System.out.print(ats.size() / 1024 + "kb ");
			System.out.print(pdf.format(entry.getValue().lastModified()) + " ");
			System.out.print(entry.getValue().getName());
			System.out.println();
			}
		} catch (IOException e) {  // this will throw the error if any.
			e.printStackTrace();   //tool use to handle exception and errors
		}
		
	});
}

	/**
	 * sort as per modification but in reverse as that of "t"
	 * @param path this will take the path of the directory
	 */
	public static void ls_T(String path) {
	File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
Map<Long, String> mp = new TreeMap<>(Collections.reverseOrder());
for (File obj : f.listFiles()) {
	mp.put(obj.lastModified(), obj.getName());
}

SimpleDateFormat pdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
mp.entrySet().forEach(entry -> {
	System.out.println(pdf.format(entry.getKey()) + " " + entry.getValue());
});
}
public static void ls_X(String path) {
File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
try{
String arr[] = f.list();
Arrays.sort(arr);
for(String s : arr) {
if(s.charAt(0)!='.')
	System.out.println(s);
}
}catch(Exception e) {
	System.out.println("An error occurred");
}
}
public static void ls_la(String path) {
	File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
try {
	SimpleDateFormat pdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	for (File f1 : f.listFiles()) {
		Path p = Path.of(f1.getPath());
		PosixFileAttributes ats = Files.readAttributes(p, PosixFileAttributes.class);
		System.out.print(PosixFilePermissions.toString(ats.permissions()) + " ");
		System.out.print(ats.owner().getName() + " ");
		System.out.print(ats.group().getName() + " ");
		System.out.print(ats.size() / 1024 + "kb ");
		System.out.print(pdf.format(f1.lastModified()) + " ");
		System.out.print(f1.getName());
		System.out.println();
	}

} catch (Exception e) {
	e.printStackTrace();
}
}


public static void ls_LRT(String path) {
	File f = new File(!path.equals("hi")?path:System.getProperty("user.dir"));
Map<Long, File> mp = new TreeMap<>(Collections.reverseOrder());
for (File obj : f.listFiles()) {
	mp.put(obj.lastModified(), obj);
}
SimpleDateFormat pdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
mp.entrySet().forEach(entry -> {
	try {
		Path p = Path.of(entry.getValue().getPath());
		PosixFileAttributes ats = Files.readAttributes(p, PosixFileAttributes.class);
		System.out.print(PosixFilePermissions.toString(ats.permissions()) + " ");
		System.out.print(ats.owner().getName() + " ");
		System.out.print(ats.group().getName() + " ");
		System.out.print(ats.size() / 1024 + "kb ");
		System.out.print(pdf.format(entry.getValue().lastModified()) + " ");
		System.out.print(entry.getValue().getName() + " ");
		System.out.println();

	} catch (Exception e) {
		e.printStackTrace();
	}
});
}
	
	
	
	
	
	
	
	public static void main(String[] args) {

		String s[]=new String[2];
		s[0]=args[0];
		
		if(args.length<=1) {
			s[1]="hi";
		}
		
		switch (s[0]) {
		case "-l":
			ls_1(s[1]);
			break;
		case "-1":
			ls_1(s[1]);
			break;
		case "-a":
			ls_a(s[1]);
			break;
		
		case "-X":
			ls_X(s[1]);
			break;
		case "-t":
			ls_t(s[1]);
			break;
		case "-T":
			ls_T(s[1]);
			break;
		case "-lS":
			ls_lS(s[1]);
			break;
		case "-la":
			ls_la(s[1]);
			break;
		case "-lrt":
			ls_LRT(s[1]);
			break;
		case "help":
			help();
			break;
		default:
			System.out.println("command doesn't match");
		}


	}
	public static void help() {
	System.out.println("ls:	-used to check the directories");
	System.out.println("ls-1:	-used to check the files one by one");
	System.out.println("ls-a:	-used to check the files which are hidden");
	System.out.println("ls-la:	-used to check the files which are hidden by printing one by one");
	System.out.println("ls-t:	-used to print the files ordered by time in ascending order");
	System.out.println("ls-T:	-used to print the files ordered by time in descending order");
	System.out.println("ls-X:	-used to print the files ordered by name in ascending order");
	System.out.println("ls-lS:	-used to print the files ordered by size in descending order");
	System.out.println("ls-la:	-used to print the file's all details");
	System.out.println("ls-lrt:	-used to print the file's all details ordered by name in ascending order");
	
}

}
