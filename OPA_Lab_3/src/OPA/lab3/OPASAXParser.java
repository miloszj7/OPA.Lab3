package OPA.lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class OPASAXParser {
	private static final String FILEPATH = "files/DASH-Ex-G1.xml"; 
	
	
	/**
	 * @param args - moze pozniej sciezka pliku xml z linii polecen ?
	 */
	public static void main(String[] args) {
				
		try {
//			BufferedReader br = new BufferedReader(new FileReader(new File(FILEPATH)));
//			String s, s2 = new String();
//		    while((s = br.readLine())!= null)
//		      s2 += s + "\n";		    
//		    System.out.println(s2);
		    
//		    InputSource is = new InputSource(br);
//		    br.close();
			
		    SAXParser parser = null;
		    SAXParserFactory factory = SAXParserFactory.newInstance();
		    parser = factory.newSAXParser();
		    DefaultHandler handler = new simpleSAXHandler();
		    
		    System.out.println("#############   Dokument XML   ##############");
		    parser.parse(FILEPATH, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
