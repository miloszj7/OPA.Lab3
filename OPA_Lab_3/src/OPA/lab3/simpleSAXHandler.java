package OPA.lab3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class simpleSAXHandler extends DefaultHandler {
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document processing started");
		super.startDocument();
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document processing finished");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println(qName + " , " + localName);
		super.startElement(uri, localName, qName, attributes);
	}
}
