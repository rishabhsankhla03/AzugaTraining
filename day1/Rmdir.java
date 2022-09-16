import java.io.*;


public class Rmdir {
	public static void main(String[] path) {
		File f = new File(path[0]);
		String arr[] = f.list();
		if (arr.length > 0)
			System.out.println("Cannot be Deleted,it contains some files");
		else {
			f.delete();
			System.out.println("File deleted successfull");
		}
	}
}