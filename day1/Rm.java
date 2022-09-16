import java.io.*;


public class Rm{
	public static void main(String[] path) {
		File f = new File(path[0]);
		if (f.delete())
        			System.out.println("File deleted successfully");
        		else
        			System.out.println("Error in deleting file or File doesnot exist");
        	}

	}
