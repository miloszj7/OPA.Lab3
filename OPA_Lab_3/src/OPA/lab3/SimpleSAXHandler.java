package OPA.lab3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author Milosz
 * Klasa pochodna z klasy DefaultHandler, wypisuje na konsole plik XML, poprzez przeladowane metody
 *
 */
public class SimpleSAXHandler extends DefaultHandler implements LexicalHandler {
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
	
	/**
	 * Bufor do wczytywania wartosci
	 */
	StringBuffer textBuffer = null;
	
	@Override
	public void startDocument() throws SAXException {
//		System.out.println("Document processing started");
		System.out.println("<?xml version='1.0' encoding='UTF-8'?>");
		super.startDocument();
	}
	
	
	@Override
	public void comment(char[] arg0, int arg1, int arg2) throws SAXException {
		String text = new String(arg0, arg1, arg2);
		for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
		System.out.print("<!--");
		System.out.print(text);
		System.out.println("-->");
		
	}

	
	@Override
	public void endDocument() throws SAXException {
//		System.out.println("Document processing finished");
		super.endDocument();
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		for (int i = 0; i < length; i++) {
//			if(ch[start + i]== ' ' || ch[start + i]== '\n')
//				continue;
//			if(i==0){
//				for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
//			}
//			System.out.print(ch[start + i]);
//			if (i==length - 1)
//				System.out.print("\n");
//		}
		if (textBuffer != null) {
		   printText();
		    textBuffer = null;
		  }
		String s = new String(ch, start, length);
		if(textBuffer == null){
			textBuffer = new StringBuffer(s);
		} else{
			textBuffer.append(s);
		}

		super.characters(ch, start, length);
	}
	
	private void printText() throws SAXException {
		if(textBuffer == null) return;
		String s = "" + textBuffer;
		if (!s.trim().equals("")){
			for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
			System.out.println(s);
		}
		textBuffer = null;
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
		printText();
		LICZBA_WCIEC--;
		for(int a=0; a<LICZBA_WCIEC; a++) {System.out.print(WCIECIE);}
		System.out.println("</" + qName + ">");
		super.endElement(uri, localName, qName);
	}



	@Override
	public void endCDATA() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDTD() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startCDATA() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDTD(String arg0, String arg1, String arg2)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
