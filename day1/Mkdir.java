import java.io.*;


public class Mkdir {
	public static void main(String[] path) {
		File f = new File(path[0]);
        		if (f.mkdir())
        			System.out.println("File created successfully");
        		else
        			System.out.println("Error in creating file");
        	}
	}
