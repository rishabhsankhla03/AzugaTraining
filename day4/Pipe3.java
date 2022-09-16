
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.nio.file.*;
import java.text.*;




public class Pipe3 {
		
		public static String[] head(String s[],int n)
		{
			String data[]= new String[n];
			
			for(int j=0; j<n; j++)
				data[j]=s[j];
			return data;

		}
		
		public static String[] tail(String s[],int n)
		{
			String data[]= new String[n];
			
			int length=s.length;
	
			for(int j=0; j<n; j++)
				data[j]=s[length-1-j];
			return data;

		}

		public static void ls_1(int headvalue,int tailvalue)
		{
			if(headvalue==0 && tailvalue==0)
			{
				String path=System.getProperty("user.dir");
		
				File f = new File(path);
				String arr[]=f.list();
				Arrays.sort(arr);				

				for(int i=0;i<arr.length;i++)
					System.out.println(arr[i]);
			}
			else
			{	
				String path=System.getProperty("user.dir");
				
				File f = new File(path);
				String arr[]=f.list();
				Arrays.sort(arr);				

				String f1[]= head(arr,headvalue);
				String f2[]= tail(f1,tailvalue);
			
				for(int i=0;i<f2.length;i++)
					System.out.println(f2[i]);
			}
		}


		public static void main(String []args) 
		{
			String mystring[]= args[0].split(" ");
					
			ArrayList<String> word= new ArrayList<String>(Arrays.asList(mystring));
		
			if(!word.contains("|"))
				ls_1(0,0);
			
			else if(word.contains("head") && word.contains("tail"))
				{
					String hvalue=mystring[4];
					String tvalue=mystring[7];
					
					int a=Character.getNumericValue(hvalue.charAt(1));
					int b=Character.getNumericValue(tvalue.charAt(1));
					
					ls_1(a,b);
				}
			
		}	

}

//Temp path = /Users/azuga/Downloads/dummy/  ; Directory 

// Temp path = /Users/azuga/Downloads/dummy/dummyfile/d1.txt  
 
