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
	private static int LICZBA_WCIEC=0;
	
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
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		for (int i = 0; i < length; i++) {
			if(/*ch[start + i]== ' ' ||*/ ch[start + i]== '\n')
				continue;
			if(i==0){
				for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
			}
			System.out.print(ch[start + i]);
			if (i==length - 1)
				System.out.print("\n");
		}
//		System.out.println(new String(ch, start, length).trim());
		
		super.characters(ch, start, length);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		length = attributes.getLength();
		for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
		if(length == 0)
			System.out.println("<" + qName + ">");
		else{
			System.out.print("<" + qName + " ");
			
			for (int b=0; b<length; b++){
				System.out.print(attributes.getQName(b) + "=\"" + attributes.getValue(b) + "\" ");
			}
			System.out.println(">");
		}
		LICZBA_WCIEC++;
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		LICZBA_WCIEC--;
		for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
		System.out.println("</" + qName + ">");
		super.endElement(uri, localName, qName);
	}
}
