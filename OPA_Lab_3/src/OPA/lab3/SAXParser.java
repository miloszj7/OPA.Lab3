package OPA.lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SAXParser {
	private static final String FILEPATH = ""; 
	class readXMLFIle{
		
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(FILEPATH)));
			String s, s2 = new String();
		    while((s = br.readLine())!= null)
		      s2 += s + "\n";
		    br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.toString());
		}
	}

}
