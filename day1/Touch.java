import java.io.*;


public class Touch {
	public static void main(String[] path) {
		try {
			File f = new File(path[0]);
			if (!f.exists() && f.createNewFile()) {
				System.out.println("File created: " + f.getName());
			} else
				System.out.println("File already exists");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}