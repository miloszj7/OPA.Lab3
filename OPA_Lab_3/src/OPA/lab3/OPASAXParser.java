package OPA.lab3;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class OPASAXParser {
	private static final String FILEPATH = "files/DASH-Ex-G1.xml"; 
	
	
	/**
	 * @param args - jeden argument - sciezka do pliku XML [opcjonalne]
	 */
	public static void main(String[] args) {
		String filePathCmd = null;
		if (args.length == 1) {
			filePathCmd = args[0];
		}
		try {
		    SAXParser parser = null;
		    SAXParserFactory factory = SAXParserFactory.newInstance();
		    parser = factory.newSAXParser();
		    XMLReader xmlReader = parser.getXMLReader();
		    DefaultHandler handler = new SimpleSAXHandler();
		    xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
		    
		    System.out.println("#############   Dokument XML   ##############");
		    if (filePathCmd == null){
		    	parser.parse(FILEPATH, handler);
		    } else {
		    	parser.parse(filePathCmd, handler);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
