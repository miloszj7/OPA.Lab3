package OPA.lab3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author Milosz
 * Klasa pochodna z klasy DefaultHandler, wypisuje na konsole plik XML, poprzez przeladowane metody
 *
 */
public class simpleSAXHandler extends DefaultHandler {
	/**
	 * Szerokosc wciecia elementow XML, teraz 3 spacje, mozna ustawic '\t'
	 */
	private static final String WCIECIE = "    ";
	
	/**
	 * Licznik ile razy zrobic wciecie, czyli czyli jak gleboko w drzewie XML jest dany element
	 */
	private static int i=0;
	
	/**
	 * Ilosc atrybutow danego elementu
	 */
	private int length = 0;
	
	@Override
	public void startDocument() throws SAXException {
//		System.out.println("Document processing started");
		super.startDocument();
	}
	
	@Override
	public void endDocument() throws SAXException {
//		System.out.println("Document processing finished");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		length = attributes.getLength();
		for(int a=0; a<i; a++) {System.out.print(WCIECIE);}
		if(length == 0)
			System.out.println("<" + qName + ">");
		else{
			System.out.print("<" + qName + " ");
			
			for (int b=0; b<length; b++){
//				String name = attributes.getQName(b);
//				System.out.print(name + "=\"");
//				String value = attributes.getValue(b);
//				System.out.print(value + "\" ");
				System.out.print(attributes.getQName(b) + "=\"" + attributes.getValue(b) + "\" ");
			}
			System.out.println(">");
		}
		i++;
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		i--;
		for(int a=0; a<i; a++) {System.out.print(WCIECIE);}
		System.out.println("</" + qName + ">");
		super.endElement(uri, localName, qName);
	}
}
